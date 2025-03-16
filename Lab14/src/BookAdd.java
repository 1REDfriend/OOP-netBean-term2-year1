import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BookAdd {
    private JFrame frame;
    private JPanel inputPanel, buttonPanel;
    private JTextField nameField, priceField;
    private JComboBox<String> typeComboBox;
    private JLabel nameLabel, priceLabel, typeLabel;
    private JButton insertButton;
    private BookModel bookModel;

    public BookAdd(BookModel bookModel) {
        this.bookModel = bookModel;
        
        frame = new JFrame("Add Book");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Changed to DISPOSE
        frame.setSize(300, 200);

        // Input Panel
        nameLabel = new JLabel("name");
        priceLabel = new JLabel("price");
        typeLabel = new JLabel("type");
        
        nameField = new JTextField(15);
        priceField = new JTextField(15);
        
        String[] bookType = {"General", "Computer", "Math&Sci", "Photo"};
        typeComboBox = new JComboBox<>(bookType);
        
        inputPanel = new JPanel(new GridLayout(3, 2));
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(priceLabel);
        inputPanel.add(priceField);
        inputPanel.add(typeLabel);
        inputPanel.add(typeComboBox);

        // Button Panel
        insertButton = new JButton("Insert");
        buttonPanel = new JPanel();
        buttonPanel.add(insertButton);

        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);

        insertButton.addActionListener(e -> {
            try {
                String name = nameField.getText().trim();
                String type = (String) typeComboBox.getSelectedItem();
                double price = Double.parseDouble(priceField.getText().trim());
                
                if (name.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Name cannot be empty");
                    return;
                }
                
                boolean result = bookModel.addBook(name, type, price);
                if (result) {
                    JOptionPane.showMessageDialog(frame, "Book added successfully");
                    frame.dispose();
                } else {
                    JOptionPane.showMessageDialog(frame, "Failed to add book");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid price format");
            }
        });

        frame.setVisible(true);
    }
}