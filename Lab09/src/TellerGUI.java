
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author TEXR
 */
public class TellerGUI implements ActionListener {

    private JFrame frame;
    private JLabel balanceLabel;
    private JTextField balanceField, amountField;
    private JButton depositButton, withdrawButton;
    private Account account;

    public TellerGUI() {
        account = new Account(6000);

        frame = new JFrame("Teller GUI");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 2));

        balanceLabel = new JLabel("Balance");
        balanceField = new JTextField(String.valueOf(account.getBalance()));
        balanceField.setEditable(false);

        JLabel amountLabel = new JLabel("Amount");
        amountField = new JTextField();

        depositButton = new JButton("Deposit");
        withdrawButton = new JButton("Withdraw");

        depositButton.addActionListener(this);
        withdrawButton.addActionListener(this);

        frame.add(balanceLabel);
        frame.add(balanceField);
        frame.add(amountLabel);
        frame.add(amountField);
        frame.add(depositButton);
        frame.add(withdrawButton);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == depositButton) {
            double amount = Double.parseDouble(amountField.getText());
            account.deposit(amount);
            balanceField.setText(String.valueOf(account.getBalance()));
        } else if (e.getSource() == withdrawButton) {
            double amount = Double.parseDouble(amountField.getText());
            account.withdraw(amount);
            balanceField.setText(String.valueOf(account.getBalance()));
        }
    }
}
