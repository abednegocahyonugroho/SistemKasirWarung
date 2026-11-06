/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author abedn
 */
import view.BarangView;
import controller.BarangController;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // 1. Buat View
                BarangView view = new BarangView();

                // 2. Buat Controller dan masukkan View ke dalamnya
                new BarangController(view);

                // 3. Tampilin View
                view.setVisible(true);
            }
        });
    }
}
