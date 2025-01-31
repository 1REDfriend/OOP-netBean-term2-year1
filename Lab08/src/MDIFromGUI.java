
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author tongt
 */
public class MDIFromGUI extends JFrame {
    private JDesktopPane desktopPane;
    private int windowCount = 1;

    public MDIFromGUI() {
        super("MDIFromGUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 500);
        setLocationRelativeTo(null);

        desktopPane = new JDesktopPane();
        desktopPane.setBackground(Color.BLACK);
        add(desktopPane);

        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenu viewMenu = new JMenu("View");
        
        JMenu newSubMenu = new JMenu("New");
        JMenuItem newWindowItem = new JMenuItem("Window");
        JMenuItem newMessageItem = new JMenuItem("Message");

        newSubMenu.add(newWindowItem);
        newSubMenu.add(newMessageItem);
        
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem exitItem = new JMenuItem("Exit");

        fileMenu.add(newSubMenu);  
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);
        
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(viewMenu);

        setJMenuBar(menuBar);

        newWindowItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JInternalFrame internalFrame = new JInternalFrame(
                        "Application " + String.format("%02d", windowCount),
                        true, 
                        true,
                        true, 
                        true
                );
                windowCount++;

                internalFrame.setSize(250, 150);
                internalFrame.setLocation(30 * windowCount, 30 * windowCount);
                
                internalFrame.setVisible(true);

                desktopPane.add(internalFrame);
            }
        });

        newMessageItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(
                        MDIFromGUI.this,
                        "Hello from MDI!",
                        "Message",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        });

        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MDIFromGUI().setVisible(true);
            }
        });
    }
}
