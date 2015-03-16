<%@ page contentType="text/html;charset=utf-8" %>
<%--так можно импортировать класс--%>
<%--<%@ page import="net.Junior.Servlets.App03_eshop_V1.Entity.Product" %>--%>
<html>
<head>
    <title>Продукт ${product.name}</title>
    <style>
        /*body {background: linear-gradient(transparent 50%, rgba(0,186,0,0.2) 50%),*/
        /*linear-gradient(90deg, rgba(0,186,0,0.2) 50%, transparent 50%);*/
        /*background-size: 40px 40px;}*/
        body {
            background: url(images/background.jpg);
            background-size: cover
        }
    </style>
</head>
<body>
<h1 style="text-align: center;">Продукт: ${product.name}</h1>
<br/>Характеристики:
<p/>Название: ${product.name}
<p/>Цена: ${product.price}
<p/>ID: ${product.id}

<br/><a href="/main.do">На главную</a>
</body>
</html>