
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
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
public class CalculatorTwoGUI {

    private JFrame screen;
    private JPanel p1, buttonP;
    private JTextField text1;
    private Map<String, JButton> buttons;

    public CalculatorTwoGUI() {
        this.screen = new JFrame("CalculatorTwoGUI");
        this.screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.screen.setLayout(new BorderLayout());
        this.screen.setLayout(new BorderLayout());
        this.screen.setLocationRelativeTo(null);
        this.screen.setSize(500, 500);

        this.p1 = new JPanel(new BorderLayout());
        this.text1 = new JTextField();
        this.p1.add(this.text1, BorderLayout.NORTH);

        this.screen.add(this.p1, BorderLayout.CENTER);

        this.buttonP = new JPanel(new GridLayout(4, 5));
     
        String[] buttonLabels = {
            "7", "8", "9", "÷",
            "4", "5", "6", "×",
            "1", "2", "3", "-",
            "0", "C", "=", "+"
        };

        this.buttons = new HashMap<>();

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            this.buttons.put(label, button);
            this.buttonP.add(button);
        }

        this.p1.add(this.buttonP, BorderLayout.CENTER);

        this.screen.setVisible(true);
    }
}
