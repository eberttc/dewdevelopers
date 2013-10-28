package com.upc.condominio.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateTimeUtil {
    
    private static final int MS_IN_HOUR = 1000 * 60 * 60;
    private static final int MS_IN_Day = 24 * MS_IN_HOUR;

    /**
     * This is a class with all static methods (often called a utility class).
     * To document the fact that it should be used without first being
     * instantiated, we make the constructor private. Furthermore, some code
     * evaluation tools, such as PMD, will complain about an empty method body,
     * so we add a comment in the method body to appease such tools.
     * 
     */
    private DateTimeUtil() {
        // I'm a utility class, do not instantiate me
    }

    /**
     * Remove all of the time elements from a date.
     */
    public static void removeTimeFrom(final Calendar c) {
        c.clear(Calendar.AM_PM);
        c.clear(Calendar.HOUR_OF_DAY);
        c.clear(Calendar.HOUR);
        c.clear(Calendar.MINUTE);
        c.clear(Calendar.SECOND);
        c.clear(Calendar.MILLISECOND);
    }

    /**
     * This is a simple algorithm to calculate the number of days between two
     * dates. It is not very accurate, does not take into consideration leap
     * years, etc. Do not use this in production code. It serves our purposes
     * here.
     * 
     * @param d1
     *            "from date"
     * @param d2
     *            "to date"
     * 
     * @return number of times "midnight" is crossed between these two dates,
     *         logically this is d2 - d1.
     */
    public static int daysBetween(final Date d1, final Date d2) {
    	DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
    	Date d11,d22;
    	try {
			d11=df.parse(df.format(d1));
		} catch (ParseException e) {
			d11=d1;
		}
		
   	 	try {
			d22=df.parse(df.format(d2));
		} catch (ParseException e) {
			d22=d2;
		}
    	Long diferencia = (d22.getTime() - d11.getTime())/MS_IN_Day;
    	return Integer.parseInt(String.valueOf(diferencia));
	}
	/**
	 * suma 1 meses a un java.sql.Date
	 * 
	 * @param fecha
	 *            Fecha al cual sumar los meses
	 * 
	 * @return
	 */
	public static java.sql.Date addMonthToDate(java.sql.Date fecha) {
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(fecha.getTime());
        //verifica el mes si llego al mes 12 pasa al siguinet año
        if (cal.get(Calendar.MONTH)==12 )// si llego a diciembre vuelve a enero cambia de año
        {
             cal.set(Calendar.MONTH, 1);
             cal.add(Calendar.YEAR, 1);
        }
        else//si no llego a diciembre aumneta un mes
        {
            cal.add(Calendar.MONTH, 1);
            
        }
        return new java.sql.Date(cal.getTimeInMillis());
	}
    
	/**
	 * Obtiene el plan de pagos del que es cada 30 de cada mes y de los bisiestos
	 * 
	 * @param fecha
	 *            Fecha del mes que se quiere sacar la fecha
	 * 
	 * @return
	 */
	public static java.sql.Date obtenerDiaPagoPlanPagos(java.sql.Date fecha,java.sql.Date fechaReferencia) {
		Calendar cal = new GregorianCalendar();
		Calendar calReferencia= new GregorianCalendar();
		calReferencia.setTimeInMillis(fechaReferencia.getTime());
		cal.setTimeInMillis(fecha.getTime());		
		int numeroDias= cal. getActualMaximum (Calendar. DAY_OF_MONTH);
		//Verifica si el numero de dias maximo de cada mes
		if  (numeroDias >= calReferencia.get(Calendar.DAY_OF_MONTH))
		{	
			cal.set(Calendar.DAY_OF_MONTH,calReferencia.get(Calendar.DAY_OF_MONTH));			
		}
		else
		{
			cal.set(Calendar.DAY_OF_MONTH,numeroDias);			
		}		
        return new java.sql.Date(cal.getTimeInMillis());
	}

    
    public static Date createDate(final int year, final int month, final int day) {
        final Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, day);

        return c.getTime();
    }
    
     public static Date addDaysToDate(final Date date, final int days) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_YEAR, days);
        return c.getTime();
        
    }
     
    public static Date addYearsToDate(final Date date, final int years) {
         Calendar c = Calendar.getInstance();
         c.setTime(date);
         c.add(Calendar.YEAR, years);
         return c.getTime();
         
     } 
     
    public static Date addMonthToDate(final Date date, final int month) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, month);
        return c.getTime();
        
    }
    
    public static String dateToString(Date fecha){
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DATE_FIELD, Locale.UK);
        return dateFormat.format(fecha);
    }
    
    public static String dateToStringLarge(Date fecha){
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG, Locale.UK);
        return dateFormat.format(fecha);
    }
    
    public static String dateToStringDiaMesAnio(final Date date) {
        SimpleDateFormat dateFormater =new SimpleDateFormat("dd/MM/yyyy"); 
 
        String fechaString = dateFormater.format(date);
        
        return fechaString;
        
    }
    
    /**
	 * Para obtener el cumpleaños
	 * @return Bandera y cuantos años Cumple.
	 */
	public static String obtenerCumpleaños(Date fechaNac, Date fechaActual){	
		String cumple="";
		Calendar c = Calendar.getInstance();
		Calendar cA = Calendar.getInstance();
        c.setTime(fechaNac);
        cA.setTime(fechaActual);	
		
		int diaNac  = c.get(Calendar.DAY_OF_MONTH);		
		int mesNac  = c.get(Calendar.MONTH);
		int anioNac = c.get(Calendar.YEAR);		
		
		int diaAc   = cA.get(Calendar.DAY_OF_MONTH);
		int mesAc   = cA.get(Calendar.MONTH);
		int anioAc  = cA.get(Calendar.YEAR); 
		
		if(diaNac == diaAc && mesNac==mesAc)	
		{				
			cumple= String.valueOf(anioAc-anioNac);			
		}
		return cumple;
	}
}
