/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author abedn
 */
import model.Barang;
import view.BarangView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class BarangController {

    private final BarangView view;

    // Constructor
    public BarangController(BarangView view) {
        this.view = view;

        // Nampilin data saat aplikasi pertama kali dibuka
        loadTable();

        // Aksi untuk tombol Simpan
        view.addSimpanListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                simpanData();
            }
        });

        // Aksi untuk tombol Clear
        view.addClearListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearForm();
            }
        });

        // aksi untuk tombol Hapus
        view.addHapusListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hapusData();
            }

            // Method untuk memproses hapus data
            private void hapusData() {
                int selectedRow = view.getTable().getSelectedRow();

                if (selectedRow != -1) {
                    // Ambil ID Barang dari kolom pertama (index 0) pada baris yang dipilih
                    String id = (String) view.getTable().getValueAt(selectedRow, 0);
                    String nama = (String) view.getTable().getValueAt(selectedRow, 1);

                    // Pop up konfirmasi
                    int konfirmasi = JOptionPane.showConfirmDialog(
                            view,
                            "Apakah Anda yakin ingin menghapus barang '" + nama + "' (ID: " + id + ")?",
                            "Konfirmasi Hapus",
                            JOptionPane.YES_NO_OPTION
                    );

                    if (konfirmasi == JOptionPane.YES_OPTION) {
                        Barang.deleteBarang(id);
                        JOptionPane.showMessageDialog(view, "Data berhasil dihapus!");
                        loadTable();
                    }
                } else {
                    JOptionPane.showMessageDialog(view, "Pilih data di tabel yang ingin dihapus terlebih dahulu!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

    }

    // Method untuk memproses penyimpanan data
    private void simpanData() {
        try {
            // Ambil data dari View
            String id = view.getTextIdBarang().getText();
            String nama = view.getTextNamaBarang().getText();

            // Validasi kolom terisi
            if (id.isEmpty() || nama.isEmpty() || view.getTextHarga().getText().isEmpty()
                    || view.getTextStok().getText().isEmpty() || view.getTextBatasMin().getText().isEmpty()) {
                JOptionPane.showMessageDialog(view, "Semua kolom harus diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Konversi tipe data String ke Integer
            int harga = Integer.parseInt(view.getTextHarga().getText());
            int stok = Integer.parseInt(view.getTextStok().getText());
            int batasMin = Integer.parseInt(view.getTextBatasMin().getText());

            // Buat objek Model Barang dan panggil fungsi insert
            Barang barangBaru = new Barang(id, nama, harga, stok, batasMin);
            barangBaru.insertBarang();

            // Tampilkan pesan sukses
            JOptionPane.showMessageDialog(view, "Data Barang Berhasil Disimpan!");

            // Bersihkan form dan refresh tabel
            clearForm();
            loadTable();

        } catch (NumberFormatException ex) {
            // massage error jika user memasukkan huruf pada kolom angka
            JOptionPane.showMessageDialog(view, "Kolom Harga, Stok, dan Batas Min harus berupa angka!", "Error Input", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, "Terjadi kesalahan: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Method untuk clear form input
    private void clearForm() {
        view.getTextIdBarang().setText("");
        view.getTextNamaBarang().setText("");
        view.getTextHarga().setText("");
        view.getTextStok().setText("");
        view.getTextBatasMin().setText("");
    }

    // Method mengambil data dari Model dan menampilkannya di Tabel View
    private void loadTable() {
        view.getTableModel().setRowCount(0);

        List<Barang> listBarang = Barang.getAllBarang();

        // Masukkan data ke dalam tabel
        for (Barang b : listBarang) {
            Object[] row = {
                b.getIdBarang(),
                b.getNamaBarang(),
                b.getHargaJual(),
                b.getStokBarang(),
                b.getBatasStokMinimum()
            };
            view.getTableModel().addRow(row);
        }
    }
}
