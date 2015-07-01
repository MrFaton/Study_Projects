package net.mr_faton.Test;

/**
 * Created by Mr_Faton on 25.05.2015.
 */
public interface GlobalConstants {
    String PAGE_STATISTIC = "/WEB-INF/pages/statistic.jsp";
    String PAGE_SETTINGS = "/WEB-INF/pages/settings.jsp";
    String PAGE_ERROR = "/WEB-INF/pages/error.jsp";
    String ATTR_TITLE = "title";
    String ATTR_TEXT = "text";
    String ATTR_ROW_LIST = "rowList";
    String ATTR_TWITTER_MODULE = "TwitterModule";
    String ATTR_MODULE_MANAGER = "ModuleManager";
    String CONTROLLER_PARAM_ID = "id";
    String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/tweagle?user=Mr_Faton&password=123";//DB at home
    //        String JDBC_URL = "jdbc:mysql://127.0.0.1:3305/tweagle?user=Mr_Faton&password=123";//DB at my work
    String CONTEXT_PARAM_APP_CONF = "ApplicationConfigLocation";//имя параметра в web.xml
    String URL_SETTINGS = "/settings.do";
    String DB_NAME = "tweagle";
    String TABLE_TWITTER_USERS = "tweagle.twitter_users";
    String TABlE_TWITTER_MESSAGES = "tweagle.twitter_messages";
    String TABlE_TWITTER_MESSAGES_N = "twitter_messages";
    String TABLE_TWITTER_POSTED_MESSAGES = "tweagle.twitter_posted_messages";
    String TABLE_TWITTER_DONORS = "tweagle.twitter_donors";

    String FILE_TURN_OFF_DAY = "TurnOffDay.ser";

    int TIME_START_HOUR = 6;
    int TIME_STOP_HOUR = 22;
}