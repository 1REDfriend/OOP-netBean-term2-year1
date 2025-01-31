
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author tongt
 */
public class CalculatorOneGUI {
    private JFrame screen;
    private JPanel panel1, panel3;
    private JTextField textInput1, textInput2, textInput3;
    private JButton btn1, btn2, btn3, btn4;
    
    public CalculatorOneGUI() {
        this.screen = new JFrame("Ni loew ma");
        this.screen.setEnabled(true);
        
        this.screen.setLayout(new BorderLayout());
        
        this.screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.screen.setLocationRelativeTo(null);
        
        this.screen.setSize(300, 200);
        
        this.panel1 = new JPanel();
        this.panel1.setLayout(new GridLayout(4, 1));
        this.screen.add(this.panel1);
        
        this.textInput1 = new JTextField("Please Enter somthing.");
        this.panel1.add(this.textInput1, BorderLayout.CENTER);
        
        this.textInput2 = new JTextField("Please Enter somthing");
        
        this.panel1.add(this.textInput2, BorderLayout.CENTER);
        
        this.panel3 = new JPanel();
        this.panel3.setLayout(new FlowLayout());
        
        this.panel1.add(this.panel3, new BorderLayout());
        
        this.btn1 = new JButton("+");
        this.btn2 = new JButton("-");
        this.btn3 = new JButton("*");
        this.btn4 = new JButton("/");
        
        this.panel3.add(this.btn1);
        this.panel3.add(this.btn2);
        this.panel3.add(this.btn3);
        this.panel3.add(this.btn4);
        
        this.textInput3 = new JTextField();
        this.panel1.add(this.textInput3, BorderLayout.CENTER);
        
        this.screen.setVisible(true);
    }
}
