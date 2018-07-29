<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<c:url value="/" var="contextPath" />
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
<link rel="icon" href="//cdn.shopify.com/s/files/1/0155/7645/t/177/assets/favicon.ico?11981592617154272979" type="image/ico" />
<link href="https://plus.googlecom/108540024862647200608" rel="publisher" />

<title>Adventure In Spring - GitHub: @matheusicaro</title>

<link href="${contextPath}resources/css/cssbase-min.css" rel="stylesheet" type="text/css" media="all" />
<link href='http://fonts.googleapis.com/css?family=Droid+Sans:400,700' rel='stylesheet' />
<link href="${contextPath}resources/css/fonts.css" rel="stylesheet" type="text/css" media="all" />
<link href="${contextPath}resources/css/fontello-ie7.css" rel="stylesheet" type="text/css" media="all" />
<link href="${contextPath}resources/css/fontello-embedded.css" rel="stylesheet" type="text/css" media="all" />
<link href="${contextPath}resources/css/fontello.css" rel="stylesheet" type="text/css" media="all" />
<link href="${contextPath}resources/css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href="${contextPath}resources/css/layout-colors.css" rel="stylesheet" type="text/css" media="all" />
<link href="${contextPath}resources/css/responsive-style.css" rel="stylesheet" type="text/css" media="all" />
<link href="${contextPath}resources/css/guia-do-programador-style.css" rel="stylesheet" type="text/css" media="all" />
<link href="${contextPath}resources/css/produtos.css" rel="stylesheet" type="text/css" media="all" />
<link rel="canonical" href="http://www.casadocodigo.com.br/" />
</head>
<body>

	<header id="layout-header">
		<div class="clearfix container">
			<a href="/" id="logo"> </a>
			<div id="header-content">
				<nav id="main-nav">

					<ul class="clearfix">
						<li><a href="/shopping-cart" rel="nofollow">Seu Carrinho (${shoppingCart.quantities})</a></li>
						<li><a href="/pages/sobre-a-casa-do-codigo" rel="nofollow">Sobre Nós</a></li>
						<li><a href="/pages/perguntas-frequentes" rel="nofollow">Perguntas Frequentes</a></li>
					</ul>
				</nav>
			</div>
		</div>
	</header>
	<nav class="categories-nav">
		<ul class="container">
			<li class="category"><a href="http://www.casadocodigo.com.br">Home</a></li>
			<li class="category"><a href="/collections/livros-de-agile"> Agile </a></li>
			<li class="category"><a href="/collections/livros-de-front-end"> Front End </a></li>
			<li class="category"><a href="/collections/livros-de-games"> Games </a></li>
			<li class="category"><a href="/collections/livros-de-java"> Java </a></li>
			<li class="category"><a href="/collections/livros-de-mobile"> Mobile </a></li>
			<li class="category"><a href="/collections/livros-desenvolvimento-web"> Web </a></li>
			<li class="category"><a href="/collections/outros"> Outros </a></li>
		</ul>
	</nav>

	<article id="livro-css-eficiente">
		<header id="products-highlight" class="clearfix">
			<div id="products-overview" class="container">
				<img width="280px" height="395px" src="data:image/jpeg;base64,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"
					class="products-featured-image" />
				<h1 class="products-title">${products.title }</h1>
				<p class="products-author">
					<span class="products-author-link"> </span>
				</p>
				<p class="book-description">${products.description }</p>
			</div>
		</header>prices[${status.index}].value

		<section class="buy-options clearfix">
			<form action='<c:url value="/shopping-cart/add" />' method="post" class="container">
				<input type="hidden" value="${products.id }" name="productId" >
				<ul id="variants" class="clearfix">
					<c:forEach items="${products.prices}" var="prices" varStatus="status">
						<li class="buy-option">
						
							<input type="radio" name="typePrice" class="variant-radio" id="typePrice" value="${prices.type}" checked="checked" /> 
							<label class="variant-label" >${prices.type }</label> 
							<small class="compare-at-price">R$ ${( prices.value + 10 )}</small>
							<p class="variant-price">${prices.value }</p>
						</li>
					</c:forEach>
				</ul>
				<button type="submit" class="submit-image icon-basket-alt" title="Compre Agora ${products.title }"></button>
			</form>
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

	<footer id="layout-footer">
		<div class="clearfix container">

			<div id="collections-footer">
				<!-- cdc-footer -->
				<p class="footer-title">Coleções de Programação</p>
				<ul class="footer-text-links">
					<li><a href="/collections/livros-de-java">Java</a></li>
					<li><a href="/collections/livros-desenvolvimento-web">Desenvolvimento Web</a></li>
					<li><a href="/collections/livros-de-mobile">Mobile</a></li>
					<li><a href="/collections/games">Games</a></li>
					<li><a href="/collections/livros-de-front-end">Front End</a></li>
				</ul>
				<p class="footer-title">Outros Assuntos</p>
				<ul class="footer-text-links">
					<li><a href="/collections/livros-de-agile">Agile</a></li>
					<li><a href="/collections/outros">e outros...</a></li>
				</ul>
			</div>
			<div id="social-footer">
				<!-- books-footer -->
				<p class="footer-title">Links da Casa do Código</p>
				<ul class="footer-text-links">
					<li><a href="http://livros.casadocodigo.com.br" rel="nofollow">Meus E-books</a></li>
					<li><a href="/pages/sobre-a-casa-do-codigo">Sobre a Casa do Código</a></li>
					<li><a href="/pages/perguntas-frequentes">Perguntas Frequentes</a></li>
					<li><a href="https://www.caelum.com.br">Caelum - Ensino e Inovação</a></li>
					<li><a href="http://www.codecrushing.com/" rel="nofollow">Code Crushing</a></li>
					<li><a href="http://www.casadocodigo.com.br/pages/politica-de-privacidade" rel="nofollow">Política de Privacidade</a></li>
				</ul>
				<p class="footer-title">Redes Sociais</p>
				<ul>
					<li class="social-links"><a href="http://www.twitter.com/casadocodigo" target="_blank" id="twitter" rel="nofollow">Facebook</a> <a
						href="http://www.facebook.com/casadocodigo" target="_blank" id="facebook" rel="nofollow">Twitter</a></li>
				</ul>
			</div>
			<div id="newsletter-footer">
				<!-- social-footer -->
				<p class="footer-title">Receba as Novidades e Lançamentos</p>
				<div id="form-newsletter">
					<form action="" method="POST" id="ss-form" class="form-newsletter">
						<ul>
							<li><input type="hidden" name="pageNumber" value="0" /><input type="hidden" name="backupCache" value="" /><input type="email"
								name="entry.0.single" value="" class="ss-q-short" id="entry_0" placeholder="seu@email.com" /></li>
							<li><input type="submit" name="submit" value="Quero Receber!" id="submit-newsletter" /></li>
						</ul>
					</form>
					<ul>
						<li class="ie8"><a href="" rel="nofollow">Receba as Novidades e Lançamentos</a></li>
					</ul>
				</div>
				<ul class="footer-payments">
					<li></li>
					<li></li>
				</ul>
			</div>
		</div>
	</footer>
</body>
</html>