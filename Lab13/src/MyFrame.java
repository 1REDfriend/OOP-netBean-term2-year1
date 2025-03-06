
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author TEXR
 */
public class MyFrame {

    public static void main(String[] args) {
        JFrame frame = new JFrame("My Clock");
        frame.setSize(300, 100);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MyClock clock = new MyClock();

        Thread t = new Thread(clock);

        t.start();

        frame.add(clock, BorderLayout.CENTER);
        clock.setHorizontalAlignment(JLabel.CENTER);
        clock.setVerticalAlignment(JLabel.CENTER);

        frame.setVisible(true);
    }
}
