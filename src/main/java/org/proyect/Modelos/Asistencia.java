package org.proyect.Modelos;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Asistencia implements Atributo{
    private int id;
    private String nombreEmpleado;
    private int idEmpleado;
    private Date fecha;
    private String hora;
    private String pattern = "dd-MM-yyyy";
    private String patternHour = "HH:mm:ss";
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    private SimpleDateFormat simpleHourFormat = new SimpleDateFormat(patternHour);

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getHora() {return hora;}

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getIdEmpleado() {return idEmpleado;}

    public void setIdEmpleado(int idEmpleado) {this.idEmpleado = idEmpleado;}

    public Asistencia(){

    }

    public Asistencia(int id, String nombreEmpleado, Date fecha, String hora) {
        this.id = id;
        this.nombreEmpleado = nombreEmpleado;
        this.fecha = fecha;
        this.hora = hora;
    }
    public Asistencia(int id, String nombreEmpleado, Date fecha) {
        this.id = id;
        this.nombreEmpleado = nombreEmpleado;
        this.fecha = fecha;

    }

    @Override
    public Object ObtenerAtributo(String atributo) {
        if (atributo.equals("id")) return getId();
        if (atributo.equals("empleado")) return getNombreEmpleado();
        if (atributo.equals("idEmpleado")) return getIdEmpleado();
        if (atributo.equals("fecha")) return getFecha();
        if (atributo.equals("hora")) return getHora();
        if (atributo.equals("fechaformateada")) return simpleDateFormat.format(fecha);
        if (atributo.equals("horaformateada")) return simpleHourFormat.format(fecha);
        return null;
    }
}
