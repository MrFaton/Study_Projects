package net.Junior.Servlets.App03_eshop_V1.DAO.implementation;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import net.Junior.Servlets.App03_eshop_V1.DAO.ProductDAO;
import net.Junior.Servlets.App03_eshop_V1.DAO.exceptions.DaoSystemException;
import net.Junior.Servlets.App03_eshop_V1.DAO.exceptions.NoSuchEntityException;
import net.Junior.Servlets.App03_eshop_V1.Entity.Product;

/**
 * Created by root on 16.03.2015.
 */
public class ProductDaoImpl implements ProductDAO {
    //объявляем мапу в которой будут храниться продукты
    private Map<Integer, Product> memory;

    public ProductDaoImpl() {
        //реализовываем потоко-защищённую мапу с продуктами
        memory = new ConcurrentHashMap<>();
        memory.put(1, new Product(1, "Хлеб", 2.35));
        memory.put(2, new Product(2, "Масло", 5.82));
        memory.put(3, new Product(3, "Сыр", 6.14));
    }

    //возвращаем продукт если он есть, если нет, то кидаем исключение
    public Product selectById (Integer id) throws NoSuchEntityException, DaoSystemException{
        if (memory.containsKey(id)) {
            return memory.get(id);
        } else {
            throw new NoSuchEntityException("такого товара нет");
        }
    }
}
/*
Реализация интерфейса ProductDAO. Это наша БД, в которой содержатся все продукты
 */