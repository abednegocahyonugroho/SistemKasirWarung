/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model;

/**
 *
 * @author abedn
 */
import java.util.List;

public interface IBarangService {

    void insertBarang(Barang barang);

    List<Barang> getAllBarang();

    void deleteBarang(String id);

    void updateBarang(Barang barang);
}
