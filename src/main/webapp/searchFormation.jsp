<%-- <%@page import="util.JpaUtil"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    
    
<%@ page import="java.util.ArrayList, java.text.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rechercher Formation</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
</head>
<body>
<h1>Rechercher Formation</h1>
<!-- <form action="ResearchTrainingServlet" method="GET"> -->
<form action="../StableRedWire/services/catalogueservices/{ref}" method="GET">


<label for="exampleFormControlInput1" class="form-label">Référence de la formation</label>
<div class="input-group mb-3">
  <input  name="ref" type="text" class="form-control" placeholder="Type the reference here" aria-describedby="button-addon1">
  <button class="btn btn-outline-info" type="submit" id="button-addon1">Rechercher</button>
</div>


<Table class="table table-hover">
<tr>

    <td class="table-dark">Réference</td>
    <td class="table-dark">Lieu</td>
    <td class="table-dark">Formation inter-entreprise</h6></td>
    <td class="table-dark">Durée</td>
    <td class="table-dark">Prérequis</td>
    <td class="table-dark">Objectif</td>
    <td class="table-dark">Public visé</td>
    <td class="table-dark">Programme détaillé</td>
    <td></td>
	<td></td>
    
</tr>

<%-- <c:if test="${ref}!=''" var="f" value="${trainingRef}">
   	<td>${f.getReference()}</td>
    <td>${f.getLieu()}</td>
    <td>${f.getInterFormation()}</td>
    <td>${f.getDuree()}</td>
    <td>${f.getPrerequis()}</td>
    <td>${f.getObjectif()}</td>
    <td>${f.getPublicVise()}</td>
    <td>${f.getProgrammeDetaille()}</td>
</c:if>  --%>

<c:forEach var="current" items="${allTrainings}" >
<tr>

    <td>${current.getReference()}</td>
    <td>${current.getLieu()}</td>
    <td>${current.getInterFormation()}</td>
    <td>${current.getDuree()}</td>
    <td>${current.getPrerequis()}</td>
    <td>${current.getObjectif()}</td>
    <td>${current.getPublicVise()}</td>
    <td>${current.getProgrammeDetaille()}</td>
    <td><button class="btn btn-secondary" type="submit" id="updateBtn">Modifier</button></td>
    <td><button class="btn btn-warning" type="submit" id="deleteBtn">Supprimer</button></td>

</tr>
 </c:forEach>
 
 </Table>
 
</form> 


</body>
</html>