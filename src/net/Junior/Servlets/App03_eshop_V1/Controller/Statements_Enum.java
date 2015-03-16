package net.Junior.Servlets.App03_eshop_V1.Controller;

/**
 * Created by root on 16.03.2015.
 */
public enum Statements_Enum {
    PARAM_ID("id"),
    ATTRIBUTE_TO_VIEW("product"),
    PAGE_MAIN("main.jsp"),
    PAGE_MAIN_URI("main.do"),
    PAGE_OK("product.jsp"),
    PAGE_ERROR("error.jsp");

    private String value;

    private Statements_Enum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
/*
не используется, но можно было использовать как вариант доступа к переменным. Почему не стал использовать: строчка кода:
Statements.ATTRIBUTE_TO_VIEW.getValue - длинная строка
 */