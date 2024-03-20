package id.ac.ui.cs.advprog.tugasprolan.service;

import id.ac.ui.cs.advprog.tugasprolan.model.Product;

import java.util.List;

public interface ProductService {
    public Product create(Product product);
    public List<Product> findAll();
}
