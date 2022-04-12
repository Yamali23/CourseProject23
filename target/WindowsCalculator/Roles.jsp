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

<p><input type="text" name="first" id="first" value="Введите логин пользователя..."> 
<input type="submit" name="sign" value="Найти">

<p><select name="number" id="number-select">
    <option value="">--Выберите роль--</option>
    <option value="oneRole">Пользователь</option>
    <option value="twoRole">Администратор</option>
    </select>
    
    <p><input type="submit" name="sign" value="Сохранить">
    <input type="submit" name="sign" value="Назад">

</body>
</html>