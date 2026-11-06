/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author abedn
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

public class BarangView extends JFrame {

    // Komponen Input
    private JTextField textIdBarang, textNamaBarang, textHarga, textStok, textBatasMin;

    // Komponen Tombol
    private JButton btnSimpan, btnHapus, btnClear;

    // Komponen Tabel
    private JTable table;
    private DefaultTableModel tableModel;

    public BarangView() {
        // Pengaturan Jendela Utama
        setTitle("Manajemen Data Barang - Warung Bu Wiwi");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 500);
        setLocationRelativeTo(null); // Muncul di tengah layar
        setLayout(new BorderLayout());

        // --- PANEL FORM (Atas) ---
        JPanel panelForm = new JPanel(new GridLayout(6, 2, 5, 5));
        panelForm.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panelForm.add(new JLabel("ID Barang:"));
        textIdBarang = new JTextField();
        panelForm.add(textIdBarang);

        panelForm.add(new JLabel("Nama Barang:"));
        textNamaBarang = new JTextField();
        panelForm.add(textNamaBarang);

        panelForm.add(new JLabel("Harga Jual (Rp):"));
        textHarga = new JTextField();
        panelForm.add(textHarga);

        panelForm.add(new JLabel("Stok Barang:"));
        textStok = new JTextField();
        panelForm.add(textStok);

        panelForm.add(new JLabel("Batas Stok Minimum:"));
        textBatasMin = new JTextField();
        panelForm.add(textBatasMin);

        // Panel Tombol
        JPanel panelTombol = new JPanel(new FlowLayout(FlowLayout.LEFT));
        btnSimpan = new JButton("Simpan");
        btnHapus = new JButton("Hapus");
        btnClear = new JButton("Clear Form");
        panelTombol.add(btnSimpan);
        panelTombol.add(btnHapus);
        panelTombol.add(btnClear);

        panelForm.add(panelTombol);

        // --- PANEL TABEL (Bawah) ---
        tableModel = new DefaultTableModel(new String[]{"ID", "Nama Barang", "Harga", "Stok", "Batas Min"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        // Gabungkan ke Frame
        add(panelForm, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    public JTextField getTextIdBarang() {
        return textIdBarang;
    }

    public JTextField getTextNamaBarang() {
        return textNamaBarang;
    }

    public JTextField getTextHarga() {
        return textHarga;
    }

    public JTextField getTextStok() {
        return textStok;
    }

    public JTextField getTextBatasMin() {
        return textBatasMin;
    }

    public JTable getTable() {
        return table;
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public void addSimpanListener(ActionListener listener) {
        btnSimpan.addActionListener(listener);
    }

    public void addHapusListener(ActionListener listener) {
        btnHapus.addActionListener(listener);
    }

    public void addClearListener(ActionListener listener) {
        btnClear.addActionListener(listener);
    }
}
