<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/bootstrap.css" rel="stylesheet">
<title>Gestion des personnes</title>
</head>
<body>
	<div class="container">

		<h2>Formulaire</h2>

		<form action="ServletPersonne">

			<div class="form-group">
				<input type="hidden" name="id" value="${id}" /> Nom:<br> <input
					type="text" name="lastname" value="${lastname}" required maxlength="14" 
					 pattern=".{2,}" title="2 characters minimum"><br>
				Prénom:<br> <input type="text" name="firstname"
					value="${firstname}" required><br> 
				Age:<br> <input
					type="number" name="age" value="${age}" required min="18"><br>
				
			</div>

			<input type="submit" name="ajouter" value="Ajouter"> <input
				type="submit" name="modifier" value="Modifier"> 
		</form>

	</div>

	<div class="container">
		<h2>Liste des personnes en BDD</h2>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>NOM</th>
					<th>PRENOM</th>
					<th>AGE</th>
					<th>SUPPRIMER</th>
					<th>MODIFIER</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${! empty personnes}">
					<c:forEach items="${personnes}" var="x">
						<tr>
							<td><c:out value="${x.id}" /></td>
							<td><c:out value="${x.nom}" /></td>
							<td><c:out value="${x.prenom}" /></td>
							<td><c:out value="${x.age}" /></td>
							<td><a href="SupprimerPersonne?idPersonne=${x.id}">supprimer</a></td>
							<td><a href="ModifierPersonne?idPersonne=${x.id}">modifier</a></td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
	</div>
</body>
</html>