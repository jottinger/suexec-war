package com.autumncode.suexec.servlet;

import freemarker.ext.servlet.FreemarkerServlet;

import javax.annotation.PostConstruct;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = {"*.ftl","*.ftlh","*.ftlx"},
        loadOnStartup = 1,
        initParams = {
        @WebInitParam(name="TemplatePath", value="/"),
        @WebInitParam(name="NoCache", value="true"),
        @WebInitParam(name="ResponseCharacterEncoding", value="fromTemplate"),
        @WebInitParam(name="ExceptionOnMissingTemplate", value="true"),
        @WebInitParam(name="incompatible_improvements", value="2.3.25"),
        @WebInitParam(name="template_exception_handler", value="html_debug"),
        @WebInitParam(name="default_encoding", value="UTF-8"),
        @WebInitParam(name="output_encoding", value="UTF-8"),
        @WebInitParam(name="locale", value="en_US"),
        @WebInitParam(name="number_format", value="0.########"),
})
public class MyFreemarkerServlet extends FreemarkerServlet {
    @PostConstruct
    void initServlet() {
        System.out.println("MyFreemarkerServlet done");
    }
}
