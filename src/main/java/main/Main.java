/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author abedn
 */
import java.util.List;
import model.Database;
import model.Barang;

public class Main {

    public static void main(String[] args) {

        // --- TEST 1: INSERT DATA ---
        // Membuat objek barang baru: (ID, Nama, Harga, Stok, Batas Min)
        Barang barangBaru = new Barang("B001", "Beras Premium", 65000, 10, 5);
        barangBaru.insertBarang();
        System.out.println("Data Beras Premium berhasil disimpan.");

        Barang barangBaru2 = new Barang("B002", "Minyak Goreng", 18000, 3, 5);
        barangBaru2.insertBarang();
        System.out.println("Data Minyak Goreng berhasil disimpan.");

        // --- TEST 2: READ DATA ---
        System.out.println("\n--- Daftar Barang di Warung ---");
        List<Barang> listBarang = Barang.getAllBarang();

        for (Barang b : listBarang) {
            System.out.println("ID: " + b.getIdBarang()
                    + " | Nama: " + b.getNamaBarang()
                    + " | Harga: Rp" + b.getHargaJual()
                    + " | Stok: " + b.getStokBarang()
                    + " | Batas Min: " + b.getBatasStokMinimum());
        }
    }
}
