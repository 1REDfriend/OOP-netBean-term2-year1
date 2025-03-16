
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author TEXR
 */
public class Poring {
    private JFrame frame;
    private JPanel panel;
    private JLabel poringLabel, countLabel;
    private int poringPanelCount = 1;
    private PoringConstructor constructor;
    private int poringNumber;

    public int getPoringNumber() {
        return poringNumber;
    }

    public void setPoringNumber(int poringNumber) {
        this.poringNumber = poringNumber;
    }

    public int getPoringPanelCount() {
        return poringPanelCount;
    }

    public void setPoringPanelCount(int poringPanelCount) {
        this.poringPanelCount = poringPanelCount;
    }
    
    public Poring(int number, PoringConstructor constructor) {
        this.poringNumber = number;
        this.constructor = constructor;

        frame = new JFrame();
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        this.poringLabel = new JLabel(new ImageIcon(getClass().getResource("/poring.jpg")));
        this.countLabel = new JLabel(String.valueOf(this.poringNumber));
        
        this.panel = new JPanel();
        this.panel.add(this.poringLabel, BorderLayout.WEST);
        this.panel.add(this.countLabel, BorderLayout.EAST);
        
        this.frame.add(this.panel, BorderLayout.CENTER);

        this.panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                constructor.removePoring(poringNumber);
            }
        });

        frame.setVisible(true);
    }
    
    public void close() {
        this.frame.dispose();
    }
}
