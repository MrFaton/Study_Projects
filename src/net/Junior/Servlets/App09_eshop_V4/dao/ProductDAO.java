package net.Junior.Servlets.App09_eshop_V4.dao;

import net.Junior.Servlets.App09_eshop_V4.entity.Product;
import net.Junior.Servlets.App09_eshop_V4.dao.exceptions.DAOSystemException;
import net.Junior.Servlets.App09_eshop_V4.dao.exceptions.NoSuchEntityException;

import java.util.List;

/**
 * Created by Mr_Faton on 27.03.2015.
 */
public interface ProductDAO {
    public Product selectById(int id) throws DAOSystemException, NoSuchEntityException;

    public List<Product> selectAll() throws DAOSystemException;
}
/*
интерфейс к нашей как бы базе данных
 */