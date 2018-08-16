<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<tags:pageTemplate titulo="GitHub: @matheusicaro">

	<section id="index-section" class="container middle">
		<h1 class="cdc-call"><fmt:message key="menu.text.products" /></h1>

		<ul class="clearfix book-collection">

			<c:forEach items="${products }" var="product">
				<li>
					<a	href="${s:mvcUrl('PC#productsDetails').arg(0, product.id).build() }" class="block clearfix">
						<h2 class="product-title">${product.title}</h2> 
						<img width="143" height="202" src="https://i.ytimg.com/vi/geKQQIJA98g/hqdefault.jpg"
						alt="Java 8 Prático" title="Java 8 Prático" /> <small	
						class="buy-button">Compre</small>
				</a></li>
			</c:forEach>

		</ul>

		<h2 class="cdc-call"><fmt:message key="menu.text.readme" /></h2>

		<h3><fmt:message key="menu.text.contend1.readme" /><a style="color: #F07D22; font-size: 24px; font-family: inherit; font-weight: bold;" href="https://github.com/matheusicaro/courses/tree/master/Java/SpringMVC"> Link</a>.</h3>
		<h3><fmt:message key="menu.text.contend2.readme" /></h3>
		<h3><fmt:message key="menu.text.contend3.readme" /></h3>
		<h3><fmt:message key="menu.text.contend4.readme" /></h3>
		
		
		
		<a	style="font-size: 30.5px; text-align: center; margin-bottom: 2%; text-decoration: blink; color: #F07D22;"
			href="${s:mvcUrl('RC#register').build() }" class="block clearfix">
		
			<fmt:message key="menu.text.click.readme" />	
		</a>
		

	</section>
</tags:pageTemplate>


