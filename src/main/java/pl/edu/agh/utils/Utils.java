package pl.edu.agh.utils;

import pl.edu.agh.model.ShoppingCart;

import javax.servlet.http.HttpServletRequest;

public class Utils {

    private final static String cartAttribute = "shoppingCart";

    public static ShoppingCart getCartInSession(HttpServletRequest request) {

        ShoppingCart shoppingCart = (ShoppingCart) request.getSession().getAttribute(cartAttribute);

        if (shoppingCart == null) {
            shoppingCart = new ShoppingCart();
            request.getSession().setAttribute(cartAttribute, shoppingCart);
        }

        return shoppingCart;
    }

    public static void removeCartInSession(HttpServletRequest request) {
        request.getSession().removeAttribute(cartAttribute);
    }

    public static void storeLastOrderedCartInSession(HttpServletRequest request, ShoppingCart shoppingCart) {
        request.getSession().setAttribute("lastOrderedCart", shoppingCart);
    }

    public static ShoppingCart getLastOrderedCartInSession(HttpServletRequest request) {
        return (ShoppingCart) request.getSession().getAttribute("lastOrderedCart");
    }

}
