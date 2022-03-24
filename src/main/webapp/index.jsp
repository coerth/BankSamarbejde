<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="ServletHello">Hello Servlet</a>
<br>
<br>
${requestScope.msg}
<br>
${requestScope.errorMessage}

<br>
<br>
<br>
<br>

<%--<c:forEach items="${applicationScope.kontis}" var="item" >

${item.value.navn}  : ${item.value.saldo}
    <br>

</c:forEach>--%>


<form action="ServletLogin">
    <label for="user">Login:</label><br>
    <input type="text" id="user" name="user" value="User"><br>
    <label for="password">Skriv kode:</label><br>
    <input type="text" id="password" name="password" value="Password"><br><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>