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


<a href="/CourseProject23/Check.pdf"> Открыть PDF-файл</a>

<form action="${pageContext.request.contextPath}/MainForm.jsp">
    <p> <input type="submit" name="sign" value="Назад"> </p>
 </form>  

</body>
</html>