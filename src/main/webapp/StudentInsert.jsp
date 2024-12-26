<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="Home.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Student</title>
<style>
        /* Scoped form styles using an ID */
        #myForm {
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 500px;
            margin: 0 auto; /* Center the form horizontally */
            display: block; /* Stack form elements vertically */
        }

        /* Styling for labels inside the form */
        #myForm label {
            font-weight: bold;
            display: block;
            margin-bottom: 4px;
            color: #333;
        }

        /* Styling for input fields inside the form */
        #myForm input[type="text"], 
        #myForm input[type="number"], 
        #myForm input[type="email"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 14px;
            display: block; /* Ensure inputs stack vertically */
        }

        /* Focus effect for input fields */
        #myForm input[type="text"]:focus, 
        #myForm input[type="number"]:focus, 
        #myForm input[type="email"]:focus {
            border-color: #007BFF;
            outline: none;
        }

        /* Styling for the submit button */
        #myForm button {
            background-color: #007BFF;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            font-size: 14px;
            cursor: pointer;
            width: 100%;
            margin-top: 10px;
        }

        /* Button hover effect */
        #myForm button:hover {
            background-color: #0056b3;
        }

        /* Space between input fields */
        br {
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
<form id="myForm" action="saveStudentDetails" method="post">
<br><br><label>Name :</label>
<input type="text" name="Sname"><br><br>
<label>Age :</label>
<input type="number" name="Sage"><br><br>
<label>Mobile :</label>
<input type="number" name="Snumber"><br><br>
<label>Address :</label>
<input type="text" name="Saddress"><br><br>
<label>Email :</label>
<input type="email" name="Smail"><br><br>
<label>Course</label>
<input type="text" name="Scourse"><br><br>
<%
if(request.getAttribute("message")!=null)
{
	out.println("<h4 style=color:red>" + request.getAttribute("message") +"</h4>");
}
%>
<input type="submit" value="Add">
</form>
</body>
</html>