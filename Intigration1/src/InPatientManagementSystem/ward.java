package InPatientManagementSystem;




import MYSQL.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hp
 */
public class ward {

    String PID="";
    String RoomNo="";
    String RoomCategory="";
    double RoomCharge=0.0;
    double DepositAmount;
    String AdmittedDr="";
    boolean RoomAvailablity=false;
    String AddDate;
    String AddTime;
    
    public ward(String rNo,String id,double depo,String aDr,String CurentDate,String CurentTime,boolean rAvai){
    RoomNo=rNo;
    PID=id;
    DepositAmount=depo;
    AdmittedDr=aDr;
    RoomAvailablity=rAvai;
    AddDate=CurentDate;
    AddTime=CurentTime;
    
    }
    
    private ward(String rNo,String id,double depo,String aDr,String CurentDate,String CurentTime,boolean rAvai,String rCat,double rCharge){
    
        this(rNo,id,depo,aDr,CurentDate,CurentTime,rAvai);
        
        RoomCategory=rCat;
        RoomCharge=rCharge;
        
    
    }
    
    public void update_roomStatus(){
        PreparedStatement pst=null;
        Statement st=null; 
        ResultSet rs=null;
        try{
            Connection conn = DBConnect
                    .connect();
            st=conn.createStatement();
           
            String q1="update warddetails set  PID=?, DepositAmount=?, AdmittedDr=?, RoomAvailability=?, AdmittedDate=?, AdmittedTime=? where RoomNo=? ";
            pst=conn.prepareStatement(q1);
            pst.setString(1,PID);
            pst.setDouble(2,DepositAmount);
            pst.setString(3,AddTime);
            pst.setBoolean(4,RoomAvailablity);
            pst.setString(5,AdmittedDr);
            pst.setString(6,AddDate);
            pst.setString(7,RoomNo);
            pst.execute();
            
            conn.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        
        }
    
    
    }
}
