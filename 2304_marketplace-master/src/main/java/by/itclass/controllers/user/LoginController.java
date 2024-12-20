package by.itclass.controllers.user;

import by.itclass.controllers.AbstractController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Objects;

import static by.itclass.constants.AppConst.LOGIN_CONTROLLER;
import static by.itclass.constants.JspConst.*;

@WebServlet(LOGIN_CONTROLLER)
public class LoginController extends AbstractController {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var login = req.getParameter(LOGIN_PARAM);
        var password = req.getParameter(PASS_PARAM);

        var user = userService.getUser(login, password);
        if (Objects.nonNull(user)) {
            var session = req.getSession();
            session.setAttribute(USER_ATTR, user);
            forward(req, resp, HOME_JSP);
        } else {
            forward(req, resp, LOGIN_JSP, "User is not found");
        }
    }
}
