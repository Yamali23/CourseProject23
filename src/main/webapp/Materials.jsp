<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Коэффициенты</title>
</head>
<link rel="stylesheet" href="One.css">
<body>

<h2 class="headline" >Изменение стоимости материалов и услуг </h2> 
<form action="${pageContext.request.contextPath}/MaterialsCost" method="post">
     <p><label for="cost1">Стоимость рамного профиля (м):
     </label> <input type="text" name="cost1" id="cost1" value=""> 
     <p><label for="cost2">Стоимость импоста (м): 
     </label> <input type="text" name="cost2" id="cost2" value=""> 
     <p><label for="cost3">Стоимость створчатого профиля (м): 
     </label> <input type="text" name="cost3" id="cost3" value=""> 
     <p><label for="cost4">Стоимость штапика шт: 
     </label> <input type="text" name="cost4" id="cost4" value=""> 
     <p><label for="cost5">Стоимость армирования (м): 
     </label> <input type="text" name="cost5" id="cost5" value=""> 
     <p><label for="cost6">Стоимость дистанционной рамки (м): 
     </label> <input type="text" name="cost6" id="cost6" value=""> 
     <p><label for="cost7">Стоимость селикогеля шт: 
     </label> <input type="text" name="cost7" id="cost7" value=""> 
     <p><label for="cost8">Стоимость резинового уплотнитея (м): 
     </label> <input type="text" name="cost8" id="cost8" value="">
     <p><label for="cost9">Стоимость герметика (шт):
     </label> <input type="text" name="cost9" id="cost9" value=""> 
     <p><label for="cost10">Стоимость бутиловой ленты (м): 
     </label> <input type="text" name="cost10" id="cost10" value=""> 
     <p><label for="cost11">Стоимость стекла (кв. м): 
     </label> <input type="text" name="cost11" id="cost11" value="">  
      <p><label for="cost12">Стоимость поворотно-откидной фурнитуры (шт): 
     </label> <input type="text" name="cost12" id="cost12" value="">  
      <p><label for="cost13">Стоимость лап крепления импоста (шт): 
     </label> <input type="text" name="cost13" id="cost13" value="">  
     <p><label for="cost14">Стоимость соединителей импоста (шт): 
     </label> <input type="text" name="cost14" id="cost14" value="">  
     <p><label for="cost15">Стоимость крепежей (саморезов) (шт): 
     </label> <input type="text" name="cost15" id="cost15" value="">  
     <p><label for="cost16">Стоимость монтажной пены (шт): 
     </label> <input type="text" name="cost16" id="cost16" value=""> 
     <p><label for="cost17">Стоимость анкера (шт): 
     </label> <input type="text" name="cost17" id="cost17" value=""> 
     <p><label for="cost18">Стоимость подкладки под стеклопакет:      
     </label> <input type="text" name="cost18" id="cost18" value=""> 
      <p><label for="cost19">Сумма зп за 1 откидную ствроку:      
     </label> <input type="text" name="cost19" id="cost19" value=""> 
      <p><label for="cost20">Сумма зп за 1 глухую створку: 
     </label> <input type="text" name="cost20" id="cost20" value=""> 
      <p><label for="cost21">Стоимость аренды: 
     </label> <input type="text" name="cost21" id="cost21" value=""> 
      <p><label for="cost22">Стоимость электроэнергии: 
     </label> <input type="text" name="cost22" id="cost22" value=""> 
     
 <p><input type="submit" name="sign" value="Сохранить">
 </form>
<form action="${pageContext.request.contextPath}/MainFormA.jsp">
    <input type="submit" name="sign" value="Назад">
 </form>  
 

<p> ${infa} </p>

</body>
</html>