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
import view.IBarangView;
import model.IBarangService;
import service.BarangService;
import controller.BarangController;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                IBarangView view = new BarangView();
                IBarangService service = new BarangService();

                new BarangController(view, service);

                ((BarangView) view).setVisible(true);
            }
        });
    }
}
