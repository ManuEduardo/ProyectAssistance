package org.proyect.Modelos.Usuario;

public class Empleado extends Usuario{
    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public Empleado() {
    }

    public Empleado(int id, String nombre, String email, String contrasena, String departamento){
        super();
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.contrasena = contrasena;
        this.departamento = departamento;
    }

    @Override
    public Object ObtenerAtributo(String atributo) {

        if (atributo.equals("id")) return getId();
        if (atributo.equals("nombre")) return getNombre();
        if (atributo.equals("email")) return getEmail();
        if (atributo.equals("departamento")) return getDepartamento();
        return null;
    }
}
