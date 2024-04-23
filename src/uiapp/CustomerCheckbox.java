/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uiapp;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author Admin
 */
public class CustomerCheckbox extends JCheckBox {

    public CustomerCheckbox(String text, Icon icon, int width, int height) {
        super(text);
        setIcon(icon);
        setHorizontalTextPosition(SwingConstants.RIGHT); // Hiển thị văn bản bên phải của hình ảnh

        // Thiết lập kích thước ở đây
        Dimension dimension = new Dimension(width, height);
        setPreferredSize(dimension);
    }

    public static void main(String[] args) {
        ImageIcon icon = new ImageIcon("C:\\Users\\Admin\\Documents\\NetBeansProjects\\UIAPP\\src\\folder\\H1.JPG"); // Đường dẫn của hình ảnh
        CustomerCheckbox checkBox1 = new CustomerCheckbox("Món 1", icon, 200, 50); // Thiết lập chiều rộng và chiều cao ở đây
        CustomerCheckbox checkBox2 = new CustomerCheckbox("Món 2", icon, 200, 50);// Thêm các checkbox tùy chỉnh vào frame hoặc panel
       JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.add(checkBox1);
        frame.add(checkBox2);
   // Tạo một JLabel để hiển thị thông tin các checkbox được chọn
        JLabel selectedCheckBoxLabel = new JLabel("CheckBox đã chọn: ");

        // Thêm JLabel vào frame
        frame.add(selectedCheckBoxLabel);

        // Tạo ActionListener cho từng checkbox
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder selectedCheckBoxes = new StringBuilder();
                if (checkBox1.isSelected()) {
                    selectedCheckBoxes.append(checkBox1.getText()).append(", ");
                }
                if (checkBox2.isSelected()) {
                    selectedCheckBoxes.append(checkBox2.getText()).append(", ");
                }
                String selectedText = selectedCheckBoxes.toString();
                // Loại bỏ dấu phẩy và khoảng trắng cuối cùng nếu có
                if (!selectedText.isEmpty()) {
                    selectedText = selectedText.substring(0, selectedText.length() - 2);
                }
                selectedCheckBoxLabel.setText("CheckBox đã chọn: " + selectedText);
            }
        };

        // Đăng ký ActionListener cho các checkbox
        checkBox1.addActionListener(actionListener);
        checkBox2.addActionListener(actionListener);

        // Thiết lập kích thước của JFrame
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
