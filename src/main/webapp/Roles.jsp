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



<h1 style="color:#00FF00;">${name}</h1>

<form action="${pageContext.request.contextPath}/JavaChangeRoles" method="post">  
 
<p><label for="ChooseRole">Выберите роль</label>
<p><select name="Role" id="number-select">
    <option value="oneRole">Пользователь</option>
    <option value="twoRole">Администратор</option>
    </select>
  <p>${sss}</p>  
    <p><input type="submit" name="role" value="Сохранить">
    </form>
    
   <form action="${pageContext.request.contextPath}/MainFormA.jsp" method="post">
    <input type="submit" name="sign" value="Назад">
 </form>  

</body>
</html>