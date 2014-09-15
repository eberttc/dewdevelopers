package com.servicios;

import javax.activation.MimeType;
import javax.annotation.Generated;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;


@Path("/ftoCService")
public class FtoCService {
	
	@GET
	@Produces("application/json")
	public Response convertFtoC() throws JSONException {
		
		JSONObject obj=new JSONObject();
		Double fahrenheit = 98.24;
        Double celsius;
        celsius = (fahrenheit - 32)*5/9; 
        obj.put("F value", fahrenheit);
        obj.put("C value", celsius);
        
        String result = "@Produces(\"application/json\") Output: \n\nF to C Converter Output: \n\n" + obj;
        return Response.status(200).entity(result).build();
	}
	
	@Path("{f}")
	@GET
	public Response convertFtoCfromInput(@PathParam("f") float f) throws JSONException{
		 JSONObject jsonObject = new JSONObject();
	        float celsius;
	        celsius =  (f - 32)*5/9; 
	        jsonObject.put("F Value", f); 
	        jsonObject.put("C Value", celsius);
	 
	        String result = "@Produces(\"application/json\") Output: \n\nF to C Converter Output: \n\n" + jsonObject;
	        return Response.status(200).entity(result).build();
	}

}
