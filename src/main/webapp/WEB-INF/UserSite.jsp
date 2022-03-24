<%--
  Created by IntelliJ IDEA.
  User: mbend
  Date: 22/03/2022
  Time: 10.06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Usersite</title>
</head>
<body>

<h1>Velkommen ${sessionScope.name}. Du er nu logget ind</h1>
din saldo er ${sessionScope.account.balance} kr.


<a href="ServletLogoff">Log af og gå til index</a>


<br>
<br>

<h2>Indsæt</h2>
<h1>${requestScope.errorMessage}</h1>
<br>
<form action="ServletTransaction" method="post">
    <label for="amount">Angiv beløb</label><br>
    <input type="text" id="amount" name="amount" placeholder="0"><br>
    <input type="submit" name="type" value="Insert">
    <input type="submit" name="type" value="Withdraw">
</form>
<br>
<h3>Skift password</h3>
${requestScope.messagePassword}
<form action="ServletChangePassword" method="post">
    <label for="password"></label><br>
    <input type="text" id="oldPassword" name="oldPassword" placeholder="Skriv dit nuværende password"><br>
    <label for="newPassword"></label><br>
    <input type="text" id="newPassword" name="newPassword" placeholder="Skriv det nye password"><br>
    <input type="submit" name="type" value="Change">
</form>
<br>
<h3>Slet din konto</h3>
<form action="ServletDeleteAccount" method="post">
    <label for="password"></label><br>
    <input type="text" id="password" name="password" placeholder="Skriv dit password"><br>
    <input type="submit" name="type" value="Delete" placeholder="Slet">
</form>


<%--<br>
<h2>Hæv</h2>
<br>
<form action="ServletTransaction" method="post">
    <label for="WithdrawAmount">Angiv beløb</label><br>
    <input type="text" id="WithdrawAmount" name="WithdrawAmount" value="0"><br>
    <input type="submit" name="type" value="" >
</form>--%>



</body>
</html>
