
<%@page import="model.Book"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/newcss.css">
        <title>Update Book</title>
    </head>
    <body>
        <h1>Update Book Information</h1>
        
        <%
           Book book = (Book) session.getAttribute("book");
        %>
       
        <form action="UpdateBookServlet" method="post">
            <table>
             
                <tr><td>bookID</td><td><input type="hidden" name="bookID" value="${book.bookID}"></td></tr>
                <tr><td>Title</td><td><input type="text" name="title" value="${book.title}"></td></tr>
                <tr><td>Author Name</td><td><input type="text" name="authorName" value="${book.authorName}"></td></tr>
                 <tr><td>Publisher Name</td><td><input type="text" name="publisherName" value="${book.publisherName}"></td></tr>
             
            <tr><td></td><td><input class ="button" type="submit" value="Update"></td></tr>
            
            </table>
                 
        </form>


    </body>
</html>
