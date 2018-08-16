<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:url value="/" var="cssPath" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">


<title>GitHub: @matheusicaro</title>
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
				<ul class="nav navbar-nav navbar-right">
        <li class="nav-item">
            <a href="#">
                <security:authentication property="principal" var="user" />
                Usuário: ${user.username }
            </a>
        </li>
    </ul>
				
			</div>
			<!-- /.navbar-collapse -->
		</div>
	</nav>

	<div class="container">

		<h1>Lista de Produtos</h1>

		<table style="text-align: center;" class="table table-bordered table-striped table-hover">
			<tr>
				<th><h2 style="text-align: center;" >Título</h2></th>
				<th><h2 style="text-align: center;" >Descrição</h2></th>
				<th><h2 style="text-align: center;" >Páginas</h2></th>
			</tr>
			<c:forEach items="${products}" var="products">
				<tr style="font-size: 20px;">
					<td><a
						href="${s:mvcUrl('PC#productsDetails').arg(0, products.id).build()}">
							${products.title} </a></td>

					<td>${products.description}</td>

					<td>${products.pages}</td>
				</tr>
			</c:forEach>
		</table>
		<div style="font-size: 17px; text-align: right;"><a href="${s:mvcUrl('PC#cleanDataBase').build() }">*Limpar Banco de Dados</a></div>
		<div>
			<h2>${success}</h2>
		</div>
		<div>
			<h2>${fail}</h2>
		</div>
	</div>
</body>
</html>