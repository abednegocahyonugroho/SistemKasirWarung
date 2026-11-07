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
}
