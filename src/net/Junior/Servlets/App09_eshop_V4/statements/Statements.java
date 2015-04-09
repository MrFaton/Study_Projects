package net.Junior.Servlets.App09_eshop_V4.statements;

/**
 * Created by Mr_Faton on 27.03.2015.
 */
public interface Statements {
    static final String URI_MAIN_1 = "/productsAll.do";
    static final String URI_MAIN_2 = "/";
    static final String URI_PRODUCT = "/product.do?id=";
    static final String PAGE_MAIN = "productsAll.jsp";
    static final String PAGE_PRODUCT = "product.jsp";
    static final String PAGE_ERROR = "error.jsp";
    static final String ATTRIBUTE_PRODUCTS_LIST = "productsList";
    static final String ATTRIBUTE_PRODUCT_TO_VIEW = "product";
    static final String ATTRIBUTE_BASKET = "basket";
    static final String COOKIE_MY_SESSION = "MY_SESSION";
    static final int COOKIE_LIFETIME = 10 * 60;
    static final String PARAM_ID = "id";
}