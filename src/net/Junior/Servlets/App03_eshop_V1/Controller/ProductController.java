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
    //Тут содержатся все наши продукты (каждому id соответсвтует продукт). Своего рода БД продуктов
    private ProductDAO productDAO = new ProductDaoImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //получаем парамет "id"
        String idStr = request.getParameter(Statements.PARAM_ID);
        if (idStr != null) {
            //Если "id" есть в ЮРЛ (http://localhost:8080/product.do?id=2)
            try {
                //приводим id из строки к числу
                Integer id = Integer.valueOf(idStr);
                //goods - продукт (товар), получаем из БД продукт по id
                Product goods = productDAO.selectById(id);
                //ложим наш продукт в атрибут запроса по имени "Statements.ATTRIBUTE_TO_VIEW = product"
                request.setAttribute(Statements.ATTRIBUTE_TO_VIEW, goods);
                /*
                если мы уже дошли сюда, занчит никаких исключений не было и мы предаём внуттрений редирект
                на стр с продуктом
                 */
                request.getRequestDispatcher(Statements.PAGE_OK).forward(request, response);
            } catch (NumberFormatException | DaoSystemException | NoSuchEntityException ex) {
                //если что-то было не так, выбрасываем клиента через внешний редирект на страницу ошибки
                response.sendRedirect(Statements.PAGE_ERROR);
            }
        }
    }
}
