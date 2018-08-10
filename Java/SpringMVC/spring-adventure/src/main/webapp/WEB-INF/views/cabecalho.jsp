<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:url value="/" var="contextPath" />

<header id="layout-header">

	<div class="clearfix container">
		<div id="header-content">
			<nav id="main-nav">
				<ul class="nav navbar-nav navbar-left">
					<security:authorize access="hasRole('ROLE_ADMIN')">
						<li><a href="${s:mvcUrl('PC#productsList').build() }"
							rel="nofollow"><fmt:message key="menu.lista_produtos" /></a></li>
						<li><a href="${s:mvcUrl('PC#form').build() }" rel="nofollow"><fmt:message
									key="menu.cadastro_produtos" /></a></li>
					</security:authorize>
					<li><a href="${s:mvcUrl('SCC#items').build() }" rel="nofollow"><s:message
								code="menu.carrinho" arguments="${shoppingCart.quantities }" /></a></li>
					<li><a href="/pages/sobre-a-casa-do-codigo" rel="nofollow"><fmt:message
								key="menu.sobre" /></a></li>
					<li><a href="<c:url value="/logout" />">Sair</a></li>
					<li><a href="?locale=pt" rel="nofollow"> <fmt:message
								key="menu.pt" />
					</a></li>

					<li><a href="?locale=en_UR" rel="nofollow"> <fmt:message
								key="menu.en" />
					</a></li>
					<security:authorize access="isAuthenticated()">
						<li><a href="<c:url value="/logout" />">Sair</a></li>
					</security:authorize>

				</ul>
			</nav>
		</div>
	</div>
	<div style="text-align: right;">
		<security:authorize access="isAuthenticated()">
			<security:authentication property="principal" var="usuario" />${user.username }
			</security:authorize>
	</div>
</header>

<nav class="categories-nav">
	<ul class="container">
		<li class="category"><a href="/collections/livros-de-agile">
				Agile </a></li>
		<li class="category"><a href="/collections/livros-de-front-end">
				Front End </a></li>
		<li class="category"><a href="/collections/livros-de-games">
				Games </a></li>
		<li class="category"><a href="/collections/livros-de-java">
				Java </a></li>
		<li class="category"><a href="/collections/livros-de-mobile">
				Mobile </a></li>
		<li class="category"><a
			href="/collections/livros-desenvolvimento-web"> Web </a></li>
		<li class="category"><a href="/collections/outros"> Outros </a></li>
	</ul>
</nav>