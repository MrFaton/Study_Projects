<%@ page contentType="text/html;charset=utf-8" %>
<%--так можно импортировать класс--%>
<%--<%@ page import="net.Junior.Servlets.App03_eshop_V1.Entity.Product" %>--%>
<html>
<head>
    <title>Продукт ${product.name}</title>
    <style>
        <%--body {background: linear-gradient(transparent 50%, rgba(0,186,0,0.2) 50%),
        linear-gradient(90deg, rgba(0,186,0,0.2) 50%, transparent 50%);
        background-size: 40px 40px;}--%>
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
<%--
${product.name} - так называемый Expressive language. Он как-то посвоему разварачивает это. Дело в том, что он
вынимает из атрибутов атрибут и именем "product" (который мы положили в атрибуты в сервлете ProductController:
request.setAttribute(Statements.ATTRIBUTE_TO_VIEW, goods);), который содержит объект класса (бин) Product где и
хранятся все данные о продукте. Как мы видим из ${product.name} мы как бы у нашего объектра класса Product берём
поле, но это не так, хотя бы потому, что у нашего класса Product все поля приватные! Дело в том, что вот это
${product.name} это Expressive language и он как-то разворачивается и использует геттеры и получает данные полей.

Точно такой код вместо ${product.name} можно было написать на джаве следующее:
сначала импортировать класс продукт:
<%@ page import="net.Junior.Servlets.App03_eshop_V1.Entity.Product" %>
потом сделать вызов:
<p/>Название: <%=((Product)request.getAttribute("product")).getName()%>

Т.е. в такой записи ${product.name} мы как бы указываем: имя атрибути.поле атрибута

Такое прокатывает только с внутернним редиректом! request.getRequestDispatcher(bla-bla.jsp).forvard()
или вместо forvard() = include(), т.к. тут передаётся одни и таже пара request/responce.
Со внешним редиректом такое не прокатит! responce.sendRedirect(). Смотри конспект почему.
--%>