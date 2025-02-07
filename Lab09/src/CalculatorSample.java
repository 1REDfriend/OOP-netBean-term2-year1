
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
 * @author TEXR
 */
public class CalculatorSample implements ActionListener{

    private JFrame frame;
    private JTextField textField;
    private JButton[] numberButtons = new JButton[10];
    private JButton[] functionButtons = new JButton[6];
    private String[] functionNames = {"+", "-", "x", "/", "=", "C"};
    private double num1, num2, result;
    private char operator;

    public CalculatorSample() {
        frame = new JFrame("Calculator Sample");
        frame.setSize(350, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(30, 25, 270, 50);
        textField.setEditable(false);
        frame.add(textField);

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
        }

        for (int i = 0; i < functionButtons.length; i++) {
            functionButtons[i] = new JButton(functionNames[i]);
            functionButtons[i].addActionListener(this);
        }

        JPanel panel = new JPanel();
        panel.setBounds(30, 100, 270, 300);
        panel.setLayout(new GridLayout(4, 4));

        for (int i = 1; i <= 9; i++) {
            panel.add(numberButtons[i]);
        }
        panel.add(functionButtons[0]);
        panel.add(numberButtons[0]);
        panel.add(functionButtons[1]);
        panel.add(functionButtons[2]);
        panel.add(functionButtons[3]);
        panel.add(functionButtons[4]);
        panel.add(functionButtons[5]);

        frame.add(panel);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText() + i);
            }
        }

        if (e.getSource() == functionButtons[0]) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        } else if (e.getSource() == functionButtons[1]) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        } else if (e.getSource() == functionButtons[2]) {
            num1 = Double.parseDouble(textField.getText());
            operator = 'x';
            textField.setText("");
        } else if (e.getSource() == functionButtons[3]) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        } else if (e.getSource() == functionButtons[4]) {
            num2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case 'x':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            textField.setText(String.valueOf(result));
        } else if (e.getSource() == functionButtons[5]) {
            textField.setText("");
        }
    }
}
