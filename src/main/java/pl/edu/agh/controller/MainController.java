package pl.edu.agh.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.edu.agh.dao.ProductDAO;
import pl.edu.agh.entity.Product;
import pl.edu.agh.model.ProductData;
import pl.edu.agh.model.ProductOrder;
import pl.edu.agh.model.ShoppingCart;
import pl.edu.agh.utils.Utils;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


@Controller
public class MainController {

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
        return "ProductData succesfully created!";
    }


    @RequestMapping(value="/viewProduct/{productID}")
    @ResponseBody
    public ModelAndView view(@PathVariable int productID) {

        return null;
    }


    @RequestMapping("/products")
    @ResponseBody
    public ModelAndView productList() {
        List<Product> products = productDAO.getAllProducts();

        ModelAndView modelAndView = new ModelAndView("/productList");
        modelAndView.addObject("products", products);

        return modelAndView;
    }


    @RequestMapping("/cart")
    public ModelAndView shoppingCart(HttpServletRequest request) {

        ShoppingCart cart = Utils.getCartInSession(request);

        List<ProductOrder> productOrders = new ArrayList<>();

        if(cart != null)
            for (ProductOrder productOrder : cart.getProductOrders())
                productOrders.add(productOrder);


        ModelAndView modelAndView = new ModelAndView("/shoppingCart");
        modelAndView.addObject("productOrders", productOrders);

        return modelAndView;
    }


    @RequestMapping("/buyProduct")
    public String buyProduct(HttpServletRequest request){

        String productId = request.getParameter("productId");

        if(productId != null && productId.length() > 0){
            Product product = productDAO.getProduct(Integer.parseInt(productId));

            if(product != null)
                Utils.getCartInSession(request).addProduct(new ProductData(product));

        }

        return "redirect:/cart";
    }


    @RequestMapping("/confirmCart")
    public String addOrder(HttpServletRequest request){

        ShoppingCart cart = Utils.getCartInSession(request);

        List<ProductOrder> productOrders = new ArrayList<>();

        if(cart != null)
            for (ProductOrder productOrder : cart.getProductOrders())
                productOrders.add(productOrder);

        return "redirect:/";
    }

}
