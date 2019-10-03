package com.alten.vts.service;

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.vaadin.flow.spring.SpringServlet;

@Service
public class Services {
	
    public static VehicleService getVehicleService() {
        return getApplicationContext().getBean(VehicleService.class);
    }

    public static ApplicationContext getApplicationContext() {
        ServletContext servletContext = SpringServlet.getCurrent().getServletContext();
        return WebApplicationContextUtils.getWebApplicationContext(servletContext);
    }

}
