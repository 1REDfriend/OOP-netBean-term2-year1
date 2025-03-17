
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
 * @author tongt
 */
public class ChatView {
    private JFrame frame;
    private JPanel messagePanel, buttonPanel;
    private JTextField inputField;
    private JTextArea messageArea;
    private JButton sendButton;
    
    private ChatModel chatModel;
    
    public ChatView(){
        chatModel = new ChatModel(this);
        
        frame = new JFrame("Chat Demo");
        frame.setLayout(new BorderLayout());
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        
        messageArea = new JTextArea();
        messageArea.setEditable(false);
        
        messagePanel = new JPanel();
        messagePanel.setLayout(new BorderLayout());
        messagePanel.add(messageArea, BorderLayout.CENTER);
        
        inputField = new JTextField();
        
        sendButton = new JButton("Send");
        
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.add(inputField, BorderLayout.CENTER);
        buttonPanel.add(sendButton, BorderLayout.EAST);
        
        frame.add(messagePanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                chatModel.saveData();
            }
        });
        
        sendButton.addActionListener(e -> {
            if (!inputField.getText().equals("")) {
                chatModel.pushMessage(messageArea, inputField.getText());
                inputField.setText("");
            }
        });
        
        chatModel.loadData();
        
        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }

    public JPanel getMessagePanel() {
        return messagePanel;
    }

    public JPanel getButtonPanel() {
        return buttonPanel;
    }

    public JTextField getInputField() {
        return inputField;
    }

    public JTextArea getMessageArea() {
        return messageArea;
    }

    public JButton getSendButton() {
        return sendButton;
    }
    
    public static void main(String[] args) {
        new ChatView();
    }
}
