package org.proyect.Controladores.BaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    Connection conect = null;

    private String user = "root";
    private String pass = "root";
    private String bd = "BDAssistance";
    private String ip = "0.0.0.0";
    private String port = "5555";

    private String url = "jdbc:postgresql://"+ip+":"+port+"/"+bd;

    public Connection makeConnection(){
        try {
            Class.forName("org.postgresql.Driver");
            conect = DriverManager.getConnection(url, user, pass);
            System.out.println("Conectado");
        }catch(Exception e){
            System.out.println(e.toString());
        }
        return conect;
    }
}
