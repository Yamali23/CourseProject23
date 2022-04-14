<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ввод параметров (администратор)</title>
</head>
<body>
<p> ${infa}</p> 
<h2>Задайте параметры для расчета : </h2> 
<p><strong>Высота:</strong> <input type="text" name="height" id="height" value=""> 
<p><strong>Ширина:</strong> <input type="text" name="widht" id="widht" value=""> 

<p><strong><label for="number-select">Количество створок:</label></strong>
<select name="number" id="number-select">
    <option value="ANS">--Выберите количество створок--</option>
    <option value="oneANS">Одна</option>
    <option value="twoANS">Две</option>
    <option value="threeANS">Три</option>
    </select>
    
    <p><strong><label for="number-select">Количество откидных створок:</label></strong>
<select name="number" id="number-select">
    <option value="ANFS">--Выберите количество откидных створок--</option>
    <option value="oneANFS">Одна</option>
    <option value="twoANFS">Две</option>
    <option value="threeANFS">Три</option>
    </select>
    
    <p><strong><label for="number-select">Тип стеклопакета:</label></strong>
<select name="number" id="number-select">
    <option value="ATW">--Выберите тип стеклопакета--</option>
    <option value="oneATW">Одномерный</option>
    <option value="twoATW">Двукамерный</option>
    </select>
    
    <p><strong><label for="number-select">Генерация PDF:</label></strong>
<select name="number" id="number-select">
    <option value="yes">Генерировать</option>
    <option value="no">Не генерировать</option>
    </select>
    
    <p><input type="submit" name="sign" value="Рассчитать">
    <p><input type="submit" name="sign" value="Коэффициенты">
    <input type="submit" name="sign" value="Роли">
    
</select>

</body>
</html>