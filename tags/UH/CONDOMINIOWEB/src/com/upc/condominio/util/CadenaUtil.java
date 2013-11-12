
package com.upc.condominio.util;

import java.util.StringTokenizer;

public class CadenaUtil {
	
	/**
	 * Metodo que devuelve un booleano true si es caso es blanco o nulo y false 
	 * en caso contrario 
	 * @param cadena: cadena que se va evaluar
	 * @return boolean [true|false]
	 */
	public static boolean esBlankStringCadena(String cadena){
		boolean b = true;
		if (cadena != null && cadena.trim().length()>0){
			return false;
		}
		return b;
	}
	
	/**
	 * Metodo que te devuelve un arreglo con datos de una trama contenido 
	 * tiene un separador
	 * @param cadena: parametro de tipo cadena ejemplo ["234;444;567;24"]
	 * @param separador: parametro cadena [";"]
	 * @return retorna un arreglo s[0]="234" s[1]="444" s[2]="567" s[3]="24" 
	 * o en su defecto null;
	 */
	public static String[] desencadenar(String cadena,String separador){
		if (cadena == null || "".equals(cadena))
			return null;
		
		StringTokenizer st = new StringTokenizer(cadena,separador);
		String[] s = new String[st.countTokens()];
		int i=0;
		while (st.hasMoreTokens()) {
			s[i] = st.nextToken();
			i++;
		}
		
		return s;
	}
	/**
	 * Elimina Saltos de linea
	 * @param cadena
	 * @param separador
	 * @return
	 */
	public static String eliminarSaltos(String cadena){
		if (cadena == null || "".equals(cadena))
			return null;
		
		StringTokenizer st = new StringTokenizer(cadena,"\n");
		String s = "";
		while (st.hasMoreTokens()) {
			s += st.nextToken();
		}
		st = new StringTokenizer(s,"\r");
		s = "";
		while (st.hasMoreTokens()) {
			s += st.nextToken();
		}
		return s;
	}
	

	//Recibe un String y si es null devuelve ""
	public static String obtieneCadena(String cadena){
	    return cadena == null?"":cadena;
	}
	
	//Prepara una cadena para que sea aceptable al grid
	public static String preparaCadena(String cadena){
	    if(cadena == null)
	        return cadena;

        //Transforma el Enter: (char)10 en espacio vacío
	    cadena = cadena.replace((char)10,' ');
	    cadena = cadena.replace((char)13,' ');
        
        //Reemplaza las " y , con espacios vacíos
	    cadena = cadena.replace(',',' ');
	    cadena = cadena.replace('"',' ');
	    
	    return cadena;
	}
	
	//Devuelve el substring de una cadena
	public static String obtieneSubStr(String cadena, int inicio, int fin){
	    String subStr = "";
	    
	    if(cadena == null || "".equals(cadena))
	        return subStr;
	    
	    if(inicio > cadena.length() || fin > cadena.length() || inicio > fin)
	        return subStr;
	    
	    subStr = cadena.substring(inicio,fin);
	    
	    return subStr;
	}
}