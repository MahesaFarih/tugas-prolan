package id.ac.ui.cs.advprog.tugasprolan.controller;

import id.ac.ui.cs.advprog.tugasprolan.model.Product;
import id.ac.ui.cs.advprog.tugasprolan.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/create")
    public String createProductPage(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "createProduct";
    }

    @PostMapping("/create")
    public String createProductPost(@ModelAttribute Product product, Model model) {
        service.create(product);
        return "redirect:list";
    }

    @GetMapping("/list")
    public String productsListPage(Model model) {
        List<Product> allProducts = service.findAll();
        model.addAttribute("products", allProducts);
        return "productList";
    }

    @GetMapping("/edit/{productName}")
    public String editProductPage(@PathVariable String productName, Model model) {
        Product product = service.findProductByName(productName);
        model.addAttribute("product", product);
        return "EditProduct";
    }

    @GetMapping("/delete/{productName}")
    public String deleteProductPage(@PathVariable String productName, Model model) {
        service.deleteProduct(productName);
        return "redirect:../list";
    }

    @PostMapping("/edit/{productName}")
    public String editProductPost(@PathVariable String productName, Model model, @ModelAttribute Product product) {
        service.editProduct(productName, product);
        return "redirect:../list";
    }

}
