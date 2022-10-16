package org.proyect;

import org.proyect.Modelos.Atributo;
import org.proyect.Modelos.Usuario.Empleado;
import org.proyect.Modelos.Asistencia;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class GenerarEmpleadosAsistencias {
    public static GenerarEmpleadosAsistencias SingletonInstance = null;

    private ArrayList<Atributo> listaEmpleadosArrayList = new ArrayList<>();
    private ArrayList<Atributo> listaAsistenciasArrayList = new ArrayList<>();

    public void actualizarListaEmpleados(ArrayList<Atributo> arrayList){
        this.listaEmpleadosArrayList = new ArrayList<>(arrayList);
    }
    public void actualizarListaAsistencias(ArrayList<Atributo> arrayList){
        this.listaAsistenciasArrayList = new ArrayList<>(arrayList);
    }
    private GenerarEmpleadosAsistencias() {
        //lista empleados
        listaEmpleadosArrayList.add(new Empleado(22694792, "Ingrid", "marta-c2002@gmail.com", "Ta1PIt12", "Marketing"));
        listaEmpleadosArrayList.add(new Empleado(23263756 , "Maritza ", "mailane43@gmail.com", "MIgLkWA1", "logistica"));
        listaEmpleadosArrayList.add(new Empleado(24743385, "Osvaldo", "iki_rojo@gmail.com", " H0RHoude", "ventas"));
        listaEmpleadosArrayList.add(new Empleado(25546888, "Camila", "Katty_magda20@gmail.com", "cHAR4gen", "Control Interno"));
        listaEmpleadosArrayList.add(new Empleado(26737523, "Ignacio", "Ibarra_32@gmail.com", "IDAZiRArS", "marketing"));
        listaEmpleadosArrayList.add(new Empleado(27599253, "Daniela", "daniela_aguilera@gmail.com", "RIStaBRiM", "Tic"));
        listaEmpleadosArrayList.add(new Empleado(28456322, "Andrea", "marissa-leo01@gmail.com", "andOsabiA", "Tic"));
        listaEmpleadosArrayList.add(new Empleado(32952649, "Paula", "Paula2002_farya@gmail.com", "isMASeria", "ventas"));
        listaEmpleadosArrayList.add(new Empleado(33343982, "Marily", "Mari10_edo@gmail.com", "APheATENg", "logistica"));
        listaEmpleadosArrayList.add(new Empleado(35545499, "Elizabeth", "elizabet39@gmail.com", "lFREsdape", "logistica"));
        listaEmpleadosArrayList.add(new Empleado(45799443, "Johanna", "joy_pao_@gmail.com", "MoPo41TAT", "Contabilidad"));
        listaEmpleadosArrayList.add(new Empleado(48482882, "Claudia", "claudia_bergez@gmail.com", "GheRmouTe", "ventas"));
        listaEmpleadosArrayList.add(new Empleado(58799654, "Sergio", "sergio_herrera2005@gmail.com", "EURsibUsi", "ventas"));
        listaEmpleadosArrayList.add(new Empleado(62965893, "Marcelo", "juan-Marc_21@gmail.com", " liC5ENVI", "Contabilidad"));
        listaEmpleadosArrayList.add(new Empleado(63465537, "Gianfranco", "ruli-andr0@gmail.com", "I08RGEnGU", "RR.HH"));
        listaEmpleadosArrayList.add(new Empleado(63587744, "Pablo", "pablo_0l44@gmail.com", "IreMORA", "ventas"));
        listaEmpleadosArrayList.add(new Empleado(64238493, "German", "campos_0fray@gmail.com", "SOnoWNEoP", "RR.HH"));
        listaEmpleadosArrayList.add(new Empleado(66474624, "Raul", "joaco-cordova@gmail.com", "tOrPERiCh", "ventas"));
        listaEmpleadosArrayList.add(new Empleado(69728459, "Ivan", "1calderon_SR@gmail.com", "RUgaRaxOT", "marketing"));
        listaEmpleadosArrayList.add(new Empleado(70426229, "Felipe", "dante_ol42@gmail.com", "shAmishOU", "Control Interno"));

        //lista asistencias
        listaAsistenciasArrayList.add(new Asistencia(11,"Maritza", new Date(116, Calendar.JUNE,-1)));
        listaAsistenciasArrayList.add(new Asistencia(22,"Felipe", new Date(114, Calendar.OCTOBER,3)));
        listaAsistenciasArrayList.add(new Asistencia(43,"Ingrid", new Date(115, Calendar.DECEMBER,4)));
        listaAsistenciasArrayList.add(new Asistencia(54,"Ivan", new Date(121, Calendar.APRIL,5)));
        listaAsistenciasArrayList.add(new Asistencia(65,"Osvaldo", new Date(110, Calendar.SEPTEMBER,-1)));
        listaAsistenciasArrayList.add(new Asistencia(76,"Raul", new Date(108, Calendar.AUGUST,8)));
        listaAsistenciasArrayList.add(new Asistencia(87,"Camila", new Date(101, Calendar.APRIL,10)));
        listaAsistenciasArrayList.add(new Asistencia(98,"German", new Date(120, Calendar.MARCH,12)));
        listaAsistenciasArrayList.add(new Asistencia(19,"Ignacio", new Date(123, Calendar.AUGUST,7)));
        listaAsistenciasArrayList.add(new Asistencia(15,"Pablo", new Date(114, Calendar.JULY,17)));
        listaAsistenciasArrayList.add(new Asistencia(21,"Daniela", new Date(118, Calendar.JANUARY,3)));
        listaAsistenciasArrayList.add(new Asistencia(32,"Gianfranco", new Date(113, Calendar.MAY,5)));
        listaAsistenciasArrayList.add(new Asistencia(43,"Andrea", new Date(111, Calendar.NOVEMBER,7)));
        listaAsistenciasArrayList.add(new Asistencia(14,"Marcelo", new Date(121, Calendar.APRIL,9)));
        listaAsistenciasArrayList.add(new Asistencia(25,"Paula", new Date(110, Calendar.SEPTEMBER,5)));
        listaAsistenciasArrayList.add(new Asistencia(36,"Sergio", new Date(118, Calendar.AUGUST,8)));
        listaAsistenciasArrayList.add(new Asistencia(27,"Marily", new Date(115, Calendar.FEBRUARY,10)));
        listaAsistenciasArrayList.add(new Asistencia(18,"Claudia", new Date(117, Calendar.MAY,12)));
        listaAsistenciasArrayList.add(new Asistencia(19,"Johanna", new Date(112, Calendar.AUGUST,14)));
        listaAsistenciasArrayList.add(new Asistencia(20,"Elizabeth", new Date(113, Calendar.OCTOBER,5)));
    }
    public static GenerarEmpleadosAsistencias singletonGenerador(){
        if(SingletonInstance == null){
            SingletonInstance = new GenerarEmpleadosAsistencias();
        }
        return SingletonInstance;
    }

    public ArrayList<Atributo> generarEmpleados(){
        return listaEmpleadosArrayList;
    }

    public ArrayList<Atributo> generarAsistencias(){
        return listaAsistenciasArrayList;
    }
}
