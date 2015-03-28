<%@ page contentType="text/html;charset=utf-8" %>
<html>
<head>
    <title>${product.name}</title>
    <style>
        body {
            background: url("images/background.jpg");
            background: cover;
        }
    </style>
</head>
<body>
<h1 style="text-align: center;">Продукт: ${product.name}</h1>
<br/>Описание:
<p/>Название: ${product.name}
<p/>Цена: ${product.price}
<p/>ID: ${product.id}
<hr/>
<a href="/productsAll.do">На главную</a>
</body>
</html>