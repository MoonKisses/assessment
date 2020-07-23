/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpSession;


public class Validator implements Serializable {
    
    private String BookIDPattern = "([0-9]*)";
    private String titlePattern = "([a-zA-Z0-9]+)(([._-])([a-zA-Z0-9]+))*(@)([a-z]+)(.)([a-z]{3})((([.])[a-z]{0,2})*)";
    private String authorNamePattern = "([A-Z][a-z]+[\\s])+[A-Z][a-z]*";
    private String publisherNamePattern = "[a-z0-9]{4,}";

    public Validator() {
    }

    public boolean validate(String pattern, String input) {
        Pattern regEx = Pattern.compile(pattern);
        Matcher match = regEx.matcher(input);
        return match.matches();
    }

    
    public boolean validateBookID(String bookID) {
        
        return validate(BookIDPattern, bookID);
    }
    
    
    public boolean validateTitle(String title) {
        return validate(titlePattern, title);
    }

    
    public boolean validateAuthorName(String authorName) {
        return validate(authorNamePattern, authorName);
    }

    public boolean validatePublisherName(String publisherName) {
        return validate(publisherNamePattern, publisherName);
    }

   
    
    public void clear(HttpSession session) {
        session.setAttribute("bookIDErr", "Enter bookID");
        session.setAttribute("titleErr", "Enter title");
        session.setAttribute("authorNameErr", "Enter authorName");
        session.setAttribute("publisherNameErr", "Enter publisherName");
    }

}

    
    
    

