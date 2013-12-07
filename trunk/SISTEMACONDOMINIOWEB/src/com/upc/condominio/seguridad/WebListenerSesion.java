package com.upc.condominio.seguridad;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class WebListenerSesion
 *
 */
@WebListener
public class WebListenerSesion implements ServletContextListener, HttpSessionListener {

    /**
     * Default constructor. 
     */
    public WebListenerSesion() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0) {
       System.out.println("Se Inicio una Session");
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent sEvent) {

    	HttpSession miSesion=sEvent.getSession();
		try {
			miSesion.removeAttribute("USUARIO_ACTUAL");
		} catch (Exception e) {
			
		}
		
		System.out.println("se destruyo la sesion");
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    }
	
}
