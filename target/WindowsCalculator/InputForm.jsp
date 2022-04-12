<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Авторизация</title>
</head>
<body>

     <h2>Авторизация </h2> 
<p><strong>Логин:</strong> <input type="text" name="login" id="login" value=""> 
<p><strong>Пароль:</strong> <input type="text" name="password" id="password" value=""> 

<form action="${pageContext.request.contextPath}/JavaStart" method="post">
<p><input type="submit" name="sign" value="Войти">
</form>

<form action="${pageContext.request.contextPath}/MainFormA.jsp" method="post">
<p><input type="submit" name="sign" value="Зарегистрироваться">
</form>


</body>
</html>