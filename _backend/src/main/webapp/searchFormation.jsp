<%-- <%@page import="util.JpaUtil"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rechercher Formation</title>
</head>
<body>
<h1>Rechercher Formation</h1>
<form action="ResearchTrainingServlet" method="POST">
<table>
<tr>
    <td>Référence de la formation</td>
    <td><input name="reference" type="text"/></td>
</tr> 
<tr>   
    <td><input type="submit" value="Rechercher"/></td>
</tr>
</table>


</form> 



</body>
</html>