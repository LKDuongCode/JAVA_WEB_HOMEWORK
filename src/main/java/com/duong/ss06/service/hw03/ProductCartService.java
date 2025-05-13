package com.duong.ss06.service.hw03;

import com.duong.ss06.model.ProductCart;

import java.util.List;

public interface ProductCartService {
    List<ProductCart> getCartByUserId(int userId);
    boolean addToCart(ProductCart cartItem);
    boolean removeFromCart(int cartId);
}
