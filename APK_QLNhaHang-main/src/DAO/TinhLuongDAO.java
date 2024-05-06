/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import POJO.TinhLuongNV;
import java.sql.ResultSet;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.sql.Time;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author Gia Bao
 */
public class TinhLuongDAO 
{
    public static ArrayList<TinhLuongNV> HienThiDanhSachLuong()
    {
        ArrayList<TinhLuongNV> dsTL = new ArrayList<TinhLuongNV>();
        try {
            String sql ="select * from TinhLuong";
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.open();
            ResultSet rs = provider.executeQuery(sql);
            while (rs.next()) {
            TinhLuongNV tl = new TinhLuongNV();
            
            
            tl.setMaLuong(rs.getInt("MaLuong"));
            tl.setStaff_id(rs.getInt("staff_id"));
            
            // Chuyển đổi giá trị từ Time của SQL thành LocalTime
            Time SoGioLamSQL = rs.getTime("SoGioLam");

            LocalTime TongSoGio;
            if (SoGioLamSQL != null) {
                TongSoGio = SoGioLamSQL.toLocalTime();
            } else {
                TongSoGio = null; // Gán giá trị null nếu SoGioLamSQL là null
            }

            // Tạo đối tượng Time mới từ LocalTime
            Time tongSoGioTime;
            if (TongSoGio != null) {
                tongSoGioTime = Time.valueOf(TongSoGio);
            } else {
                tongSoGioTime = Time.valueOf("00:00:00"); // Gán giá trị null nếu TongSoGio là null
            }

            // Đặt giá trị cho thuộc tính giờ làm của đối tượng LichLamNV
            tl.setSoGioLam(tongSoGioTime);

    
//            // Chuyển đổi giá trị từ Time của SQL thành LocalTime
//            Time SoGioLamSQL = rs.getTime("SoGioLam");
//        
//            LocalTime TongSoGio = SoGioLamSQL.toLocalTime();
//  
//            // Tạo đối tượng Time mới từ LocalTime
//            Time tongSoGioTime = Time.valueOf(TongSoGio);
//           
//            // Đặt giá trị cho thuộc tính giờ làm của đối tượng LichLamNV
//            tl.setSoGioLam(tongSoGioTime);
           
            tl.setLuongCoBan(rs.getDouble("LuongCoBan"));
            tl.setTongLuong(rs.getDouble("TongLuong"));
            
   
            dsTL.add(tl);
        }
            provider.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsTL;
    }
    
    public static boolean ThemLuong(TinhLuongNV tl) {
    boolean kq = false;

    Time soGioLam = tl.getSoGioLam();
    String gioFormatted = soGioLam.toString(); // Chuyển thời gian thành chuỗi

   

    String sql = String.format("INSERT INTO TinhLuong(staff_id, SoGioLam, LuongCoBan, TongLuong) VALUES (%d, '%s', %f, %f)", tl.getStaff_id(), gioFormatted, tl.getLuongCoBan(), tl.getTongLuong());

    SQLServerDataProvider provider = new SQLServerDataProvider();
    
    try {
        provider.open();
        
        int n = provider.executeUpdate(sql);
        
        if (n == 1) {
            kq = true;
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        provider.close();
    }
    
    return kq;
}
    
    public static boolean XoaLuong(int MaLuong)
    {
        boolean kq = false;
        String sql = String.format("delete from TinhLuong where MaLuong=%d", MaLuong);
        SQLServerDataProvider provider = new SQLServerDataProvider();
        provider.open();
        int n = provider.executeUpdate(sql);
        if(n==1)
        {
            kq = true;
        }
        provider.close();
        return kq;
    }
    
    public static boolean SuaLuong(TinhLuongNV tl)
    {
        boolean kq = false;

        Time soGioLam = tl.getSoGioLam();
        String gioFormatted = soGioLam.toString(); // Chuyển thời gian thành chuỗi

        
        String sql = String.format("UPDATE TinhLuong "
                                    + "SET staff_id = '%s', SoGioLam = '%s', LuongCoBan = '%f', TongLuong = '%f' "
                                    + "WHERE MaLuong = '%d'", tl.getStaff_id(), gioFormatted, tl.getLuongCoBan(), tl.getTongLuong(), tl.getMaLuong());
        SQLServerDataProvider provider = new SQLServerDataProvider();
        try {
        provider.open();
        
        int n = provider.executeUpdate(sql);
        
        if (n == 1) {
            kq = true;
        }
        } catch (Exception e) {
        e.printStackTrace();
        } finally {
        provider.close();
        }
        
         return kq;
    }
  
    
    public static boolean tinhLuong(int staff_id) {
        String sql = String.format("EXEC TinhLuongNV %d", staff_id);
        SQLServerDataProvider provider = new SQLServerDataProvider();

        provider.open();
        int result = provider.executeUpdate(sql);
        provider.close();

        return result > 0;
    }
}
   
    

