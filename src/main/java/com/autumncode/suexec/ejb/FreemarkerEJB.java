package com.autumncode.suexec.ejb;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import java.io.IOException;

@Singleton
public class FreemarkerEJB {
    Configuration configuration;

    @PostConstruct
    void init() {
        configuration = new Configuration(Configuration.VERSION_2_3_25);

// Specify the source where the template files come from. Here I set a
// plain directory for it, but non-file-system sources are possible too:
        //cfg.setDirectoryForTemplateLoading(new File("/where/you/store/templates"));

        configuration.setClassLoaderForTemplateLoading(this.getClass().getClassLoader(), "/");

        configuration.setDefaultEncoding("UTF-8");

        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER);

        configuration.setLogTemplateExceptions(false);
    }

    public Template getTemplate(String name) throws IOException {
        return configuration.getTemplate(name);
    }
}
