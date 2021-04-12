package InPatientManagementSystem;




import MYSQL.DBConnect;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class payment {
    
    String PID="";
    String RoomNo="";
    String AdmittedDate="";
    String DischargeDate="";
    double advance=0.0;
    double total=0.0;
    double due=0.0;
    double charge=0.0;
    
    
    
    public payment(String b,String c,String d,String e,double f,double g,double h,double i){
        
        PID=b;
        RoomNo=c;
        AdmittedDate=d;
        DischargeDate=e;
        advance=f;
        total=g;
        due=h;
        charge=i;
    
    }
    
    public void add_payment()throws ClassNotFoundException{
        Statement st=null;
        
        try{
            Connection conn = DBConnect.connect();
            st = conn.createStatement();
            
            String q="insert into wardpayment(`PID`,`RoomNo`,`AdmittedDate`,`DischargeDate`,`DepositAmount`,`TotalPayment`,`DueAmount`,`RoomCharge`)"
                    + "values('"+PID+"','"+RoomNo+"','"+AdmittedDate+"','"+DischargeDate+"','"+advance+"','"+total+"','"+due+"','"+charge+"')";
        
             st.executeUpdate(q);
              JOptionPane.showMessageDialog(null,"Payment Added!!");
              conn.close();
            
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.toString());
        }
    
    
    }
    
    
    
    
}
