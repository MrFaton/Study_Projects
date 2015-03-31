package net.Junior.Servlets.App07_eshop_V2.statements;

/**
 * Created by Mr_Faton on 27.03.2015.
 */
public interface Statements {
    static final String URI_MAIN_1 = "/productsAll.do";
    static final String URI_MAIN_2 = "/";
    static final String PAGE_MAIN = "productsAll.jsp";
    static final String PAGE_PRODUCT = "product.jsp";
    static final String PAGE_ERROR = "error.jsp";
    static final String ATTRIBUTE_PRODUCTS_LIST = "productsList";
    static final String ATTRIBUTE_PRODUCT = "product";
    static final String PARAM_ID = "id";
    static final String COOKIE_JSESSIONID = "JSESSIONID";

    static final Long PARAM_SESSION_EXPIRATION = 2 * 60 * 1000L; // это преобразование 10 минт в миллисекунды
}