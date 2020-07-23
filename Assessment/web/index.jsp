<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/newcss.css">
        <title>Home Page</title>
    </head>
    <body onload="startTime()">
        <div><span class="time" id="time" ></span></div>
        
            <div class = "c1">
                <h1>Add Book Information</h1>
                 </div>
        <div class = "c2">
             <img class="pic" src="css/book.png"/>
        
          </div>
             <div class="centre">
                <a class="button" href="add_book.jsp">Add</a>
             </div>
       
        <jsp:include page="/ConnServlet" flush="true" />
    </body>
</html>
