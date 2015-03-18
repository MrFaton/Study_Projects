<html>
    <body>
        <b/>Attributes test page
        <hr/>

        <!--если бы test-attr бы определён на странице, то взяли бы его, т.к. его нет, возьмут у request-->
        <br/>Value of testAttr = ${testAttr}
        <hr/>

        <!--Как работать с классами, которые были вложины в атрибуты-->
        <br/>requestAttribute, Get a string = ${requestAttribute.str}
        <br/>requestAttribute, Get a string from array of strings = ${requestAttribute.arrayStr[1]}
        <br/>requestAttribute, Get an item from a list = ${requestAttribute.list[2]}
        <br/>requestAttribute, Get an item from map = ${requestAttribute.map['key--0']}
        <!--Как получить поле другой сущньсти-->
        <br/>requestAttribute, Get a string field from BeanBB = ${requestAttribute.mockBeanBB.text}
        <hr/>

        <br/>sessionAttribute, Get a string = ${sessionAttribute.str}
        <br/>sessionAttribute, Get a string from array of strings = ${sessionAttribute.arrayStr[1]}
        <br/>sessionAttribute, Get an item from a list = ${sessionAttribute.list[2]}
        <br/>sessionAttribute, Get an item from map = ${sessionAttribute.map['key--0']}
        <!--Как получить поле другой сущньсти-->
        <br/>sessionAttribute, Get a string field from BeanBB = ${sessionAttribute.mockBeanBB.text}
        <hr/>

        <br/>servletContextAttribute, Get a string = ${servletContextAttribute.str}
        <br/>servletContextAttribute, Get a string from array of strings = ${servletContextAttribute.arrayStr[1]}
        <br/>servletContextAttribute, Get an item from a list = ${servletContextAttribute.list[2]}
        <br/>servletContextAttribute, Get an item from map = ${servletContextAttribute.map['key--0']}
        <!--Как получить поле другой сущньсти-->
        <br/>servletContextAttribute, Get a string field from BeanBB = ${servletContextAttribute.mockBeanBB.text}
        <hr/>
        <hr/>

        <!--Немного другой способ получения данных полей-->
        <jsp:useBean id="myBean" scope="page" class="net.Junior.Servlets.App04_AttributesScopesOrder_V1.Bean.MockBeanAA"></jsp:useBean>
        <br/>Another way to get a field, first elem from a list = ${myBean.list[0]}
        <hr/>

        <br/>(myBean.list[0] gt -1) and (myBean.list[2] lt 1000) = ${(myBean.list[0] gt -1) and (myBean.list[2] lt 1000)}


    </body>
</html>
<%--
Если определить настранице "test-attr = 4" , то выведитися "test-attr = 4"
gt = greate или просто знак ">"
lt = less или просто знак "<"
--%>