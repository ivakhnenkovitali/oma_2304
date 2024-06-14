package by.itclass.controllers.order;

import by.itclass.controllers.AbstractController;
import by.itclass.model.entities.OrderItem;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Objects;

import static by.itclass.constants.AppConst.*;
import static by.itclass.constants.JspConst.*;

@WebServlet(CART_CONTROLLER)
public class CartController extends AbstractController {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var cartAction = req.getParameter(CART_ACTION_PARAM);
        var itemType = Integer.parseInt(req.getParameter(ITEM_TYPE_PARAM));
        var itemId = Integer.parseInt(req.getParameter(ITEM_ID_PARAM));
        var itemVendor = req.getParameter(ITEM_VENDOR_PARAM);
        var itemModel = req.getParameter(ITEM_MODEL_PARAM);

        var itemPriceParam = req.getParameter(ITEM_PRICE_PARAM);
        var itemPrice = Objects.nonNull(itemPriceParam) ? Double.parseDouble(itemPriceParam) : 0;

        var quantityParam = req.getParameter(QUANTITY_PARAM);
        var quantity = Objects.nonNull(quantityParam) ? Integer.parseInt(quantityParam) : 0;

        var item = new OrderItem(itemType, itemId, itemVendor, itemModel, itemPrice, quantity);
        var session = req.getSession();
        var items = cartService.processCart(session, cartAction, item);
        session.setAttribute(ORDER_ITEMS_ATTR, items);
        if ("add".equals(cartAction)) {
            redirectToProductPage(resp, itemType);
        } else {
            redirect(resp, CART_JSP);
        }
    }

    private void redirectToProductPage(HttpServletResponse response, int itemType) throws IOException {
        switch (itemType) {
            case 1 -> redirect(response, TV_STOCK);
            case 2 -> redirect(response, LAPTOP_STOCK);
        }
    }
}
