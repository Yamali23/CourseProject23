<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Роли</title>
</head>
<link rel="stylesheet" href="One.css">
<body>

<h2 class="headline" >Изменение роли пользователя </h2> 

<form action="${pageContext.request.contextPath}/JavaFindUser" method="post">    
<p><input type="text" name="userName" id="first" value="">

<p>
    
    <p><input type="submit" name="role" value="Найти">
    </form>
  <p>${infa}</p>   
   <form action="${pageContext.request.contextPath}/MainFormA.jsp">
    <input type="submit" name="sign" value="Назад">
 </form>  

</body>
</html>