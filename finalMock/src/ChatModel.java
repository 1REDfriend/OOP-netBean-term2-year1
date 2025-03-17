
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author tongt
 */
public class ChatModel implements Serializable{
    private ArrayList<String> chatList;
    private ChatView chatView;
    
    public ChatModel(ChatView chatView) {
        chatList = new ArrayList<>();
        this.chatView = chatView;
    }
    
    public void saveData() {
        try (ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream("backup.dat"))) {
            obj.writeObject(chatList);
            obj.flush();
        }   catch (FileNotFoundException ex) {
            Logger.getLogger(ChatModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ChatModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void loadData() {
        try (ObjectInputStream obj = new ObjectInputStream(new FileInputStream("backup.dat"))){
            chatList = (ArrayList<String>) obj.readObject();
            chatList.forEach(e -> {
                chatView.getMessageArea().append(e + "\n");
            });
        }   catch (FileNotFoundException ex) {
            Logger.getLogger(ChatModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ChatModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void pushMessage(JTextArea textArea, String text) {
        DateTimeFormatter dft = DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm:ss");
        String time = dft.format(LocalDateTime.now());
        text = time + " " + text;
        chatList.add(text);
        textArea.append(text + "\n");
    }
}
