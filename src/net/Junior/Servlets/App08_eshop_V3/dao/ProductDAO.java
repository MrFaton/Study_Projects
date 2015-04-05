package net.Junior.Servlets.App08_eshop_V3.dao;

import net.Junior.Servlets.App08_eshop_V3.dao.exceptions.DAOSystemException;
import net.Junior.Servlets.App08_eshop_V3.dao.exceptions.NoSuchEntityException;
import net.Junior.Servlets.App08_eshop_V3.entity.Product;

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