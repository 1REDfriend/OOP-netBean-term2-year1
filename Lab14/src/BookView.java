import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BookView {
    private JFrame frame;
    private JPanel inputPanel, countPanel, buttonPanel;
    private JTextField nameField, priceField, countField;
    private JComboBox<String> typeComboBox;
    private JLabel nameLabel, priceLabel, typeLabel;
    private JButton increaseButton, reductButton, addButton, updateButton, deleteButton;
    private BookModel bookModel;
    private int locateBook;

    public BookView() {
        frame = new JFrame("Book Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(300, 200);

        // Input Panel
        nameLabel = new JLabel("name");
        priceLabel = new JLabel("price");
        typeLabel = new JLabel("type");
        
        nameField = new JTextField(15);
        nameField.setEditable(false);
        priceField = new JTextField(15);
        priceField.setEditable(false);
        
        String[] bookType = {"General", "Computer", "Math&Sci", "Photo"};
        typeComboBox = new JComboBox<>(bookType);
        
        inputPanel = new JPanel(new GridLayout(3, 2));
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(priceLabel);
        inputPanel.add(priceField);
        inputPanel.add(typeLabel);
        inputPanel.add(typeComboBox);

        // Counter Panel
        reductButton = new JButton("<<<");
        countField = new JTextField("0 of 0", 10);
        countField.setEditable(false);
        increaseButton = new JButton(">>>");
        
        countPanel = new JPanel();
        countPanel.add(reductButton);
        countPanel.add(countField);
        countPanel.add(increaseButton);

        // Button Panel
        addButton = new JButton("Add");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");
        
        buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        frame.setLayout(new BorderLayout(10, 10));
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(countPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        bookModel = new BookModel();
        locateBook = -1;

        // Initialize display
        updateDisplay();

        // Listeners
        increaseButton.addActionListener(e -> {
            if (locateBook < bookModel.getBookShelf().size() - 1) {
                locateBook++;
                updateDisplay();
            }
        });

        reductButton.addActionListener(e -> {
            if (locateBook > 0) {
                locateBook--;
                updateDisplay();
            }
        });

        addButton.addActionListener(e -> new BookAdd(bookModel));

        updateButton.addActionListener(e -> {
            try {
                if (locateBook >= 0 && locateBook < bookModel.getBookShelf().size()) {
                    boolean result = bookModel.updateBook(
                        nameField.getText(),
                        (String) typeComboBox.getSelectedItem(),
                        Double.parseDouble(priceField.getText())
                    );
                    JOptionPane.showMessageDialog(frame, result ? "Updated successfully" : "Update failed");
                    updateDisplay();
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid price format");
            }
        });

        deleteButton.addActionListener(e -> {
            if (locateBook >= 0 && locateBook < bookModel.getBookShelf().size()) {
                boolean result = bookModel.removeBook(
                    nameField.getText(),
                    (String) typeComboBox.getSelectedItem(),
                    Double.parseDouble(priceField.getText())
                );
                JOptionPane.showMessageDialog(frame, result ? "Deleted successfully" : "Delete failed");
                if (result && locateBook >= bookModel.getBookShelf().size()) {
                    locateBook--;
                }
                updateDisplay();
            }
        });

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                bookModel.saveBook();
            }
        });

        frame.setVisible(true);
    }

    private void updateDisplay() {
        if (bookModel.getBookShelf().isEmpty()) {
            nameField.setText("");
            priceField.setText("");
            typeComboBox.setSelectedIndex(0);
            countField.setText("0 of 0");
            locateBook = -1;
        } else {
            if (locateBook < 0) locateBook = 0;
            if (locateBook >= bookModel.getBookShelf().size()) locateBook = bookModel.getBookShelf().size() - 1;
            
            Book book = bookModel.getBookShelf().get(locateBook);
            nameField.setText(book.getName());
            priceField.setText(String.valueOf(book.getPrice()));
            typeComboBox.setSelectedItem(book.getType());
            countField.setText((locateBook + 1) + " of " + bookModel.getBookShelf().size());
        }
        updateButtonStates();
    }

    private void updateButtonStates() {
        reductButton.setEnabled(locateBook > 0);
        increaseButton.setEnabled(locateBook < bookModel.getBookShelf().size() - 1);
        updateButton.setEnabled(!bookModel.getBookShelf().isEmpty());
        deleteButton.setEnabled(!bookModel.getBookShelf().isEmpty());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BookView::new);
    }
}