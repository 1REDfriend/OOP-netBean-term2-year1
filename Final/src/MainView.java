
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LAB304_23
 */
public class MainView implements Serializable {
    private JFrame frame;
    private JPanel typePanel, inputPanel, buttonPanel, idPanel, centerPanel;
    private JRadioButton incomeRadio, expensesRadio;
    private JLabel amountLabel, detailLabel, typeLabel, deleteLabel;
    private JTextField amountField, detailField, deleteField;
    private JButton saveButton, clearButton, deleteButton;
    
    private ArrayList<Bfit> bfitList;
    private Bfit bfit;
    private int id;
    
    private DisplayView displayView;
    
    public MainView() {
        this.bfitList = new ArrayList<>();
        displayView = new DisplayView();
        this.id = 0;
        
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 250);
        frame.setLocationRelativeTo(null);
        
        this.typeLabel = new JLabel("Type :");
        this.amountLabel = new JLabel("Amount :");
        this.detailLabel = new JLabel("Detail :");
        this.deleteLabel = new JLabel("Delete ID:");
        
        this.incomeRadio = new JRadioButton("Income");
        this.expensesRadio = new JRadioButton("Expenses");
        
        this.amountField = new JTextField();
        this.detailField = new JTextField();
        this.deleteField = new JTextField();
        
        this.saveButton = new JButton("Save");
        this.clearButton = new JButton("Clear");
        this.deleteButton = new JButton("Delete");
        
        this.typePanel = new JPanel();
        this.inputPanel = new JPanel(new GridLayout(3,2));
        this.buttonPanel = new JPanel();
        this.idPanel = new JPanel();
        this.centerPanel = new JPanel();
        
        this.typePanel.add(this.incomeRadio);
        this.typePanel.add(this.expensesRadio);
        
        this.inputPanel.add(this.typeLabel);
        this.inputPanel.add(this.typePanel);
        this.inputPanel.add(this.amountLabel);
        this.inputPanel.add(this.amountField);
        this.inputPanel.add(this.detailLabel);
        this.inputPanel.add(this.detailField);
        
        this.buttonPanel.add(this.saveButton);
        this.buttonPanel.add(this.clearButton);
        
        this.idPanel.setLayout(new BorderLayout());
        this.idPanel.add(this.deleteLabel, BorderLayout.WEST);
        this.idPanel.add(this.deleteField, BorderLayout.CENTER);
        this.idPanel.add(this.deleteButton, BorderLayout.EAST);
        
        
        frame.add(this.inputPanel, BorderLayout.NORTH);
        frame.add(this.buttonPanel, BorderLayout.CENTER);
        frame.add(this.idPanel, BorderLayout.SOUTH);
        
        this.clearButton.addActionListener(e -> {
            this.amountField.setText("");
            this.detailField.setText("");
            this.deleteField.setText("");
        });
        
        this.incomeRadio.addActionListener(e -> {
            this.expensesRadio.setSelected(false);
        });
        
        this.expensesRadio.addActionListener(e -> {
            this.incomeRadio.setSelected(false);
        });
        
        this.saveButton.addActionListener(e -> {
            if (this.amountField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(frame,"Please enter number in Amount field only.");
            } else if (this.detailField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(frame,"Please enter text in detail field only.");
            } else if (!this.incomeRadio.isSelected() && !this.expensesRadio.isSelected()) {
                JOptionPane.showMessageDialog(frame,"You forgot to select the Income or Expenses type.");
            } else {
                DateTimeFormatter dft = DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm:ss");
                String time = dft.format(LocalDateTime.now());
                
                Bfit newBfit = new Bfit();
                newBfit.setID(this.id);
                newBfit.setAmount(Double.parseDouble(this.amountField.getText()));
                newBfit.setDetail(this.detailField.getText());
                newBfit.setDate(time);
                newBfit.setType(this.incomeRadio.isSelected() ? "Income" : "Expenses");
                
                System.out.println(newBfit.getID());
                
                this.bfitList.add(this.bfit);
                
                this.id++;
                
                this.amountField.setText("");
                this.detailField.setText("");
                
                this.updateData();
                this.saveData();
            }
        });
        
        this.deleteButton.addActionListener(e -> {
            if (this.deleteField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(frame,"You forgot to fill the delete ID field.");
            }
            this.deleteID(Integer.parseInt(this.deleteField.getText()));
        });
        
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                saveData();
            }
            
        });
        
        this.loadData();
        
        frame.setVisible(true);
    }
    
    public boolean saveData() {
        try (ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream("save.dat"))) {
            obj.writeObject(this.bfitList);
            obj.flush();
            return true;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean loadData() {
        try (ObjectInputStream obj = new ObjectInputStream(new FileInputStream("save.dat"))) {
            this.bfitList.clear();
            this.bfitList = (ArrayList<Bfit>) obj.readObject();
            this.id = 0;
            this.bfitList.forEach(e -> {
                if (e != null) { 
                    this.id = Math.max(e.getID(), this.id);
                }
            });
            this.id++;
            this.bfitList.removeIf(e -> e == null);
            this.updateData();
            return true;
        } catch (IOException | ClassNotFoundException ex) {
            this.bfitList = new ArrayList<>();
            this.saveData();
            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public void updateData() {
        this.displayView.getTextArea().setText("");
        if (!this.bfitList.isEmpty()) {
            this.bfitList.forEach(e -> {
                if (e != null) { 
                    this.displayView.getTextArea().append("[" + e.getID() + "]" + " - " + e.getDate() + " - " + "(" + e.getType() + ")" + " Detail=" + e.getDetail() + ", Amount=" + e.getAmount() + ".\n");
                }
            });
        }
       
    }
    
    public boolean deleteID(int ID) {
        for (int i=0 ; i < this.bfitList.size() ; i++) {
            Bfit data = this.bfitList.get(i);
            if (data.getID() == ID) {
                this.bfitList.remove(i);
                return true;
            }
        }
        this.updateData();
        return false;
    }
    
    public static void main(String[] args) {
        new MainView();
    }
}
