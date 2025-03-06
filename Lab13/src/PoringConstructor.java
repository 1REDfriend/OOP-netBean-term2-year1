/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 *
 * @author TEXR
 */

public class PoringConstructor {
    private JFrame frame;
    private List<Poring> poringList = new ArrayList<>();
    private TreeSet<Integer> usedNumbers = new TreeSet<>();

    public PoringConstructor() {
        frame = new JFrame();
        frame.setSize(200, 100);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        JButton addButton = new JButton("Add");
        panel.add(addButton);
        
        frame.add(panel);

        addButton.addActionListener(e -> {
            int nextNumber = findNextAvailableNumber();
            Poring newPoring = new Poring(nextNumber, this);
            poringList.add(newPoring);
            usedNumbers.add(nextNumber);
        });

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                for (Poring poring : poringList) {
                    poring.close();
                }
            }
        });

        frame.setVisible(true);
    }

    private int findNextAvailableNumber() {
        int number = 1;
        while (usedNumbers.contains(number)) {
            number++;
        }
        return number;
    }

    public void removePoring(int number) {
        usedNumbers.remove(number);
        poringList.removeIf(poring -> poring.getPoringNumber() == number);
    }

    public static void main(String[] args) {
        new PoringConstructor();
    }
}
