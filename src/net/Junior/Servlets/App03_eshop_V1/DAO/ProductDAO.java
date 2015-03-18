package net.Junior.Servlets.App03_eshop_V1.DAO;

import net.Junior.Servlets.App03_eshop_V1.DAO.exceptions.DaoSystemException;
import net.Junior.Servlets.App03_eshop_V1.DAO.exceptions.NoSuchEntityException;
import net.Junior.Servlets.App03_eshop_V1.Entity.Product;

/**
 * Created by root on 16.03.2015.
 */
public interface ProductDAO {
    //возвращает продукт из базы по его id
    public Product selectById(Integer id) throws NoSuchEntityException, DaoSystemException;
}
/*
Как бы наша база данных продуктов.
 */