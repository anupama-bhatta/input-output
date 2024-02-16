package AuxPackage;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;

/*
 * Author:      Sergey Chernokov
 * Date:        1/13/2017
 * Description: Method to be used in form validation
 */

public class AuxValidatorForm {
    

//=========================================  Validate Number =============================================================   
  

    public static boolean IsValidNumber(JComponent control, JLabel lblError, double min, double max) 
    {
        String sErr = "Enter valid number between " + AuxFormatter.formatNumber(min) + " and "  +  AuxFormatter.formatNumber(max);
        return IsValidNumber( control,  lblError,  min,  max,  sErr) ;
         
    }
    
    
    
    public static boolean IsValidNumber(JComponent control, JLabel lblError, double min, double max, String sErr) 
    {
       String sInput = "";

        if (control instanceof JTextField)
            sInput = ((JTextField)control).getText();
        
          if (control instanceof JComboBox)
            sInput = ((JComboBox)control).getSelectedItem().toString();
       
         if ( AuxValidator.isInt(sInput))
         {
             double dNum = Double.parseDouble(sInput);
            
             if (dNum < min)
                sErr =  "The number is too small. " + sErr;                   
             else if (dNum > max)
                   sErr = "The number is too large. " + sErr;
             else 
             {
                styleNormal(control);
                lblError.setText("");
                lblError.setVisible(false);
                return true;
             }         
         }
         

        lblError.setText(sErr);
        styleError(control);
        styleError(lblError);
        return false;
         
    }
    
    
    public static boolean IsValidNumber(JComponent control, JLabel lblError, String sErr) 
    {
        String sVal = "";

        if (control instanceof JTextField)
            sVal = ((JTextField)control).getText();
        
          if (control instanceof JComboBox)
            sVal = ((JComboBox)control).getSelectedItem().toString();
        
        
        if ( AuxValidator.isNumber(sVal)){

             styleNormal(control);
             lblError.setText("");
             return true;
         }
         else
         {
             lblError.setText(sErr);
             styleError(control);
             styleError(lblError);
             return false;
         }
    }
  
    
    
    public static boolean IsValidNumber(JTextField txtField, JLabel lblError) 
    {
        String  sErr =  "Enter a valid numeric value";
        return IsValidNumber( txtField,  lblError,  sErr) ;

    }
    
      
    
   public static boolean isEmpty(JComponent control, JLabel lblError)
   {
       String sVal="";
       if (control instanceof  JComboBox )
       {
           if (((JComboBox)control).getSelectedItem()==null)
               return true;
           sVal = ((JComboBox)control).getSelectedItem().toString();
       }
       
        if (control instanceof  JTextField )
           sVal = ((JTextField)control).getText();
        
        
        if (sVal.equals(""))
        {
            styleError(control);
            styleError(lblError);
            lblError.setText("This field is required");
            return false;
        }
        
        
        styleNormal(control);
        styleNormal(lblError);
        lblError.setVisible(false);
        return true;
   }

 //========================================= END Validate Numeric =============================================================   

    public static void styleError(JComponent control)
    {
        control.setVisible(true);   
        control.setBackground(new java.awt.Color(255, 204, 204));
        control.setForeground(new java.awt.Color(204, 0, 51));
        control.setOpaque(true);  
    }
 
    public static void styleNormal(JComponent control)
    {
        control.setVisible(true);   
        control.setBackground(new java.awt.Color(255, 255, 255));
        control.setForeground(new java.awt.Color(0, 0, 0));
        control.setOpaque(true);
    }
    
    public static void styleInfo(JComponent control)
    {
        control.setVisible(true);   
        control.setBackground(new java.awt.Color(217, 237, 247));
        control.setForeground(new java.awt.Color(49, 112, 143));
        control.setOpaque(true);
    }
}


