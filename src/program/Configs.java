package program;

/**
* Author: Anupama Bhatta
* Date:   04/01/2019
* Description: Java application that can consolidate all files into one spreadsheet based
on the data range provided by the user. 
*/

public class Configs {

    private String imageDir = "/images/";  
    protected static String fileExtension = ".csv";
    
    public Configs()
    {
         
               
    }
    
    public String getImageURL() {
        return imageDir;
    }

    public String getImageDir() {
        return imageDir;
    }

    public static String getImageDirStatic() {
        Configs _config = new Configs();
        return _config.imageDir;
    }  
}
