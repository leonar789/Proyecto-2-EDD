/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

/**
 *
 * @author Leonardo
 */
public class Cliente {

    private int cedula;
    private String nombre;
    private String apellido;
    private String email;
    private String genero;
    private String celular;
    private String fechaLlegada;
    private String fechaSalida;
    private int habitacion;
    private String tipoHabitacion;
    private String nombreCompleto;

    //constructor empleado para la creación de clientes alojados ya en el hotel o que pertenecen al histórico
    public Cliente(int cedula, String nombre, String apellido, String email, String genero, String celular, String fechaLlegada, String fechaSalida, int habitacion) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.genero = genero;
        this.celular = celular;
        this.fechaLlegada = fechaLlegada;
        this.fechaSalida = fechaSalida;
        this.habitacion = habitacion;
        this.nombreCompleto = nombre + " " + apellido;
    }

    //constructor empleado para la creación de reservas
    public Cliente(int cedula, String nombre, String apellido, String email, String genero, String celular, String fechaLlegada, String fechaSalida, String tipoHabitacion) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.genero = genero;
        this.celular = celular;
        this.fechaLlegada = fechaLlegada;
        this.fechaSalida = fechaSalida;
        this.tipoHabitacion = tipoHabitacion;
        this.nombreCompleto = nombre + " " + apellido;
    }

    public int getCedula() {
        return this.cedula;
    }

    public int getHabitacion() {
        return this.habitacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public String getGenero() {
        return genero;
    }

    public String getCelular() {
        return celular;
    }

    public String getFechaLlegada() {
        return fechaLlegada;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String toString() {
        return this.nombreCompleto;
    }

}
