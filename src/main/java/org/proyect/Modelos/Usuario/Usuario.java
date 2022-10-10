package org.proyect.Modelos.Usuario;

import org.proyect.Modelos.Atributo;

public class Usuario implements Atributo {
    protected int id;
    protected String nombre;
    protected String email;
    protected String contrasena;
    protected String departamento;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public Object ObtenerAtributo(String atributo) {
        if (atributo.equals("id")) return getId();
        if (atributo.equals("nombre")) return getNombre();
        return null;
    }
}
