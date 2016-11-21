package com.autumncode.suexec.servlet;

import com.autumncode.suexec.ejb.FreemarkerEJB;
import com.autumncode.suexec.ejb.MyEJB;
import com.github.jknack.handlebars.Handlebars;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = {"/servletfreemarker"})
public class TestServletFreemarker extends HttpServlet {
    @EJB
    MyEJB ejb;
    @EJB
    FreemarkerEJB freemarker;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Handlebars handlebars = new Handlebars();

        Map<String, Object> map=new HashMap<>();
        map.put("when", new Date());
        map.put("ejb", ejb);
        map.put("invocation", ejb.greet());
Template template=freemarker.getTemplate("testservletfreemarker.ftl");
        PrintWriter  out=resp.getWriter();

        try {
            template.process(map, out);
        } catch (TemplateException e) {
            throw new ServletException(e);
        }
    }
}
