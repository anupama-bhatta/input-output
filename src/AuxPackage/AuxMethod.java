package AuxPackage;


import java.util.Date;
import java.util.GregorianCalendar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author schernokov
 */
public class AuxMethod 
{
    
    
    public static double DateDiffSeconds(Date startDate) {


    /** Today's date */
    Date today = new Date();

    // Get msec from each, and subtract.
    long diff = today.getTime() - startDate.getTime();
    
    double seconds = (double) diff / (double)(1000);
    seconds = Math.round(seconds*100)/100D;
    return seconds;
            
  
    }
    
    
    
    
}
