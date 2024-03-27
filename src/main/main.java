/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import com.opencsv.exceptions.CsvValidationException;
import frames.VentanaPrincipal;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Leonardo
 */
public class main {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.io.FileNotFoundException
     * @throws com.opencsv.exceptions.CsvValidationException
     */
    public static void main(String[] args) throws IOException, FileNotFoundException, CsvValidationException {
        VentanaPrincipal frame= new VentanaPrincipal();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        //ListaDoble huespedes = ((Habitacion) habitaciones.getRaiz().get()).getHistorial();
        //NodoDoble huesped = huespedes.getFirstNodo();
        //while (huesped != null) {
         //   System.out.println(((Cliente) huesped.get()).toString());
         //   huesped = huesped.nNext();
        //}
        //reservas.inOrder(reservas.getRaiz());
        //System.out.println(reservas.buscar(13032602, reservas.getRaiz()).toString());
        //ls.Vaciado("./src/db/Histórico.csv");
        //ls.Vaciado("./src/db/estado.csv");
        //ls.Vaciado("./src/db/reservas.csv");
        //ls.Guardar("./src/db/estado.csv", listaEstado, "estado");
        //ls.Guardar("./src/db/Histórico.csv", listaHistorico, "historico");
        //ls.Guardar("./src/db/reservas.csv", listaReservas, "reservas");
        /*
        JavaApplication2 ls = new JavaApplication2();
        ListaDoble listaReservas = ls.hacerLista("./src/db/reservas.csv", "reserva"), listaHistorico = ls.hacerLista("./src/db/Histórico.csv", "historico"), listaHabitaciones = ls.hacerLista("./src/db/habitaciones.csv", "habitacion"), listaEstado = ls.hacerLista("./src/db/estado.csv", "estado");
        listaHabitaciones.EstadoHistorico(listaEstado, listaHistorico);
        ArbolAVL habitaciones = ls.hacerArbol(listaHabitaciones);
        Habitacion aver = (Habitacion) habitaciones.buscar(23, habitaciones.getRaiz());
        System.out.println(aver.getOcupante().getNombre());
        HashTable prueba = listaEstado.hacerHash();
        ListaDoble individuo = prueba.Buscar("Rufus", "Pesselt");
        System.out.println(((Cliente) individuo.getFirstNodo().get()).getCedula());
        ls.CheckOut((Cliente) individuo.getFirstNodo().get(), prueba, listaHistorico, habitaciones, listaEstado
        */
    }
    
}
