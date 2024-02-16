
package program;

/**
* Author: Anupama Bhatta
* Date:   04/01/2019
* Description: Java application that can consolidate all files into one spreadsheet based
on the data range provided by the user. 
*/

import AuxPackage.AuxValidator;
import AuxPackage.AuxValidatorForm;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;

public class UI_Form extends javax.swing.JFrame {

    private boolean outputFileOK;
    private boolean inputDirOK;
    private boolean startDatesOK;
    private boolean endDatesOK;
    private String outputFile;
    
    ProcessFiles procFiles;
    String defaultOutputFileName;
    private ProgressCounter counter;       

    public UI_Form( ) {
        counter= new ProgressCounter();
        setSize(800, 600);
        
        setBackgroundImage("calculator.jpg");
        setResizable(false);
        
        initComponents();
        setPosition();
        setBorder();
        
        procFiles = new ProcessFiles();
        defaultOutputFileName = "ConsolidatedStockFile.csv";
        
        InitControls();
        setTestInits();

        if (txtEndDate.getText().isEmpty() || txtStartDate.getText().isEmpty())
        {
            hideLabelsAndButtons();
        }
    }

    private void setPosition() //put the form in the middle of the screen
    {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - getHeight()) / 2);
        setLocation(x, y);
    }
 
    public void setBackgroundImage(String imagePath)
    {
      //resizes the images based on the size of the form.
        imagePath = Configs.getImageDirStatic() + imagePath;
        ImageIcon imageIcon = new ImageIcon(getClass().getResource(imagePath)); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it
        Image newimg = image.getScaledInstance(getWidth(), getHeight(),  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way 
        imageIcon = new ImageIcon(newimg);  // transform it back
        setContentPane(new JLabel(imageIcon)); 
    }
    
     
     public void setBorder()
    {
        getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.decode("#182943")));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblProgress = new javax.swing.JLabel();
        lblFile = new javax.swing.JLabel();
        txtOutputFile = new javax.swing.JTextField();
        btnBrowseOutputFile = new javax.swing.JButton();
        btnBrowseInputFiles = new javax.swing.JButton();
        txtInputDataDirectory = new javax.swing.JTextField();
        lblStartDate = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        lblLoader = new javax.swing.JLabel();
        btnProcessFiles = new javax.swing.JButton();
        lblFile2 = new javax.swing.JLabel();
        txtEndDate = new javax.swing.JTextField();
        txtStartDate = new javax.swing.JTextField();
        lblDateDash = new javax.swing.JLabel();
        lblError = new javax.swing.JLabel();
        lblDateError = new javax.swing.JLabel();
        btnOpenConsolidated = new javax.swing.JButton();
        progressBar = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        lblProgress.setBackground(new java.awt.Color(255, 255, 255));
        lblProgress.setOpaque(true);
        getContentPane().add(lblProgress);
        lblProgress.setBounds(250, 350, 530, 30);

        lblFile.setBackground(new java.awt.Color(255, 255, 255));
        lblFile.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblFile.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFile.setText(" Output File Directory:");
        lblFile.setOpaque(true);
        getContentPane().add(lblFile);
        lblFile.setBounds(10, 170, 150, 25);

        txtOutputFile.setBackground(new java.awt.Color(245, 245, 245));
        txtOutputFile.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtOutputFile.setForeground(new java.awt.Color(0, 0, 102));
        txtOutputFile.setMargin(new java.awt.Insets(5, 5, 5, 5));
        getContentPane().add(txtOutputFile);
        txtOutputFile.setBounds(170, 170, 520, 25);

        btnBrowseOutputFile.setText("Browse...");
        btnBrowseOutputFile.setActionCommand("Browse");
        btnBrowseOutputFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseOutputFileActionPerformed(evt);
            }
        });
        getContentPane().add(btnBrowseOutputFile);
        btnBrowseOutputFile.setBounds(700, 170, 87, 25);

        btnBrowseInputFiles.setText("Browse...");
        btnBrowseInputFiles.setActionCommand("Browse");
        btnBrowseInputFiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseInputFilesActionPerformed(evt);
            }
        });
        getContentPane().add(btnBrowseInputFiles);
        btnBrowseInputFiles.setBounds(700, 140, 87, 25);

        txtInputDataDirectory.setBackground(new java.awt.Color(245, 245, 245));
        txtInputDataDirectory.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtInputDataDirectory.setMargin(new java.awt.Insets(5, 5, 5, 5));
        txtInputDataDirectory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtInputDataDirectoryActionPerformed(evt);
            }
        });
        getContentPane().add(txtInputDataDirectory);
        txtInputDataDirectory.setBounds(170, 140, 520, 25);

        lblStartDate.setBackground(new java.awt.Color(255, 255, 255));
        lblStartDate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblStartDate.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblStartDate.setText("Date Range:");
        lblStartDate.setOpaque(true);
        getContentPane().add(lblStartDate);
        lblStartDate.setBounds(10, 210, 150, 25);

        lblTitle.setBackground(new java.awt.Color(102, 102, 102));
        lblTitle.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Process Files Demo");
        getContentPane().add(lblTitle);
        lblTitle.setBounds(0, 10, 800, 30);

        lblStatus.setBackground(new java.awt.Color(255, 255, 255));
        lblStatus.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblStatus.setForeground(new java.awt.Color(0, 51, 102));
        lblStatus.setText(" Output File Directory:");
        lblStatus.setOpaque(true);
        getContentPane().add(lblStatus);
        lblStatus.setBounds(10, 260, 540, 50);

        lblLoader.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/load.gif"))); // NOI18N
        getContentPane().add(lblLoader);
        lblLoader.setBounds(23, 345, 42, 42);

        btnProcessFiles.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnProcessFiles.setText("Process Files");
        btnProcessFiles.setActionCommand("                        Process Files");
        btnProcessFiles.setAutoscrolls(true);
        btnProcessFiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcessFilesActionPerformed(evt);
            }
        });
        getContentPane().add(btnProcessFiles);
        btnProcessFiles.setBounds(20, 340, 200, 50);

        lblFile2.setBackground(new java.awt.Color(255, 255, 255));
        lblFile2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblFile2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFile2.setText(" Data Files Directory:");
        lblFile2.setOpaque(true);
        getContentPane().add(lblFile2);
        lblFile2.setBounds(10, 140, 150, 25);

        txtEndDate.setBackground(new java.awt.Color(245, 245, 245));
        txtEndDate.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtEndDate.setForeground(new java.awt.Color(0, 0, 102));
        txtEndDate.setText("End Date");
        txtEndDate.setMargin(new java.awt.Insets(5, 5, 5, 5));
        txtEndDate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEndDateFocusLost(evt);
            }
        });
        txtEndDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtEndDateMouseClicked(evt);
            }
        });
        txtEndDate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEndDateKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEndDateKeyReleased(evt);
            }
        });
        getContentPane().add(txtEndDate);
        txtEndDate.setBounds(290, 210, 100, 25);

        txtStartDate.setBackground(new java.awt.Color(245, 245, 245));
        txtStartDate.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtStartDate.setForeground(new java.awt.Color(0, 0, 102));
        txtStartDate.setText("Start Date");
        txtStartDate.setMargin(new java.awt.Insets(5, 5, 5, 5));
        txtStartDate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtStartDateFocusLost(evt);
            }
        });
        txtStartDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtStartDateMouseClicked(evt);
            }
        });
        txtStartDate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtStartDateKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtStartDateKeyReleased(evt);
            }
        });
        getContentPane().add(txtStartDate);
        txtStartDate.setBounds(170, 210, 100, 25);

        lblDateDash.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblDateDash.setText(" - ");
        getContentPane().add(lblDateDash);
        lblDateDash.setBounds(270, 210, 20, 22);

        lblError.setBackground(new java.awt.Color(255, 204, 204));
        lblError.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblError.setForeground(new java.awt.Color(204, 0, 51));
        lblError.setText("Error Label");
        lblError.setOpaque(true);
        getContentPane().add(lblError);
        lblError.setBounds(9, 52, 770, 80);

        lblDateError.setBackground(new java.awt.Color(255, 204, 204));
        lblDateError.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblDateError.setForeground(new java.awt.Color(204, 0, 51));
        lblDateError.setText("Date Error");
        lblDateError.setOpaque(true);
        getContentPane().add(lblDateError);
        lblDateError.setBounds(400, 210, 380, 30);

        btnOpenConsolidated.setText("Open Consolidated File");
        btnOpenConsolidated.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenConsolidatedActionPerformed(evt);
            }
        });
        getContentPane().add(btnOpenConsolidated);
        btnOpenConsolidated.setBounds(560, 260, 210, 50);
        getContentPane().add(progressBar);
        progressBar.setBounds(250, 380, 530, 10);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBrowseOutputFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseOutputFileActionPerformed
         setOutputFile();
    }//GEN-LAST:event_btnBrowseOutputFileActionPerformed

    private void setInputDir()
    {
        // method that invokes file chooser and counts how many csv files in selected directory and displays the number of found files.

        File dataDir = getFileDirectoryFileChooser();
        if (dataDir == null) // this is needed when user clicks cancel in the file chooser; then dataDir is null - make sure to stop the method otherwise errors.
            return;
        txtInputDataDirectory.setText(dataDir.getAbsolutePath());
         
        File[] directoryListing = dataDir.listFiles();
        if (directoryListing != null)
        {
            int iCount = 0;
            for (int i=0; i < directoryListing.length; i++)
            {
                String fileName = directoryListing[i].getName();
                if (fileName.contains(Configs.fileExtension))
                   iCount++;
            }            
            if (iCount > 0)
            {
                lblStatus.setText(" " + iCount + " data files were found.");
                progressBar.setMaximum(iCount);
                lblError.setVisible(false);                
                progressBar.setMaximum(iCount);
                lblStatus.setVisible(true);
                AuxValidatorForm.styleNormal(txtInputDataDirectory);
                inputDirOK = true;
            }
            else
            {
                lblStatus.setVisible(false);
                lblError.setVisible(true);
                lblError.setText("No data files were found. Please specify the folder with data.");
                AuxValidatorForm.styleNormal(txtInputDataDirectory);
                inputDirOK = false;
            }
        }
        else
        {
            lblStatus.setVisible(false);    
            lblError.setVisible(true);
            lblError.setText("There was a problem with the folder you selected. Please verify the directory and try again.");
        }  
        
        if (outputFileOK && inputDirOK && startDatesOK && endDatesOK)
            btnProcessFiles.setVisible(true);
        else
            btnProcessFiles.setVisible(false);    
    }
    
    private void setOutputFile()
    {
        //method invokes file chooser and sets the output file
        
         File dataDir = getFileDirectoryFileChooser();
         if (dataDir==null) // this is needed when user clicks cancel in the file chooser; then dataDir is null - make sure to stop the method otherwise errors.
             return;
    }
    
    
    private void setTestInits(){
        //here for testing
        txtInputDataDirectory.setText("Data/CSV");
        txtOutputFile.setText(defaultOutputFileName);
        
        btnProcessFiles.setVisible(true);
        outputFileOK=true;
        inputDirOK=true;
        startDatesOK=true;
        endDatesOK=true;
        
        counter.setMax(419);
        progressBar.setMaximum(counter.getMax());       
        
    }
    
    private boolean checkStartDate()
    {
        if (AuxValidator.isDate(txtStartDate.getText()) == true)   
        {
            AuxValidatorForm.styleNormal(txtStartDate);
            lblDateError.setVisible(false);
            btnProcessFiles.setVisible(true);
            startDatesOK = true;
            return true; 
        }
        else
        {
            lblDateError.setVisible(true);
            lblDateError.setText("Start date is not correct. Format as MM/DD/YYYY.");
            AuxValidatorForm.styleError(txtStartDate);           
            btnProcessFiles.setVisible(false);
            startDatesOK = false;
            return false;    
        }     
    }        
     
    private boolean checkStartDateTwo()
    {
        if (AuxValidator.isCorrectDate(txtStartDate.getText()) == true)   
        {
            AuxValidatorForm.styleNormal(txtStartDate);
            lblDateError.setVisible(false);
            btnProcessFiles.setVisible(true);
            startDatesOK = true;
            return true; 
        }
        else
        {
            lblDateError.setVisible(true);
            lblDateError.setText("Please provide the correct start date.");
            AuxValidatorForm.styleError(txtStartDate);           
            btnProcessFiles.setVisible(false);
            startDatesOK = false;
            return false;    
        }     
    }
    
    private boolean checkEndDate()
    {
        if (AuxValidator.isDate(txtEndDate.getText()) == true)   
        {
            AuxValidatorForm.styleNormal(txtEndDate);
            lblDateError.setVisible(false);
            btnProcessFiles.setVisible(true);
            endDatesOK = true;
            return true;
        }
        else
        {
            lblDateError.setVisible(true);
            lblDateError.setText("End date is not correct. Format as MM/DD/YYYY.");
            AuxValidatorForm.styleError(txtEndDate);
            btnProcessFiles.setVisible(false);
            endDatesOK = false;
            return false;     
        }
    }
     
    private boolean checkEndDateTwo()
    {
        if (AuxValidator.isCorrectDate(txtEndDate.getText()) == true)   
        {
            AuxValidatorForm.styleNormal(txtEndDate);
            lblDateError.setVisible(false);
            btnProcessFiles.setVisible(true);
            endDatesOK = true;
            return true;
        }
        else
        {
            lblDateError.setVisible(true);
            lblDateError.setText("Please provide the correct end date.");
            AuxValidatorForm.styleError(txtEndDate);
            btnProcessFiles.setVisible(false);
            endDatesOK = false;
            return false;     
        }
        
    }
    private void InitControls()
    {
        //method that set initial visibility of labels (hides error labels and clears labels and text boxes)
        lblError.setVisible(false);
        lblLoader.setVisible(false);
        btnProcessFiles.setVisible(false);
        lblStatus.setText("");
        txtStartDate.setText(null);
        txtEndDate.setText(null);
        lblStatus.setVisible(false);
        lblDateError.setVisible(false);
        btnProcessFiles.setVisible(false);
        btnOpenConsolidated.setVisible(false);
    }
     

    private File getFileDirectoryFileChooser()
    {
        File selectedFile = null;
        
        //the the folder where the application is in
        String applicationDir = getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
        
        //specify the starting directory of the file chooser.
        JFileChooser fileChooser = new JFileChooser(applicationDir);
        
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); // enforces to get the directory instead of file
         

        int returnValue = fileChooser.showOpenDialog(null); //show the dialog window of file chooser and get the return value

          //make sure user selected the file/direcotry properly by comparing return value with approve option
        if (returnValue == JFileChooser.APPROVE_OPTION)
            selectedFile = fileChooser.getSelectedFile(); //get the selected file/directory
  
        return selectedFile;
    }
     
     
    private void btnBrowseInputFilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseInputFilesActionPerformed
        setInputDir();
    }//GEN-LAST:event_btnBrowseInputFilesActionPerformed

    private void processFiles()
    {
        //method the processes all files and creates consolidation file.
        progressBar.setVisible(true);
        lblProgress.setVisible(true);
        
        String dataDir= txtInputDataDirectory.getText();
        outputFile= txtOutputFile.getText();
        String sStartDate= txtStartDate.getText();
        String sEndDate= txtEndDate.getText();
        
        procFiles= new ProcessFiles(dataDir, outputFile, sStartDate, sEndDate, counter);
        
        String sStatus= procFiles.getProcessedFileCount()+ " stocks were consolidated successfully.<br/>";
        sStatus += procFiles.getRejectedFileCount()+ " files were skipped because they did not have qualified dates.<br/>";
        sStatus = "<html>" + sStatus + "</html>";
        lblStatus.setText(sStatus);
        lblStatus.setVisible(true);
        
        if(procFiles.getStatus()==true)
        {
            if(procFiles.getProcessedFileCount()>0)
                btnOpenConsolidated.setVisible(true);
            else{
                btnOpenConsolidated.setVisible(false);
            }
        }
        else
        {
            btnProcessFiles.setVisible(false);
            lblProgress.setText("Error: " + procFiles.getStatusDesc());
            lblError.setText("<html>Error: " + procFiles.getStatusDesc() + "</html");
            lblError.setVisible(true);
            progressBar.setVisible(false);
            btnOpenConsolidated.setVisible(false);   
        }      
    }
    
    private void hideLabelsAndButtons()
    {
        lblProgress.setVisible(false);
        progressBar.setVisible(false);
        btnProcessFiles.setVisible(false);
        btnOpenConsolidated.setVisible(false);
        lblLoader.setVisible(false);        
    }
    
    private void btnProcessFilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcessFilesActionPerformed
        if(lblLoader.isVisible()==true)
            return;

        new Thread(() -> {
            updateProgressBar();
            progressBar.setValue(progressBar.getMaximum());
        }).start();
        
        new Thread(() -> {
            lblLoader.setVisible(true);
            processFiles(); //reads file, processes logic and output the file
            lblLoader.setVisible(false);
            progressBar.setVisible(false);
        }).start();

    }//GEN-LAST:event_btnProcessFilesActionPerformed

    public void updateProgressBar()
    {
        //show the progress of reading the file
        while(!counter.isReadingComplete)
        {
            int filesProcessed= counter.getCount();
            progressBar.setValue(filesProcessed);
            lblProgress.setText(counter.getTaskDescription());
        }
        
        //use the counter to display the progress of writing the file
        
        progressBar.setMaximum(counter.getMax());
        while(!counter.isOutputComplete())
        {
            int filesProcessed= counter.getCount();
            progressBar.setValue(filesProcessed);
            lblProgress.setText(counter.getTaskDescription()); 
        }
        
        lblProgress.setText("File processing is complete!");
    }
  

    private void txtStartDateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtStartDateFocusLost
        
//        if (checkStartDateTwo() && checkEndDateTwo())
//            btnProcessFiles.setVisible(true);
    }//GEN-LAST:event_txtStartDateFocusLost

    private void txtEndDateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEndDateFocusLost
        
//        if (checkEndDateTwo() && checkStartDateTwo())
//            btnProcessFiles.setVisible(true);
    }//GEN-LAST:event_txtEndDateFocusLost

    private void txtStartDateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStartDateKeyReleased

        if (checkStartDate() && checkEndDate())
            btnProcessFiles.setVisible(true);        
    }//GEN-LAST:event_txtStartDateKeyReleased

    private void txtEndDateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEndDateKeyReleased

        if (checkEndDate() && checkStartDate())
            btnProcessFiles.setVisible(true);
    }//GEN-LAST:event_txtEndDateKeyReleased

    private void btnOpenConsolidatedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenConsolidatedActionPerformed
        File file = new File(outputFile);
        try {
            Desktop.getDesktop().open(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnOpenConsolidatedActionPerformed

    private void txtStartDateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtStartDateMouseClicked
        
    }//GEN-LAST:event_txtStartDateMouseClicked

    private void txtStartDateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStartDateKeyPressed

    }//GEN-LAST:event_txtStartDateKeyPressed

    private void txtEndDateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEndDateKeyPressed

    }//GEN-LAST:event_txtEndDateKeyPressed

    private void txtInputDataDirectoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInputDataDirectoryActionPerformed

    }//GEN-LAST:event_txtInputDataDirectoryActionPerformed

    private void txtEndDateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEndDateMouseClicked
        
    }//GEN-LAST:event_txtEndDateMouseClicked

  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBrowseInputFiles;
    private javax.swing.JButton btnBrowseOutputFile;
    private javax.swing.JButton btnOpenConsolidated;
    private javax.swing.JButton btnProcessFiles;
    private javax.swing.JLabel lblDateDash;
    private javax.swing.JLabel lblDateError;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblFile;
    private javax.swing.JLabel lblFile2;
    private javax.swing.JLabel lblLoader;
    private javax.swing.JLabel lblProgress;
    private javax.swing.JLabel lblStartDate;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JTextField txtEndDate;
    private javax.swing.JTextField txtInputDataDirectory;
    private javax.swing.JTextField txtOutputFile;
    private javax.swing.JTextField txtStartDate;
    // End of variables declaration//GEN-END:variables
}
