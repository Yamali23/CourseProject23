<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Информация</title>
</head>
<link rel="stylesheet" href="One.css">
<body>

<h2 class="headline" >Внимание! </h2> 
<p>${infa}</p> 

<form action="${pageContext.request.contextPath}/MainForm.jsp">
    <input type="submit" name="sign" value="Назад">
 </form>  
 
</body>
</html>