/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import com.opencsv.exceptions.CsvValidationException;
import estructuras.ArbolAVL;
import estructuras.Cliente;
import estructuras.Habitacion;
import estructuras.ListaDoble;
import estructuras.NodoDoble;
import java.io.FileNotFoundException;
import java.io.IOException;
import proyecto.pkg2.edd.JavaApplication2;

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
        JavaApplication2 ls = new JavaApplication2();
        ListaDoble listaReservas = ls.hacerLista("C:\\Users\\Jose Gabriel\\Downloads\\reservas.csv", "reserva", false), listaHistorico = ls.hacerLista("C:\\Users\\Jose Gabriel\\Downloads\\Histórico.csv", "historico", false), listaEstado = ls.hacerLista("C:\\Users\\Jose Gabriel\\Downloads\\estado.csv", "estado", false), listaHabitaciones = ls.hacerLista("C:\\Users\\Jose Gabriel\\Downloads\\habitaciones.csv", "habitacion", false);
        listaHabitaciones.EstadoHistorico(listaEstado, listaHistorico);
        ArbolAVL reservas = ls.hacerArbol(listaReservas);
        ArbolAVL habitaciones = ls.hacerArbol(listaHabitaciones);
        ListaDoble huespedes = ((Habitacion) habitaciones.getRaiz().get()).getHistorial();
        NodoDoble huesped = huespedes.getFirstNodo();
        while (huesped != null) {
            System.out.println(((Cliente) huesped.get()).toString());
            huesped = huesped.nNext();
        }
        //ls.Vaciado("C:\\Users\\Jose Gabriel\\Downloads\\estado - copia.csv");
        //ls.Vaciado("C:\\Users\\Jose Gabriel\\Downloads\\Histórico - copia.csv");
        //ls.Vaciado("C:\\Users\\Jose Gabriel\\Downloads\\reservas - copia.csv");
        //ls.Vaciado("C:\\Users\\Jose Gabriel\\Downloads\\habitaciones - copia.csv");
        //ls.Guardar("C:\\Users\\Jose Gabriel\\Downloads\\estado - copia.csv", listaEstado, "estado");
        //ls.Guardar("C:\\Users\\Jose Gabriel\\Downloads\\Histórico - copia.csv", listaHistorico, "historico");
        //ls.Guardar("C:\\Users\\Jose Gabriel\\Downloads\\reservas - copia.csv", listaReservas, "reservas");
        //ls.Guardar("C:\\Users\\Jose Gabriel\\Downloads\\habitaciones - copia.csv", listaHabitaciones, "habitaciones");
    }
    
}
