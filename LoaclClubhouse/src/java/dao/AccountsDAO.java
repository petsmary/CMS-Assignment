/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author MingWai
 */
public class AccountsDAO {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/cmsdb";
    static final String USER = "root";
    static final String PASS = "root";
    static final String TABLE = "accounts";

    public static String login(String username, String password) {
        Connection conn = null;

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            String sql = "SELECT * FROM " + TABLE + " WHERE login_name = ? and password = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String c = rs.getString("acc_cust_id");
                conn.close();
                return c;
            }
        } catch (SQLException se) {
            //Handle errors for JDBC

        } catch (Exception e) {
            //Handle errors for Class.forName

        }
        return null;
    }
    
    public static boolean loginAdmin(String username, String password) {
        Connection conn = null;

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            String sql = "SELECT * FROM " + TABLE + " WHERE login_name = ? and password = ? and isOfficer is true";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                conn.close();
                return true;
            }
        } catch (SQLException se) {
            //Handle errors for JDBC

        } catch (Exception e) {
            //Handle errors for Class.forName

        }
        return false;
    }
}
