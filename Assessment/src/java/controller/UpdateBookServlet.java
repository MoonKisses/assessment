
package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Book;
import model.dao.BookDBManager;


public class UpdateBookServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException{
        HttpSession session = request.getSession();
        
        
        
        int bookID = Integer.parseInt(request.getParameter("bookID"));
        String title = request.getParameter("title");
        String authorName = request.getParameter("authorName");
        String publisherName = request.getParameter("publisherName");
        
        Book book = new Book(bookID, title, authorName, publisherName);
        BookDBManager manager = (BookDBManager) session.getAttribute("manager");
        
        try{
             
                manager.updateBook(bookID, title, authorName, publisherName);
                //session.setAttribute("updated", "Update was successful");
                request.getRequestDispatcher("main.jsp").include(request, response);
            
        }catch (SQLException ex){
            Logger.getLogger(ReadBookServlet.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getErrorCode() + " and " + ex.getMessage());
        }
        
    }
}
    
    
   
   