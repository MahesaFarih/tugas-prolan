package id.ac.ui.cs.advprog.tugasprolan.service;

import id.ac.ui.cs.advprog.tugasprolan.model.Product;

import java.util.List;

public interface ProductService {
    public Product create(Product product);
    public List<Product> findAll();
    public Product findProductByName(String name);
    public Product editProduct(String name, Product editedProduct);
    public Product deleteProduct(String name);
}
