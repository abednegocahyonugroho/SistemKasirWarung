/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author abedn
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Barang {

    private String idBarang;
    private String namaBarang;
    private int hargaJual;
    private int stokBarang;
    private int batasStokMinimum;

    // Constructor
    public Barang(String idBarang, String namaBarang, int hargaJual, int stokBarang, int batasStokMinimum) {
        this.idBarang = idBarang;
        this.namaBarang = namaBarang;
        this.hargaJual = hargaJual;
        this.stokBarang = stokBarang;
        this.batasStokMinimum = batasStokMinimum;
    }

    // Getter dan Setter
    public String getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(String idBarang) {
        this.idBarang = idBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public int getHargaJual() {
        return hargaJual;
    }

    public void setHargaJual(int hargaJual) {
        this.hargaJual = hargaJual;
    }

    public int getStokBarang() {
        return stokBarang;
    }

    public void setStokBarang(int stokBarang) {
        this.stokBarang = stokBarang;
    }

    public int getBatasStokMinimum() {
        return batasStokMinimum;
    }

    public void setBatasStokMinimum(int batasStokMinimum) {
        this.batasStokMinimum = batasStokMinimum;
    }

    // 1. Operasi Insert (Create)
    public void insertBarang() {
        Database db = new Database();
        db.connect();
        String sql = "INSERT INTO barang (id_barang, nama_barang, harga_jual, stok_barang, batas_stok_minimum) VALUES ('"
                + this.idBarang + "', '"
                + this.namaBarang + "', "
                + this.hargaJual + ", "
                + this.stokBarang + ", "
                + this.batasStokMinimum + ")";
        db.query(sql);
        db.disconnect();
    }

    // 2. Operasi Read (Select All)
    public static List<Barang> getAllBarang() {
        List<Barang> daftarBarang = new ArrayList<>();
        Database db = new Database();
        db.connect();
        ResultSet rs = db.view("SELECT * FROM barang");

        try {
            while (rs.next()) {
                Barang b = new Barang(
                        rs.getString("id_barang"),
                        rs.getString("nama_barang"),
                        rs.getInt("harga_jual"),
                        rs.getInt("stok_barang"),
                        rs.getInt("batas_stok_minimum")
                );
                daftarBarang.add(b);
            }
        } catch (SQLException e) {
            System.out.println("Kesalahan saat membaca data: " + e.getMessage());
        }
        db.disconnect();
        return daftarBarang;
    }
}
