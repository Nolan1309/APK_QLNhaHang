/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import POJO.MonAn;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Order_Load {
    public static ArrayList<MonAn> getThucDon() {
        try {
            ArrayList<MonAn> listmonan = new ArrayList<>();
            String sql = "select * from MonAn where danh_muc_id = 1 or danh_muc_id = 2";
            Connect provider = new Connect();
            provider.ketNoiCSDL();
            ResultSet rs = provider.executeQuery(sql);
            while (rs.next()) {
                MonAn monan = new MonAn();
                monan.setId(rs.getInt("monan_id"));
                monan.setTenmon(rs.getString("ten_mon"));
                monan.setIddanhmuc(rs.getInt("danh_muc_id"));

                monan.setGiamon(rs.getString("gia"));
                monan.setMota(rs.getString("mo_ta"));
                monan.setHinhanh(rs.getString("hinh_anh"));
                //nhanVien.setTrangThai(rs.getBoolean("TrangThai"));
                listmonan.add(monan);
            }
            provider.close();
            return listmonan;
        } catch (SQLException ex) {
            Logger.getLogger(ThucDonDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }
}
