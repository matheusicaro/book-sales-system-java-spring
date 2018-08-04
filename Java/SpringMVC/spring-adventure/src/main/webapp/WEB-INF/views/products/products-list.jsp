<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Adventure In Spring - GitHub: @matheusicaro</title>
<c:url value="/" var="cssPath" />
<link rel="stylesheet" href="${cssPath}/resources/css/bootstrap.min.css">
<link rel="stylesheet" href="${cssPath}/resources/css/bootstrap-theme.min.css">
<style type="text/css">
body {
	padding-top: 60px;
}
</style>
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="${s:mvcUrl('HC#home').build()}">
					HOME </a>
			</div>
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="${s:mvcUrl('PC#productsList').build()}">
							Lista de Produtos </a></li>
					<li><a href="${s:mvcUrl('PC#form').build()}"> Cadastro de
							Produtos </a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
	</nav>

	<div class="container">

		<h1>Lista de Produtos</h1>

		<table class="table table-bordered table-striped table-hover">
			<tr>
				<th><h2>Título</h2></th>
				<th><h2>Descrição</h2></th>
				<th><h2>Páginas</h2></th>
			</tr>
			<c:forEach items="${products}" var="products">
				<tr>
					<td><a
						href="${s:mvcUrl('PC#productsDetails').arg(0, products.id).build()}">
							${products.title} </a></td>

					<td>${products.description}</td>

					<td>${products.pages}</td>
				</tr>
			</c:forEach>
		</table>
		<br /> <br />
		<div>
			<h2>${success}</h2>
		</div>
		<div>
			<h2>${fail}</h2>
		</div>
	</div>
</body>
</html>