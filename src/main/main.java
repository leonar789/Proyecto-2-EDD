/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import com.opencsv.exceptions.CsvValidationException;
import estructuras.ArbolAVL;
import clases.Cliente;
import clases.Habitacion;
import estructuras.ListaDoble;
import estructuras.NodoDoble;
import frames.VentanaPrincipal;
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
    }
    
}
