<%@ page import="java.util.ArrayList" %>
<%@ page import="LoginPac.Student" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="Home.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display data</title>
</head>
<body>
<table>
<thead>
<tr>
<th>Sid</th>
<th>Name</th>
<th>Age</th>
<th>Mobile</th>
<th>Address</th>
<th>Email</th>
<th>Course</th>
</tr>
</thead>
<tbody>
<%
ArrayList<Student> al = (ArrayList<Student>) request.getAttribute("student list");
if (al != null) {
    for (Student s : al) {
%>
<tr>
    <td><%= s.getSid() %></td>
    <td><%= s.getName() %></td>
    <td><%= s.getAge() %></td>
    <td><%= s.getMobile() %></td>
    <td><%= s.getAddress() %></td>
    <td><%= s.getEmail() %></td>
    <td><%= s.getCourse() %></td>
</tr>
<%
    }
} else {
%>
<tr>
    <td colspan="7">No students found.</td>
</tr>
<%
}
%>

</tbody>
</table>
</body>
</html>