/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uiapp;

import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class CustomCheckBoxPanel extends JPanel {
    public CustomCheckBoxPanel(String text, Icon icon) {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel label = new JLabel(text, icon, JLabel.LEFT);
        JCheckBox checkBox = new JCheckBox();
        add(checkBox);
        add(label);
    }

    public static void main(String[] args) {
        ImageIcon icon = new ImageIcon("image.png"); // Đường dẫn của hình ảnh

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        CustomCheckBoxPanel checkBoxPanel1 = new CustomCheckBoxPanel("Món 1", icon);
        CustomCheckBoxPanel checkBoxPanel2 = new CustomCheckBoxPanel("Món 2", icon);

        frame.add(checkBoxPanel1);
        frame.add(checkBoxPanel2);

        frame.pack();
        frame.setVisible(true);
    }
}
