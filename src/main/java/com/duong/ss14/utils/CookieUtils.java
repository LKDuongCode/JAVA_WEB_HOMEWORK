package com.duong.ss14.utils;

import com.duong.ss14.model.ProductItem;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

public class CookieUtils {
    public static List<ProductItem> getProductList(HttpServletRequest request) throws JsonProcessingException, UnsupportedEncodingException {
        Cookie[] cookies = request.getCookies();
        ObjectMapper mapper = new ObjectMapper();

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("productList")) {
                    String json = URLDecoder.decode(c.getValue(), "UTF-8");
                    return mapper.readValue(json, new TypeReference<List<ProductItem>>() {});
                }
            }
        }
        return new ArrayList<>();
    }
}
