/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class NewClass {

    public static void main(String[] args) {
        Date currentDate = new Date();

// Tạo đối tượng SimpleDateFormat để định dạng ngày giờ
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

// Định dạng ngày giờ hiện tại thành chuỗi
        String formattedDate = dateFormat.format(currentDate);
        System.out.println(formattedDate);
    }
}
