package net.Junior.Servlets.App07_eshop_V2.dao.implementation;

import net.Junior.Servlets.App07_eshop_V2.dao.ProductDAO;
import net.Junior.Servlets.App07_eshop_V2.dao.exceptions.DAOSystemException;
import net.Junior.Servlets.App07_eshop_V2.dao.exceptions.NoSuchEntityException;
import net.Junior.Servlets.App07_eshop_V2.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Mr_Faton on 27.03.2015.
 */
public class ProductDAOImpl implements ProductDAO {
    private final Map<Integer, Product> memory;

    public ProductDAOImpl() {
        this.memory = new ConcurrentHashMap<>();

        memory.put(1, new Product(1, "Хлеб", "2,50"));
        memory.put(2, new Product(2, "Масло", "4,80"));
        memory.put(3, new Product(3, "Сыр", "5,90"));
    }

    @Override
    public Product selectById(int id) throws DAOSystemException, NoSuchEntityException {
        if (memory.containsKey(id)) {
            return memory.get(id);
        } else {
            throw new NoSuchEntityException("Товара с таким id нет");
        }
    }

    @Override
    public List<Product> selectAll() throws DAOSystemException {
        ArrayList<Product> products = new ArrayList<>(memory.size());
        for (Map.Entry<Integer, Product> product : memory.entrySet()) {
            products.add(product.getValue());
        }
        return products;
    }
}
