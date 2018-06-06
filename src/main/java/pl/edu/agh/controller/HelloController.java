package pl.edu.agh.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.edu.agh.dao.ProductDAO;
import pl.edu.agh.entity.Product;

import java.security.Principal;
import java.util.List;

@RestController
public class HelloController {

    @Autowired
    private ProductDAO productDAO;

    @RequestMapping("/")
    public String index() {
        return "Hello, it is working!";
    }


    @RequestMapping(value="/addProduct/{name}/{price}/{quantity}")
    @ResponseBody
    public String create(@PathVariable String name,
                         @PathVariable double price,
                         @PathVariable int quantity) {
        try {
            Product newProduct = new Product();
            newProduct.setName(name);
            newProduct.setPrice(price);
            newProduct.setQuantity(quantity);
            productDAO.addProduct(newProduct);
        }
        catch (Exception ex) {
            return "Error creating the product: " + ex.toString();
        }
        return "Product succesfully created!";
    }


    @RequestMapping(value="/viewProduct/{productID}")
    @ResponseBody
    public ModelAndView view(@PathVariable int productID) {
        Product x = productDAO.getProduct(productID);
        ModelAndView modelAndView = new ModelAndView("/productList");
        modelAndView.addObject("name", x.getName());
        modelAndView.addObject("price", x.getPrice());
        modelAndView.addObject("quantity", x.getQuantity());

        return modelAndView;

    }


    @RequestMapping("/products")
    @ResponseBody
    public ModelAndView productList() {
        List<Product> products = productDAO.getAllProducts();

        ModelAndView modelAndView = new ModelAndView("/productList");
        modelAndView.addObject("products", products);

        return modelAndView;
    }


    @RequestMapping(value = "/test", method = RequestMethod.GET)
    String index(Principal principal) {
        return principal != null ? "/homeSignedIn" : "/homeNotSignedIn";
    }




}
