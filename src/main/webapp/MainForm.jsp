<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Ввод параметров </title>
</head>
<body>
<p> ${infa}</p> 
<h2>Задайте параметры для расчета : </h2> 
<p><strong>Высота:</strong> <input type="text" name="height" id="height" value=""> 
<p><strong>Ширина:</strong> <input type="text" name="widht" id="widht" value=""> 

<p><strong><label for="number-select">Количество створок:</label></strong>
<select name="number" id="number-select">
    <option value="NS">--Выберите количество створок--</option>
    <option value="oneNS">Одна</option>
    <option value="twoNS">Две</option>
    <option value="threeNS">Три</option>
    </select>
    
    <p><strong><label for="number-select">Количество откидных створок:</label></strong>
<select name="number" id="number-select">
    <option value="NFS">--Выберите количество откидных створок--</option>
    <option value="oneNFS">Одна</option>
    <option value="twoNFS">Две</option>
    <option value="threeNFS">Три</option>
    </select>
    
    <p><strong><label for="number-select">Тип стеклопакета:</label></strong>
<select name="number" id="number-select">
    <option value="TW">--Выберите тип стеклопакета--</option>
    <option value="oneTW">Одномерный</option>
    <option value="twoTW">Двукамерный</option>
    </select>
    
    <p><strong><label for="number-select">Генерация PDF:</label></strong>
<select name="number" id="number-select">
    <option value="yes">Генерировать</option>
    <option value="no">Не генерировать</option>
    </select>
    
    <p><input type="submit" name="sign" value="Рассчитать">
    
</select>



</body>
</html>