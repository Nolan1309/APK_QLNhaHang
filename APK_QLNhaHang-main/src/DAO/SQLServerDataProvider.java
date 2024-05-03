/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Gia Bao
 */
public class SQLServerDataProvider {
    private Connection connection;
    //Statement statement;
    //ResultSet resultSet;
    
    public void open()
    {
        String strServer="DESKTOP-SS9RUEB\\MSSQLSERVERRR";
        String strDatabase="QL_NhaHang";
        String strUsername="sa";
        String strPass="sa123";
        
        String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SQLServerDataProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        String ConnectionURL="jdbc:sqlserver://"+strServer
                            +":1433;databaseName="+strDatabase
                            //+";integratedSecurity = true"
                            +";user="+strUsername
                            +";password="+strPass
                            ;
        try {
            connection = DriverManager.getConnection(ConnectionURL);
            
        } catch (SQLException ex) {
            //ex.printStackTrace();
            //Logger.getLogger(SQLServerDataProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
    
    public void close()
    {
        try {
            this.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ResultSet executeQuery(String sql)
    {
        ResultSet rs = null;
        try {
            
            Statement sm  = connection.createStatement();
            rs = sm.executeQuery(sql);
            
        } catch (SQLException e) {
              
        }
        return rs;
    }
    
    public int executeUpdate(String sql)
    {
        int n =-1;
       
        try {
            Statement sm  = connection.createStatement();
            
            n = sm.executeUpdate(sql);
            
        } catch (SQLException e) {
         
        }
        return n;
    }
}
