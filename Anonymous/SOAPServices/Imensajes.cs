using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace SOAPServices
{
    [ServiceContract]
    public interface Imensajes
    {
       
         [OperationContract]
         string saludar(String name);

         [OperationContract]
         string despedir(String name, String curso);
    

    }
}
