package com.servicios;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.spi.container.ParamQualifier;


@Path("/ctoFService")
public class CtoFService {
	
	 @GET
	 @Produces(MediaType.TEXT_PLAIN)
	public String convertCtoF(){
		 Double fahrenheit;
	     Double celsius = 36.8;
	     fahrenheit = ((celsius * 9) / 5) + 32;
	   /*  String result = "@Produces(\"application/xml\") Output: \n\nC to F Converter Output: \n\n" + fahrenheit;
	        return "<ctofservice>" + "<celsius>" + celsius + "</celsius>" + "<ctofoutput>" + result + "</ctofoutput>" + "</ctofservice>";
	    */
	     return fahrenheit.toString();
	}
	
	@Path("{c}")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String convertCtoFfromInput(@PathParam("c") Double c){
		  Double fahrenheit;
	        Double celsius = c;
	        fahrenheit = ((celsius * 9) / 5) + 32;
	 
	       /* String result = "@Produces(\"application/xml\") Output: \n\nC to F Converter Output: \n\n" + fahrenheit;
	        return "<ctofservice>" + "<celsius>" + celsius + "</celsius>" + "<ctofoutput>" + result + "</ctofoutput>" + "</ctofservice>";
	   */
	        return fahrenheit.toString();
		
	}

}
