<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modifier une formation</title>
</head>
<body>
<h1>Modifier une formation</h1>
<form action="ModifyTrainingServlet" method="POST">
<table>
<tr>
    <td>Identifiant de la formation</td>
    <td><input name="id" type="text"/></td>
    <td>Lieu</td>
    <td><input name="lieu" type="text"/></td>
</tr>
<tr>   
    <td><input type="submit" value="Valider"/></td>
</tr>
</table>
</form>
</body>
</html>