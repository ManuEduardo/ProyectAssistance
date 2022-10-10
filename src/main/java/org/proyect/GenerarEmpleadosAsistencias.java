package org.proyect;

import org.proyect.Modelos.Atributo;
import org.proyect.Modelos.Usuario.Empleado;
import org.proyect.Modelos.Asistencia;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class GenerarEmpleadosAsistencias {
    public static GenerarEmpleadosAsistencias SingletonInstance = null;

    private ArrayList<Empleado> listaEmpleadosArrayList = new ArrayList<>();
    private ArrayList<Asistencia> listaAsistenciasArrayList = new ArrayList<>();

    private GenerarEmpleadosAsistencias() {
        //lista empleados
        listaEmpleadosArrayList.add(new Empleado(16708024, "Miguel", "miguelitoxd@gmail.com", "supercontraseña123", "Logistica"));
        listaEmpleadosArrayList.add(new Empleado(16704362, "José", "joselito@gmail.com", "inhackeable", "Ventas"));

        //lista asistencias
            //FECHA: PRIMERO EL AÑO,
            // PONES EL AÑO MENOS 1900 | MES, PONES EL MES PONES COMO EL EJEMPLO | DIA, 0 ES EL 31, 1 ES EL 1
        listaAsistenciasArrayList.add(new Asistencia(1,"Miguel", new Date(116, Calendar.JANUARY,-1)));

    }
    public static GenerarEmpleadosAsistencias singletonGenerador(){
        if(SingletonInstance == null){
            SingletonInstance = new GenerarEmpleadosAsistencias();
        }
        return SingletonInstance;
    }

    public Atributo[] generarEmpleados(){
        Empleado u1 = new Empleado(); u1.setId(500); u1.setNombre("Manuel"); u1.setDepartamento("Logistica"); u1.setEmail("manuel@hotmail.com");
        Empleado u2 = new Empleado(); u2.setId(3); u2.setNombre("Jose"); u2.setDepartamento("Marketing"); u2.setEmail("jose@hotmail.com");
        Empleado u3 = new Empleado(); u3.setId(8); u3.setNombre("Maria"); u3.setDepartamento("Ventas"); u3.setEmail("mariapro@gmail.com");
        Empleado u4 = new Empleado(); u4.setId(32); u4.setNombre("Pedro"); u4.setDepartamento("Tic"); u4.setEmail("psanchez@tuki.com");
        Empleado u5 = new Empleado(); u5.setId(55); u5.setNombre("Zac"); u5.setDepartamento("Tic"); u5.setEmail("sac@si.com");
        Empleado u6 = new Empleado(); u6.setId(77); u6.setNombre("Roberto"); u6.setDepartamento("Marketing"); u6.setEmail("rrbort@hotmail.com");
        Empleado u7 = new Empleado(); u7.setId(31); u7.setNombre("Messi"); u7.setDepartamento("Ventas"); u7.setEmail("goat@hotmail.com");
        Empleado u8 = new Empleado(); u8.setId(30); u8.setNombre("Curry"); u8.setDepartamento("Ventas"); u8.setEmail("3shoot@gmail.com");
        Empleado u9 = new Empleado(); u9.setId(6); u9.setNombre("Lebron"); u9.setDepartamento("Logistica"); u9.setEmail("king@nba.com");
        Empleado u10 = new Empleado(); u10.setId(43); u10.setNombre("Giannis"); u10.setDepartamento("Marketing"); u10.setEmail("freak@buck.com");
        Atributo[] listaEmpleados = new Atributo[10];
        listaEmpleados[0] = u1;
        listaEmpleados[1] = u2;
        listaEmpleados[2] = u3;
        listaEmpleados[3] = u4;
        listaEmpleados[4] = u5;
        listaEmpleados[5] = u6;
        listaEmpleados[6] = u7;
        listaEmpleados[7] = u8;
        listaEmpleados[8] = u9;
        listaEmpleados[9] = u10;
        return listaEmpleados;
    }

    public Atributo[] generarAsistencias(){
        Date d1 = new Date(116, Calendar.JUNE,-1);
        Asistencia a1 = new Asistencia(); a1.setId(21); a1.setEmpleado("Jorge"); a1.setFecha(d1);
        Date d2 = new Date(114, Calendar.OCTOBER,3);
        Asistencia a2 = new Asistencia(); a2.setId(43); a2.setEmpleado("Miguel"); a2.setFecha(d2);
        Date d3 = new Date(114, Calendar.DECEMBER,4);
        Asistencia a3 = new Asistencia(); a3.setId(1); a3.setEmpleado("Marcos"); a3.setFecha(d3);
        Date d4 = new Date(121, Calendar.APRIL,5);
        Asistencia a4 = new Asistencia(); a4.setId(243); a4.setEmpleado("Moises"); a4.setFecha(d4);
        Date d5 = new Date(110, Calendar.SEPTEMBER,-1);
        Asistencia a5 = new Asistencia(); a5.setId(2143); a5.setEmpleado("Andres"); a5.setFecha(d5);
        Date d6 = new Date(108, Calendar.AUGUST,0);
        Asistencia a6 = new Asistencia(); a6.setId(432); a6.setEmpleado("Ximena"); a6.setFecha(d6);
        Date d7 = new Date(101, Calendar.APRIL,3);
        Asistencia a7 = new Asistencia(); a7.setId(4); a7.setEmpleado("Rosa"); a7.setFecha(d7);
        Date d8 = new Date(120, Calendar.MARCH,2);
        Asistencia a8 = new Asistencia(); a8.setId(54); a8.setEmpleado("Yanely"); a8.setFecha(d8);
        Date d9 = new Date(123, Calendar.AUGUST,4);
        Asistencia a9 = new Asistencia(); a9.setId(215); a9.setEmpleado("Lucero"); a9.setFecha(d9);
        Date d10 = new Date(114, Calendar.JULY,-1);
        Asistencia a10 = new Asistencia(); a10.setId(545324); a10.setEmpleado("Carla"); a10.setFecha(d10);
        Atributo[] listaAsistencias = new Atributo[10];
        listaAsistencias[0] = a1;
        listaAsistencias[1] = a2;
        listaAsistencias[2] = a3;
        listaAsistencias[3] = a4;
        listaAsistencias[4] = a5;
        listaAsistencias[5] = a6;
        listaAsistencias[6] = a7;
        listaAsistencias[7] = a8;
        listaAsistencias[8] = a9;
        listaAsistencias[9] = a10;
        return listaAsistencias;
    }
}
