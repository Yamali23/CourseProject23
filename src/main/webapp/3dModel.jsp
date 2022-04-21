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

<form action="${pageContext.request.contextPath}/For3dModel" method="post">
<p><select name="number" id="number-select">
    <option value="pause">Пауза</option>
    <option value="right">Вправо</option>
    <option value="left">Влево</option>
    </select>
    <p><input type="submit" name="apply" value="Применить">
    </form>

<form action="${pageContext.request.contextPath}/MainForm.jsp" method="post">
    <p><input type="submit" name="sign" value="Назад">
</form>  
    
    <img src= "Window_cut.gif">   
   
    
</body>
</html>