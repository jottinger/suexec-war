package com.autumncode.suexec.servlet;

import com.autumncode.suexec.ejb.MyEJB;
import com.github.jknack.handlebars.Handlebars;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(urlPatterns = {"/servletfreemarker"})
public class TestServletFreemarker extends HttpServlet {
    @EJB
    MyEJB ejb;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Handlebars handlebars = new Handlebars();

        req.setAttribute("when", new Date());
        req.setAttribute("ejb", ejb);
        req.setAttribute("invocation", ejb.greet());

        String path = "/testservletfreemarker.ftl";
        System.out.println("forwarding to " + path);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(path);

        dispatcher.forward(req, resp);
    }
}
