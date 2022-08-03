<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Supprimer formation</title>
</head>

<body>
<h1>Supprimer Formation</h1>
<form action="DeleteTrainingServlet" method="POST">
<table>
<tr>
    <td>Identifiant de la formation</td>
    <td><input name="id" type="text"/></td>
</tr>
<tr>   
    <td><input type="submit" value="Supprimer"/></td>
</tr>
</table>
</form>
</body>
</html>