/*
 * Created on 02-mar-2005
 */
package com.upc.condominio.util;

import java.io.Serializable;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class FormatoFecha implements Serializable {
	
	public FormatoFecha() {
		super();
	}	
	
	

	
	public String obtenerHoraFecha(String strCadena){
		String strResultado;
		strResultado = strCadena.substring(11);
		return strResultado;
	}
	
	public String obtenerFechaActual(){
		int dia  = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);		
		int mes  = Calendar.getInstance().get(Calendar.MONTH);
		int anio = Calendar.getInstance().get(Calendar.YEAR);		
		String strDia = dia<10 ? "0" + dia : dia + "";
		String strMes = mes<10 ? "0" + (mes+1) : (mes +1) + "";
		String strAnio = String.valueOf(anio);
		String fecha = strDia + "/" + strMes + "/" + anio;
		return fecha;
	}
	/**
	 * Metodo que permite formatear la fecha en el 
	 * formato AAAA-MM-DD al formato DD/MM/AAAA  
	 * @param  strCadena Cadena
	 * @return Fecha formateada
	 */
	public String obtenerFecha(String strCadena){
	    //Si la fecha viene con datos de la hora, estos son descartados
	    if(strCadena.length() > 10)
	        strCadena = strCadena.substring(0,10);
	    
	    if(strCadena.length() == 10){
			String strResultado = strCadena.substring(8)+"/"+strCadena.substring(5,7)+"/"+strCadena.substring(0,4);
			return strResultado;
	    }else
	        return strCadena;
	}
	
	public String obtenerFechaInv(String strCadena){
		String strResultado;
		strResultado = strCadena.substring(0,4)+"/"+strCadena.substring(5,7)+
						"/"+strCadena.substring(8,10);
		return strResultado;
	}

	public static String obtenerHora(){
		int intHora  = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		int intMinutos  = Calendar.getInstance().get(Calendar.MINUTE);
		int intSegundos = Calendar.getInstance().get(Calendar.SECOND);
		String strHora = intHora<10 ? "0" + intHora : intHora + "";
		String strMinutos = intMinutos<10 ? "0" + (intMinutos) : (intMinutos) + "";
		String strSegundos = intSegundos<10 ? "0" + (intSegundos) : (intSegundos) + "";
		String strHoraCompleta = strHora + ":" + strMinutos + ":" + strSegundos;
		return strHoraCompleta;
	}
	
	public String primerDiaMes(String strCadena){		
		String strResultado;
		strResultado = "01"+"/"+strCadena.substring(3,5)+"/"+strCadena.substring(6,10);		
		return strResultado;
	}
	
	public java.sql.Date ultimoDiaMes(java.sql.Date fecha){		
		Calendar cal = GregorianCalendar.getInstance();
		cal.setTimeInMillis(fecha.getTime());		 
	    cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH));	    
	    return  new java.sql.Date(cal.getTime().getTime());
		
		
	}
	public String diaAnterior(String strCadena){
		
		String strResultado;
		String dia = strCadena.substring(0,2);
							 
		int intDia = Integer.parseInt(dia);
		if(intDia!=1) intDia = Integer.parseInt(dia)-1;
		
		String strDiaAnt = (intDia < 10 ? "0"+ String.valueOf(intDia):
			String.valueOf(intDia));
		
		strResultado = strDiaAnt+"/"+strCadena.substring(3,5)+
			"/"+strCadena.substring(6,10);		
		return strResultado;
	}
	
	public String rellenar(String cadena,String relleno,int cantidad,String direccion){
		while(cadena.length()<cantidad)
			if(direccion=="0")//derecha
				cadena = cadena + relleno;
			else		  //izquierda
				cadena = relleno + cadena;
			
		return cadena;
	}
	
	public static String quitaRelleno(String cadena,char relleno,String direccion){
	    //Se convierte el relleno String de tamaño 1 en un char
	    //En cada iteración se inicializa la variable borrador cad
	    	    
	    if(cadena.length() <= 1)
	        return cadena;
	    
	    String cad;
	    //Derecha
		if(direccion == "0"){
			while(cadena.charAt(cadena.length()-1) == relleno){
				cad = "";
				for(int i=0;i<cadena.length()-1;i++)
					cad = cad+cadena.charAt(i);
				cadena = cad;
			}
		}

		//Izquierda
		else{
		    while(cadena.charAt(0) == relleno){
				cad = "";
				for(int i=cadena.length()-1;i>0;i--)
					cad = cadena.charAt(i)+cad;
				cadena = cad;
			}
		}

		return cadena;
	}
	
	/**
	 * Devuelve String fecha Ingresada formato YYYY/MM/DD
	 * date: de tipo java.sql.Date 
	 * si el objeto date que se ingresa es nulo devuelve nulo 
	 */
	public static String dateToStringYYYYMMDD(Date date){
		if (date == null)
			return null;
						
		return new SimpleDateFormat("yyyy/MM/dd").format(date);
	}
	
	/**
	 * @param fecha: parametro de entrada de tipo String dd/mm/yyyy ejemplo [10/02/2006] 
	 * @return retorna un obejeto de tipo java.sql.Date o un objeto nulo
	 * @throws ParseException
	 */
	public static Date stringToSqlDate(String fecha){
		Date dFecha = null;
		if (fecha != null && fecha.length() == 10){
		    try{
				long lTime = new SimpleDateFormat("dd/MM/yyyy").parse(fecha).getTime();
				dFecha = new Date(lTime);
		    }catch(Exception e){
		        return null;
		    }
		}
		return dFecha;
	}
	
	/**
	 * @param fecha: parametro de entrada de tipo String dd/mm/yyyy ejemplo [10/02/2006] 
	 * @return retorna un obejeto de tipo java.sql.Date o un objeto nulo
	 * @throws ParseException
	 */
	public static Date stringToSqlDateYYYYMMDD(String fecha){
		Date dFecha = null;
		if (fecha != null && fecha.length() == 10){
		    try{
				long lTime = new SimpleDateFormat("yyyy-MM-dd").parse(fecha).getTime();
				dFecha = new Date(lTime);
		    }catch(Exception e){
		        return null;
		    }
		}
		return dFecha;
	}
	
	/**
	 * Devuelve String fecha Ingresada formato dd/MM/yyyy
	 * date: de tipo java.sql.Date 
	 * si el objeto date que se ingresa es nulo devuelve nulo 
	 */
	public static String dateToStringDDMMYYYYY(java.sql.Date date){
		if (date == null)
			return null;
		
		return (new SimpleDateFormat("dd/MM/yyyy")).format(date);
	}
	
	/**
	 * Devuelve String fecha Ingresada formato dd/MM/yyyy
	 * date: de tipo java.sql.Date 
	 * si el objeto date que se ingresa es nulo devuelve nulo 
	 */
	public static String dateToStringDDMMYYYYY(java.util.Date date){
		if (date == null)
			return null;
		
		return (new SimpleDateFormat("dd/MM/yyyy")).format(date);
	}
	
	public static int obtenerAnios(Date fechaNac,Date fechaActual){	    
        Calendar earlier = Calendar.getInstance();
        Calendar later = Calendar.getInstance();
    	        
	    earlier.setTime(fechaNac);
	    later.setTime(fechaActual);
	
	    long millis = later.getTimeInMillis()-earlier.getTimeInMillis();
	    long days = (long)millis/(1000*60*60*24)+1; // +1 to make the end inclusive
    
	    // Count number of february 29's between cal1 and cal2
	    int startyear = earlier.get(Calendar.YEAR);
	    int endyear = later.get(Calendar.YEAR);
	    
	    if (earlier.get(Calendar.MONTH) > Calendar.FEBRUARY)
	      startyear++;
	    
	    if (later.get(Calendar.MONTH) < Calendar.FEBRUARY ||
	        (later.get(Calendar.MONTH) == Calendar.FEBRUARY && 
	         later.get(Calendar.DAY_OF_MONTH) < 29)) 
	      endyear--;
	    
	    int feb29s = 0;
	    for (int i = startyear; i <= endyear; i++)
	      if ((i%4 == 0) && (i%100 != 0) || (i%400 == 0))
	        feb29s++;
	      
	    return (int)days/(365+feb29s);
	}
	
	/**
	 * devuelve una cadena de fecha formateada tipo dd/mm/yyyy 
	 * @param fecha : parametro de entrada de tipo yyyy-mm-dd
	 * @return cadena fecha ejemplo [02/09/2006]
	 */
	public static String obtenerFechaDesdeyyyymmdd(String fecha){
		String fechaFinal = null;
		if (fecha != null && fecha.length() == 10){
			String[] arrFecha = CadenaUtil.desencadenar(fecha,"-");
			fechaFinal = arrFecha[2] + "/" +arrFecha[1] + "/" + arrFecha[0];  
		}
		return fechaFinal;
	}
	
	public static String obtenerFechaDesdeyyyymmdd2(String fecha){
		String fechaFinal = null;
		if (fecha != null && fecha.length() == 10){
			String[] arrFecha = CadenaUtil.desencadenar(fecha,"/");
			fechaFinal = arrFecha[2] + "-" +arrFecha[1] + "-" + arrFecha[0];  
		}
		return fechaFinal;
	}
	
	public static Date getPrimerDiaDelMes(Date fecha) {
			Calendar cFecha = Calendar.getInstance();
	        cFecha.setTime(fecha);
	        cFecha.set(cFecha.get(Calendar.YEAR),
	        cFecha.get(Calendar.MONTH),
	        cFecha.getActualMinimum(Calendar.DAY_OF_MONTH),
	        cFecha.getMaximum(Calendar.HOUR_OF_DAY),  
	        cFecha.getMaximum(Calendar.MINUTE),  
	        cFecha.getMaximum(Calendar.SECOND)); 
			return new Date (cFecha.getTimeInMillis());  
	}  

    public static Date getUltimoDiaDelMes(Date fecha) {
    	Calendar cFecha = Calendar.getInstance();
        cFecha.setTime(fecha);
        cFecha.set(cFecha.get(Calendar.YEAR),
        cFecha.get(Calendar.MONTH),
        cFecha.getActualMaximum(Calendar.DAY_OF_MONTH),
        cFecha.getMaximum(Calendar.HOUR_OF_DAY),  
        cFecha.getMaximum(Calendar.MINUTE),  
        cFecha.getMaximum(Calendar.SECOND)); 
		return new Date( cFecha.getTimeInMillis());  

    }  

    public static String getNombreMes(String mes){
    	int intMes=Integer.parseInt(mes);
    	
    	switch(intMes){
    	case 1:return "Enero";
    	case 2:return "Febrero";
    	case 3:return "Marzo";
    	case 4:return "Abril";
    	case 5:return "Mayo";
    	case 6:return "Junio";
    	case 7:return "Julio";
    	case 8:return "Agosto";
    	case 9:return "Septiembre";
    	case 10:return "Octubre";
    	case 11:return "Noviembre";
    	case 12 : return "Diciembre";
    	}
    	
    	return "";
    }
	
}