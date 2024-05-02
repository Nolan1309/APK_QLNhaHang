/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import POJO.BanAn;
import POJO.Order;
import POJO.Order_Detail;
import java.beans.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    public static boolean KiemTraBanTrong(int idban) {
        try {
            String sql = "SELECT * FROM DonHang WHERE id_ban = ?";
            Connect provider = new Connect();

            PreparedStatement statement = provider.ketNoiCSDL().prepareStatement(sql);
            statement.setInt(1, idban);
            ResultSet rs = statement.executeQuery();

            boolean coDonHang = rs.next(); // Kiểm tra xem ResultSet có dòng dữ liệu nào không

            provider.close();
            return coDonHang;
        } catch (SQLException ex) {
            Logger.getLogger(Order_XuLy.class.getName()).log(Level.SEVERE, null, ex);
            return false; // Trả về false trong trường hợp xảy ra lỗi
        }
    }

    public static ArrayList<Order> KiemTraBan() {
        ArrayList<Order> danhSachBan = new ArrayList<>();
        try {
            String sql = "select * from DonHang";
            Connect provider = new Connect();

            PreparedStatement statement = provider.ketNoiCSDL().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Order ban = new Order();
                ban.setOrder_id(rs.getInt("order_id"));
                ban.setId_ban(rs.getInt("id_ban"));
                ban.setGiamgia(rs.getFloat("gia_giam"));

                ban.setThanhtien(rs.getFloat("tongtien"));
                ban.setTrangthai(rs.getString("trang_thai_thanhtoan"));
                ban.setTongbill(rs.getFloat("TongBill"));
                danhSachBan.add(ban);
            }

            provider.close();
            return danhSachBan;
        } catch (SQLException ex) {
            Logger.getLogger(Order_XuLy.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public static ArrayList<Order_Detail> getOrderDetail(int idOrder) {
        try {
            ArrayList<Order_Detail> chitietorderlist = new ArrayList<>();
            String sql = "select * from ChiTietDonHang where order_id= " + idOrder;

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

    public static boolean InsertOrder(Order item) {
        try {
            String sql = "insert into DonHang(id_ban  , tongtien ,trang_thai_thanhtoan,TongBill)values(?,?,?,?)";
            Connect provider = new Connect();

            Connection connection = provider.ketNoiCSDL();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, item.getId_ban());
//            statement.setFloat(2, item.getGiamgia());
            statement.setFloat(2, item.getTongbill());
            statement.setString(3, item.getTrangthai());
            statement.setFloat(4, item.getThanhtien());

            int rowsAffected = statement.executeUpdate(); // Thực thi câu lệnh INSERT

            provider.close();

            return rowsAffected > 0; // Trả về true nếu có ít nhất một dòng bị ảnh hưởng
        } catch (SQLException ex) {
            Logger.getLogger(Order_XuLy.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public static int GetIdOrder() {
        try {
            String query = "SELECT SCOPE_IDENTITY()";
            Connect provider = new Connect();
            provider.ketNoiCSDL();
            ResultSet rs = provider.executeQuery(query);
            int orderId = 0;
            if (rs.next()) {
                orderId = rs.getInt(1);
            }
            provider.close();
            return orderId;
        } catch (SQLException ex) {
            Logger.getLogger(Order_XuLy.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;

    }

    public static boolean InsertOrderDetail(Order_Detail item) {
        try {
            String sql = "insert into ChiTietDonHang(order_id,id_monan,tenmonan,so_luong,dongia,Thanhtien) values(?,?,?,?,?,?)";
            Connect provider = new Connect();

            Connection connection = provider.ketNoiCSDL();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, item.getOrderId());
            statement.setFloat(2, item.getIdMonan());
            statement.setString(3, item.getTenMonan());
            statement.setInt(4, item.getSoLuong());
            statement.setDouble(5, item.getDonGia());
            statement.setDouble(6, item.getThanhTien());
            int rowsAffected = statement.executeUpdate(); // Thực thi câu lệnh INSERT

            provider.close();

            return rowsAffected > 0; // Trả về true nếu có ít nhất một dòng bị ảnh hưởng
        } catch (SQLException ex) {
            Logger.getLogger(Order_XuLy.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public static Boolean UpDateTrangThaiBan(int idBan, Date time) {
        try {
            String sql = "update Ban set ngay_dat = '?' , trang_thai = N'Có người' where id_ban = ?";
            Connect provider = new Connect();

            Connection connection = provider.ketNoiCSDL();
            PreparedStatement statement = connection.prepareStatement(sql);

            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
            String formattedDate = dateFormat.format(time);
            statement.setString(1, formattedDate);
            statement.setFloat(2, idBan);

            int rowsAffected = statement.executeUpdate(); // Thực thi câu lệnh INSERT

            provider.close();

            return rowsAffected > 0; // Trả về true nếu có ít nhất một dòng bị ảnh hưởng
        } catch (SQLException ex) {
            Logger.getLogger(ThucDonDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
}
