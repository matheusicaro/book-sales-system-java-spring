<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<c:url value="/" var="contextPath" />

<tags:pageTemplate titulo="${products.title }">

	<article id="livro-css-eficiente">
		<header id="products-highlight" class="clearfix">
			<div id="products-overview" class="container">
				<img width="280px" height="395px" src="https://i.ytimg.com/vi/geKQQIJA98g/hqdefault.jpg"
					class="products-featured-image" />
				<h1 class="products-title">Titulo do Livro: <strong>${products.title }</strong></h1>
				<p class="products-author">
					<span class="products-author-link"> </span>
				</p>
				<p class="book-description">Descrição do Livro: <strong>${products.description }</strong></p>
			</div>
		</header>

		<section class="buy-options clearfix">
			<form:form action="${contextPath }shopping-cart/add" method="post" class="container">
				<input type="hidden" value="${products.id }" name="productId" >
				<ul id="variants" class="clearfix">
					<c:forEach items="${products.prices}" var="prices">
						<li class="buy-option">
						
							<input type="radio" name="typePrice" class="variant-radio" id="typePrice" value="${prices.type}" checked="checked" /> 
							<label class="variant-label" >${prices.type }</label> 
							<small class="compare-at-price">R$ ${( prices.value + 10 )}</small>
							<p class="variant-price">${prices.value }</p>
						</li>
					</c:forEach>
				</ul>
				<button type="submit" class="submit-image icon-basket-alt" title="Compre Agora ${products.title }"></button>
				</form:form>
		</section>

		<div class="container">
			<section class="summary">
				<ul>
					<li>
						<h3>E muito mais... <a href='/pages/sumario-java8'>veja o sumário</a>.</h3>
					</li>
				</ul>
			</section>

			<section class="data products-detail">
				<h2 class="section-title">Dados do livro:</h2>
				<p>
					Número de páginas: <span>${products.pages}</span>
				</p>
				<p>
				   Data de publicação: <fmt:formatDate pattern="dd/MM/yyyy" value="${products.dateLaunch.time}"/>
            	</p>
				<p>
					Encontrou um erro? <a href='/submissao-errata' target='_blank'>Submeta uma errata</a>
				</p>
			</section>
		</div>
	</article>
	
</tags:pageTemplate>