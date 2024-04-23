package by.itclass.controllers.user;

import by.itclass.controllers.AbstractController;
import by.itclass.model.entities.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static by.itclass.constants.AppConst.REGISTRATION_CONTROLLER;
import static by.itclass.constants.JspConst.*;

@WebServlet(REGISTRATION_CONTROLLER)
public class RegistrationController extends AbstractController {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var login = req.getParameter(LOGIN_PARAM);
        var name = req.getParameter(NAME_PARAM);
        var email = req.getParameter(EMAIL_PARAM);
        var password = req.getParameter(PASS_PARAM);
        var user = new User(name, email, login, password.toCharArray());
        if (userService.addUser(user)) {
            redirect(resp, LOGIN_JSP);
        } else {
            forward(req, resp, REGISTRATION_JSP, "Registration isn't success");
        }
    }
}
