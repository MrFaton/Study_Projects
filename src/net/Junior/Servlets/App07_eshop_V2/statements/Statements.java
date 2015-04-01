package net.Junior.Servlets.App07_eshop_V2.statements;

/**
 * Created by Mr_Faton on 27.03.2015.
 */
public interface Statements {
    static final String URI_MAIN_1 = "/productsAll.do";
    static final String URI_MAIN_2 = "/";
    static final String PAGE_MAIN = "productsAll.jsp";
    static final String PAGE_ERROR = "error.jsp";
    static final String ATTRIBUTE_PRODUCTS_LIST = "productsList";
    static final String COOKIE_JSESSIONID = "MY_JSESSIONID";

    //сколько будет жить сессия с момента последнего доступа к ней
    static final Long PARAM_SESSION_EXPIRATION = 2 * 60 * 1000L; // это преобразование 2 мин в миллисекунды
    //если в хранилище нет сессий, то сколько будет спать поток-очиститель сессии, перед тем, как будет проверять сессии в хранилище
    static final Long PARAM_SLEEP_TIME = 30_000L;
}