<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Роли</title>
</head>
<body>

<h2>Изменение роли пользователя </h2>   
<h1 style="color:#FA0A0A;">${name}</h1>
<p>
<p>
    
<p> Пользователь не найден
   <form action="${pageContext.request.contextPath}/MainFormA.jsp" method="post">
    <input type="submit" name="sign" value="Назад">
 </form>  
<p>${sss}</p>
</body>
</html>