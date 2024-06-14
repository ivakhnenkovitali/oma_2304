package by.itclass.controllers.order;

import by.itclass.controllers.AbstractController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static by.itclass.constants.AppConst.ORDER_CONTROLLER;
import static by.itclass.constants.JspConst.*;

@WebServlet(ORDER_CONTROLLER)
public class OrderController extends AbstractController {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var address = req.getParameter(ADDRESS_PARAM);
        var session = req.getSession();
        if (orderService.saveOrder(session, address)) {
            var orderId = session.getAttribute(ORDER_ID_ATTR);
            session.removeAttribute(ORDER_ID_ATTR);
            session.removeAttribute(ORDER_ITEMS_ATTR);
            forward(req, resp, HOME_JSP, String.format("Your order id is %s, you can print it on the Orders page", orderId));
        } else {
            forward(req, resp, CART_JSP, "Order wasn't saved");
        }
    }
}
