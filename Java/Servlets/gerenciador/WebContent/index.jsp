<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
Bem vindo ao nosso gerenciador de empresas!<br/>

<c:if test="${userLogged!=null}">
    <b>Voce esta logado como ${userLogged.email}</b></b><br/><br/>
</c:if>


<form action="Controller?task=NewCompany" method="post">
    Nome: <input type="text" name="name" /><br />
    <input type="submit" value="Send" />
</form>
<br />
<br />
<form action="Controller?task=Login" method="post">
    Usuario: <input type="text" name="user" /><br />
    Senha: <input type="text" name="password" /><br />
    <input type="submit" value="login" />
</form>
<form action="Controller?task=Logout" method="post">
    <input type="submit" value="Logout" />
</form>
</body>
</html>