<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Adventure In Spring</title>
</head>
<body>

	<form:form action="${s:mvcUrl('PC#save').build()}" method="POST"
		commandName="product" enctype="multipart/form-data">

		<div>
			<label>Título</label>
			<form:input path="title" />
			<form:errors path="title" />
		</div>
		<div>
			<label>Descrição</label>
			<textarea rows="10" cols="20" name="description"></textarea>
			<form:errors path="description" />

		</div>
		<div>
			<label>Páginas</label>
			<form:input path="pages" />
			<form:errors path="pages" />

		</div>

		<div>
			<label>Data de Lançamento</label>
			<form:input path="dateLaunch" />
			<form:errors path="dateLaunch" />
		</div>

		<c:forEach items="${typesBook}" var="EnumTypeBook" varStatus="status">
			<div>
				<label>${EnumTypeBook}</label>
				<form:input path="prices[${status.index}].value" />
				<form:hidden path="prices[${status.index}].type"
					value="${EnumTypeBook}" />
			</div>
		</c:forEach>
		
		<br/><br/>
		
		<div>
			<label>Sumário</label> <input name="sumaryFile" type="file" />
		</div>

		<button type="submit">Cadastrar</button>

	</form:form>
</body>
</html>