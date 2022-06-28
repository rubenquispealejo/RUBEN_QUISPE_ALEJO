package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Vendedor {

     //Métodos para la extraccion de datos de la BBDD 
         Conexion conexionBBDD = new Conexion ();
         Connection miConexion;
         PreparedStatement ps;
         ResultSet rs;
    
        public String validarCliente(String telefono, String usuario){
        
        
        EntidadVendedor usuarioCliente = new EntidadVendedor ();
        String nombre="";
        
        try{
                miConexion=conexionBBDD.Conectado();

                ps=miConexion.prepareStatement("select * from NOMBREDELATABLADELABBDD where telefono = ? and usuario = ?");
                ps.setString(1,telefono);
                ps.setString(2,usuario);
                rs = ps.executeQuery();
                if(rs.next()){//Esto es true cuando encuentra a una persona en la tabla que cumple la condicion que le pasamos
                    nombre=rs.getString("nombre");                   
                }
        }catch(Exception e){

                e.printStackTrace(); //para ver qué excepciones saltan y dónde
        }                
        return nombre; 
    }

}
