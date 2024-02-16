package AuxPackage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
* Author: Sergey Y Chernokov
* Date:   10/11/2017
* Description: Class that contains static methods to validate values
 */
public class AuxValidator {
    
        
    /***
     * 
     * @param String value to validate - check to see if it is a number. isNumeric() method uses try-catch block to determine if the string a valid number.
     * @return true or false. True if the string is a valid number; false if the string is not a valid number
     */
    public static boolean isNumeric(String sValue)
    {
       // try parsing the value into integer, if fails then the number is not integer
       try {
           double num = Double.parseDouble(sValue);
           return true;
       }
       catch(Exception ex) //raise an exception if the code fails to execute
       {
           return false; // return false if parsing to an integer fails. It means that the value is not integer.
       }

    }
     
    /***
     * 
     * @param String value to validate - check to see if it is a number. isNumber() uses while loop to inspect the string.
     * @return true or false. True if the string is a valid number; false if the string is not a valid number
     */
    public static boolean isNumber(String sValue) 
    {
        boolean status=true;
           if(sValue.length()<1)
               return false;
           
            
        sValue = sValue.replace("$","");
        sValue = sValue.replace(" ","");
        
        
        
           int iCount=0;
           while (iCount < sValue.length())
           {
               char c=sValue.charAt(iCount);
               if( !Character.isDigit(c) && c !='.' )
               {
                   status=false;
                   break;
               }
               
               iCount++;
           }
           return status;
    }
    
    
    public static boolean isInt(String sValue) 
    {
        boolean status=true;
        if(sValue.length()<1)
            return false;

         sValue = sValue.replace("$","");
         sValue = sValue.replace(" ","");
        
        try 
        {
            int iInt = Integer.parseInt(sValue);
            return true;
        }
        catch(Exception ex)
        {
            return false;
        }
 
    }
    
    public static boolean isDate(String myDate)
    {
        Pattern pattern = Pattern.compile("^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$");
                Matcher matcher = pattern.matcher((CharSequence)myDate); 
                return matcher.matches(); 
    } 
    
    public static boolean isCorrectDate(String myDate)
    {
    Pattern pattern = Pattern.compile("^((2000|2400|2800|(19|2[0-9](0[48]|[2468][048]|[13579][26])))/02/29)$"
                +"^(((19|2[0-9])[0-9]{2})/02/(0[1-9]|1[0-9]|2[0-8]))$"
                + "|^(((19|2[0-9])[0-9]{2})/(0[13578]|10|12)/(0[1-9]|[12][0-9]|3[01]))$"
                + "|^(((19|2[0-9])[0-9]{2})/(0[469]|11)/(0[1-9]|[12][0-9]|30))$");
                Matcher matcher = pattern.matcher((CharSequence)myDate); 
                return matcher.matches(); 
    }        
}
