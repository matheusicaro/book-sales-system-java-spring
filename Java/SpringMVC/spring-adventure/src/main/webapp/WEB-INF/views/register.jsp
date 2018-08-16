<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" --%>
<%-- 	pageEncoding="UTF-8"%> --%>

<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>
<%-- <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> --%>
<%-- <%@ taglib uri="http://www.springframework.org/tags" prefix="s"%> --%>
<%-- <%@ taglib uri="http://www.springframework.org/security/tags" --%>
<%-- 	prefix="security"%> --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>GitHub: @matheusicaro</title>

<c:url value="/" var="cssPath" />
<link rel="stylesheet" href="${cssPath}/resources/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${cssPath}/resources/css/bootstrap-theme.min.css">
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
		
	</div>
	</nav>

	<div class="container">
		<h1>Cadastro de Usuario</h1>
		<form:form action="${s:mvcUrl('RC#createRegister').build() }" method="POST"
			commandName="user">

			<div class="form-group">
				<label>Nome</label>
				<form:input path="name" cssClass="form-control" />
				<form:errors path="name" />
			</div>
			<div class="form-group">
				<label>E-mail (Login)</label>
				<form:input path="email" cssClass="form-control" />
				<form:errors path="email" />

			</div>
			<div class="form-group">
				<label>Senha</label>
				<form:input path="password" />
				<form:errors path="password" />

			</div>

			<button type="submit" class="btn btn-primary">Cadastrar</button>

		</form:form>

		
	</div>
</body>
</html>