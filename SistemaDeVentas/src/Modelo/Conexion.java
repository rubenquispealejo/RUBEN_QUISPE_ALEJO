package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    Connection con;
    String url = "";
    String user = "root";
    String password = "";

    public Connection Conectado() {
        try {
            Class.forName("");
            con = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
        }
        return (con);
    }

}
