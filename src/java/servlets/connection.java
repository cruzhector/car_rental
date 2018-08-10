/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.jasper.tagplugins.jstl.core.Catch;

/**
 *
 * @author kolip
 */
public class connection {
    
    public static final String DRIVER="com.mysql.jdbc.Driver";
    public static final String url="jdbc:mysql://localhost/carrental";
    public static final String user="root";
    public static final String password="hector1998";

   
   
    
    
    public static Connection con() throws ClassNotFoundException, SQLException{
        
        Class.forName(DRIVER);
        
        return (com.mysql.jdbc.Connection)DriverManager.getConnection(url, user, password);
    }
    
}
