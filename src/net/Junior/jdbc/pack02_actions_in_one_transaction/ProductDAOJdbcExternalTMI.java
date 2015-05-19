package net.Junior.jdbc.pack02_actions_in_one_transaction;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Mr_Faton on 18.05.2015.
 */
public class ProductDAOJdbcExternalTMI implements ProductDAO {
    public static final String JDBC_URL =
            "jdbc:mysql://127.0.0.1:3306/my_test_db?user=Mr_Faton&password=123";//DB at my home

    public static final String SELECT_BY_ID_SQL = "some select query1";
    public static final String SELECT_ALL_SQL = "some select query2";

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Product selectByID(int id) {
        return null;
    }

    @Override
    public List<Product> selectAll() {
        return null;
    }
}
