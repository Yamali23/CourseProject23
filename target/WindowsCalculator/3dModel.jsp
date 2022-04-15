<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>3D</title>
</head>
<body>

<h2>3D модель окна в разрезе  </h2> 

<p><select name="number" id="number-select">
    <option value="pause">Пауза</option>
    <option value="right">Вправо</option>
    <option value="left">Влево</option>
    </select>
<form action="${pageContext.request.contextPath}/MainForm.jsp" method="post">
    <input type="submit" name="sign" value="Назад">
 </form>  
   <p><img src="Steam_Valentine.gif"> 
   
    
</body>
</html>