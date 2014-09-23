

using RESTservices.Dominio;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Web;

namespace RESTservices.Persistencia
{
    public class AlumnoDAO
    {

        public Alumno crear(Alumno a) {

            Alumno al = null;
            string sql = "INSERT INTO t_alumno VALUES (@COD,@NOM)";
            using(SqlConnection con=new SqlConnection(ConexionUtil.cadena)){
                con.Open();
                using(SqlCommand command=new SqlCommand(sql,con)){

                    command.Parameters.Add(new SqlParameter("@COD", a.codigo));
                    command.Parameters.Add(new SqlParameter("@NOM", a.nombre));
                    command.ExecuteNonQuery();

                }
            
            }

            al = a;
            return al;
        
        }


        public Alumno obtener(String codigo) {

            Alumno alumnoEncontrado = null;
            string sql = "select * from   t_alumno where codigo=@cod";
            using (SqlConnection con = new SqlConnection(ConexionUtil.cadena)) {

                con.Open();

                using(SqlCommand com=new SqlCommand(sql,con)){
                    com.Parameters.Add("@cod", codigo);

                    using (SqlDataReader resultado = com.ExecuteReader()) {
                        if (resultado.Read()) {


                            alumnoEncontrado = new Alumno(){
                                codigo=(string)resultado["codigo"],
                                nombre=(string)resultado["nombre"]

                            }

                        
                        }
                    
                    }
                
                
                }

                return alumnoEncontrado;
            }
        
        
        
        }




    }
}  