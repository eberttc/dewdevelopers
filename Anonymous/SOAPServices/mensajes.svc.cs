using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace SOAPServices
{
     public class mensajes : Imensajes
    {



        #region Imensajes Members

        public string saludar(string name)
        {
            return "hola" + name;
        }

        public string despedir(string name, string curso)
        {
            return "chau" + name + "|atentamente, tu profe de " + curso;
        }

        #endregion
    }
}
