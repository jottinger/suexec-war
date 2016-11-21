package com.autumncode.suexec.servlet;

import com.autumncode.suexec.ejb.MyEJB;

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
        req.setAttribute("when", new Date());
        req.setAttribute("ejb", ejb);
        req.setAttribute("invocation", ejb.greet());
        req.setAttribute("cp", req.getContextPath());

        String path = "/testservletfreemarker.ftl";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(path);

        dispatcher.forward(req, resp);
    }
}
