/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import estructuras.ArbolAVL;
import estructuras.ListaDoble;
import java.io.IOException;
import proyecto.pkg2.edd.JavaApplication2;

/**
 *
 * @author Leonardo
 */
public class App {
    public static JavaApplication2 ls;
    public static ListaDoble listaReservas;
    public static ListaDoble listaHistorico;
    public static ListaDoble listaEstado;
    public static ListaDoble listaHabitaciones;
    public static ArbolAVL reservas;
    public static ArbolAVL habitaciones;
    public static ArbolAVL estado;
                    
    public App() throws IOException{
        ls = new JavaApplication2();
        listaReservas = ls.hacerLista("./src/db/reservas.csv", "reserva", false);
        listaHistorico = ls.hacerLista("./src/db/Histórico.csv", "historico", false);
        listaEstado = ls.hacerLista("./src/db/estado.csv", "estado", false);
        listaHabitaciones = ls.hacerLista("./src/db/habitaciones.csv", "habitacion", false);
        listaHabitaciones.EstadoHistorico(listaEstado, listaHistorico);
        reservas = ls.hacerArbol(listaReservas);
        habitaciones = ls.hacerArbol(listaHabitaciones);
        estado = ls.hacerArbol(listaEstado);
        ListaDoble huespedes = ((Habitacion) habitaciones.getRaiz().get()).getHistorial();
        
    }
    public static ListaDoble getHistorico(int nHab){
        Habitacion hab=(Habitacion)App.habitaciones.buscar(nHab, App.habitaciones.getRaiz());
        return hab.getHistorial();
    }
    
}
