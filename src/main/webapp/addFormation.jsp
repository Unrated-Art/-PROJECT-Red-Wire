<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajouter Formation</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
</head>
<body>
<h1>Ajouter formation</h1>
<!-- <form action="AddTrainingServlet" method="POST"> -->
<form action="../StableRedWire/services/catalogueservices" method="POST">


	<div class="mb-3">
	  <label for="exampleFormControlInput1" class="form-label">Référence</label>
	  <input type="text" class="form-control" name="ref" placeholder="XX123">
	</div>
					

	<div class="mb-3">
		<label for="exampleFormControlInput1" class="form-label">Lieu de formation</label>
		<select name="location" class="form-select" aria-label="Default select example" >
		  <option value="Paris La défense" selected>Paris La défense</option>
		  <option value="Lyon" >Lyon</option>
		  <option value="Sophia Antipolis">Sophia Antipolis</option>
		  <option value="Aix-en-provence">Aix-en-provence</option>
		  <option value="Toulouse">Toulouse</option>
		  <option value="Bordeaux">Bordeaux</option>
		  <option value="Nantes">Nantes</option>
		  <option value="Rennes">Rennes</option>
		  <option value="Rouen">Rouen</option>
		  <option value="Lille">Lille</option>
		  <option value="Starsbourg">Starsbourg</option>
		</select>
	</div>

    <div class="mb-3">
     <!-- Formation inter-entreprises/Formation intra-entreprise -->
	     <div>
	    	<label for="exampleFormControlInput1" class="form-label">Type de formation: </label>
		 </div>

	    	<label class="form-check-label" for="inlineRadio1">Formation inter</label>
	  		<input name="interIntra" class="form-check-input" type="radio" value="true" id="inter" checked="checked">

		
			<label class="form-check-label" for="inlineRadio2">Formation intra</label>
		    <input  name="interIntra" class="form-check-input" type="radio" value="false" id="intra">
		    
	</div>

	<div class="mb-3">
	  <label for="exampleFormControlInput1" class="form-label">Durée</label>
	  <input name="duration" type="text" class="form-control" placeholder="nbre de jours">
	</div>

	<div class="mb-3">
	  <label for="exampleFormControlTextarea1" class="form-label">Prerequis</label>
	  <textarea name="prerequis" class="form-control" id="exampleFormControlTextarea1" rows="2"></textarea>
	</div>
	
	
	<div class="mb-3">
	  <label for="exampleFormControlInput1" class="form-label">Objectif</label>
	  <textarea name="goal" class="form-control" id="exampleFormControlTextarea1" rows="2"></textarea>
	</div>
	
	
	<div class="mb-3">
	  <label for="exampleFormControlTextarea1" class="form-label">Public visé</label>
	  <textarea name="targetPublic" class="form-control" id="exampleFormControlTextarea1" rows="2"></textarea>
	</div>
	
	<div class="mb-3">
	  <label for="exampleFormControlTextarea1" class="form-label">Programme détaillé</label>
	  <textarea name="details" class="form-control" id="exampleFormControlTextarea1" rows="4"></textarea>
	</div>

	
	<div >
		<input type="submit" value="Enregistrer" class="btn btn-primary"/>
	</div>

</form>
</body>
</html>