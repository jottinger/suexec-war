package com.autumncode.suexec.ejb;

import javax.ejb.Singleton;
import javax.enterprise.context.ApplicationScoped;

@Singleton
@ApplicationScoped
public class MyEJB {
    public String greet() {
        return "Hello, world";
    }
}
