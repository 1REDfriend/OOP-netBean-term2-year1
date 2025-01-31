
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
public class TellerGUI {
    private JFrame frame;
    private JTextField balanceField, amountField;
    private JButton depositButton, withdrawButton, exitButton;
    private double balance = 6000;

    public TellerGUI() {
        frame = new JFrame("Teller GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(500, 300);
        frame.setLayout(new GridLayout(3, 2, 5, 5));

        frame.add(new JLabel("Balance"));
        balanceField = new JTextField(String.valueOf(balance));
        balanceField.setEditable(false);
        frame.add(balanceField);

        frame.add(new JLabel("Amount"));
        amountField = new JTextField();
        frame.add(amountField);

        depositButton = new JButton("Deposit");
        withdrawButton = new JButton("Withdraw");
        exitButton = new JButton("Exit");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(depositButton);
        buttonPanel.add(withdrawButton);
        buttonPanel.add(exitButton);
        frame.add(buttonPanel);

        frame.setVisible(true);
    }
}
