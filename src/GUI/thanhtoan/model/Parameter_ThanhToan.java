/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI.thanhtoan.model;

import java.util.List;

/**
 *
 * @author Admin
 */
public class Parameter_ThanhToan {

    public Parameter_ThanhToan(String tenNhanVien, String tenBan, String ngaythanhtoan, List<ItemMonAn_report> listThanhToan) {
        this.tenNhanVien = tenNhanVien;
        this.tenBan = tenBan;
        this.ngaythanhtoan = ngaythanhtoan;
        this.listThanhToan = listThanhToan;
    }

    public Parameter_ThanhToan() {
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public String getTenBan() {
        return tenBan;
    }

    public void setTenBan(String tenBan) {
        this.tenBan = tenBan;
    }

    public String getNgaythanhtoan() {
        return ngaythanhtoan;
    }

    public void setNgaythanhtoan(String ngaythanhtoan) {
        this.ngaythanhtoan = ngaythanhtoan;
    }

    public List<ItemMonAn_report> getListThanhToan() {
        return listThanhToan;
    }

    public void setListThanhToan(List<ItemMonAn_report> listThanhToan) {
        this.listThanhToan = listThanhToan;
    }
    String tenNhanVien;
    String tenBan;
    String ngaythanhtoan;
    List<ItemMonAn_report> listThanhToan ;
    
}
