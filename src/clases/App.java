/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;


import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;

import estructuras.HashTable;
import estructuras.ArbolAVL;
import estructuras.ListaDoble;
import estructuras.NodoDoble;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;



/**
 *
 * @author Leonardo
 */
public class App {
    public static GestorArchivos ls;
    public static ListaDoble listaReservas;
    public static ListaDoble listaHistorico;
    public static ListaDoble listaEstado;
    public static ListaDoble listaHabitaciones;
    public static ArbolAVL reservas;
    public static ArbolAVL habitaciones;
    public static ArbolAVL estado;
    public static HashTable hash;
    
    
    //clase de propósitos múltiples. Aqui se guarda la información que se muestra en la interfáz
    public App() throws IOException{
        ls = new GestorArchivos();
        listaReservas = ls.hacerLista("./src/db/reservas.csv", "reserva");
        listaHistorico = ls.hacerLista("./src/db/Histórico.csv", "historico");
        listaEstado = ls.hacerLista("./src/db/estado.csv", "estado");
        listaHabitaciones = ls.hacerLista("./src/db/habitaciones.csv", "habitacion");
        listaHabitaciones.EstadoHistorico(listaEstado, listaHistorico);
        reservas = ls.hacerArbol(listaReservas);
        habitaciones = ls.hacerArbol(listaHabitaciones);
        hash = listaEstado.hacerHash();
        ListaDoble huespedes = ((Habitacion) habitaciones.getRaiz().get()).getHistorial();
        
    }
    //permite obtener el histórico de una habitación
    public static ListaDoble getHistorico(int nHab){
        Habitacion hab=(Habitacion)App.habitaciones.buscar(nHab, App.habitaciones.getRaiz());
        if (hab==null){
            return null;
        }
        return hab.getHistorial();
    }
    
    //se llama a esta función cuando se cierra el programa para guardar la información nueva
    public static void Guardar() throws IOException, FileNotFoundException, CsvValidationException{
        ls.Vaciado("./src/db/Histórico.csv");
        ls.Vaciado("./src/db/estado.csv");
        ls.Vaciado("./src/db/reservas.csv");
        ls.Guardar("./src/db/estado.csv", listaEstado, "estado");
        ls.Guardar("./src/db/Histórico.csv", listaHistorico, "historico");
        ls.Guardar("./src/db/reservas.csv", listaReservas, "reservas");
    }
    
    
    //funcion que permite extraer a alguien del listado de Estado e introducirlo en el arbol AVL de habitaciones
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
                clientico.setNumHab(numHab);
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
        JOptionPane.showInternalMessageDialog(null, "Check Out realizado correctamente", "Hasta la próxima", JOptionPane.INFORMATION_MESSAGE);

    }
    
    //funcion empleada para evitar que el usuario tenga que incluir las mayúsculas al buscar un nombre
    public static String capitalize(String valor) {
    if (valor == null || valor.isEmpty()) {
        return valor;
    } else {
        if (valor.length()>=3){
            if (valor.substring(0, 2).toLowerCase().equals("mc")){
  
                return valor.toUpperCase().charAt(0)+""+valor.toLowerCase().charAt(1)+""+valor.toUpperCase().charAt(2) + valor.substring(3, valor.length()).toLowerCase();
            }
        }
        return  valor.toUpperCase().charAt(0) + valor.substring(1, valor.length()).toLowerCase();
        
    }
    }
    
    //funcion que elimina un elemento del arbol AVL de Reservas y lo introduce en la Hash Table de estado
    public static boolean checkIn(int cedula){
        Cliente cliente = (Cliente)reservas.buscar(cedula, reservas.getRaiz());
        int disponible =0;
        NodoDoble auxHab=listaHabitaciones.getFirstNodo();
        while (auxHab!=null){
            if (((Habitacion)auxHab.get()).getTipo().equals(cliente.getTipoHabitacion()) && ((Habitacion)auxHab.get()).getOcupante()==null){
                break;
            }
            auxHab=auxHab.nNext();
        }
        if (auxHab==null){
            JOptionPane.showInternalMessageDialog(null, "No hay ninguna habitación "+cliente.getTipoHabitacion()+" disponible actualmente", "No hay Disponibilidad", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        else{
            App.listaReservas.deleteByKey(cliente);
            App.reservas=ls.hacerArbol(listaReservas);
            App.reservas.inOrder(reservas.getRaiz());
            ((Habitacion)auxHab.get()).setOcupante(cliente);
            cliente.setNumHab(((Habitacion)auxHab.get()).getNumHab());
            App.hash.Insertar(cliente);
            NodoDoble aux=listaEstado.getFirstNodo();
            int posicion=0;
            while (((Cliente)aux.get()).getHabitacion()<((Habitacion)auxHab.get()).getNumHab()){
                posicion++;
                aux=aux.nNext();
            }
            App.listaEstado.insertarPorIndice(cliente, posicion);
            JOptionPane.showInternalMessageDialog(null, "Encantados de recibirlo. Su número de habitación es: "+((Habitacion)auxHab.get()).getNumHab(), "Bienvenido", JOptionPane.INFORMATION_MESSAGE);
            return true;
        }
        
        
    }
}
