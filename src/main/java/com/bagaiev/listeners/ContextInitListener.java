package com.bagaiev.listeners;

import org.apache.log4j.Logger;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by Kostya on 16.08.2014.
 */
public class ContextInitListener implements ServletContextListener{

    private static final Logger LOGGER = Logger.getLogger(ContextInitListener.class);
    protected WebApplicationContext getWebApplicationContext(ServletContextEvent event) {
        ServletContext servletContext = event.getServletContext();
        return (WebApplicationContext) servletContext.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
    }

    @Override
    public void contextInitialized(ServletContextEvent event) {
        ServletContext context = event.getServletContext();
        String contextPath = context.getContextPath();
        System.out.println("LISTENER !!!!!");
        LOGGER.info("ContextPath: " + contextPath);
        context.setAttribute("context", contextPath);

        //ConfigApplicationService configAppService = getWebApplicationContext(event).getBean(ConfigApplicationService.class);
        //context.setAttribute("CSS_JS_VERSION", configAppService.getCssJsVersion());

        LOGGER.info("ContextInitListener has been started");
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        LOGGER.info("ContextInitListener has been destroyed");
    }
}
