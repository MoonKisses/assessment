package controller;

import java.sql.*;
import java.util.*;
import java.util.logging.*;
import model.Book;
import model.dao.DBConnector;
import model.dao.BookDBManager;


/**
 *
 * @author apple
 */
public class TestDB {
    
    private static Scanner in = new Scanner(System.in);
    private DBConnector connector;
    private Connection conn;
    private BookDBManager db;

        
    public static void main(String[] args) throws SQLException {
         (new TestDB()).runQueries();
    }

    public TestDB() {
        try {
            connector = new DBConnector();
            conn = connector.openConnection();
            db = new BookDBManager(conn);
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    private char readChoice() {
        System.out.print("Operation CRUD or * to exit: ");
        return in.nextLine().charAt(0);    
    }
    
    private void runQueries() throws SQLException {      
        char c;
        while ((c = readChoice()) != '*') {
            switch (c) {
                case 'C':
                    testCreate();
                    break;
                case 'R':
                    testRead();
                    break;
                case 'U':
                    testUpdate();
                    break;
                case 'D':
                    testDelete();
                    break;
                default:
                    System.out.println("Unknown Command");
                    break;
            }
        }
    }
     
    private void testCreate() {      
        System.out.print("BookID: ");
        int bookID = in.nextInt();
        in.nextLine();
        System.out.print("title: ");
        String title = in.nextLine();
        System.out.print("Author Name: ");
        String authorName = in.nextLine();
        System.out.print("Publisher Name: ");
        String publisherName = in.nextLine();
   
        try {
            db.createBook(bookID, title, authorName, publisherName);
            
        } catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Book is added to the database.");
    }
        
    private void testRead() throws SQLException {
        System.out.print("bookID: ");
        int bookID = in.nextInt();
        in.nextLine();
        
        Book books = db.findBook(bookID);
        
        System.out.println(bookID);
    }
       
    private void testUpdate() {
        System.out.print("BookID: ");
        int bookID = in.nextInt();
        in.nextLine(); 
        try {
            if (db.idExist(bookID)) {
               
                System.out.print("Book new title: ");
                String title = in.nextLine();
                
                System.out.print("Book new author name: ");
                String authorName = in.nextLine();
                System.out.print("Book new publisher name: ");
                String publisherName = in.nextLine();
             
                db.updateBook(bookID, title, authorName, publisherName);
                System.out.println("BookID: " + bookID + " was updated.");
            } else {
                System.out.println("Book does not exist.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    private void testDelete() {       
        System.out.print("BookID: ");
        int bookID = in.nextInt();
        in.nextLine(); 
        try {
            if (db.idExist(bookID)) {
                db.deleteBook(bookID);
                System.out.println("BookId: " + bookID + " was deleted.");
            } else {
                System.out.println("Book does not exist.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    
    

}



