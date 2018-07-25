<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Adventure In Spring</title>
</head>
<body>
    <h1>Lista de Produtos</h1>
    <table>
        <tr>
            <td>Título</td>
            <td>Descrição</td>
            <td>Páginas</td>
        </tr>
        <c:forEach items="${products}" var="products">
            <tr>
                <td>${products.title}</td>
                <td>${products.description}</td>
                <td>${products.pages}</td>
            </tr>
        </c:forEach>
    </table>
     <br/><br/><b>${success}</b>
</body>
</html>