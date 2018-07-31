<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Adventure In Spring - GitHub: @matheusicaro</title>
</head>
<body>
	<h1>Lista de Produtos</h1>

	<a href="products/form">Cadastrar Livros</a>

	<table>
		<tr>
			<td><h2>Título</h2></td>
			<td></td><td></td>
			<td></td><td></td>
			<td><h2>Descrição</h2></td>
			<td></td><td></td>
			<td></td><td></td>
			<td><h2>Páginas</h2></td>
		</tr>
		<c:forEach items="${products}" var="products">
			<tr>
				<td><a
					href="${s:mvcUrl('PC#productsDetails').arg(0, products.id).build()}">
						${products.title} </a></td>
				<td></td><td></td>
				<td></td><td></td>

				<td>${products.description}</td>
				<td></td><td></td>
				<td></td><td></td>

				<td>${products.pages}</td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<br />
	<div>
		<h2>${success}</h2>
	</div>
	<div>
		<h2>${fail}</h2>
	</div>
</body>
</html>