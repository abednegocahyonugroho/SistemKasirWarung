/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package view;

/**
 *
 * @author abedn
 */
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;

public interface IBarangView {

    JTextField getTextIdBarang();

    JTextField getTextNamaBarang();

    JTextField getTextHarga();

    JTextField getTextStok();

    JTextField getTextBatasMin();

    JTable getTable();

    DefaultTableModel getTableModel();

    void addSimpanListener(ActionListener listener);

    void addHapusListener(ActionListener listener);

    void addClearListener(ActionListener listener);

    void addTableMouseListener(java.awt.event.MouseAdapter listener);
}
