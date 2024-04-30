/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import POJO.BanAn;
import POJO.Order;
import POJO.Order_Detail;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Order_XuLy {

    public static ArrayList<Order> getOrderByBan(int idban) {
        try {
            ArrayList<Order> listbanan = new ArrayList<>();
            String sql = "select * from DonHang where id_ban= " + idban;
            Connect provider = new Connect();
            provider.ketNoiCSDL();
            ResultSet rs = provider.executeQuery(sql);
            while (rs.next()) {
                Order ban = new Order();

                ban.setOrder_id(rs.getInt("order_id"));
                ban.setId_ban(rs.getInt("id_ban"));
                ban.setGiamgia(rs.getFloat("gia_giam"));

                ban.setThanhtien(rs.getFloat("tongtien"));
                ban.setTrangthai(rs.getString("trang_thai_thanhtoan"));
                ban.setTongbill(rs.getFloat("TongBill"));

                listbanan.add(ban);
            }
            provider.close();
            return listbanan;
        } catch (SQLException ex) {
            Logger.getLogger(Order_XuLy.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public static ArrayList<Order_Detail> getOrderDetail(int idOrder) {
        try {
            ArrayList<Order_Detail> chitietorderlist = new ArrayList<>();
            String sql = "select * from ChiTietDonHang where order_id= " + idOrder;
            System.out.println(sql);
            Connect provider = new Connect();
            provider.ketNoiCSDL();
            ResultSet rs = provider.executeQuery(sql);
            while (rs.next()) {
                Order_Detail ban = new Order_Detail();

                ban.setDetailId(rs.getInt("detail_id"));
                ban.setOrderId(rs.getInt("order_id"));
                ban.setIdMonan(rs.getInt("id_monan"));
                ban.setTenMonan(rs.getString("tenmonan"));
                ban.setSoLuong(rs.getInt("so_luong"));
                ban.setThanhTien(rs.getFloat("Thanhtien"));
                ban.setDonGia(rs.getDouble("dongia"));
                

                chitietorderlist.add(ban);
            }
            provider.close();
            return chitietorderlist;
        } catch (SQLException ex) {
            Logger.getLogger(Order_XuLy.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
}
