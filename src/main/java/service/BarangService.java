/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

/**
 *
 * @author abedn
 */
import model.Barang;
import model.Database;
import model.IBarangService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BarangService implements IBarangService {

    @Override
    public void insertBarang(Barang barang) {
        Database db = new Database();
        db.connect();
        String sql = "INSERT INTO barang VALUES ('" + barang.getIdBarang() + "', '" + barang.getNamaBarang() + "', " + barang.getHargaJual() + ", " + barang.getStokBarang() + ", " + barang.getBatasStokMinimum() + ")";
        db.query(sql);
        db.disconnect();
    }

    @Override
    public List<Barang> getAllBarang() {
        List<Barang> daftarBarang = new ArrayList<>();
        Database db = new Database();
        db.connect();
        ResultSet rs = db.view("SELECT * FROM barang");
        try {
            while (rs.next()) {
                daftarBarang.add(new Barang(
                        rs.getString("id_barang"),
                        rs.getString("nama_barang"),
                        rs.getInt("harga_jual"),
                        rs.getInt("stok_barang"),
                        rs.getInt("batas_stok_minimum")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        db.disconnect();
        return daftarBarang;
    }

    @Override
    public void deleteBarang(String id) {
        Database db = new Database();
        db.connect();
        db.query("DELETE FROM barang WHERE id_barang = '" + id + "'");
        db.disconnect();
    }

    @Override
    public void updateBarang(Barang barang) {
        Database db = new Database();
        db.connect();
        String sql = "UPDATE barang SET nama_barang = '" + barang.getNamaBarang() + "', harga_jual = " + barang.getHargaJual() + ", stok_barang = " + barang.getStokBarang() + ", batas_stok_minimum = " + barang.getBatasStokMinimum() + " WHERE id_barang = '" + barang.getIdBarang() + "'";
        db.query(sql);
        db.disconnect();
    }
}
