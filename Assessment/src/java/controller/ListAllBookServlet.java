package controller;

import java.io.IOException;

import model.Book;
import model.dao.BookDBManager;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ListAllBookServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException{ 
        HttpSession session = request.getSession();
        BookDBManager manager = (BookDBManager) session.getAttribute("manager");
        //session.setAttribute("deleted", "");
       
        
        try{            
           ArrayList<Book> books = manager.listAllBook();
           session.setAttribute("books", books);
           request.getRequestDispatcher("main.jsp").include(request, response);
 
        }catch(SQLException ex){
            Logger.getLogger(ListAllBookServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
}