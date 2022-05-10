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

<h2 class="headline" >Информация </h2> 

<p>Значения размеров окна должны находиться в диапазоне 0.5 - 2.5</p>
<p>Количество откидных створок не может быть больше общего числа створок</p>
<p>Ширина створки не может быть меньше, чем 0.5</p>

<p> </p>
<p><strong>Разработчики: </strong></p>
<p>Ямали Д.Д.</p>
<p>Полетавкина А.С.</p>
<p>Кадыров Р. Р.</p>
<p>Аюпов Д. А.</p>

<form action="${pageContext.request.contextPath}/MainForm.jsp">
    <input type="submit" name="sign" value="Назад">
 </form>  
 
</body>
</html>