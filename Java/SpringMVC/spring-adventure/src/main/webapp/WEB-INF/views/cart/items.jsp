<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>


<c:url value="/" var="contextPath" />

<tags:pageTemplate titulo="GitHub: @matheusicaro">

	<jsp:attribute name="extraScripts">
   <script>
				console.log("Finalização de compra de ${shoppingCart.quantities} itens");
			</script>
</jsp:attribute>

	<jsp:body>
	<section class="container middle">
		<h2 id="cart-title">Seu carrinho de compras</h2>
		<table id="cart-table">
			<colgroup>
				<col class="item-col" />
				<col class="item-price-col" />
				<col class="item-quantity-col" />
				<col class="line-price-col" />
				<col class="delete-col" />
			</colgroup>
			<thead>
				<tr>
					<th class="cart-img-col"></th>
					<th width="65%">Item</th>
					<th width="10%">Preço</th>
					<th width="10%">Quantidade</th>
					<th width="10%">Total</th>
					<th width="5%"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${shoppingCart.items }" var="item">
					<tr>
						<td class="cart-img-col"><img
								src="http://cdn.shopify.com/s/files/1/0155/7645/products/css-eficiente-featured_large.png?v=1435245145"
								width="71px" height="100px" /></td>
						<td class="item-title">${item.product.title }</td>
						<td class="numeric-cell">${item.price}</td>
						<td class="quantity-input-cell">
							<input type="number" min="0" id="quantities" name="quantities"
								value="${shoppingCart.getQuantities(item)}" />
							</td>
						<td class="numeric-cell">${shoppingCart.getTotal(item) }</td>
						<td class="remove-item">
							<form:form action="${s:mvcUrl('SCC#remove').arg(0, item.product.id).arg(1, item.typePrice).build() }" method="POST">
								<input type="image"
										src="${contextPath }/resources/imagens/excluir.png"
										alt="Excluir" title="Excluir" />
							</form:form>
						</td>
					</tr>					$
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="3">
						<form:form action="${s:mvcUrl('PC#finalizeBuyItem').build()}"
								method="POST">
							<input type="submit" class="checkout" name="checkout"
									value="Finalizar compra" />
						</form:form>
					</td>
					<td class="numeric-cell">${shoppingCart.total }</td>
					<td></td>
				</tr>
			</tfoot>
		</table>

		<h2>Você já conhece os outros livros?</h2>
		<ul id="collection" class="related-books">
			<li class="col-left"><a href="${s:mvcUrl('HC#home').build() }"
					class="block clearfix book-suggest"
					data-book="PL/SQL: Domine a linguagem do banco de dados Oracle">
					<img width="113px" height="160px"
						src="http:////cdn.shopify.com/s/files/1/0155/7645/products/plsql-featured_compact.png?v=1434740236"
						alt="PL/SQL: Domine a linguagem do banco de dados Oracle" />
			</a></li>
		</ul>

		<h2>
			<a href="${s:mvcUrl('HC#home').build() }">Veja todos os livros que publicamos!</a>
		</h2>
	</section>
</jsp:body>

</tags:pageTemplate>