package id.ac.ui.cs.advprog.tugasprolan.repository;

import id.ac.ui.cs.advprog.tugasprolan.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> productData = new ArrayList<>();
    public Product create(Product product){
        productData.add(product);
        return product;
    }

    public Product editProduct(String name, Product newProduct) {
        Product product = findProductByName(name);
        product.setProductName(newProduct.getProductName());
        product.setProductQuantity(newProduct.getProductQuantity());
        product.setProductId(newProduct.getProductId());
        return product;
    }

    public Product findProductByName(String name) {
        for (Product product : productData) {
            if (product.getProductName().equals(name)) {
                return product;
            }
        }
        return null;
    }

    public  Iterator<Product> findAll() {
        return productData.iterator();
    }

}
