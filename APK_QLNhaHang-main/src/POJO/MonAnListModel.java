/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJO;

import java.util.ArrayList;
import javax.swing.AbstractListModel;

/**
 *
 * @author Admin
 */
public class MonAnListModel extends AbstractListModel<String> {

    private ArrayList<MonAn> monAnList;

    public MonAnListModel(ArrayList<MonAn> monAnList) {
        this.monAnList = monAnList;
    }

    @Override
    public int getSize() {
        return monAnList.size();
    }

    @Override
    public String getElementAt(int index) {
        MonAn monAn = monAnList.get(index);
        return "ID: " + monAn.getId() + ", Tên món: " + monAn.getTenmon() + ", Giá món: " + monAn.getGiamon();
    }
}
