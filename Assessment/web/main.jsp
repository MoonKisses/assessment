<%@page import="java.util.ArrayList"%>
<%@page import="model.Book"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/newcss.css">
        <title>Main Page</title>
    </head>

 <%
        ArrayList<Book> book = (ArrayList<Book>) session.getAttribute("books");

 %>
   <h1 class = "c1">Books Database </h1>
  

 <div class="c2">

         <a class="button"  href ="add_book.jsp">Add A Book</a>
         <a class="button"  href = "ListAllBookServlet">List All Books</a>

     <table>
         <tr>
                    <td>bookID </td>
                    <td>Title</td>
                    <td>Author Name</td>
                    <td>Publisher Name</td>
                </tr>
            
            <c:forEach var="book" items="${books}">
                <tr>
                    <td><c:out value="${book.bookID}"/></td>
                    <td><c:out value="${book.title}" /></td>
                    <td><c:out value="${book.authorName}" /></td>
                    <td><c:out value="${book.publisherName}" /></td>
                
                    <td>           
                 <a class = "button" href="DeleteBookServlet?id=<c:out value ="${book.bookID}"/>">Delete</a>            
                </td>
                </tr>
            </c:forEach>
</table>
  </div>

</html>