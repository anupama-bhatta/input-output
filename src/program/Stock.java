package program;

/**
* Author: Anupama Bhatta
* Date:   04/01/2019
* Description: Java application that can consolidate all files into one spreadsheet based
on the data range provided by the user. 
*/

import java.util.ArrayList;

public class Stock {
    
    public String CsiNum;
    public String symbol;
    public String name;
    public String exchange;
    public String company;
    public ArrayList<StockData> ArStockData;
    
    public Stock(String CsiNum, String name, String exchange, String symbol, ArrayList<StockData> listStockData){
        this.CsiNum=CsiNum;
        this.name=name;
        this.exchange= exchange;
        this.symbol=symbol;
        this.ArStockData= new ArrayList<>();
        this.ArStockData= listStockData;   
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public ArrayList<StockData> getArStockData() {
        return ArStockData;
    }

    public void setArStockData(ArrayList<StockData> listStockData) {
        this.ArStockData = listStockData;
    }
    
    public String getCsiNum() {
        return CsiNum;
    }

    public void setCsiNum(String CsiNum) {
        this.CsiNum = CsiNum;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    } 
}
