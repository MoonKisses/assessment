package controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.dao.BookDBManager;
import model.Book;


public class CreateBookServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();  
        Validator validator = new Validator();  
        
        int bookID = Integer.parseInt(request.getParameter("bookID"));
        String title = request.getParameter("title");
        String authorName = request.getParameter("authorName");
        String publisherName = request.getParameter("publisherName");
        validator.clear(session);
        BookDBManager manager = (BookDBManager)session.getAttribute("manager");
      
        Book book = null;
        
        try {
            book = manager.findBook(bookID);
        }    catch (SQLException ex) {
            Logger.getLogger(ReadBookServlet.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getErrorCode() + " and " + ex.getMessage());
        }
        if (book != null) {
            session.setAttribute("existErr", "Book already exists in the Database");
            request.getRequestDispatcher("add_book.jsp").include(request, response);
        }
         else {
            try{
                    manager.createBook(bookID, title, authorName, publisherName);
                   // Book book = new Book((bookID, title, authorName, publisherName);
                    session.setAttribute("book", book);
                    request.getRequestDispatcher("main.jsp").include(request, response);
       
                   }
         catch (SQLException ex) {
                Logger.getLogger(CreateBookServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
        
    }
}

   // manager.createBook(bookID, title, authorName, publisherName);
     //       request.getRequestDispatcher("main.jsp").include(request, response);
