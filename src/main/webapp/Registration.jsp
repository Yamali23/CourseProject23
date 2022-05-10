<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Регистрация</title>
</head>
<link rel="stylesheet" href="One.css">
<body>

     <h2 class="headline" >Регистрация </h2> 

<form action="${pageContext.request.contextPath}/JavaRegistration" method="post">
<p><strong>Логин:</strong> <input type="text" name="login" id="login" value="">
<p><strong>Пароль:</strong> <input type="text" name="password" id="password" value="">
<p><input type="submit" name="ent" value="Зарегистрироваться">

<p> ${infa} </p>
</form>


<form action="${pageContext.request.contextPath}/InputForm.jsp">
    <input type="submit" name="sign" value="Назад">
 </form>  






</body>
</html>