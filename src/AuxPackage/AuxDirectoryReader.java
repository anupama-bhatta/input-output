/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AuxPackage;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Sergey
 */
public class AuxDirectoryReader {
   
    private boolean success;
    private String error;
    private ArrayList<String> arFileNames;
    
    private String directoryPath;
    

    public AuxDirectoryReader(String dataDir) {
        this.directoryPath = dataDir;
        
    }

    public  ArrayList<String> getFileNames(String dataDir, String fileExtention)
    {
        arFileNames = new ArrayList<String>();
         
        File dirData =  new File(dataDir);
        if (dataDir==null)
        {
            error = "Directory does not exists: '" + dataDir + "'";
           return null;
        }


        //======== Read all files and populate array of stocks with the qualified data ================= 
         File[] directoryListing = dirData.listFiles();
         if (directoryListing != null && directoryListing.length>0)
         {

             for (int i = 0; i < directoryListing.length; i++)
             {
                   String fileName = directoryListing[i].getName();
                if (fileName.toLowerCase().endsWith(fileExtention) )
                    arFileNames.add(fileName);

             }
         }
         
         return arFileNames;
     
    }
     

     


    
}
