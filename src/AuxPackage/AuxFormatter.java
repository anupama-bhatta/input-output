package AuxPackage;


import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;


public class AuxFormatter {
    public static String formatDate(String dDate)
    {
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");

        String sDate = format.format(dDate);
        
        return sDate;
        
    }
    
    public static String formatCurrency(double dVal)
    {
        return NumberFormat.getCurrencyInstance().format(dVal);
    }
      
     public static String formatNumberTwoDecimals(double dVal)
     {
         DecimalFormat fmt = new DecimalFormat("0.##"); 
         return fmt.format(dVal);
     }
     
     public static String formatPercent(double dVal)
     {
         NumberFormat format = NumberFormat.getPercentInstance();
         format.setMaximumFractionDigits(2);
         format.setMinimumFractionDigits(2);
         return format.format(dVal);
     }
     
    public static String formatNumber(double dVal)
    {

       return NumberFormat.getInstance().format(dVal);
    }
    
    public static String convertToHTML(String sVal)
    {
        sVal = sVal.replace("\n", "<br/>");
        sVal = "<html>" + sVal + "</html>";
        return sVal;
    }
    
    public static String convertDateToString(Long lDate){
        //use substring to add / between numbers
        
        String sDate= String.valueOf(lDate);
        String sYear=sDate.substring(0,4);
        String sMonth= sDate.substring(4,6);
        String sDay= sDate.substring(6,8);
        
        String sSDate= sMonth+"/"+sDay+"/"+sYear;
        
        return sSDate;
    }
    
    public static long convertDateToLong(String sDate){
        String sYear= sDate.substring(6,10);
        String sMonth= sDate.substring(0,2);
        String sDay= sDate.substring(3,5);
        
        sDate=""+ sYear+sMonth+sDay;
        
        return Long.parseLong(sDate);
    }
    
}
