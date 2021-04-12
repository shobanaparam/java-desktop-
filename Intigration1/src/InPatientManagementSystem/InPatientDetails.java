package InPatientManagementSystem;

//import InPatient.PaymentInPatient;
import MYSQL.DBConnect;
import java.awt.Color;
import java.awt.event.KeyEvent;
import static java.lang.Thread.sleep;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class InPatientDetails extends javax.swing.JFrame {

    Connection conn=null;
    ResultSet rs=null;
    PreparedStatement pst=null;
    public boolean rmAvailable;
    private String pid;
    private String pid1;
    
    /**
     * Creates new form InPatientDetails
     */
    public InPatientDetails() {
        initComponents();
        conn = DBConnect.connect();
        currentDate();
        tableload();
        load();
    }
    
    public int autoID(){
        int id= 1;
        String query = "SELECT * FROM patientdetails";
        
        try{
            Connection conn = DBConnect.connect();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()){
                id = 1 + rs.getInt("PID");
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return id;
    }
    
    private void load(){
        PatientIDBox.setText(String.valueOf(autoID()));
    }

    private void tableload() {
       try{
        String sql="SELECT PID,PatientName,Gender,DOB,Age,BloodGroup,NIC,Address,Phone,Email,GuardianName,GuardianRelation,GuardianAddress,GuardianPhone  FROM patientdetails";
         pst=conn.prepareStatement(sql); 
         rs=pst.executeQuery();
         
         jTable1.setModel(DbUtils.resultSetToTableModel(rs));
       }
        catch(Exception e){
     }
     }
    
     private void Reset()
    {
        SearchField.setText("");
        //PatientIDBox.setText("");
        PatientIDBox.setText(String.valueOf(autoID()));
        NameField.setText("");
        GenderBox.setSelectedIndex(-1);
        DOBField.setDate(null);
        AgeField.setText("");
        BloodField.setSelectedIndex(-1);
        NICField.setText("");
        AddressField.setText("");
        PhoneField.setText("");
        EmailField.setText("");
        GuardianNameField.setText("");
        GuardianRelationField.setText("");
        GuardianAddressField.setText("");
        GuardianPhoneField.setText("");
        jButtonAddPatient.setEnabled(true);
        jButtonUpdatePatient.setEnabled(true);
        jButtonDeletePatient.setEnabled(true);
   
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
     
    
    
     
     private Date getDate(String DOB) {

        DateTimeFormatter dtfFormatador = DateTimeFormatter
                .ofLocalizedDate(FormatStyle.MEDIUM)
                .withLocale(Locale.US);
        LocalDate data = LocalDate.parse(DOB, dtfFormatador);
        Instant instante = data.atStartOfDay(ZoneId.systemDefault()).toInstant();
        return Date.from(instante);
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
        jPanel5 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        NameField = new javax.swing.JTextField();
        AgeField = new javax.swing.JTextField();
        NICField = new javax.swing.JTextField();
        GenderBox = new javax.swing.JComboBox<>();
        PatientIDBox = new javax.swing.JLabel();
        DOBField = new com.toedter.calendar.JDateChooser();
        BloodField = new javax.swing.JComboBox<>();
        jPanel9 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        PhoneField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        AddressField = new javax.swing.JTextArea();
        EmailField = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        GuardianNameField = new javax.swing.JTextField();
        GuardianRelationField = new javax.swing.JTextField();
        GuardianPhoneField = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        GuardianAddressField = new javax.swing.JTextArea();
        jButtonAddPatient = new javax.swing.JButton();
        jButtonUpdatePatient = new javax.swing.JButton();
        jButtonDeletePatient = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel13 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        SearchField = new javax.swing.JTextField();
        jLabel129 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jButtonClearFields = new javax.swing.JButton();
        BillButton = new javax.swing.JButton();

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
                .addGap(62, 62, 62)
                .addComponent(Back)
                .addGap(122, 122, 122)
                .addComponent(DateField, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112)
                .addComponent(jLabel1)
                .addGap(229, 229, 229)
                .addComponent(TimeField, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(113, Short.MAX_VALUE))
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

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.setPreferredSize(new java.awt.Dimension(1357, 601));

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Personal Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel2.setText("Name");

        jLabel3.setText("Patient ID");

        jLabel4.setText("Gender");

        jLabel5.setText("Age");

        jLabel6.setText("Blood Group");

        jLabel7.setText("NIC");

        jLabel8.setText("Date of Birth");

        AgeField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                AgeFieldFocusLost(evt);
            }
        });

        NICField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                NICFieldFocusLost(evt);
            }
        });

        GenderBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));

        DOBField.setDateFormatString("yyyy-MM-dd");

        BloodField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-" }));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(NameField)
                    .addComponent(AgeField)
                    .addComponent(NICField)
                    .addComponent(GenderBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PatientIDBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DOBField, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                    .addComponent(BloodField, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(47, 47, 47))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PatientIDBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(NameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(GenderBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(DOBField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AgeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(BloodField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NICField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contact Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        jPanel9.setPreferredSize(new java.awt.Dimension(330, 320));

        jLabel9.setText("Address");

        jLabel10.setText("Phone Number");

        jLabel11.setText("Email");

        PhoneField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                PhoneFieldFocusLost(evt);
            }
        });

        AddressField.setColumns(20);
        AddressField.setLineWrap(true);
        AddressField.setRows(2);
        AddressField.setTabSize(1);
        jScrollPane2.setViewportView(AddressField);

        EmailField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                EmailFieldFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addGap(24, 24, 24)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PhoneField)
                    .addComponent(EmailField)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PhoneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EmailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Guardian Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        jPanel10.setPreferredSize(new java.awt.Dimension(302, 313));

        jLabel12.setText("Guardian Name");

        jLabel13.setText("Guardian Relation");

        jLabel14.setText("Guardian Address");

        jLabel15.setText("Guardian Phone");

        GuardianPhoneField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                GuardianPhoneFieldFocusLost(evt);
            }
        });

        GuardianAddressField.setColumns(20);
        GuardianAddressField.setLineWrap(true);
        GuardianAddressField.setRows(2);
        GuardianAddressField.setTabSize(1);
        jScrollPane4.setViewportView(GuardianAddressField);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel12)
                    .addComponent(jLabel15))
                .addGap(22, 22, 22)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(GuardianNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(GuardianPhoneField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel10Layout.createSequentialGroup()
                                .addComponent(GuardianRelationField, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(62, 62, 62))))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(GuardianNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(GuardianRelationField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GuardianPhoneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonAddPatient.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonAddPatient.setText("Add Patient");
        jButtonAddPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddPatientActionPerformed(evt);
            }
        });

        jButtonUpdatePatient.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonUpdatePatient.setText("Update Details");
        jButtonUpdatePatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdatePatientActionPerformed(evt);
            }
        });

        jButtonDeletePatient.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonDeletePatient.setText("Delete Patient");
        jButtonDeletePatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeletePatientActionPerformed(evt);
            }
        });

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Patient Table", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10", "Title 11", "Title 12", "Title 13", "Title 14"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1253, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setText("Search : ");

        SearchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SearchFieldKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SearchFieldKeyTyped(evt);
            }
        });

        jLabel129.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel129.setText("Patient Details");

        jToggleButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jToggleButton1.setText("Demo");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jToggleButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jToggleButton2.setText("Patients Report");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addComponent(SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(150, 150, 150)
                .addComponent(jLabel129)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jToggleButton2)
                .addGap(18, 18, 18)
                .addComponent(jToggleButton1)
                .addGap(71, 71, 71))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jToggleButton1)
                        .addComponent(jToggleButton2))
                    .addComponent(jLabel16)
                    .addComponent(jLabel129)
                    .addComponent(SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jButtonClearFields.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonClearFields.setText("Clear Fields");
        jButtonClearFields.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearFieldsActionPerformed(evt);
            }
        });

        BillButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BillButton.setText("Bill");
        BillButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BillButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonAddPatient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonUpdatePatient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonDeletePatient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonClearFields, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BillButton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(52, 52, 52))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE))
                        .addGap(13, 13, 13))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BillButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonAddPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonUpdatePatient, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonDeletePatient, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonClearFields, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 1310, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
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
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NICFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_NICFieldFocusLost
        String x=NICField.getText().toString();
        if(!NICField.getText().equals("")){

            if(!x.matches("[0-9]{9}[V|v]")){
                JOptionPane.showMessageDialog(null, "Invalid NIC");
            }

        }
    }//GEN-LAST:event_NICFieldFocusLost

    private void PhoneFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PhoneFieldFocusLost
        String x=PhoneField.getText().toString();
        if(!PhoneField.getText().equals("")){

            if(!x.matches("[0-9]{10}")){
                JOptionPane.showMessageDialog(null, "Invalid Patient Number");
            }

        }
    }//GEN-LAST:event_PhoneFieldFocusLost

    private void EmailFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EmailFieldFocusLost
        String x=EmailField.getText().toString();
        if(!EmailField.getText().equals("")){

            if(!x.matches("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[_A-Za-z0-9-]+(\\.[V]+)*(\\.[A-za-z]{2,})$")){
                JOptionPane.showMessageDialog(null, "Invalid Email");
            }

        }
    }//GEN-LAST:event_EmailFieldFocusLost

    private void GuardianPhoneFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_GuardianPhoneFieldFocusLost
        String x=GuardianPhoneField.getText().toString();
        if(!GuardianPhoneField.getText().equals("")){

            if(!x.matches("[0-9]{10}")){
                JOptionPane.showMessageDialog(null, "Invalid Guardian Number");
            }

        }
    }//GEN-LAST:event_GuardianPhoneFieldFocusLost

    private void jButtonAddPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddPatientActionPerformed

        String PatientName=NameField.getText();
        String Gender=GenderBox.getSelectedItem().toString();
        //String DOB=((JTextField)DOBField.getDateEditor().getUiComponent()).getText();
        SimpleDateFormat date =new SimpleDateFormat("yyyy-MM-dd");
        String DOB = date.format(DOBField.getDate());
        String Age=AgeField.getText();
        String BloodGroup=BloodField.getSelectedItem().toString();
        String NIC=NICField.getText();
        String Address=AddressField.getText();
        String Phone=PhoneField.getText();
        String Email=EmailField.getText();
        String GuardianName=GuardianNameField.getText();
        String GuardianRelation=GuardianRelationField.getText();
        String GuardianAddress=GuardianAddressField.getText();
        String GuardianPhone=GuardianPhoneField.getText();

        if(PatientName.equals("")){
            JOptionPane.showMessageDialog(null,"Enter a name.");
        }

        if(DOB.equals("")){
            JOptionPane.showMessageDialog(null,"Enter Date of birth.");
        }

        if(Age.equals("")){
            JOptionPane.showMessageDialog(null,"Enter age.");
        }

        if(Address.equals("")){
            JOptionPane.showMessageDialog(null,"Enter a Address.");
        }

        if(Phone.equals("")){
            JOptionPane.showMessageDialog(null,"Enter number.");
        }

        if(GuardianName.equals("")){
            JOptionPane.showMessageDialog(null,"Enter guardian name.");
        }

        if(GuardianRelation.equals("")){
            JOptionPane.showMessageDialog(null,"Enter guardian relation.");
        }

        if(GuardianAddress.equals("")){
            JOptionPane.showMessageDialog(null,"Enter guardian address.");
        }

        if(GuardianPhone.equals("")){
            JOptionPane.showMessageDialog(null,"Enter guardian phone.");
        }
        else{

            try{

                String q= "insert into patientdetails(PatientName,Gender,DOB,Age,BloodGroup,NIC,Address,Phone,Email,GuardianName,GuardianRelation,GuardianAddress,GuardianPhone)values ('"+PatientName+"','"+Gender +"','"+DOB +"','"+Age +"','"+BloodGroup +"','"+NIC +"','"+Address +"','"+Phone+"','"+Email +"','"+GuardianName +"','"+GuardianRelation +"','"+GuardianAddress +"','"+GuardianPhone +"')";

                pst=conn.prepareStatement(q);

                pst.execute();
                JOptionPane.showMessageDialog(null,"New Patient Added");
                tableload();
            }
            catch(Exception e){

            }
        }

    }//GEN-LAST:event_jButtonAddPatientActionPerformed

    private void jButtonUpdatePatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdatePatientActionPerformed

        int x= JOptionPane.showConfirmDialog(null,"Do you really want to update");
        if(x==0){
            String PID= PatientIDBox.getText();
            String PatientName=NameField.getText();
            String Gender=GenderBox.getSelectedItem().toString();
            //String DOB=((JTextField)DOBField.getDateEditor().getUiComponent()).getText();
            String DOB=((JTextField)DOBField.getDateEditor().getUiComponent()).getText();
            String Age=AgeField.getText();
            String BloodGroup=BloodField.getSelectedItem().toString();
            String NIC=NICField.getText();
            String Address=AddressField.getText();
            String Phone=PhoneField.getText();
            String Email=EmailField.getText();
            String GuardianName=GuardianNameField.getText();
            String GuardianRelation=GuardianRelationField.getText();
            String GuardianAddress=GuardianAddressField.getText();
            String GuardianPhone=GuardianPhoneField.getText();

            String q="UPDATE patientdetails SET PatientName='"+PatientName+"',Gender='"+Gender+"',DOB='"+DOB+"',Age='"+Age+"',BloodGroup='"+BloodGroup+"',NIC='"+NIC+"',Address='"+Address+"',Phone='"+Phone+"',Email='"+Email+"',GuardianName='"+GuardianName+"',GuardianRelation='"+GuardianRelation+"',GuardianAddress='"+GuardianAddress+"',GuardianPhone='"+GuardianPhone+"' where PID='"+PID+"'" ;
            try{
                pst=conn.prepareStatement(q);

                pst.execute();
                JOptionPane.showMessageDialog(null,"Patient Updated");
                tableload();
            }
            catch(Exception e){

            }

        }
    }//GEN-LAST:event_jButtonUpdatePatientActionPerformed

    private void jButtonDeletePatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeletePatientActionPerformed

        int x=JOptionPane.showConfirmDialog(null, "Do you want to delete this");

        if(x==0){
            String PID=PatientIDBox.getText();

            String q="DELETE from patientdetails where PID='"+PID+"'";
            try{
                pst=conn.prepareStatement(q);
                pst.execute();
                JOptionPane.showMessageDialog(null,"Patient Deleted");

                tableload();
            }
            catch(Exception e){

            }
        }
    }//GEN-LAST:event_jButtonDeletePatientActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        int r=jTable1.getSelectedRow();
        pid = jTable1.getValueAt(r, 0).toString();
        String PID=jTable1.getValueAt(r, 0).toString();
        String PatientName=jTable1.getValueAt(r, 1).toString();
        String Gender=jTable1.getValueAt(r, 2).toString();
        String DOB=jTable1.getValueAt(r, 3).toString();
        String Age=jTable1.getValueAt(r, 4).toString();
        String BloodGroup=jTable1.getValueAt(r, 5).toString();
        String NIC=jTable1.getValueAt(r, 6).toString();
        String Address=jTable1.getValueAt(r, 7).toString();
        String Phone=jTable1.getValueAt(r, 8).toString();
        String Email=jTable1.getValueAt(r, 9).toString();
        String GuardianName=jTable1.getValueAt(r, 10).toString();
        String GuardianRelation=jTable1.getValueAt(r, 11).toString();
        String GuardianAddress=jTable1.getValueAt(r, 12).toString();
        String GuardianPhone=jTable1.getValueAt(r, 13).toString();

        NameField.setText(PatientName);
        GenderBox.setSelectedItem(Gender);
       // DOBField.setDate(getDate(DOB));
        ((JTextField)DOBField.getDateEditor().getUiComponent()).setText(DOB);
        AgeField.setText(Age);
        BloodField.setSelectedItem(BloodGroup);
        NICField.setText(NIC);
        AddressField.setText(Address);
        PhoneField.setText(Phone);
        EmailField.setText(Email);
        GuardianNameField.setText(GuardianName);
        GuardianRelationField.setText(GuardianRelation);
        GuardianAddressField.setText(GuardianAddress);
        GuardianPhoneField.setText(GuardianPhone);

        PatientIDBox.setText(PID);
    }//GEN-LAST:event_jTable1MouseClicked

    private void SearchFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchFieldKeyPressed
        try {

            String sql = "select *from patientdetails where PatientName = ?";

            pst= conn.prepareStatement(sql);
            pst.setString(1, SearchField.getText());

            rs = pst.executeQuery();

            if(rs.next()){

                pid = PatientIDBox.getText();
                String add1 = rs.getString("PID");
                PatientIDBox.setText(add1);
                String add2 = rs.getString("PatientName");
                NameField.setText(add2);
                String add3 = rs.getString("Gender");
                GenderBox.setSelectedItem(add3);
                Date add4 = rs.getDate("DOB");
                DOBField.setDate(add4);
                String add5 = rs.getString("Age");
                AgeField.setText(add5);
                String add6 = rs.getString("BloodGroup");
                BloodField.setSelectedItem(add6);
                String add7 = rs.getString("NIC");
                NICField.setText(add7);
                String add8 = rs.getString("Address");
                AddressField.setText(add8);
                String add9 = rs.getString("Phone");
                PhoneField.setText(add9);
                String add10 = rs.getString("Email");
                EmailField.setText(add10);
                String add11 = rs.getString("GuardianName");
                GuardianNameField.setText(add11);
                String add12 = rs.getString("GuardianRelation");
                GuardianRelationField.setText(add12);
                String add13 = rs.getString("GuardianAddress");
                GuardianAddressField.setText(add13);
                String add14 = rs.getString("GuardianPhone");
                GuardianPhoneField.setText(add14);

                
            }
        }catch (Exception e) {

            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_SearchFieldKeyPressed

    private void SearchFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchFieldKeyTyped

        char c =evt.getKeyChar();
        if(!(Character.isAlphabetic(c) || (c == KeyEvent.VK_BACK_SPACE)|| c==KeyEvent.VK_DELETE)){
            evt.consume();

        }
    }//GEN-LAST:event_SearchFieldKeyTyped

    private void jButtonClearFieldsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearFieldsActionPerformed

        Reset();
    }//GEN-LAST:event_jButtonClearFieldsActionPerformed

    private void BillButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BillButtonActionPerformed
        PaymentInPatient Pay1=new PaymentInPatient(pid);
        //Pay1.payment(pay);
        Pay1.setVisible(true);
    }//GEN-LAST:event_BillButtonActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        HomeInPatient home =new HomeInPatient();
        this.setVisible(false);
    }//GEN-LAST:event_BackActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        NameField.setText("Ananth");
        GenderBox.setSelectedItem("Male");
        //DOBField.setDate("1988-10-19");
        AgeField.setText("24");
        BloodField.setSelectedItem("O+");
        NICField.setText("967865456V");
        AddressField.setText("Colombo");
        PhoneField.setText("0773434567");
        EmailField.setText("Karthu@gmail.com");
        GuardianNameField.setText("Ram");
        GuardianRelationField.setText("Father");
        GuardianAddressField.setText("Jaffna");
        GuardianPhoneField.setText("0778989654");
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            //conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/inpatientmanagement","root","");
            String Report="C:\\Users\\it17039000\\Documents\\NetBeansProjects\\Intigration1\\src\\InPatientManagementSystem\\WardPatientDetailsReport.jrxml";
            
            JasperReport jr = JasperCompileManager.compileReport(Report);  
            JasperPrint jp = JasperFillManager.fillReport(jr,null,conn);
            JasperViewer.viewReport(jp);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, ex);
        
        }
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void AgeFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_AgeFieldFocusLost
        String x=AgeField.getText().toString();
        if(!AgeField.getText().equals("")){

            if(!x.matches("[0-9]{2}")){
                JOptionPane.showMessageDialog(null, "Invalid Patient Age");
            }

        }
    }//GEN-LAST:event_AgeFieldFocusLost

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
            java.util.logging.Logger.getLogger(InPatientDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InPatientDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InPatientDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InPatientDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InPatientDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea AddressField;
    private javax.swing.JTextField AgeField;
    private javax.swing.JToggleButton Back;
    private javax.swing.JButton BillButton;
    private javax.swing.JComboBox<String> BloodField;
    private com.toedter.calendar.JDateChooser DOBField;
    private javax.swing.JLabel DateField;
    private javax.swing.JTextField EmailField;
    private javax.swing.JComboBox<String> GenderBox;
    private javax.swing.JTextArea GuardianAddressField;
    private javax.swing.JTextField GuardianNameField;
    private javax.swing.JTextField GuardianPhoneField;
    private javax.swing.JTextField GuardianRelationField;
    private javax.swing.JTextField NICField;
    private javax.swing.JTextField NameField;
    private javax.swing.JLabel PatientIDBox;
    private javax.swing.JTextField PhoneField;
    private javax.swing.JTextField SearchField;
    private javax.swing.JLabel TimeField;
    private javax.swing.JButton jButtonAddPatient;
    private javax.swing.JButton jButtonClearFields;
    private javax.swing.JButton jButtonDeletePatient;
    private javax.swing.JButton jButtonUpdatePatient;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    // End of variables declaration//GEN-END:variables
}
