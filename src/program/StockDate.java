
package program;

/**
* Author: Anupama Bhatta
* Date:   04/01/2019
* Description: Java application that can consolidate all files into one spreadsheet based
on the data range provided by the user. 
*/

import java.util.ArrayList;

public class StockDate {
    
    public long lDate;
    
    public StockDate(){
        
    }

    public long getlDate() {
        return lDate;
    }

    public void setlDate(long lDate) {
        this.lDate = lDate;
    }
    
    public static boolean dateExists(ArrayList<StockDate> listDates, long lDate){
        
        boolean exists=false;
        
        for(StockDate date: listDates)
        {
            if(lDate==date.getlDate())
                return true;
        }
        return exists;
        
    }
    
    public static boolean longDateExists(ArrayList<Long> listDates, long lDate){
        boolean exists=false;
        
        for(Long thisDate: listDates)
        {
            if(lDate==thisDate)
                return true;
        }
        return exists;
    }
    
    public static void sortLongDates(ArrayList<Long> listDates){
        
        Long thisDate=0L;
        Long minDate=0L;
        
        for(int i=0; i<listDates.size()-1; i++)
        {
            int minIndex=i;
            for(int n=i+1; n<listDates.size(); n++)
            {
                thisDate=listDates.get(n);
                minDate=listDates.get(minIndex);
                if(thisDate<minDate)
                    minIndex=n;
            }
            
            minDate=listDates.get(minIndex);
            Long lTemp= minDate;
            listDates.set(minIndex, listDates.get(i));
            listDates.set(i, lTemp);
            
        }
        
    }
}
