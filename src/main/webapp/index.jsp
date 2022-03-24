<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Bank og Kebab</title>
</head>
<body>

<br>
<br>
${requestScope.msg}
<br>
${requestScope.errorMessage}

<br>
<br>
<br>
<br>

<c:forEach items="${applicationScope.accounts}" var="item" >

${item.value.name}  : ${item.value.balance}
    <br>

</c:forEach>

<h2>Har du allerede en bruger? Log in her: </h2>
<form action="ServletLogin">
    <label for="user">Login:</label><br>
    <input type="text" id="user" name="user" placeholder="User"><br>
    <label for="password">Skriv kode:</label><br>
    <input type="text" id="password" name="password" placeholder="Password"><br><br>
    <input type="submit" value="Submit">
</form>



<h2>Ny bruger? Opret en konto her: </h2>
<form action="ServletCreateAccount">
    <label for="newUser">Vælg dit unikke brugernavn her: </label><br>
    <input type="text" id="newUser" name="newUser" placeholder="newUser"><br>
    <label for="newPassword">Vælg et kodeord her:</label><br>
    <input type="text" id="newPassword" name="newPassword" placeholder="newPassword"><br><br>
    <input type="submit" value="Submit">
</form>

</body>
</html>