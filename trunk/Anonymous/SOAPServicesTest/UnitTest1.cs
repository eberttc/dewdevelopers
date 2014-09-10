using System;
using System.Text;
using System.Collections.Generic;
using System.Linq;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace SOAPServicesTest
{
    
    [TestClass]
    public class UnitTest1
    {
       

        


        [TestMethod]
        public void TestMethod1()
        {
            //1.-instancias el artefacto a ser probado
            MensajeWS.ImensajesClient proxy = new MensajeWS.ImensajesClient();

            //2.- invocar la operacion a ser probado
           string nombre = proxy.saludar("angel");

            //3.-validacion
           Assert.AreEqual("holaangel", nombre);

        }
    }
}
