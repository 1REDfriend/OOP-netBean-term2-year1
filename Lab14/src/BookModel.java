
import java.nio.file.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author tongt
 */
public class BookModel {
    private ArrayList<Book> bookShelf;
    
    public BookModel() {
        this.bookShelf = new ArrayList<>();
        this.loadBook();
    }
    
    public boolean addBook(String name, String category, double price) {
        Book newBook = new Book(name, category, price);
        boolean result = bookShelf.add(newBook);
        if (result) saveBook();
        loadBook();
        return result;
    }
    
    public boolean removeBook(String name,String category, double price) {
        for (int i = 0; i < bookShelf.size(); i++) {
            Book book = bookShelf.get(i);
            if (book.getName().equals(name) && book.getType().equals(category)) {
                bookShelf.remove(i);
                return true;
            }
        }
        return false;
    }
    
    public boolean updateBook(String name, String category, double price) {
        for (int i = 0; i < bookShelf.size(); i++) {
            Book book = bookShelf.get(i);
            if (book.getName().equals(name) && book.getPrice() == price) {
                bookShelf.remove(i);
                addBook(name, category, price);
                return true;
            }
        }
        return false;
    }
    
    public void saveBook() {
        try (ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream("books.dat"))) {
            obj.writeObject(bookShelf);
            obj.flush();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BookModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BookModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean loadBook() {
        try (ObjectInputStream obj = new ObjectInputStream(new FileInputStream("books.dat"))) {
            bookShelf = (ArrayList<Book>) obj.readObject();
            return true;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BookModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(BookModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<Book> getBookShelf() {
        return bookShelf;
    }
}
