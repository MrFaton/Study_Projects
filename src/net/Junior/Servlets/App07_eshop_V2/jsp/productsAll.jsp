<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=utf-8" %>
<html>
<head>
    <title>Интернет магазин продуктов!</title>
    <style>
        body {
            background: url("images/background.jpg");
            background: cover;
        }
    </style>
    <link rel="shortcut icon" href="images/favicon.ico"/>
</head>
<body>
<h1 style="text-align: center;">Добро пожаловать в наш интренет магазин продуктов!</h1>
<hr/>
<br/>Список наших продуктов:
<ul>
    <c:forEach var="productFromList" items="${productsList}">
        <li>
            <a href="/product.do?id=${productFromList.id}">${productFromList.name}</a>
        </li>
    </c:forEach>
</ul>
</body>
</html>