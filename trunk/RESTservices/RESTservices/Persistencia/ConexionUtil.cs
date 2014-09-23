using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace RESTservices.Persistencia
{
    public class ConexionUtil
    {

        public static String cadena { 
            get {


                return "DataSource=(local);"+
                       "Initial catalog=Votacion;"+
                       "Integrated Security=SSPI;";

            }
        }
    }
}