package net.Junior.jdbc.pack02_actions_in_one_transaction;

import java.util.List;

/**
 * Created by Mr_Faton on 18.05.2015.
 */
public interface ProductDAO {
    public Product selectByID(int id);

    public List<Product> selectAll();
}
