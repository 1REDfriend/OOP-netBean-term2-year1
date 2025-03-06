import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StudentView {
    public Student student;
    private JTextField idField, nameField, moneyField;
    private final String saveFile = "studentM.dat";

    public StudentView() {
        JFrame frame = new JFrame();
        this.student = new Student();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 150);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel idLabel = new JLabel("ID :");
        JLabel nameLabel = new JLabel("Name :");
        JLabel moneyLabel = new JLabel("Money :");

        this.idField = new JTextField();
        this.nameField = new JTextField();
        this.moneyField = new JTextField("0");
        moneyField.setEditable(false);

        panel.add(idLabel);
        panel.add(idField);
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(moneyLabel);
        panel.add(moneyField);

        frame.add(panel, BorderLayout.NORTH);

        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("WithDraw");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(depositButton);
        buttonPanel.add(withdrawButton);

        frame.add(buttonPanel, BorderLayout.SOUTH);

        this.loadData();

        frame.setVisible(true);

        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    student.setID(Integer.parseInt(idField.getText()));
                } catch (NumberFormatException ex) {
                    System.err.println("Invalid ID");
                    student.setID(0);
                    idField.setText(String.valueOf(student.getID()));
                }
                student.setName(nameField.getText());
                student.setMoney(student.getMoney() + 100);
                moneyField.setText(String.valueOf(student.getMoney()));
            }
        });

        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    student.setID(Integer.parseInt(idField.getText()));
                } catch (NumberFormatException ex) {
                    System.err.println("Invalid ID");
                    student.setID(0);
                    idField.setText(String.valueOf(student.getID()));
                }
                student.setName(nameField.getText());
                if (student.getMoney() >= 100) {
                    student.setMoney(student.getMoney() - 100);
                    moneyField.setText(String.valueOf(student.getMoney()));
                } else {
                    System.out.println("Not enough money");
                }
            }
        });

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                saveData();
            }
        });
    }

    public void saveData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(saveFile))) {
            oos.writeObject(student);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(saveFile))) {
            student = (Student) ois.readObject();
            idField.setText(String.valueOf(student.getID()));
            nameField.setText(student.getName());
            moneyField.setText(String.valueOf(student.getMoney()));
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading data: " + e.getMessage());
            student = new Student();
        }
    }

    public static void main(String[] args) {
        new StudentView();
    }
}