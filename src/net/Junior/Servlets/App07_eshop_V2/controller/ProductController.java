package net.Junior.Servlets.App07_eshop_V2.controller;

import net.Junior.Servlets.App07_eshop_V2.dao.implementation.ProductDAOImpl;
import net.Junior.Servlets.App07_eshop_V2.dao.ProductDAO;
import net.Junior.Servlets.App07_eshop_V2.statements.Statements;
import net.Junior.Servlets.App07_eshop_V2.entity.Product;
import net.Junior.Servlets.App07_eshop_V2.dao.exceptions.NoSuchEntityException;
import net.Junior.Servlets.App07_eshop_V2.dao.exceptions.DAOSystemException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by root on 28.03.2015.
 */
public class ProductController extends HttpServlet {
    private ProductDAO productDAO = new ProductDAOImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Integer id = Integer.valueOf(request.getParameter(Statements.PARAM_ID));
            Product product = productDAO.selectById(id);
            request.setAttribute(Statements.ATTRIBUTE_PRODUCT, product);
            request.getRequestDispatcher(Statements.PAGE_PRODUCT).forward(request, response);
        } catch (NumberFormatException | NoSuchEntityException | DAOSystemException ex) {
            response.sendRedirect(Statements.PAGE_ERROR);
        }
    }
}
