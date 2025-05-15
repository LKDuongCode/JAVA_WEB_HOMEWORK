package com.duong.ss08.repository.hw02;

import java.util.List;

public interface Hw02_ProductRepo {
    List<String> getAllProduct ();
    boolean addProduct (String product);
}
