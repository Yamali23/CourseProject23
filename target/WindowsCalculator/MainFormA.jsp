<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ввод параметров (администратор)</title>
</head>
<body>
<p> ${name}</p> 
<h2>Задайте параметры для расчета : </h2> 
<form action="${pageContext.request.contextPath}/JavaCalc" method="post">
<p><strong>Высота:</strong> <input type="text" name="height" id="height" value=""> 
<p><strong>Ширина:</strong> <input type="text" name="width" id="width" value=""> 

<p><strong><label for="number-select">Количество створок:</label></strong>
<select name="NumStvor" id="number-select">
    <option value="NS">--Выберите количество створок--</option>
    <option value="1">Одна</option>
    <option value="2">Две</option>
    <option value="3">Три</option>
    </select>
    
    <p><strong><label for="number-select">Количество откидных створок:</label></strong>
<select name="NumFuncStvor" id="number-select">
    <option value="NFS">--Выберите количество откидных створок--</option>
    <option value="1">Одна</option>
    <option value="2">Две</option>
    <option value="3">Три</option>
    </select>
    
    <p><strong><label for="number-select">Тип стеклопакета:</label></strong>
<select name="TypeWind" id="number-select">
    <option value="TW">--Выберите тип стеклопакета--</option>
    <option value="1">Одномерный</option>
    <option value="2">Двукамерный</option>
    </select>
    
    <p><strong><label for="number-select">Генерация PDF:</label></strong>
<select name="PDF" id="number-select">
    <option value="yes">Генерировать</option>
    <option value="no">Не генерировать</option>
    </select>
    
    <p><input type="submit" name="sign" value="Рассчитать">
    
</select>
</form>

<p> ${infa} </p>

<form action="${pageContext.request.contextPath}/Materials.jsp" method="post">    
    <p><input type="submit" name="coef" value="Коэффициенты">
</form>

<form action="${pageContext.request.contextPath}/FindUser.jsp" method="post">    
    <input type="submit" name="roles" value="Роли">
</form>    

<form action="${pageContext.request.contextPath}/InputForm.jsp" method="post">    
    <p><input type="submit" name="exit" value="Выход">
</form>  

</body>
</html>