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

public class DeleteBookServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();  
        
        int bookID =  Integer.parseInt(request.getParameter("id"));
        
        BookDBManager manager = (BookDBManager) session.getAttribute("manager");
        try {
            manager.deleteBook(bookID);
            request.getRequestDispatcher("main.jsp").include(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(DeleteBookServlet.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getErrorCode() + " and " + ex.getMessage());
        }
    }
}
