using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Web;

namespace RESTservices.Dominio
{
    [DataContract]
    public class Alumno
    {

        [DataMember]
        public string codigo { get; set; }

        [DataMember]
        public string nombre { get; set; }

    }
}