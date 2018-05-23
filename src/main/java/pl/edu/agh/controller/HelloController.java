package pl.edu.agh.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.agh.dao.ProductDAO;
import pl.edu.agh.entity.Product;

@RestController
public class HelloController {

    @Autowired
    private ProductDAO productDAO;

    @RequestMapping("/")
    public String index() {
        return "Hello, it is working!";
    }


    @RequestMapping(value="/addProduct")
    @ResponseBody
    public String create() {
        try {
            Product newProduct = new Product();
            newProduct.setName("JakisProdukt");
            newProduct.setPrice(3.50);
            newProduct.setQuantity(10);
            productDAO.addProduct(newProduct);
        }
        catch (Exception ex) {
            return "Error creating the product: " + ex.toString();
        }
        return "Product succesfully created!";
    }


    @RequestMapping(value="/viewProduct")
    @ResponseBody
    public String view() {
        try {
            Product x = productDAO.getProduct();
            return "Product:  " + x.getName();
        }
        catch (Exception ex) {
            return "Error getting the product: " + ex.toString();
        }
    }


}
