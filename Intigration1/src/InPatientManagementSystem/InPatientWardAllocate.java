package InPatientManagementSystem;

import MYSQL.DBConnect;
import java.awt.Color;
import java.awt.event.KeyEvent;
import static java.lang.Thread.sleep;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hp
 */
public class InPatientWardAllocate extends javax.swing.JFrame {

    Connection conn=null;
    ResultSet rs=null;
    PreparedStatement pst=null;
    public boolean rmAvailable;
    private String pid;
    private String pid1;
    /**
     * Creates new form InPatientWardAllocate
     */
    public InPatientWardAllocate() {
        initComponents();
        conn = DBConnect.connect();
        currentDate();
        Display_roomAvailability();

    }

    public void ward_allocate(String roomid){
        this.setVisible(true);
        WardBooking w=new WardBooking();
        w.set_Wdetails(roomid);
        w.setVisible(true);
        w.setWard(this);
        //Display_roomAvailability();
      

    }
    
    private void currentDate(){
        /*Calendar cal = new GregorianCalendar();
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        
        DateField.setText("Current Date : "+day+"/"+(month+1)+"/"+year);
        
       
        int minute = cal.get(Calendar.MINUTE);
        int hour = cal.get(Calendar.HOUR);
        
        TimeField.setText("Current Time : "+hour+":"+minute);*/
        Thread clock=new Thread(){
          public void run(){
              for(;;){
                  Calendar cal=new GregorianCalendar();
       
                    int month=cal.get(Calendar.MONTH);
                    int year=cal.get(Calendar.YEAR);
                    int day=cal.get(Calendar.DAY_OF_MONTH);
   
                    DateField.setText(year+"-"+(month+1)+"-"+day);
       
                    int second=cal.get(Calendar.SECOND);
                    int minute=cal.get(Calendar.MINUTE);
                    int hour=cal.get(Calendar.HOUR);
       
                    TimeField.setText(hour+":"+minute+":"+second);
                  
                  try {
                      sleep(1000);
                  } catch (InterruptedException ex) {
                      Logger.getLogger(InPatientDetails.class.getName()).log(Level.SEVERE, null, ex);
                  }
              
              
              }
          
          
          } 
       
       
       };
       clock.start();
        
    }
    
    
    public boolean check_room_availabilty(String RoomNo){
        Connection conn = DBConnect.connect();
        String q="select RoomAvailability from warddetails where RoomNo=? ";
        boolean avl=true;
        try {
            pst=conn.prepareStatement(q);
            pst.setString(1,RoomNo);
            rs=pst.executeQuery();
            if(rs.next()){
            
            avl=rs.getBoolean("RoomAvailability");
            conn.close();
            }
          
        } catch (SQLException ex) {
            Logger.getLogger(InPatientWardAllocate.class.getName()).log(Level.SEVERE, null, ex);
        }

        
     return avl;
    
    }
    
    public void Display_roomAvailability(){
        available.setBackground(Color.green);
        unavailable.setBackground(Color.red);
        
        String[] roomId = new String[] {"Room 1","Room 2","Room 3","Room 4","Room 5","Room 6","Room 7","Room 8","Room 9","Room 10","Room 11","Room 12","Room 13","Room 14","Room 15","Room 16","Room 17","Room 18","Room 19","Room 20","Room 21","Room 22","Room 23","Room 24","Room 25","Room 26","Room 27","Room 28","Room 29","Room 30","Room 31","Room 32","Room 33","Room 34","Room 35","Room 36","Room 37","Room 38","Room 39","Room 40","Room 41","Room 42","Room 43","Room 44","Room 45","Room 46","Room 47","Room 48"};
    
        if(check_room_availabilty(roomId[0])){
            room1.setBackground(Color.green);
        }
        else{
            room1.setBackground(Color.red);    
        }
        
        
        if(check_room_availabilty(roomId[1])){
            room2.setBackground(Color.green);
        }
        else{
            room2.setBackground(Color.red);    
        }
        
        
        if(check_room_availabilty(roomId[2])){
            room3.setBackground(Color.green);
        }
        else{
            room3.setBackground(Color.red);    
        }
        
        
        if(check_room_availabilty(roomId[3])){
            room4.setBackground(Color.green);
        }
        else{
            room4.setBackground(Color.red);    
        }
        
        
        if(check_room_availabilty(roomId[4])){
            room5.setBackground(Color.green);
        }
        else{
            room5.setBackground(Color.red);    
        }
        
        
        if(check_room_availabilty(roomId[5])){
            room6.setBackground(Color.green);
        }
        else{
            room6.setBackground(Color.red);    
        }
        
        
        if(check_room_availabilty(roomId[6])){
            room7.setBackground(Color.green);
        }
        else{
            room7.setBackground(Color.red);    
        }
        
        
        if(check_room_availabilty(roomId[7])){
            room8.setBackground(Color.green);
        }
        else{
            room8.setBackground(Color.red);    
        }
        
        
        if(check_room_availabilty(roomId[8])){
            room9.setBackground(Color.green);
        }
        else{
            room9.setBackground(Color.red);    
        }
        
        
        if(check_room_availabilty(roomId[9])){
            room10.setBackground(Color.green);
        }
        else{
            room10.setBackground(Color.red);    
        }
        
        
        if(check_room_availabilty(roomId[10])){
            room11.setBackground(Color.green);
        }
        else{
            room11.setBackground(Color.red);    
        }
        
        
        if(check_room_availabilty(roomId[11])){
            room12.setBackground(Color.green);
        }
        else{
            room12.setBackground(Color.red);    
        }
        
        
        if(check_room_availabilty(roomId[12])){
            room13.setBackground(Color.green);
        }
        else{
            room13.setBackground(Color.red);    
        }
        
        
        if(check_room_availabilty(roomId[13])){
            room14.setBackground(Color.green);
        }
        else{
            room14.setBackground(Color.red);    
        }
        
        
        if(check_room_availabilty(roomId[14])){
            room15.setBackground(Color.green);
        }
        else{
            room15.setBackground(Color.red);    
        }
        
        
        if(check_room_availabilty(roomId[15])){
            room16.setBackground(Color.green);
        }
        else{
            room16.setBackground(Color.red);    
        }
        
        
        if(check_room_availabilty(roomId[16])){
            room17.setBackground(Color.green);
        }
        else{
            room17.setBackground(Color.red);    
        }
        
        
        if(check_room_availabilty(roomId[17])){
            room18.setBackground(Color.green);
        }
        else{
            room18.setBackground(Color.red);    
        }
        
        
        if(check_room_availabilty(roomId[18])){
            room19.setBackground(Color.green);
        }
        else{
            room19.setBackground(Color.red);    
        }
        
        
        if(check_room_availabilty(roomId[19])){
            room20.setBackground(Color.green);
        }
        else{
            room20.setBackground(Color.red);    
        }
        
        
        if(check_room_availabilty(roomId[20])){
            room21.setBackground(Color.green);
        }
        else{
            room21.setBackground(Color.red);    
        }
        
        
        if(check_room_availabilty(roomId[21])){
            room22.setBackground(Color.green);
        }
        else{
            room22.setBackground(Color.red);    
        }
        
        
        if(check_room_availabilty(roomId[22])){
            room23.setBackground(Color.green);
        }
        else{
            room23.setBackground(Color.red);    
        }
        
        
        if(check_room_availabilty(roomId[23])){
            room24.setBackground(Color.green);
        }
        else{
            room24.setBackground(Color.red);    
        }
        
        
        if(check_room_availabilty(roomId[24])){
            room25.setBackground(Color.green);
        }
        else{
            room25.setBackground(Color.red);    
        }
        
        
        if(check_room_availabilty(roomId[25])){
            room26.setBackground(Color.green);
        }
        else{
            room26.setBackground(Color.red);    
        }
        
        
        if(check_room_availabilty(roomId[26])){
            room27.setBackground(Color.green);
        }
        else{
            room27.setBackground(Color.red);    
        }
        
        
        if(check_room_availabilty(roomId[27])){
            room28.setBackground(Color.green);
        }
        else{
            room28.setBackground(Color.red);    
        }
        
        
        if(check_room_availabilty(roomId[28])){
            room29.setBackground(Color.green);
        }
        else{
            room29.setBackground(Color.red);    
        }
        
        
        if(check_room_availabilty(roomId[29])){
            room30.setBackground(Color.green);
        }
        else{
            room30.setBackground(Color.red);    
        }
        
        
        if(check_room_availabilty(roomId[30])){
            room31.setBackground(Color.green);
        }
        else{
            room31.setBackground(Color.red);    
        }
        
        
        if(check_room_availabilty(roomId[31])){
            room32.setBackground(Color.green);
        }
        else{
            room32.setBackground(Color.red);    
        }
        
        
        if(check_room_availabilty(roomId[32])){
            room33.setBackground(Color.green);
        }
        else{
            room33.setBackground(Color.red);    
        }
        
        
        if(check_room_availabilty(roomId[33])){
            room34.setBackground(Color.green);
        }
        else{
            room34.setBackground(Color.red);    
        }
        
        
        if(check_room_availabilty(roomId[34])){
            room35.setBackground(Color.green);
        }
        else{
            room35.setBackground(Color.red);    
        }
        
        
        if(check_room_availabilty(roomId[35])){
            room36.setBackground(Color.green);
        }
        else{
            room36.setBackground(Color.red);    
        }
        
        
        if(check_room_availabilty(roomId[36])){
            room37.setBackground(Color.green);
        }
        else{
            room37.setBackground(Color.red);    
        }
        
        
        if(check_room_availabilty(roomId[37])){
            room38.setBackground(Color.green);
        }
        else{
            room38.setBackground(Color.red);    
        }
        
        if(check_room_availabilty(roomId[38])){
            room39.setBackground(Color.green);
        }
        else{
            room39.setBackground(Color.red);    
        }
        
        if(check_room_availabilty(roomId[39])){
            room40.setBackground(Color.green);
        }
        else{
            room40.setBackground(Color.red);    
        }
        
        if(check_room_availabilty(roomId[40])){
            room41.setBackground(Color.green);
        }
        else{
            room41.setBackground(Color.red);    
        }
        
        if(check_room_availabilty(roomId[41])){
            room42.setBackground(Color.green);
        }
        else{
            room42.setBackground(Color.red);    
        }
        
        if(check_room_availabilty(roomId[42])){
            room43.setBackground(Color.green);
        }
        else{
            room43.setBackground(Color.red);    
        }
        
        if(check_room_availabilty(roomId[43])){
            room44.setBackground(Color.green);
        }
        else{
            room44.setBackground(Color.red);    
        }
        
        if(check_room_availabilty(roomId[44])){
            room45.setBackground(Color.green);
        }
        else{
            room45.setBackground(Color.red);    
        }
        
        if(check_room_availabilty(roomId[45])){
            room46.setBackground(Color.green);
        }
        else{
            room46.setBackground(Color.red);    
        }
        
        if(check_room_availabilty(roomId[46])){
            room47.setBackground(Color.green);
        }
        else{
            room47.setBackground(Color.red);    
        }
        
        if(check_room_availabilty(roomId[47])){
            room48.setBackground(Color.green);
        }
        else{
            room48.setBackground(Color.red);    
        }
        
                
    }
        
    public void view_AdmittedPatientDetails(String roomid){
        this.setVisible(true);
        AdmittedPatientDetails adp=new AdmittedPatientDetails();
        adp.addmitted_patient(roomid);
        adp.setVisible(true);
        adp.setWard(this);

    }
    
    public void Display_roomOrPatientDetails(String roomId){
        if(check_room_availabilty(roomId)){
            this.setVisible(true);
            ward_allocate(roomId);
            //this.setVisible(false);
        }
        else{
            this.setVisible(true);
            view_AdmittedPatientDetails(roomId);
            //this.setVisible(false);
        }
    
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        DateField = new javax.swing.JLabel();
        TimeField = new javax.swing.JLabel();
        Back = new javax.swing.JToggleButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        room1 = new javax.swing.JButton();
        room2 = new javax.swing.JButton();
        room3 = new javax.swing.JButton();
        room4 = new javax.swing.JButton();
        room5 = new javax.swing.JButton();
        room6 = new javax.swing.JButton();
        room7 = new javax.swing.JButton();
        room8 = new javax.swing.JButton();
        room9 = new javax.swing.JButton();
        room10 = new javax.swing.JButton();
        room11 = new javax.swing.JButton();
        room12 = new javax.swing.JButton();
        room13 = new javax.swing.JButton();
        room14 = new javax.swing.JButton();
        room15 = new javax.swing.JButton();
        room16 = new javax.swing.JButton();
        room17 = new javax.swing.JButton();
        room18 = new javax.swing.JButton();
        room19 = new javax.swing.JButton();
        room20 = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        room41 = new javax.swing.JButton();
        room42 = new javax.swing.JButton();
        room43 = new javax.swing.JButton();
        room44 = new javax.swing.JButton();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        room45 = new javax.swing.JButton();
        room46 = new javax.swing.JButton();
        room47 = new javax.swing.JButton();
        room48 = new javax.swing.JButton();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        available = new javax.swing.JButton();
        unavailable = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        jLabel125 = new javax.swing.JLabel();
        jLabel126 = new javax.swing.JLabel();
        jLabel127 = new javax.swing.JLabel();
        jLabel128 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        room21 = new javax.swing.JButton();
        room23 = new javax.swing.JButton();
        room24 = new javax.swing.JButton();
        room25 = new javax.swing.JButton();
        room22 = new javax.swing.JButton();
        room26 = new javax.swing.JButton();
        room27 = new javax.swing.JButton();
        room28 = new javax.swing.JButton();
        room29 = new javax.swing.JButton();
        room30 = new javax.swing.JButton();
        room31 = new javax.swing.JButton();
        room32 = new javax.swing.JButton();
        room33 = new javax.swing.JButton();
        room34 = new javax.swing.JButton();
        room35 = new javax.swing.JButton();
        room36 = new javax.swing.JButton();
        room37 = new javax.swing.JButton();
        room38 = new javax.swing.JButton();
        room39 = new javax.swing.JButton();
        room40 = new javax.swing.JButton();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        jLabel114 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        jLabel121 = new javax.swing.JLabel();
        jLabel122 = new javax.swing.JLabel();
        jLabel123 = new javax.swing.JLabel();
        jLabel124 = new javax.swing.JLabel();
        ReportButton = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(1300, 690));

        jPanel2.setPreferredSize(new java.awt.Dimension(1335, 690));

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Patient Management");

        Back.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(Back)
                .addGap(103, 103, 103)
                .addComponent(DateField, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112)
                .addComponent(jLabel1)
                .addGap(229, 229, 229)
                .addComponent(TimeField, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(107, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TimeField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(Back))
                            .addComponent(DateField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(2, 2, 2)))
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Normal Ward 1", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        room1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InPatientManagementSystem/wardPng.png"))); // NOI18N
        room1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room1ActionPerformed(evt);
            }
        });

        room2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InPatientManagementSystem/wardPng.png"))); // NOI18N
        room2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room2ActionPerformed(evt);
            }
        });

        room3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InPatientManagementSystem/wardPng.png"))); // NOI18N
        room3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room3ActionPerformed(evt);
            }
        });

        room4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InPatientManagementSystem/wardPng.png"))); // NOI18N
        room4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room4ActionPerformed(evt);
            }
        });

        room5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InPatientManagementSystem/wardPng.png"))); // NOI18N
        room5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room5ActionPerformed(evt);
            }
        });

        room6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InPatientManagementSystem/wardPng.png"))); // NOI18N
        room6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room6ActionPerformed(evt);
            }
        });

        room7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InPatientManagementSystem/wardPng.png"))); // NOI18N
        room7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room7ActionPerformed(evt);
            }
        });

        room8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InPatientManagementSystem/wardPng.png"))); // NOI18N
        room8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room8ActionPerformed(evt);
            }
        });

        room9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InPatientManagementSystem/wardPng.png"))); // NOI18N
        room9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room9ActionPerformed(evt);
            }
        });

        room10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InPatientManagementSystem/wardPng.png"))); // NOI18N
        room10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room10ActionPerformed(evt);
            }
        });

        room11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InPatientManagementSystem/wardPng.png"))); // NOI18N
        room11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room11ActionPerformed(evt);
            }
        });

        room12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InPatientManagementSystem/wardPng.png"))); // NOI18N
        room12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room12ActionPerformed(evt);
            }
        });

        room13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InPatientManagementSystem/wardPng.png"))); // NOI18N
        room13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room13ActionPerformed(evt);
            }
        });

        room14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InPatientManagementSystem/wardPng.png"))); // NOI18N
        room14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room14ActionPerformed(evt);
            }
        });

        room15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InPatientManagementSystem/wardPng.png"))); // NOI18N
        room15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room15ActionPerformed(evt);
            }
        });

        room16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InPatientManagementSystem/wardPng.png"))); // NOI18N
        room16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room16ActionPerformed(evt);
            }
        });

        room17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InPatientManagementSystem/wardPng.png"))); // NOI18N
        room17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room17ActionPerformed(evt);
            }
        });

        room18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InPatientManagementSystem/wardPng.png"))); // NOI18N
        room18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room18ActionPerformed(evt);
            }
        });

        room19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InPatientManagementSystem/wardPng.png"))); // NOI18N
        room19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room19ActionPerformed(evt);
            }
        });

        room20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InPatientManagementSystem/wardPng.png"))); // NOI18N
        room20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room20ActionPerformed(evt);
            }
        });

        jLabel27.setText("Room 1");

        jLabel28.setText("Room 2");

        jLabel29.setText("Room 3");

        jLabel30.setText("Room 4");

        jLabel31.setText("Room 5");

        jLabel32.setText("Room 6");

        jLabel33.setText("Room 7");

        jLabel34.setText("Room 8");

        jLabel35.setText("Room 9");

        jLabel36.setText("Room 10");

        jLabel37.setText("Room 11");

        jLabel38.setText("Room 12");

        jLabel39.setText("Room 13");

        jLabel40.setText("Room 14");

        jLabel41.setText("Room 15");

        jLabel42.setText("Room 16");

        jLabel43.setText("Room 17");

        jLabel44.setText("Room 18");

        jLabel45.setText("Room 19");

        jLabel46.setText("Room 20");

        jLabel75.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel75.setText("(NL)");

        jLabel77.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel77.setText("(NL)");

        jLabel78.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel78.setText("(NL)");

        jLabel79.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel79.setText("(NL)");

        jLabel80.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel80.setText("(NL)");

        jLabel76.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel76.setText("(S/T)");

        jLabel81.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel81.setText("(S/T)");

        jLabel82.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel82.setText("(S/T)");

        jLabel83.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel83.setText("(S/T)");

        jLabel84.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel84.setText("(S/T)");

        jLabel85.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel85.setText("(LX)");

        jLabel86.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel86.setText("(LX)");

        jLabel87.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel87.setText("(LX)");

        jLabel88.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel88.setText("(LX)");

        jLabel89.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel89.setText("(LX)");

        jLabel105.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel105.setText("(STD)");

        jLabel106.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel106.setText("(STD)");

        jLabel107.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel107.setText("(STD)");

        jLabel108.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel108.setText("(STD)");

        jLabel109.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel109.setText("(STD)");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(room1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(room2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(44, 44, 44)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(room6, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(room7, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel32)
                                    .addComponent(jLabel33)
                                    .addComponent(jLabel76)
                                    .addComponent(jLabel81)))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(room5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(room4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(room3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(44, 44, 44)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(room9, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(room8, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(room10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel36)
                                    .addComponent(jLabel35)
                                    .addComponent(jLabel34)
                                    .addComponent(jLabel84)
                                    .addComponent(jLabel83)
                                    .addComponent(jLabel82)))
                            .addComponent(jLabel27))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(room15, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel41)
                                    .addComponent(jLabel109))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel46)
                                    .addComponent(room20, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel89)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(room14, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel40)
                                    .addComponent(jLabel108))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel45)
                                    .addComponent(room19, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel88)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(room13, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel39)
                                    .addComponent(jLabel107))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel44)
                                    .addComponent(room18, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel87)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(room12, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel38)
                                    .addComponent(jLabel106))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel43)
                                    .addComponent(room17, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel86)))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(room11, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel14Layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel105)
                                            .addComponent(jLabel37))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(room16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel42)
                                        .addComponent(jLabel85)))))
                        .addGap(25, 25, 25))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28)
                            .addComponent(jLabel29)
                            .addComponent(jLabel31)
                            .addComponent(jLabel30)
                            .addComponent(jLabel75)
                            .addComponent(jLabel80)
                            .addComponent(jLabel79)
                            .addComponent(jLabel78)
                            .addComponent(jLabel77))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(room6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(room1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel27)
                                    .addComponent(jLabel32))
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel14Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(jLabel75))
                                    .addGroup(jPanel14Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel76)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(room2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(room7, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel14Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(room16, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel42)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel85))
                                    .addGroup(jPanel14Layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(room11, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel37)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel105)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(room12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(room17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel28)
                                    .addComponent(jLabel33)
                                    .addComponent(jLabel38)
                                    .addComponent(jLabel43))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel77)
                                        .addComponent(jLabel81))
                                    .addComponent(jLabel106, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addComponent(jLabel86, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(room3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(room8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(room18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(room13, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel34)
                        .addComponent(jLabel44)
                        .addComponent(jLabel39)))
                .addGap(5, 5, 5)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel78)
                    .addComponent(jLabel82)
                    .addComponent(jLabel87)
                    .addComponent(jLabel107))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(room4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(room9, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(room14, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(room19, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30)
                            .addComponent(jLabel45)
                            .addComponent(jLabel40))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel79)
                            .addComponent(jLabel83)
                            .addComponent(jLabel88)
                            .addComponent(jLabel108))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(room5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(room10, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(room15, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(room20, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31)
                            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel36)
                                .addComponent(jLabel41))
                            .addComponent(jLabel46)))
                    .addComponent(jLabel35))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel80)
                    .addComponent(jLabel84)
                    .addComponent(jLabel89)
                    .addComponent(jLabel109))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ICU", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        room41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InPatientManagementSystem/wardPng.png"))); // NOI18N
        room41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room41ActionPerformed(evt);
            }
        });

        room42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InPatientManagementSystem/wardPng.png"))); // NOI18N
        room42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room42ActionPerformed(evt);
            }
        });

        room43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InPatientManagementSystem/wardPng.png"))); // NOI18N
        room43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room43ActionPerformed(evt);
            }
        });

        room44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InPatientManagementSystem/wardPng.png"))); // NOI18N
        room44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room44ActionPerformed(evt);
            }
        });

        jLabel47.setText("Room 41");

        jLabel48.setText("Room 42");

        jLabel49.setText("Room 43");

        jLabel50.setText("Room 44");

        jLabel95.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel95.setText("(NL)");

        jLabel96.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel96.setText("(NL)");

        jLabel97.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel97.setText("(LX)");

        jLabel98.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel98.setText("(LX)");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(room41, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(room42, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel48)
                        .addGroup(jPanel15Layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(jLabel96)))
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel95)
                        .addComponent(jLabel47)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(room43, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(room44, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel49)
                    .addComponent(jLabel50)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel97)
                            .addComponent(jLabel98))))
                .addGap(59, 59, 59))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(room41, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(room43, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel47)
                    .addComponent(jLabel49))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel95, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel97))
                .addGap(10, 10, 10)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(room42, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(room44, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel50)
                    .addComponent(jLabel48))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel96, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel98))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ETU", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        room45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InPatientManagementSystem/wardPng.png"))); // NOI18N
        room45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room45ActionPerformed(evt);
            }
        });

        room46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InPatientManagementSystem/wardPng.png"))); // NOI18N
        room46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room46ActionPerformed(evt);
            }
        });

        room47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InPatientManagementSystem/wardPng.png"))); // NOI18N
        room47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room47ActionPerformed(evt);
            }
        });

        room48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InPatientManagementSystem/wardPng.png"))); // NOI18N
        room48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room48ActionPerformed(evt);
            }
        });

        jLabel51.setText("Room 45");

        jLabel52.setText("Room 46");

        jLabel53.setText("Room 47");

        jLabel54.setText("Room 48");

        jLabel101.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel101.setText("(STD)");

        jLabel102.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel102.setText("(STD)");

        jLabel103.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel103.setText("(STD)");

        jLabel104.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel104.setText("(STD)");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(room45, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(room46, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel51)
                    .addComponent(jLabel52)
                    .addComponent(jLabel101)
                    .addComponent(jLabel102))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(room47, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(room48, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel53)
                    .addComponent(jLabel104)
                    .addComponent(jLabel103)
                    .addComponent(jLabel54))
                .addGap(59, 59, 59))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(room45, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(room47, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel51)
                    .addComponent(jLabel53))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel101)
                    .addComponent(jLabel103))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(room48, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(room46, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel54)
                    .addComponent(jLabel52))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel104)
                    .addComponent(jLabel102))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Available Status", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        available.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InPatientManagementSystem/wardPng.png"))); // NOI18N

        unavailable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InPatientManagementSystem/wardPng.png"))); // NOI18N

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Available");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("Unavailable");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(available, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(unavailable, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(jLabel17))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(available, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel17)))
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(unavailable, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(51, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel18)
                        .addGap(64, 64, 64))))
        );

        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ward Types", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel19.setText("Normal");

        jLabel20.setText("Semi(Share Toilet)");

        jLabel21.setText("Luxury");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setText("2000.00");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setText("2500.00");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setText("3500.00");

        jLabel99.setText("Standard");

        jLabel100.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel100.setText("3000.00");

        jLabel125.setText("ICU(LX)");

        jLabel126.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel126.setText("5500.00");

        jLabel127.setText("ICU(NL)");

        jLabel128.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel128.setText("4500.00");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel23)
                        .addGap(39, 39, 39))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel127)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel99))
                                .addGap(53, 53, 53)
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel25)
                                    .addComponent(jLabel100)
                                    .addComponent(jLabel126)
                                    .addComponent(jLabel128)))
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel24))
                            .addComponent(jLabel125))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel23))
                .addGap(18, 18, 18)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel24))
                .addGap(18, 18, 18)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel25))
                .addGap(18, 18, 18)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel99)
                    .addComponent(jLabel100))
                .addGap(18, 18, 18)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel125, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel126))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel127, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel128))
                .addGap(4, 4, 4))
        );

        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Normal Ward 2", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        jPanel19.setPreferredSize(new java.awt.Dimension(357, 23));

        room21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InPatientManagementSystem/wardPng.png"))); // NOI18N
        room21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room21ActionPerformed(evt);
            }
        });

        room23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InPatientManagementSystem/wardPng.png"))); // NOI18N
        room23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room23ActionPerformed(evt);
            }
        });

        room24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InPatientManagementSystem/wardPng.png"))); // NOI18N
        room24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room24ActionPerformed(evt);
            }
        });

        room25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InPatientManagementSystem/wardPng.png"))); // NOI18N
        room25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room25ActionPerformed(evt);
            }
        });

        room22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InPatientManagementSystem/wardPng.png"))); // NOI18N
        room22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room22ActionPerformed(evt);
            }
        });

        room26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InPatientManagementSystem/wardPng.png"))); // NOI18N
        room26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room26ActionPerformed(evt);
            }
        });

        room27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InPatientManagementSystem/wardPng.png"))); // NOI18N
        room27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room27ActionPerformed(evt);
            }
        });

        room28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InPatientManagementSystem/wardPng.png"))); // NOI18N
        room28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room28ActionPerformed(evt);
            }
        });

        room29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InPatientManagementSystem/wardPng.png"))); // NOI18N
        room29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room29ActionPerformed(evt);
            }
        });

        room30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InPatientManagementSystem/wardPng.png"))); // NOI18N
        room30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room30ActionPerformed(evt);
            }
        });

        room31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InPatientManagementSystem/wardPng.png"))); // NOI18N
        room31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room31ActionPerformed(evt);
            }
        });

        room32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InPatientManagementSystem/wardPng.png"))); // NOI18N
        room32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room32ActionPerformed(evt);
            }
        });

        room33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InPatientManagementSystem/wardPng.png"))); // NOI18N
        room33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room33ActionPerformed(evt);
            }
        });

        room34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InPatientManagementSystem/wardPng.png"))); // NOI18N
        room34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room34ActionPerformed(evt);
            }
        });

        room35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InPatientManagementSystem/wardPng.png"))); // NOI18N
        room35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room35ActionPerformed(evt);
            }
        });

        room36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InPatientManagementSystem/wardPng.png"))); // NOI18N
        room36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room36ActionPerformed(evt);
            }
        });

        room37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InPatientManagementSystem/wardPng.png"))); // NOI18N
        room37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room37ActionPerformed(evt);
            }
        });

        room38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InPatientManagementSystem/wardPng.png"))); // NOI18N
        room38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room38ActionPerformed(evt);
            }
        });

        room39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InPatientManagementSystem/wardPng.png"))); // NOI18N
        room39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room39ActionPerformed(evt);
            }
        });

        room40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InPatientManagementSystem/wardPng.png"))); // NOI18N
        room40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room40ActionPerformed(evt);
            }
        });

        jLabel55.setText("Room 21");

        jLabel56.setText("Room 22");

        jLabel57.setText("Room 23");

        jLabel58.setText("Room 24");

        jLabel59.setText("Room 25");

        jLabel60.setText("Room 26");

        jLabel61.setText("Room 27");

        jLabel62.setText("Room 28");

        jLabel63.setText("Room 29");

        jLabel64.setText("Room 30");

        jLabel65.setText("Room 31");

        jLabel66.setText("Room 32");

        jLabel67.setText("Room 33");

        jLabel68.setText("Room 34");

        jLabel69.setText("Room 35");

        jLabel70.setText("Room 36");

        jLabel71.setText("Room 37");

        jLabel72.setText("Room 38");

        jLabel73.setText("Room 39");

        jLabel74.setText("Room 40");

        jLabel110.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel110.setText("(STD)");

        jLabel111.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel111.setText("(STD)");

        jLabel112.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel112.setText("(STD)");

        jLabel113.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel113.setText("(STD)");

        jLabel114.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel114.setText("(STD)");

        jLabel115.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel115.setText("(LX)");

        jLabel116.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel116.setText("(LX)");

        jLabel117.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel117.setText("(LX)");

        jLabel118.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel118.setText("(LX)");

        jLabel119.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel119.setText("(LX)");

        jLabel90.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel90.setText("(NL)");

        jLabel91.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel91.setText("(NL)");

        jLabel92.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel92.setText("(NL)");

        jLabel93.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel93.setText("(NL)");

        jLabel94.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel94.setText("(NL)");

        jLabel120.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel120.setText("(S/T)");

        jLabel121.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel121.setText("(S/T)");

        jLabel122.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel122.setText("(S/T)");

        jLabel123.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel123.setText("(S/T)");

        jLabel124.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel124.setText("(S/T)");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(room25, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(room21, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(room24, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(room23, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(room22, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel58)
                            .addComponent(jLabel90)
                            .addComponent(jLabel94)
                            .addComponent(jLabel93)
                            .addComponent(jLabel92)
                            .addComponent(jLabel91))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel63)
                            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel19Layout.createSequentialGroup()
                                    .addComponent(room29, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(jPanel19Layout.createSequentialGroup()
                                    .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(room28, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel19Layout.createSequentialGroup()
                                            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(room26, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(room27, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(room30, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel64)
                                                .addComponent(jLabel61)
                                                .addComponent(jLabel60)
                                                .addComponent(jLabel62)
                                                .addComponent(jLabel120)
                                                .addComponent(jLabel124)
                                                .addComponent(jLabel123)
                                                .addComponent(jLabel122)
                                                .addComponent(jLabel121))
                                            .addGap(29, 29, 29)
                                            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel67)
                                                .addComponent(room33, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(room31, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(room32, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(room34, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(room35, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel65)
                                                .addComponent(jLabel69)
                                                .addComponent(jLabel68)
                                                .addComponent(jLabel66)
                                                .addComponent(jLabel110)
                                                .addComponent(jLabel114)
                                                .addComponent(jLabel113)
                                                .addComponent(jLabel112)
                                                .addComponent(jLabel111))))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)))))
                    .addComponent(jLabel55)
                    .addComponent(jLabel59)
                    .addComponent(jLabel57)
                    .addComponent(jLabel56))
                .addGap(18, 18, 18)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(room36, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(room40, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(room39, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(room38, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(room37, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel70)
                    .addComponent(jLabel74)
                    .addComponent(jLabel73)
                    .addComponent(jLabel72)
                    .addComponent(jLabel71)
                    .addComponent(jLabel115)
                    .addComponent(jLabel119)
                    .addComponent(jLabel118)
                    .addComponent(jLabel117)
                    .addComponent(jLabel116))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(room21, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(room26, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(room31, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(room36, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel55)
                    .addComponent(jLabel60)
                    .addComponent(jLabel65)
                    .addComponent(jLabel70))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel110)
                    .addComponent(jLabel115)
                    .addComponent(jLabel90)
                    .addComponent(jLabel120))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(room27, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(room22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(room32, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(room37, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56)
                    .addComponent(jLabel61)
                    .addComponent(jLabel66)
                    .addComponent(jLabel71))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel116)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel91)
                            .addComponent(jLabel111)
                            .addComponent(jLabel121))
                        .addGap(14, 14, 14)))
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(room23, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(room28, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(room33, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(room38, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel57)
                            .addComponent(jLabel62)
                            .addComponent(jLabel67)
                            .addComponent(jLabel72))
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel112)
                                    .addComponent(jLabel92)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel122))))
                    .addComponent(jLabel117))
                .addGap(18, 18, 18)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(room39, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(room34, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(room24, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(room29, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel58)
                            .addComponent(jLabel63)
                            .addComponent(jLabel68)
                            .addComponent(jLabel73))
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel113)
                                    .addComponent(jLabel93)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel123))))
                    .addComponent(jLabel118))
                .addGap(18, 18, 18)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(room25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(room30, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(room35, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(room40, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel59)
                    .addComponent(jLabel64)
                    .addComponent(jLabel69)
                    .addComponent(jLabel74))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel114)
                    .addComponent(jLabel119)
                    .addComponent(jLabel94)
                    .addComponent(jLabel124))
                .addGap(35, 35, 35))
        );

        ReportButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ReportButton.setText("Ward Report");
        ReportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReportButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(33, 33, 33))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(ReportButton, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ReportButton)
                        .addGap(53, 53, 53)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 696, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1348, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 718, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        HomeInPatient home =new HomeInPatient();
        this.setVisible(false);
    }//GEN-LAST:event_BackActionPerformed

    private void room40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room40ActionPerformed
        Display_roomOrPatientDetails("Room 40");
    }//GEN-LAST:event_room40ActionPerformed

    private void room39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room39ActionPerformed
        Display_roomOrPatientDetails("Room 39");
    }//GEN-LAST:event_room39ActionPerformed

    private void room38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room38ActionPerformed
        Display_roomOrPatientDetails("Room 38");
    }//GEN-LAST:event_room38ActionPerformed

    private void room37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room37ActionPerformed
        Display_roomOrPatientDetails("Room 37");
    }//GEN-LAST:event_room37ActionPerformed

    private void room36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room36ActionPerformed
        Display_roomOrPatientDetails("Room 36");
    }//GEN-LAST:event_room36ActionPerformed

    private void room35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room35ActionPerformed
        Display_roomOrPatientDetails("Room 35");
    }//GEN-LAST:event_room35ActionPerformed

    private void room34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room34ActionPerformed
        Display_roomOrPatientDetails("Room 34");
    }//GEN-LAST:event_room34ActionPerformed

    private void room33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room33ActionPerformed
        Display_roomOrPatientDetails("Room 33");
    }//GEN-LAST:event_room33ActionPerformed

    private void room32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room32ActionPerformed
        Display_roomOrPatientDetails("Room 32");
    }//GEN-LAST:event_room32ActionPerformed

    private void room31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room31ActionPerformed
        Display_roomOrPatientDetails("Room 31");
    }//GEN-LAST:event_room31ActionPerformed

    private void room30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room30ActionPerformed
        Display_roomOrPatientDetails("Room 30");
    }//GEN-LAST:event_room30ActionPerformed

    private void room29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room29ActionPerformed
        Display_roomOrPatientDetails("Room 29");
    }//GEN-LAST:event_room29ActionPerformed

    private void room28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room28ActionPerformed
        Display_roomOrPatientDetails("Room 28");
    }//GEN-LAST:event_room28ActionPerformed

    private void room27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room27ActionPerformed
        Display_roomOrPatientDetails("Room 27");
    }//GEN-LAST:event_room27ActionPerformed

    private void room26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room26ActionPerformed
        Display_roomOrPatientDetails("Room 26");
    }//GEN-LAST:event_room26ActionPerformed

    private void room22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room22ActionPerformed
        Display_roomOrPatientDetails("Room 22");
    }//GEN-LAST:event_room22ActionPerformed

    private void room25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room25ActionPerformed
        Display_roomOrPatientDetails("Room 25");
    }//GEN-LAST:event_room25ActionPerformed

    private void room24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room24ActionPerformed
        Display_roomOrPatientDetails("Room 24");
    }//GEN-LAST:event_room24ActionPerformed

    private void room23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room23ActionPerformed
        Display_roomOrPatientDetails("Room 23");
    }//GEN-LAST:event_room23ActionPerformed

    private void room21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room21ActionPerformed
        Display_roomOrPatientDetails("Room 21");
    }//GEN-LAST:event_room21ActionPerformed

    private void room48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room48ActionPerformed
        Display_roomOrPatientDetails("Room 48");
    }//GEN-LAST:event_room48ActionPerformed

    private void room47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room47ActionPerformed
        Display_roomOrPatientDetails("Room 46");
    }//GEN-LAST:event_room47ActionPerformed

    private void room46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room46ActionPerformed
        Display_roomOrPatientDetails("Room 47");
    }//GEN-LAST:event_room46ActionPerformed

    private void room45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room45ActionPerformed
        Display_roomOrPatientDetails("Room 45");
    }//GEN-LAST:event_room45ActionPerformed

    private void room44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room44ActionPerformed
        Display_roomOrPatientDetails("Room 44");
    }//GEN-LAST:event_room44ActionPerformed

    private void room43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room43ActionPerformed
        Display_roomOrPatientDetails("Room 43");
    }//GEN-LAST:event_room43ActionPerformed

    private void room42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room42ActionPerformed
        Display_roomOrPatientDetails("Room 42");
    }//GEN-LAST:event_room42ActionPerformed

    private void room41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room41ActionPerformed
        Display_roomOrPatientDetails("Room 41");
    }//GEN-LAST:event_room41ActionPerformed

    private void room20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room20ActionPerformed
        Display_roomOrPatientDetails("Room 20");
    }//GEN-LAST:event_room20ActionPerformed

    private void room19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room19ActionPerformed
        Display_roomOrPatientDetails("Room 19");
    }//GEN-LAST:event_room19ActionPerformed

    private void room18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room18ActionPerformed
        Display_roomOrPatientDetails("Room 18");
    }//GEN-LAST:event_room18ActionPerformed

    private void room17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room17ActionPerformed
        Display_roomOrPatientDetails("Room 17");
    }//GEN-LAST:event_room17ActionPerformed

    private void room16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room16ActionPerformed
        Display_roomOrPatientDetails("Room 16");
    }//GEN-LAST:event_room16ActionPerformed

    private void room15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room15ActionPerformed
        Display_roomOrPatientDetails("Room 15");
    }//GEN-LAST:event_room15ActionPerformed

    private void room14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room14ActionPerformed
        Display_roomOrPatientDetails("Room 14");
    }//GEN-LAST:event_room14ActionPerformed

    private void room13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room13ActionPerformed
        Display_roomOrPatientDetails("Room 13");
    }//GEN-LAST:event_room13ActionPerformed

    private void room12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room12ActionPerformed
        Display_roomOrPatientDetails("Room 12");
    }//GEN-LAST:event_room12ActionPerformed

    private void room11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room11ActionPerformed
        Display_roomOrPatientDetails("Room 11");
    }//GEN-LAST:event_room11ActionPerformed

    private void room10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room10ActionPerformed
        Display_roomOrPatientDetails("Room 10");
    }//GEN-LAST:event_room10ActionPerformed

    private void room9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room9ActionPerformed
        Display_roomOrPatientDetails("Room 9");
    }//GEN-LAST:event_room9ActionPerformed

    private void room8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room8ActionPerformed
        Display_roomOrPatientDetails("Room 8");
    }//GEN-LAST:event_room8ActionPerformed

    private void room7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room7ActionPerformed
        Display_roomOrPatientDetails("Room 7");
    }//GEN-LAST:event_room7ActionPerformed

    private void room6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room6ActionPerformed
        Display_roomOrPatientDetails("Room 6");
    }//GEN-LAST:event_room6ActionPerformed

    private void room5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room5ActionPerformed
        Display_roomOrPatientDetails("Room 5");
    }//GEN-LAST:event_room5ActionPerformed

    private void room4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room4ActionPerformed
        Display_roomOrPatientDetails("Room 4");
    }//GEN-LAST:event_room4ActionPerformed

    private void room3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room3ActionPerformed
        Display_roomOrPatientDetails("Room 3");
    }//GEN-LAST:event_room3ActionPerformed

    private void room2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room2ActionPerformed
        Display_roomOrPatientDetails("Room 2");
    }//GEN-LAST:event_room2ActionPerformed

    private void room1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room1ActionPerformed
        Display_roomOrPatientDetails("Room 1");
    }//GEN-LAST:event_room1ActionPerformed

    private void ReportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReportButtonActionPerformed
        
        //Connection conn = DBConnection.connect();
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            //conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/inpatientmanagement","root","");
            String Report="C:\\Users\\it17039000\\Documents\\NetBeansProjects\\Intigration1\\src\\InPatientManagementSystem\\WardPaymentDetailsReport.jrxml";
            
            JasperReport jr = JasperCompileManager.compileReport(Report);  
            JasperPrint jp = JasperFillManager.fillReport(jr,null,conn);
            JasperViewer.viewReport(jp);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, ex);
            //Logger.getLogger(InPatientWardAllocate.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
    }//GEN-LAST:event_ReportButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InPatientWardAllocate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InPatientWardAllocate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InPatientWardAllocate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InPatientWardAllocate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InPatientWardAllocate().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton Back;
    private javax.swing.JLabel DateField;
    private javax.swing.JToggleButton ReportButton;
    private javax.swing.JLabel TimeField;
    private javax.swing.JButton available;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JButton room1;
    private javax.swing.JButton room10;
    private javax.swing.JButton room11;
    private javax.swing.JButton room12;
    private javax.swing.JButton room13;
    private javax.swing.JButton room14;
    private javax.swing.JButton room15;
    private javax.swing.JButton room16;
    private javax.swing.JButton room17;
    private javax.swing.JButton room18;
    private javax.swing.JButton room19;
    private javax.swing.JButton room2;
    private javax.swing.JButton room20;
    private javax.swing.JButton room21;
    private javax.swing.JButton room22;
    private javax.swing.JButton room23;
    private javax.swing.JButton room24;
    private javax.swing.JButton room25;
    private javax.swing.JButton room26;
    private javax.swing.JButton room27;
    private javax.swing.JButton room28;
    private javax.swing.JButton room29;
    private javax.swing.JButton room3;
    private javax.swing.JButton room30;
    private javax.swing.JButton room31;
    private javax.swing.JButton room32;
    private javax.swing.JButton room33;
    private javax.swing.JButton room34;
    private javax.swing.JButton room35;
    private javax.swing.JButton room36;
    private javax.swing.JButton room37;
    private javax.swing.JButton room38;
    private javax.swing.JButton room39;
    private javax.swing.JButton room4;
    private javax.swing.JButton room40;
    private javax.swing.JButton room41;
    private javax.swing.JButton room42;
    private javax.swing.JButton room43;
    private javax.swing.JButton room44;
    private javax.swing.JButton room45;
    private javax.swing.JButton room46;
    private javax.swing.JButton room47;
    private javax.swing.JButton room48;
    private javax.swing.JButton room5;
    private javax.swing.JButton room6;
    private javax.swing.JButton room7;
    private javax.swing.JButton room8;
    private javax.swing.JButton room9;
    private javax.swing.JButton unavailable;
    // End of variables declaration//GEN-END:variables
}
