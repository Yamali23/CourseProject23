<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Результаты</title>
</head>
<link rel="stylesheet" href="One.css">
<body>
<h1 class="headline" >Результаты </h1>
<p><strong>Ваши введеные данные: </strong> <p> 
<p>Высота:${height}</p> 
<p>Ширина:${width}</p> 
<p>Количество створок:${NumStvor}</p> 
<p>Количество откидных створок: ${NumFuncStvor}</p> 
<p>Тип стеклопакета:${TypeWind}</p> 
<p><strong>Итоговая стоимость:</strong> ${FinalCost}</p> 

<p>${Error1}</p> 
<p>${Error2}</p> 
<p>${Error3}</p> 
<p>${Error4}</p> 
<p>${Error5}</p> 


<form action="${pageContext.request.contextPath}/MainFormA.jsp">
    <p> <input type="submit" name="sign" value="Назад"> </p>
 </form>  

</body>
</html>