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




public class EditBookServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        HttpSession session = request.getSession();
        String bookID = request.getParameter("bookID");
        BookDBManager manager = (BookDBManager) session.getAttribute("manager");

        Book book = null;

        try{
         
            book = manager.findBook(Integer.parseInt(bookID));
            if(book != null){
                session.setAttribute("book", book);
                //request.getRequestDispatcher("shipmentEdit.jsp").include(request, response);
            }else{
                session.setAttribute("existErr", "Book does not exist in the Database!");
                request.getRequestDispatcher("update_book.jsp").include(request, response);
            }
        } catch (SQLException ex){
            Logger.getLogger(EditBookServlet.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getErrorCode() + " and " +ex.getMessage());
        }
        request.getRequestDispatcher("update_book.jsp").include(request, response);
    }

    }