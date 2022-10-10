package org.proyect.Modelos;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Asistencia implements Atributo{
    private int id;
    private String empleado;
    private Date fecha;
    private String pattern = "dd-MM-yyyy";
    private String patternHour = "HH:mm";
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    private SimpleDateFormat simpleHourFormat = new SimpleDateFormat(patternHour);

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Asistencia(){

    }

    public Asistencia(int id, String empleado, Date fecha) {
        this.id = id;
        this.empleado = empleado;
        this.fecha = fecha;
    }

    @Override
    public Object ObtenerAtributo(String atributo) {
        if (atributo.equals("id")) return getId();
        if (atributo.equals("empleado")) return getEmpleado();
        if (atributo.equals("fecha")) return getFecha();
        if (atributo.equals("fechaformateada")) return simpleDateFormat.format(fecha);
        if (atributo.equals("horaformateada")) return simpleHourFormat.format(fecha);
        return null;
    }
}
