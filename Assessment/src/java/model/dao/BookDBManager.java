package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Book;

/**
 *
 * @author webdevelopacc
 */
public class BookDBManager {

    private Statement st;

    public BookDBManager(Connection conn) throws SQLException {
        st = conn.createStatement();
    }


    public void createBook(int bookID, String title, String authorName, String publisherName) throws SQLException {
  
      
    
            st.executeUpdate("INSERT INTO BOOKUSER.BOOK(bookID, title, authorName, publisherName) VALUES(" + bookID + ",'" + title + "','" + authorName + "','" + publisherName + "')");
    }
    
     
    public Book findBook(int bookID) throws SQLException {
        
    String fetch = "SELECT * FROM BOOKUSER.BOOK WHERE BOOKID =" + bookID + "";
      
        ResultSet rs = st.executeQuery(fetch);
      
        while (rs.next()) {
            int id = rs.getInt(1);
            String title = rs.getString(2);
            String authorName = rs.getString(3);
            String publisherName= rs.getString(4);
            return new Book (id, title, authorName, publisherName);
        }
       return null;
    }

    public ArrayList<Book> listAllBook() throws SQLException {
        
    String fetch = "SELECT * FROM BOOKUSER.BOOK";
    ResultSet rs = st.executeQuery(fetch);
    ArrayList<Book> temp = new ArrayList();
    
 while(rs.next()){
           Integer bookID = rs.getInt(1);
           String title = rs.getString(2);
           String authorName = rs.getString(3);
           String publisherName = rs.getString(4);
          
        temp.add(new Book(bookID, title, authorName, publisherName));
    }
    return temp;
    
}
  
    public void updateBook(int bookID, String title, String authorName, String publisherName) throws SQLException { 
        st.executeUpdate("UPDATE BOOKUSER.BOOK SET TITLE ='" +title+ "',AUTHORNAME ='" +authorName+ "',PUBLISHERNAME ='" +publisherName+ "'WHERE BOOKID =" +bookID);
    }

    public void deleteBook(int bookID) throws SQLException {
        
        
        st.executeUpdate("DELETE FROM BOOKUSER.BOOK WHERE BOOKID =" + bookID);
    }
    
    public boolean idExist(int bookID) throws SQLException {
        ResultSet rs = st.executeQuery("SELECT BOOKID FROM BOOKUSER.BOOK");
        while (rs.next()) {
            if (bookID == rs.getInt(1)) {
                return true;
            }
        }
        return false;
    }
    
    
    
    
}
    