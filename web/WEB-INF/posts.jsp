<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Konstantin
  Date: 14.09.2016
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Guest book posts</title>
</head>
<body>
<h1>Book manager prototype</h1>
<table border="1">
    <tr>
        <td><p>Id</p></td>
        <td width="300"><p>Name</p></td>
        <td></td>
    </tr>
    <c:forEach items="${posts}" var="post">
    <tr>
        <td> ${post.id}</td>
        <td width="300"><c:out value="${post.text}"/></td>
        <td>
            <a href="delete?id=${post.id}">
                <img src="delete.png" width="40" height="40">
            </a>
        </td>
    </tr>
    </c:forEach>
</table>
<p>You can add entry here:</p>
<form action="/add" method="POST">
    <tr>
        <td colspan="2">
            <input name="text" type="text" required>
        </td>
        <td>
            <input type="submit" value="Add entry" >
        </td>
    </tr>
</form>
<h2>F.A.Q.</h2>
<p>This icon delete an entry from base:   <img src="delete.png" width="40" height="40"></p>
<p>This icon adds an entry :   <img src="add.png" width="40" height="40"></p>
</body>
</html>
