<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="Home.jsp" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<form action="DeleteStudentDetails" method="post">
<div class="mb-3" align="center"><br>
<label>E-mail</label>
<input type="email" name="Dname"><br><br>
<input type="submit" value="Delete"><br>
<% 
            String message = (String) request.getAttribute("Delete");
            if (message != null) {
                out.print(message);
            }
        %>
</div>
</form>
</body>
</html>