package com.duong.ss06.service.hw03;

import com.duong.ss06.dao.hw03.ProductCartDao;
import com.duong.ss06.dao.hw03.ProductCartDaoImpl;
import com.duong.ss06.model.ProductCart;

import java.util.List;

public class ProductCartServiceImpl implements ProductCartService {
    private final ProductCartDao productCartDao = new ProductCartDaoImpl();

    @Override
    public List<ProductCart> getCartByUserId(int userId) {
        return productCartDao.getCartByUserId(userId);
    }

    @Override
    public boolean addToCart(ProductCart cartItem) {
        return productCartDao.addToCart(cartItem);
    }

    @Override
    public boolean removeFromCart(int cartId) {
        return productCartDao.removeFromCart(cartId);
    }
}
