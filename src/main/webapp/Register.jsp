<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Page</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f9;
        margin: 0;
        padding: 0;
    }
    .container {
        width: 100%;
        max-width: 600px;
        margin: 50px auto;
        padding: 20px;
        background-color: white;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    h1 {
        text-align: center;
        color: #333;
    }
    label {
        font-size: 1.2em;
        color: #333;
        margin-bottom: 8px;
        display: inline-block;
    }
    input[type="text"], input[type="email"], input[type="password"] {
        width: 100%;
        padding: 10px;
        margin: 10px 0;
        border: 1px solid #ddd;
        border-radius: 4px;
        font-size: 1em;
    }
    input[type="submit"] {
        width: 100%;
        padding: 12px;
        background-color: #4CAF50;
        color: white;
        border: none;
        border-radius: 4px;
        font-size: 1.2em;
        cursor: pointer;
    }
    input[type="submit"]:hover {
        background-color: #45a049;
    }
    a {
        display: block;
        text-align: center;
        margin-top: 10px;
        text-decoration: none;
        color: #333;
        font-size: 1em;
    }
    a:hover {
        text-decoration: underline;
    }
    .message {
        color: #ff0000;
        text-align: center;
    }
</style>
</head>
<body>
<div class="container">
    <form action="reg" method="post">
        <h1>Register</h1>
        <label for="Uname">Name :</label>
        <input type="text" id="Uname" name="Uname" required><br>
        
        <label for="Umail">Email :</label>
        <input type="email" id="Umail" name="Umail" required><br>
        
        <label for="Upass">Password :</label>
        <input type="password" id="Upass" name="Upass" required><br>

        <%
        if(request.getAttribute("message") != null) {
            out.println("<p class='message'>" + request.getAttribute("message") + "</p>");
        }
        %>

        <input type="submit" value="Register">
        <a href="login.jsp">Already have an account? Login here</a>
    </form>
</div>
</body>
</html>
