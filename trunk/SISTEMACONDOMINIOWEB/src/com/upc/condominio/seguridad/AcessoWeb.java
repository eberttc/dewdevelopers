package com.upc.condominio.seguridad;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.upc.condominio.modelo.Usuario;

/**
 * Servlet Filter implementation class AcessoWeb
 */
@WebFilter(filterName="/AcessoWeb" ,
		   urlPatterns={"/*"},
		   initParams={
			   	@WebInitParam(name="homePage", value="/pages/ErrorSesion.jsp")
		   	})
public class AcessoWeb implements Filter {
	private FilterConfig filterConfig = null;
	public FilterConfig getFilterConfig() {
		return filterConfig;
	}

	public void setFilterConfig(FilterConfig filterConfig) {
		this.filterConfig = filterConfig;
	}

	public String getHomePage() {
		return homePage;
	}

	public void setHomePage(String homePage) {
		this.homePage = homePage;
	}

	private String homePage = null;
    /**
     * Default constructor. 
     */
    public AcessoWeb() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		this.filterConfig = null;
		this.homePage = null;
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here	
	
		
		boolean acceso = false;
		HttpSession session = null;
		if (request instanceof HttpServletRequest) {
			session = ((HttpServletRequest) request).getSession(false);
			if (session != null) {
				if (session.getAttribute("USUARIO_ACTUAL") != null||paginaInicio(request, response)) {
					acceso = true;
				}
			}else{
				if (paginaInicio(request, response)) {
					acceso = true;
				}
			}
		}
		
		if (acceso) {
			chain.doFilter(request, response);
			return;
		} else {
			if (this.getFilterConfig() != null) {
				if ((this.getHomePage() != null)
						&& (!this.getHomePage().equals(""))) {

					HttpServletResponse httpResp = (HttpServletResponse) response;

					// httpResp.setHeader(arg0, arg1);
					httpResp.setHeader("Cache-Control", "no-cache"); // HTTP 1.1
					httpResp.setHeader("Pragma", "no-cache"); // HTTP 1.0
					httpResp.setDateHeader("Expires", 0); // prevents caching at the proxy server

					
					this.getFilterConfig().getServletContext().getRequestDispatcher(this.getHomePage()).forward(request, httpResp);
					
					return;
				}
			}
		}
		
		
	}
	public boolean paginaInicio(ServletRequest request, ServletResponse response) {
		HttpServletRequest httpReq = (HttpServletRequest) request;

		String caller[] = httpReq.getRequestURI().split("/");
		// Lo siguiente devuelve true
		Pattern pattern = Pattern.compile("(.css||.js|.html|.htm|.gif|.jpg|.png)");
		
		
		String call = caller[caller.length - 1];
		
		/*Matcher matcher = pattern.matcher(call);

		if (matcher.find()) {
			
			return true;
		}*/
		if ( call.indexOf(".css") > 0||call.indexOf(".js") > 0||call.indexOf(".html") > 0||call.indexOf(".gif") > 0 || call.indexOf(".png") > 0 || call.indexOf(".jpg") > 0){
			return true;
	    }
	   
	  
		
		String pagInicio[] = {"SISTEMACONDOMINIOWEB","index.jsp","LoginServlet"};
		//si no encuentra retorna false 
		if (buscar(call,pagInicio)<0)
			return false;
		

		return true;
	}
	
	
	public static int buscar(String str, String a[ ])
    {
        int i;
        int pos = -1;  /* asume que no lo encuentra */
        for(i = 0; i < a.length; i++)
        {
            if ( str.compareTo(a[i]) == 0)
            {
                pos = i;    
                break;
            }    
        }
        
        return pos;
    }

	

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
		this.homePage = filterConfig.getInitParameter("homePage");
	}

}
