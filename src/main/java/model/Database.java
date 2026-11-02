/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author abedn
 */
import java.sql.*;

public class Database {

    static final String url = "jdbc:mysql://localhost:3306/db_warung_bu_wiwi";
    static final String user = "root";
    static final String pass = "Sun3@Rise";
    static Connection conn;
    public static Statement stmt;
    public static ResultSet rs;

    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pass);
            stmt = conn.createStatement();
            System.out.println("Koneksi Berhasil!");
        } catch (Exception e) {
            System.out.println("Koneksi Gagal: " + e.getMessage());
        }
    }

    public void query(String sql) {
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println("Kesalahan Query: " + ex.getMessage());
        }
    }

    public ResultSet view(String sql) {
        try {
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println("Kesalahan View: " + ex.getMessage());
        }
        return rs;
    }

    public void disconnect() {
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Kesalahan saat menutup koneksi: " + ex.getMessage());
        }
    }
}
