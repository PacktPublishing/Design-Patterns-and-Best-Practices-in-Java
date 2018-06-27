<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC “-//W3C//DTD HTML 4.01 Transitional//EN" “http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content= text/html; charset=UTF-8">
<title>Welcome to Spring</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>
<body>
<table>
<th>Name</th>
<th>Email</th>
<th>Address</th>
<th>Telephone</th>
<th>Action</th>
 
<c:forEach var="employee" items="${employeeList}">
    <tr>

        <td>${employee.id}</td>
        <td>${employee.name}</td>
        <td>${employee.designation}</td>
    </tr>
</c:forEach>
</table>

</body>
</html>