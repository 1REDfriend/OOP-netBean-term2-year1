
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author TEXR
 */
public class ChatDemo {
    private JFrame frame;
    private JPanel panel,btnPanel, southPanel;
    private JTextArea textArea;
    private JTextField textField;
    private JButton submitBtn, resetBtn;
    private final String saveFile = "ChatDemo.dat"; 
    
    public ChatDemo() {
        // Initialize the frame
        this.frame = new JFrame("Chat Demo");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setLocationRelativeTo(null);
        this.frame.setSize(600, 400);
        
        // Set panel with BorderLayout
        this.panel = new JPanel(new BorderLayout());
        
        this.textArea = new JTextArea();
        this.textArea.setEditable(false);
        this.textArea.setSize(45, 20);
        
        this.textField = new JTextField();
        this.textField.setEditable(true);
        this.textField.setSize(45, this.textField.getHeight());
        
        this.btnPanel = new JPanel();
        this.submitBtn = new JButton("Submit");
        this.resetBtn = new JButton("Reset");
        this.btnPanel.add(this.submitBtn);
        this.btnPanel.add(this.resetBtn);
        
        this.southPanel = new JPanel(new BorderLayout());
        this.southPanel.add(this.textField, BorderLayout.NORTH);
        this.southPanel.add(this.btnPanel, BorderLayout.SOUTH);
        
        this.panel.add(this.textArea, BorderLayout.CENTER);
        this.panel.add(southPanel, BorderLayout.SOUTH);
        
        this.frame.add(this.panel, BorderLayout.CENTER);
        
        this.loadChatHistory();
        
        this.frame.setVisible(true);
        
        this.submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!"".equals(textArea.getText())) {
                    textArea.setText(textArea.getText() + "\n" + getDateTime() + " " + textField.getText());
                } else {
                    textArea.setText(getDateTime() + " " + textField.getText());
                }
                textField.setText("");
            }
        });
        
        this.resetBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                textField.setText("");
            }
        });
        
        this.frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                saveChatHistory();
            }
        });
    }
    
   public String getDateTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        return dtf.format(LocalDateTime.now());
   }
   
    private void loadChatHistory() {
        File file = new File(saveFile);
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    textArea.append(line + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    private void saveChatHistory() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(saveFile))) {
            writer.write(textArea.getText());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new ChatDemo();
    }
}
