package pl.edu.agh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.edu.agh.dao.ProductDAO;
import pl.edu.agh.entity.Product;
import pl.edu.agh.model.ProductData;
import pl.edu.agh.model.ShoppingCart;
import pl.edu.agh.utils.Utils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
//@RestController
public class MainController {

    @Autowired
    private ProductDAO productDAO;

    @RequestMapping("/")
    public String index() {
        return "redirect:/products";
    }


    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/user")
    public String userIndex() {
        return "user/index";
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


    @ResponseBody
    @RequestMapping("/cart")
    public ModelAndView shoppingCart(){//@RequestBody String payload) {
        //HttpServletRequest request,
        //@ModelAttribute("shopCart")ShoppingCart shoppingCart

        //System.out.println(payload);

        List<Product> products = productDAO.getAllProducts();

        ModelAndView modelAndView = new ModelAndView("/shoppingCart");
        modelAndView.addObject("products", products);

        return modelAndView;
    }


    @ResponseBody
    @RequestMapping("/buyProduct")
    public String buyProduct(HttpServletRequest request,
                                   @RequestParam(value = "prodid", defaultValue = "")String productId){
        System.out.println("buy product!");

        if(productId != null && productId.length() > 0){
            Product product = productDAO.getProduct(Integer.parseInt(productId));

            if(product != null)
                Utils.getCartInSession(request).addProduct(new ProductData(product));
        }
        return "redirect:/cart";
    }


}
