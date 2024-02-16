
package program;

/**
* Author: Anupama Bhatta
* Date:   04/01/2019
* Description: Java application that can consolidate all files into one spreadsheet based
on the data range provided by the user. 
*/

import AuxPackage.AuxFileReader;
import AuxPackage.AuxFormatter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ProcessFiles {
    
//============ Attributes =================    
    private int rejectedFileCount;
    private int processedFileCount;
    
    private long startDate;     
    private long endDate;      
    
    private boolean isComplete;    

    private boolean status;        
    private String statusDesc;      

    private ArrayList<Stock> listStocks = new ArrayList<Stock>(); 
    
    private ArrayList<Long> listHeaderDates;     

//============ Attributes =================  
    
    public ProcessFiles()
    {
        isComplete=false;
    }
    
      
    public ProcessFiles(String dataDir, String outputFile, String sStartDate, String sEndDate, ProgressCounter counter)
    {
        
        listHeaderDates=new ArrayList<Long>();
        listStocks= new ArrayList<Stock>();
        
        isComplete=false;
        
        File dirData=new File(dataDir);
        if(dataDir==null)
            return;
        
        File fileOutput=new File(outputFile);
        if(fileOutput==null)
            return;
       
        
        startDate=AuxFormatter.convertDateToLong(sStartDate);
        endDate=AuxFormatter.convertDateToLong(sEndDate);

        
        File[] directoryListing= dirData.listFiles();
        
        
        if(directoryListing !=null)
        {
            for(int i=0; i<directoryListing.length; i++)
            {
                String fileName= directoryListing[i].getName();
                if(fileName.contains(Configs.fileExtension))
                {
                     boolean include= readSingleFile(directoryListing[i].getAbsolutePath()); 
                     if(!include)
                         rejectedFileCount++;
                }
                   
                counter.up("read");
            }
            
        }
        
        isComplete=true;
        
        if(processedFileCount==0)
        {
            status=true;
        }
        
        counter.setReadingComplete(true);
        counter.setCount(0);
        counter.setMax(listStocks.size());
        counter.setOutputComplete(false);
        

        if(listStocks.size()>0)
        {
            outPutFile(fileOutput, counter);
        }
        
        counter.setOutputComplete(true);
        counter.up("complete");  
    }
   
    public int getProcessedFileCount(){
        return processedFileCount;
    }
   
    public int getRejectedFileCount(){
        return rejectedFileCount;  
    }
   
    public boolean getStatus(){
        return status;
    }
   
    public String getStatusDesc() {
        return statusDesc;
    }
    
    private boolean readSingleFile(String filePath)
    {
        ArrayList<StockData> listStockData = new ArrayList<StockData>();
        String sCompany="";
        String symbol="";
        String exchange="";
        String csiNum="";
        Long lDate=0L;

        AuxPackage.AuxFileReader reader= new AuxFileReader(filePath);
        if(!reader.isSuccess())
        {
            statusDesc=reader.getError();
            status=false;
            return status;
        }
       
        ArrayList<String> listRows= new ArrayList<String>();

        int count=0;
        for(int i=1; i<reader.getFileArray().length; i++ )
        {
            count++;
            String[] arLine= reader.getFileArray()[i].split(",");
            listRows.add(arLine[0]);

            if(i ==2)
            {
                sCompany=arLine[8];
                symbol=arLine[2];
                exchange=arLine[3];
                csiNum=arLine[1];

            }
            lDate=Long.parseLong(arLine[0]);
            double dPrice=Double.parseDouble(arLine[4]);

            if(lDate>= startDate && lDate<=endDate)
            {
                listStockData.add(new StockData(lDate, dPrice));
                if(StockDate.longDateExists(listHeaderDates, lDate)==false)
                    listHeaderDates.add(lDate);
            }
        }

            if (listStockData.isEmpty()){
                rejectedFileCount++;
                return false;
            }
                     
            Stock stock= new Stock(csiNum, sCompany, exchange, symbol, listStockData);
            listStocks.add(stock);

            return true; 
    }
   
   
    private boolean outPutFile(File fileOutput, ProgressCounter counter)
    {
        String delim = ",";
        PrintWriter outputStream = null;

        try
        {
           outputStream = new PrintWriter(new FileOutputStream(fileOutput));
        }
        catch(FileNotFoundException e)
        {
           status = false;
           statusDesc = "Problem accessing output file." + e.getMessage();
           return false;
        }
       
        if(outputStream == null)
        {
            status = false;
            statusDesc = "Problem accessing output file. Output stream is null.";
            return false;
        }

        String sLine;

        StockDate.sortLongDates(listHeaderDates);
        sLine = "CSI Num" + delim + "Symbol" + delim + "Company" + delim + "Exchange";

        for(Long lDate: listHeaderDates)
        {
            sLine += "," + AuxFormatter.convertDateToString(lDate);
        }

        outputStream.println(sLine);
       
        for(Stock stock: listStocks)
        {
            int reqNum = listHeaderDates.size();
            int actNum = stock.getArStockData().size();
            if(reqNum != actNum)
            {
                rejectedFileCount++;
                counter.up("write");
                continue;
            }
                processedFileCount++;

                sLine = stock.getCsiNum()+ delim+ stock.getSymbol()+ delim+ stock.getName()+ delim+ stock.getExchange();
               
                for(StockData stockData: stock.getArStockData())
                {
                    sLine += ","+ stockData.getPrice();
                }
                
                outputStream.println(sLine);
           
                counter.up("write");
               
        }
        
        outputStream.close();
        status = true;
        statusDesc = "";
        
        return true;     
   }   
}
