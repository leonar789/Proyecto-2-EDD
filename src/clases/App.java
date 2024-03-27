/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import com.mycompany.hola2.HashTable;
import estructuras.ArbolAVL;
import estructuras.ListaDoble;
import estructuras.NodoDoble;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    public static HashTable hash;
                    
    public App() throws IOException{
        ls = new JavaApplication2();
        listaReservas = ls.hacerLista("./src/db/reservas.csv", "reserva");
        listaHistorico = ls.hacerLista("./src/db/Histórico.csv", "historico");
        listaEstado = ls.hacerLista("./src/db/estado.csv", "estado");
        listaHabitaciones = ls.hacerLista("./src/db/habitaciones.csv", "habitacion");
        listaHabitaciones.EstadoHistorico(listaEstado, listaHistorico);
        reservas = ls.hacerArbol(listaReservas);
        habitaciones = ls.hacerArbol(listaHabitaciones);
        estado = ls.hacerArbol(listaEstado);
        hash = listaEstado.hacerHash();
        ListaDoble huespedes = ((Habitacion) habitaciones.getRaiz().get()).getHistorial();
        
    }
    public static ListaDoble getHistorico(int nHab){
        Habitacion hab=(Habitacion)App.habitaciones.buscar(nHab, App.habitaciones.getRaiz());
        return hab.getHistorial();
    }
    
    public static void CheckOut(int cedula, String nombre, String apellido){
        
        ListaDoble hashy = hash.Buscar(nombre, apellido);
        NodoDoble cli = hashy.getFirstNodo();
        while(cli != null){
            if(((Cliente) cli.get()).getCedula() == cedula){
                break;                
            }
            cli = cli.nNext();
        }
        int numHab = ((Cliente) cli.get()).getHabitacion();
        NodoDoble historia = listaHistorico.getFirstNodo();
        NodoDoble estaba = listaEstado.getFirstNodo();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while(((Cliente) historia.get()).getHabitacion() < numHab){
            historia = historia.nNext();
        }
        while(((Cliente) estaba.get()).getCedula() != cedula){
            estaba = estaba.nNext();
        }
        Cliente clientico = null;
        while(cli != null){
            if(((Cliente) cli.get()).getHabitacion() == numHab){
                Cliente objeto = (Cliente) cli.get();
                clientico = new Cliente(objeto.getCedula(),objeto.getNombre(),objeto.getApellido(), objeto.getEmail(), objeto.getGenero(),objeto.getCelular(), objeto.getFechaLlegada(), LocalDate.now().format(dateTimeFormatter), objeto.getCelular());
                NodoDoble nuevo_historia= new NodoDoble(clientico);
                listaEstado.delete(estaba);
                hash.Eliminar((Cliente) cli.get());
                nuevo_historia.setPrev(historia);
                nuevo_historia.setNext(historia.nNext());
                (historia.nNext()).setPrev(nuevo_historia);
                historia.setNext(nuevo_historia);
            }
            cli = cli.nNext();
        }
        Habitacion habitacion = (Habitacion) habitaciones.buscar(numHab, habitaciones.getRaiz());
        habitacion.agregarAlHistorial(clientico);
        habitacion.setOcupante(null);
    }        
    
}
