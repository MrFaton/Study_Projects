<%@ page contentType="text/html;charset=utf-8" %>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Продукт: ${product.name}</title>
    <style>
        body {
            background: url(images/background.jpg);
            background-size: cover
        }
    </style>
    <link rel="shortcut icon" href="images/favicon.ico"/>
</head>
<body>
<h1 style="text-align: center;">Продукт: ${product.name}</h1>
<hr/>
<p><font size="5">Описание:</font></p>
<br/><font size="4">ID: ${product.id}</font>
<br/><font size="4">Название: ${product.name}</font>
<br/><font size="4">Цена: ${product.price}</font>

<p/><font size="4"><a href="/productsAll.do">На главную</a></font>

<p/><font size="4"><a href="/productAddToBasket.do?id=${product.id}">Добавить продукт в корзину!</a></font>
<hr/>

<p/><font size="5">Продукуты в корзине</font>
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