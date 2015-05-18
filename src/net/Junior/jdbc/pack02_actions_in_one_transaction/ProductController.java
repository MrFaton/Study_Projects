package net.Junior.jdbc.pack02_actions_in_one_transaction;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.Callable;

/**
 * Created by Mr_Faton on 18.05.2015.
 */
public class ProductController extends HttpServlet {
    @Inject("productDAO")
    ProductDAO productDAO;

    @Inject("txManager")
    TransactionManager txManager;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            final int id = 1;
            Callable<Product> unitOfWork = new Callable<Product>() {
                @Override
                public Product call() throws Exception {
                    return productDAO.selectByID(id);
                }
            };
            Product model = txManager.doInTransaction(unitOfWork);
        } catch (Exception ex) {
            /*NOP*/
        }
    }
}
