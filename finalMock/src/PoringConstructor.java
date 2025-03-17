
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author tongt
 */
public class PoringConstructor {
    private JFrame frame;
    private JPanel panel;
    private JButton addButton;
    
    private ArrayList<Poring> poringList;
    private int poringCount;
    
    public PoringConstructor() {
        poringList = new ArrayList<>();
        
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 100);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        
        addButton = new JButton("Add");
        
        panel = new JPanel();
        panel.add(addButton);
        
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                poringCount++;
                Poring newPoring = new Poring(poringCount, PoringConstructor.this);
                poringList.add(newPoring);
            }
            
        });
        
        frame.add(panel);
        
        frame.setVisible(true);
        
    }

    public int getPoringCount() {
        return poringCount;
    }

    public void setPoringCount(int poringCount) {
        this.poringCount = poringCount;
    }
    
    

    public static void main(String[] args) {
        new PoringConstructor();
    }
    
}
