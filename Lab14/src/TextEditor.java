
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author tongt
 */
public class TextEditor {
    private JFrame frame1;
    private JPanel panel1;
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenuItem newfile, openfile, savefile, closefile;
    private JTextArea textArea1;
    
    public TextEditor() {
        
        this.frame1 = new JFrame("My Text Editor");
        this.frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame1.setLocationRelativeTo(null);
        this.frame1.setSize(500, 300);
        
        // create a meneBar
        
        this.menuBar1 = new JMenuBar();
        
        this.menu1 = new JMenu("file");
        
        this.newfile = new JMenuItem("New");
        this.openfile = new JMenuItem("Open");
        this.savefile = new JMenuItem("Save");
        this.closefile = new JMenuItem("Close");
        
        this.menu1.add(this.newfile);
        this.menu1.add(this.openfile);
        this.menu1.add(this.savefile);
        this.menu1.add(this.closefile);
        
        this.menuBar1.add(this.menu1);
        
        this.frame1.add(this.menuBar1, BorderLayout.NORTH);
        
        // create a panel with text editor
        this.panel1 = new JPanel(new BorderLayout());
        this.textArea1 = new JTextArea();
        
        this.textArea1.setLineWrap(true);
        this.textArea1.setWrapStyleWord(true);
        
        this.panel1.add(this.textArea1, BorderLayout.CENTER);
        this.frame1.add(this.panel1, BorderLayout.CENTER);
        
        this.newfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("New File");
                textArea1.setText("");
                frame1.revalidate();
                frame1.repaint();
            }
        });
        
        this.openfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Open File");
                
                JFileChooser fc = new JFileChooser();
                
                int returnVal = fc.showOpenDialog(frame1);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File f = fc.getSelectedFile();
                    System.out.println("File : " + f);

                    if (f.getName().endsWith(".txt")) {
                        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
                            StringBuilder content = new StringBuilder();
                            String line;
                            while ((line = br.readLine()) != null) {
                                content.append(line).append("\n");
                            }
                            textArea1.setText(content.toString());
                        } catch (IOException ex) {
                            System.out.println("Error to Read file.");
                        }
                    } else {
                        System.out.println("Is not a .txt file.");
                    }
                }
            }
        });
        
        this.savefile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Save File");
                
                JFileChooser fc = new JFileChooser();
                int returnVal = fc.showSaveDialog(frame1);
                
               if(returnVal == JFileChooser.APPROVE_OPTION) {
                   File f = fc.getSelectedFile();
                   
                   String pathFile = f.getAbsolutePath();
                   if (!pathFile.endsWith(".txt")) {
                       f = new File(pathFile + ".txt");
                   }
                   
                   try (FileWriter fw = new FileWriter(f)) {
                       fw.write(textArea1.getText());
                       textArea1.setText("");
                       System.out.println("Save Text File Complete.");
                   } catch (IOException ex) {
                        Logger.getLogger(TextEditor.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
            }
        
        });
        
        this.closefile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Close file");
                
                frame1.dispose();
            }
        });
        
        this.frame1.setVisible(true);
    }
    
    public static void main(String[] args) {
        new TextEditor();
    }
}
