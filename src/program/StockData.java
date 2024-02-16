
package program;

/**
* Author: Anupama Bhatta
* Date:   04/01/2019
* Description: Java application that can consolidate all files into one spreadsheet based
on the data range provided by the user. 
*/

public class StockData {
    
    public double Price;
    public long lDate;
    
    public StockData(Long lDate, double dPrice){
        this.lDate=lDate;
        this.Price= dPrice;
    }

    public long getlDate() {
        return lDate;
    }

    public void setlDate(long lDate) {
        this.lDate = lDate;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }
  
}
