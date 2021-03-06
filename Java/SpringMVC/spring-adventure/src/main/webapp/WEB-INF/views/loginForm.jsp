<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Livros de Java, Android, iPhone, Ruby, PHP e muito mais - Casa do Código</title>
    <c:url value="/resources/css" var="cssPath" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <style type="text/css">
        body {
            padding: 60px 0px;
        }
    </style>
  
</head>
<body>

  <div class="container"><a style="margin-left: 50%; font-size: 35px;" class="navbar-brand" href="${s:mvcUrl('HC#home').build()}">	HOME </a></div>	
    <div class="container">
        <h1 style="margin-bottom: 3%;">Login</h1>	
        <form:form servletRelativeAction="/login" method="POST">
            <div class="form-group">
                <label>E-mail</label>
                <input type="text" name="username" 
                    class="form-control" />
            </div>
            <div class="form-group">
                <label>Senha</label>
                <input type="password" name="password" 
                    class="form-control" />
            </div>
            <button type="submit" class="btn btn-primary">
                Logar
            </button>
        </form:form>

		<div>
			<h2>${success}</h2>
		</div>
		<div>
			<h2>${fail}</h2>
		</div>
	</div>
</body>
</html>
