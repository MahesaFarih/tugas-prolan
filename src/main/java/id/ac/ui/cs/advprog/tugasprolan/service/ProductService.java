package id.ac.ui.cs.advprog.prolan.service;
import id.ac.ui.cs.advprog.prolan.model.Product;
import java.util.List;

public interface ProductService {
    public Product create(Product product);
    public List<Product> findAll();
}
