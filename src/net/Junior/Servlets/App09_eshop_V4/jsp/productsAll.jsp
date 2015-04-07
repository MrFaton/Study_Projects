<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=utf-8" %>
<html>
<head>
    <title>Интернет магазин продуктов!</title>
    <style>
        body {
            background: url("images/background.jpg");
            background-size: cover;
        }
    </style>
    <link rel="shortcut icon" href="images/favicon.ico"/>
</head>
<body>
<h1 style="text-align: center;">Добро пожаловать в наш интренет магазин продуктов!</h1>
<hr/>
<p/><font size="5">Список наших продуктов:
    <ul>
        <c:forEach var="productFromList" items="${productsList}">
            <li>
                <font size="4"><a href="/product.do?id=${productFromList.id}">${productFromList.name}</a></font>
            </li>
        </c:forEach>
    </ul>
    <hr/>
    <p/><font size="5">Продукуты в корзине
        <c:if test="${basket != null}">
        <c:forEach var="productFromBasket" items="${basket}">
        <li>
            <font size="4"><a href="/product.do?id=${productFromBasket.key.id}">${productFromBasket.key.name}</a> =
                    ${productFromBasket.value} (<a
                        href="/productRemoveFromBasket.do?id=${productFromBasket.key.id}">X</a>)
            </font>
        </li>
        </c:forEach>
        </c:if>
        <c:if test="${basket == null}">
        <br/><font size="4">К сожалению твоя корзина пока пуста :-( Купи что-нибудь у нас :)</font>
        </c:if>
</body>
</html>