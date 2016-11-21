package com.autumncode.suexec.ejb;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.archive.importer.MavenImporter;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.net.URL;

@RunWith(Arquillian.class)
public class TestWebApp {
    @Deployment(testable = false)
    public static WebArchive createDeployment() {
        return ShrinkWrap
                .create(MavenImporter.class)
                .loadPomFromFile("pom.xml")
                .importBuildOutput()
                .as(WebArchive.class);
    }

    @FindBy(id="greeting")
    private WebElement greeting;

    @Drone
    WebDriver browser;
    @ArquillianResource
    private URL deploymentUrl;

    @Test
    public void testFreemarker() {
        browser.get(deploymentUrl.toExternalForm()+"servletfreemarker");
        Assert.assertEquals(greeting.getText(), "Hello, world");

    }

    @Test
    public void testHandlebars() {
        browser.get(deploymentUrl.toExternalForm()+"servlet");
        Assert.assertEquals(greeting.getText(), "Hello, world");

    }
}
