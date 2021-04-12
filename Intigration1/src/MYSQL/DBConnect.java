/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MYSQL;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author it17039000
 */
public class DBConnect {
    public static Connection connect(){
        Connection con=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "");
        }
        
        
   
        catch(Exception e ){
            System.out.print(e);
        }
        
        return con;
    }

    public static Connection ConnectDB() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
