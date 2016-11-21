package com.autumncode.suexec.servlet;

import com.autumncode.suexec.ejb.MyEJB;
import com.github.jknack.handlebars.Context;
import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import com.github.jknack.handlebars.context.MapValueResolver;

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

@WebServlet(urlPatterns = {"/servlet"})
public class TestServlet extends HttpServlet {
    @EJB
    MyEJB ejb;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Handlebars handlebars = new Handlebars();

        Template template = handlebars.compile("testservlet");
        Map<String, Object> map=new HashMap<>();
        map.put("when", new Date());
        map.put("ejb", ejb);
        map.put("invocation", ejb.greet());
        Context ctx= Context.newBuilder(map)
                .resolver(MapValueResolver.INSTANCE)
                .build();
        PrintWriter  out=resp.getWriter();

        out.println(template.apply(ctx));
    }
}
