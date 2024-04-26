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
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Connect {

    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;

    String strServer = "DESKTOP-MEUMH4V";
    String strDatabase = "QL_NhaHang";
    String strUser = "S1";
    String strPassword = "123";

    public Connect() {
        ketNoiCSDL();
    }

    void ketNoiCSDL() {
        try {
            try {
                String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
                Class.forName(driver);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
            }
            // Thêm cài đặt SSL vào URL kết nối
            String connectURL = "jdbc:sqlserver://" + strServer
                    + ":1433;databaseName=" + strDatabase
                    + ";user=" + strUser + ";password=" + strPassword
                    + ";encrypt=true;trustServerCertificate=true;";
            connection = DriverManager.getConnection(connectURL);
            if (connection != null) {
                System.out.println("Kết nối thành công");
            } else {
                System.out.println("Kết nối thất bại");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        Connect db = new Connect();
       
    }
}
