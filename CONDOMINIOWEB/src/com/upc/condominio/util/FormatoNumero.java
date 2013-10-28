
package com.upc.condominio.util;


public class FormatoNumero {
	
	/**
	 * formatea un numero que viene de la caja de texto 
	 * @param numero: parametro de tipo string [123,536.12]
	 * @return objeto Double new Double(123536.12) or en su defecto objeto null
	 */
	public static Double formatearNumero(String numero){
		Double d = null;
		if (!"".equals(numero) && numero != null ){
			String[] s = CadenaUtil.desencadenar(numero,",");
			String t = ""; 
			
			for (int i=0;i<s.length;i++){
				t +=s[i];
			}
			d = new Double(t);
		}
		
		return d;
	}
	
	/**
	 * convierte un String en Integer
	 * @param numero: parametro de tipo string
	 * @return objeto Integer new Integer(entero) o en su defecto objeto null
	 */
	public static Integer stringToInteger(String numero){
		Integer i = null;
		if ("".equals(numero) || numero == null )
		    return null;
		
		try{
		    i = Integer.valueOf(numero);
		}catch(Exception e){
		    return null;
		}
		
		return i;
	}
	
	/**
	 * convierte un String en Double
	 * @param numero: parametro de tipo string
	 * @return objeto Double new Double o en su defecto objeto null
	 */
	public static Double stringToDouble(String numero){
		Double d = null;
		if ("".equals(numero) || numero == null )
		    return null;
		
		try{
		    d = Double.valueOf(numero);
		}catch(Exception e){
		    return null;
		}
		
		return d;
	}
}