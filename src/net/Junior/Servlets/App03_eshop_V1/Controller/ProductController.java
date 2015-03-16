package net.Junior.Servlets.App03_eshop_V1.Controller;

import net.Junior.Servlets.App03_eshop_V1.DAO.ProductDAO;
import net.Junior.Servlets.App03_eshop_V1.DAO.exceptions.DaoSystemException;
import net.Junior.Servlets.App03_eshop_V1.DAO.exceptions.NoSuchEntityException;
import net.Junior.Servlets.App03_eshop_V1.DAO.implementation.ProductDaoImpl;
import net.Junior.Servlets.App03_eshop_V1.Entity.Product;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by root on 16.03.2015.
 */
public class ProductController extends HttpServlet {
    private ProductDAO productDAO = new ProductDaoImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter(Statements.PARAM_ID);
        if (idStr != null) {
            try {
                Integer id = Integer.valueOf(idStr);
                Product goods = productDAO.selectById(id);
                request.setAttribute(Statements.ATTRIBUTE_TO_VIEW, goods);
                //OK
                request.getRequestDispatcher(Statements.PAGE_OK).forward(request, response);
            } catch (NumberFormatException | DaoSystemException | NoSuchEntityException ex) {
                response.sendRedirect(Statements.PAGE_ERROR);
            }
        }
    }
}
