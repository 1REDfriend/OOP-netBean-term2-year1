
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author tongt
 */
public class Poring{
    private JFrame frame;
    private JPanel panel;
    private JLabel imgLabel, intLabel;
    
    private Random random;
    
    private Timer timer;
    
    private int count = 1;
    
    public Poring(int poringCount, PoringConstructor parent) {
        count = poringCount;
        random = new Random();
        
        this.frame = new JFrame();
        frame.setSize(220, 200);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        
        imgLabel = new JLabel(new ImageIcon(getClass().getResource("./poring.jpg")));
        
        intLabel = new JLabel(String.valueOf(count));
        
        panel = new JPanel();
        
        panel.add(imgLabel);
        panel.add(intLabel);
        
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                parent.setPoringCount(parent.getPoringCount() - 1);
                frame.dispose();
            }
            
        });
        
        frame.add(panel);
        
        randomScreen();
        timer = new Timer(500, e -> randomMove());
        timer.start();
        frame.setVisible(true);
    }
    
    public void randomScreen() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        // Calculate max x and y to keep the frame fully on screen
        int maxX = screenWidth - frame.getWidth();
        int maxY = screenHeight - frame.getHeight();

        // Generate random x and y coordinates
        int randomX = (int) (Math.random() * maxX);
        int randomY = (int) (Math.random() * maxY);

        // Set the frame's location
        frame.setLocation(randomX, randomY);
    }
    
    public void randomMove() {
        int currentX = frame.getX();
        int currentY = frame.getY();

        int deltaX = random.nextInt(11) - 5; 
        int deltaY = random.nextInt(11) - 5; 

        int newX = currentX + deltaX;
        int newY = currentY + deltaY;

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int maxX = screenSize.width - frame.getWidth();
        int maxY = screenSize.height - frame.getHeight();

        newX = Math.max(0, Math.min(newX, maxX));
        newY = Math.max(0, Math.min(newY, maxY));

        frame.setLocation(newX, newY);
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
