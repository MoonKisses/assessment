<%@page import="model.Book"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/newcss.css">
        <title>Add Book</title>
    </head>
    <body> 
        <%
            
            String existErr = (String) session.getAttribute("existErr");
            String bookIDErr = (String) session.getAttribute("bookIDErr");
            String titleErr = (String) session.getAttribute("titleErr");
            String authorNameErr = (String) session.getAttribute("authorNameErr");
            String publisherNameErr = (String) session.getAttribute("publisherNameErr");

        %>
        
        <div>
        <h1 class="c1">Add Book Page</h1><span class="message"> <%=(existErr != null ? existErr : "") %></span>
        </div>
        
        <form action="CreateBookServlet" method="post">
            <div class="c2">
            <table align="center">
            <tr><td>BookID:</td><td><input type="text" placeholder="<%=(bookIDErr != null ? bookIDErr : "Enter bookID")%>" name="bookID" required></td></tr>
            <tr><td>Title:</td><td><input type="text" placeholder="<%=(titleErr != null ? titleErr : "Enter Title")%>" name="title" required> </td></tr>
            <tr><td>Author Name:</td><td><input type="text" placeholder="<%=(authorNameErr != null ? authorNameErr : "Enter Author Name")%>" name="authorName" required></td></tr>
            <tr><td>Publisher Name:</td><td><input type="text" placeholder="<%=(publisherNameErr != null ? publisherNameErr : "Enter Publisher Name")%>" name="publisherName" required></td></tr>
            </table>
                </div>
            <div class="centre">
            <input class="button" type="submit" value="Submission">
            <a class="button" href="main.jsp"> Main</a>
            </div>
            
         </form>

  
            
        
    
    </body>
</html>
