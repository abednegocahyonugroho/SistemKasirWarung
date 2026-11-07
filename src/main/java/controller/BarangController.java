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
import model.IBarangService;
import view.IBarangView;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class BarangController {

    // DIP: Bergantung pada Interface (abstraksi), bukan class konkret
    private final IBarangView view;
    private final IBarangService service;

    public BarangController(IBarangView view, IBarangService service) {
        this.view = view;
        this.service = service;

        loadTable();

        view.addSimpanListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                simpanData();
            }
        });

        view.addClearListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearForm();
            }
        });

        view.addHapusListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hapusData();
            }
        });

        view.addTableMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                int selectedRow = view.getTable().getSelectedRow();
                if (selectedRow != -1) {
                    view.getTextIdBarang().setText(view.getTable().getValueAt(selectedRow, 0).toString());
                    view.getTextNamaBarang().setText(view.getTable().getValueAt(selectedRow, 1).toString());
                    view.getTextHarga().setText(view.getTable().getValueAt(selectedRow, 2).toString());
                    view.getTextStok().setText(view.getTable().getValueAt(selectedRow, 3).toString());
                    view.getTextBatasMin().setText(view.getTable().getValueAt(selectedRow, 4).toString());

                    // ID dikunci karena Primary Key tidak boleh diubah
                    view.getTextIdBarang().setEditable(false);
                }
            }
        });
    }

    private void simpanData() {
        try {
            String id = view.getTextIdBarang().getText();
            String nama = view.getTextNamaBarang().getText();

            if (id.isEmpty() || nama.isEmpty() || view.getTextHarga().getText().isEmpty()
                    || view.getTextStok().getText().isEmpty() || view.getTextBatasMin().getText().isEmpty()) {
                JOptionPane.showMessageDialog((java.awt.Component) view, "Semua kolom harus diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                return;
            }

            int harga = Integer.parseInt(view.getTextHarga().getText());
            int stok = Integer.parseInt(view.getTextStok().getText());
            int batasMin = Integer.parseInt(view.getTextBatasMin().getText());

            Barang barang = new Barang(id, nama, harga, stok, batasMin);

            // Logika membedakan Insert (data baru) atau Update (data lama)
            boolean isUpdate = false;
            for (Barang b : service.getAllBarang()) {
                if (b.getIdBarang().equals(id)) {
                    isUpdate = true;
                    break;
                }
            }

            if (isUpdate) {
                service.updateBarang(barang);
                JOptionPane.showMessageDialog((java.awt.Component) view, "Data Barang Berhasil Diubah!");
            } else {
                service.insertBarang(barang);
                JOptionPane.showMessageDialog((java.awt.Component) view, "Data Barang Berhasil Disimpan!");
            }

            clearForm();
            loadTable();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog((java.awt.Component) view, "Kolom Harga, Stok, dan Batas Min harus berupa angka!", "Error Input", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog((java.awt.Component) view, "Terjadi kesalahan: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void hapusData() {
        int selectedRow = view.getTable().getSelectedRow();

        if (selectedRow != -1) {
            String id = (String) view.getTable().getValueAt(selectedRow, 0);
            String nama = (String) view.getTable().getValueAt(selectedRow, 1);

            int konfirmasi = JOptionPane.showConfirmDialog(
                    (java.awt.Component) view,
                    "Apakah Anda yakin ingin menghapus barang '" + nama + "' (ID: " + id + ")?",
                    "Konfirmasi Hapus",
                    JOptionPane.YES_NO_OPTION
            );

            if (konfirmasi == JOptionPane.YES_OPTION) {
                service.deleteBarang(id);
                JOptionPane.showMessageDialog((java.awt.Component) view, "Data berhasil dihapus!");
                loadTable();
            }
        } else {
            JOptionPane.showMessageDialog((java.awt.Component) view, "Pilih data di tabel yang ingin dihapus terlebih dahulu!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void clearForm() {
        view.getTextIdBarang().setText("");
        view.getTextNamaBarang().setText("");
        view.getTextHarga().setText("");
        view.getTextStok().setText("");
        view.getTextBatasMin().setText("");
        view.getTextIdBarang().setEditable(true);
    }

    private void loadTable() {
        view.getTableModel().setRowCount(0);
        List<Barang> listBarang = service.getAllBarang();

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
