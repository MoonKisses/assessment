package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.Book;
import model.dao.BookDBManager;

/**
 *
 * @author apple
 */
public class ReadBookServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();   
        int bookID = Integer.parseInt(request.getParameter("bookID"));
        
        BookDBManager manager = (BookDBManager) session.getAttribute("manager");
       
        Book books = null;
        
        try {
            books = manager.findBook(bookID);
            session.setAttribute("book", books);
            request.getRequestDispatcher("main.jsp").include(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ReadBookServlet.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getErrorCode() + " and " + ex.getMessage());
        }
    }
}

