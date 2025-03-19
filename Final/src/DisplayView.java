
import java.awt.*;
import javax.swing.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LAB304_23
 */
public class DisplayView {
    private JFrame frame;
    private JPanel panel;
    private JTextArea textArea;
    
    public DisplayView() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(500, 250);
        
        this.textArea = new JTextArea();
        this.textArea.setEditable(false);
        
        this.panel = new JPanel();
        
        this.panel.setLayout(new BorderLayout());
        this.panel.add(this.textArea);
        
        frame.add(panel);
        
        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }

    public JPanel getPanel() {
        return panel;
    }

    public JTextArea getTextArea() {
        return textArea;
    }
    
    
    
    public static void main(String[] args) {
        new DisplayView();
    }
}
