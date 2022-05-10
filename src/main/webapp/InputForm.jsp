<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Авторизация</title>
</head>

<link rel="stylesheet" href="One.css">
<body>

<h1 class="headline"> Авторизация </h1> 
     
<form action="${pageContext.request.contextPath}/JavaEntrance" method="post">
<p><strong>Логин: </strong> <input type="text" name="login" id="login" value="">
<p><strong>Пароль: </strong> <input type="text" name="password" id="password" value="">
<p><input type="submit" name="ent" value="Войти">
</form>


<form action="${pageContext.request.contextPath}/Registration.jsp">
<p><input type="submit" name="reg" value="Зарегистрироваться"> 
</form>

<p> ${infa} </p>

</body>
</html>