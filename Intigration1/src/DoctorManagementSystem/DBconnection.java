package DoctorManagementSystem;




import com.mysql.jdbc.Connection;
import java.sql.DriverManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kajenthirakumar
 */
public class DBconnection {
    
    public static Connection connect()
    {
        
        Connection conn = null;
        
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3307/NewDoctor","root","");
            
        }
        catch (Exception e) 
        {
            
            System.out.println(e);
            
        }
        
        return conn;
    }
    
}
