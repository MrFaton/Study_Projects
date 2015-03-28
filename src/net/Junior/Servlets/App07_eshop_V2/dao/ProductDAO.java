package net.Junior.Servlets.App07_eshop_V2.dao;

import net.Junior.Servlets.App07_eshop_V2.dao.exceptions.DAOSystemException;
import net.Junior.Servlets.App07_eshop_V2.dao.exceptions.NoSuchEntityException;
import net.Junior.Servlets.App07_eshop_V2.entity.Product;

import java.util.List;

/**
 * Created by Mr_Faton on 27.03.2015.
 */
public interface ProductDAO {
    //возвращает продукт по id
    public Product selectById(int id) throws DAOSystemException, NoSuchEntityException;
    //возвращает список всех продуктов из БД
    public List<Product> selectAll() throws DAOSystemException;
}
