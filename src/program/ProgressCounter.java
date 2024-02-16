
package program;

/**
* Author: Anupama Bhatta
* Date:   04/01/2019
* Description: Java application that can consolidate all files into one spreadsheet based
on the data range provided by the user. 
*/

import AuxPackage.AuxFormatter;

public class ProgressCounter {
    int count;                    
    boolean isReadingComplete;    
    boolean outputComplete;      
    int max;                      
    String taskDescription;       
    String task;
        
    public ProgressCounter(){
        this.count=0;
        isReadingComplete=false;
        outputComplete=false;        
    }

    public boolean isOutputComplete() {
        return outputComplete;
    }

    public void setOutputComplete(boolean outputComplete) {
        this.outputComplete = outputComplete;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isReadingComplete() {
        return isReadingComplete;
    }

    public void setReadingComplete(boolean isComplete) {
        this.isReadingComplete = isComplete;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }
    
    public void up(String whatProcess){
        this.count++;
        
        if(whatProcess.equalsIgnoreCase("read"))
            this.taskDescription= setReadingTaskStatus();
        
        if(whatProcess.equalsIgnoreCase("write"))
            this.taskDescription= setWritingTaskStatus();
        
        if(whatProcess.equalsIgnoreCase("complete"))
            this.taskDescription= "All files were consolidated.";
    }
    
    public String setReadingTaskStatus(){
      return "Input data files are being read and processed: " + AuxFormatter.formatPercent((double)count/max);  
    }
    
    public String setWritingTaskStatus(){
      return "Input data files were read and proessed. Creating output files: " + AuxFormatter.formatPercent((double)count/max);  
    }
}
