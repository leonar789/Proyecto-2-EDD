/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clases;

import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import estructuras.ArbolAVL;
import clases.Cliente;
import clases.Habitacion;
import estructuras.HashTable;
import estructuras.ListaDoble;
import estructuras.NodoDoble;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Jose Gabriel
 */
public class GestorArchivos {
    private BufferedReader lector;
    private String linea;
    private String partes[] = null;
    /**
     * @param archivo
     * @param tema
     * @param copia
     * @return 
     * @throws java.io.IOException
     */
    
    
    //se encarga del cargado de la información desde los csv
    public ListaDoble hacerLista(String archivo, String tema) throws IOException {
        try{
            ListaDoble lista = new ListaDoble();
            lector = new BufferedReader(new FileReader(archivo));
            while((linea = lector.readLine())!= null){
                partes = linea.split(",");
                switch (tema) {
                    case "reserva" -> lista.append(new Cliente(Integer.parseInt(partes[0]), partes[1], partes[2], partes[3], partes[4], partes[6], partes[7], partes[8], partes[5]));
                    case "historico" -> lista.append(new Cliente(Integer.parseInt(partes[0]), partes[1], partes[2], partes[3], partes[4], partes[8], partes[5], partes[7], Integer.parseInt(partes[6])));
                    case "estado" -> lista.append(new Cliente(Integer.parseInt(partes[7]), partes[1], partes[2], partes[3], partes[4], partes[5], partes[6], null, Integer.parseInt(partes[0])));
                    case "habitacion" -> lista.append(new Habitacion(Integer.parseInt(partes[0]), partes[1], Integer.parseInt(partes[2])));
                    default -> {
                    }
                }

            }
            lector.close();
            linea = null;
            partes = null;
            return lista;
        }catch(FileNotFoundException e){
            System.out.println("ERROR");
            return null;
        }
    }
    //funcion que permite construir un arbol a partir de una lista
    public ArbolAVL hacerArbol(ListaDoble nuevo_arbol){
        NodoDoble primero = nuevo_arbol.getFirstNodo();
        ArbolAVL arbol = new ArbolAVL();
        while(primero != null){
            arbol.insertar(primero.get());
            primero = primero.nNext();
        }
        return arbol;
    }
    //se emplea para refrescar el condenido de la base de datos
    public void Vaciado(String archivo) throws FileNotFoundException, IOException, CsvValidationException{
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
            bw.write("");
            bw.close();
        }catch(IOException e){
            
        }
    }  
    //permite guardar los cambios en los csv
    public void Guardar(String archivo, ListaDoble info, String tema){
        try{
            NodoDoble nodo = info.getFirstNodo();
            CSVWriter escribir = new CSVWriter(new FileWriter(archivo),CSVWriter.DEFAULT_SEPARATOR,CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.NO_ESCAPE_CHARACTER,CSVWriter.DEFAULT_LINE_END);
            while(nodo != null){
                switch (tema) {
                    case "estado" ->                         {
                            Cliente cliente = (Cliente) nodo.get();
                            String a[] = new String[]{String.valueOf(cliente.getHabitacion()) +","+ cliente.getNombre()+","+cliente.getApellido()+","+cliente.getEmail()+","+cliente.getGenero()+","+cliente.getCelular()+","+cliente.getFechaLlegada()+","+String.valueOf(cliente.getCedula())};
                            escribir.writeNext(a);
                            nodo = nodo.nNext();
                        }
                    case "reservas" ->                         {
                            Cliente cliente = (Cliente) nodo.get();
                            String a[] = new String[]{String.valueOf(cliente.getCedula())+","+ cliente.getNombre()+","+  cliente.getApellido()+","+ cliente.getEmail()+","+  cliente.getGenero()+","+  cliente.getTipoHabitacion()+","+ cliente.getCelular()+","+  cliente.getFechaLlegada()+","+  cliente.getFechaSalida()};
                            escribir.writeNext(a);
                            nodo = nodo.nNext();
                        }
                    case "historico" ->                         {
                            Cliente cliente = (Cliente) nodo.get();
                            String a[] = new String[]{String.valueOf(cliente.getCedula())+","+ cliente.getNombre()+","+  cliente.getApellido()+","+ cliente.getEmail()+","+  cliente.getGenero()+","+  cliente.getFechaLlegada()+","+ String.valueOf(cliente.getHabitacion())+","+  cliente.getFechaSalida()+","+  cliente.getCelular()};
                            escribir.writeNext(a);
                            nodo = nodo.nNext();  
                        }
                    case "habitaciones" ->                         {
                            Habitacion habitaciones = (Habitacion) nodo.get();
                            String a[] = new String[]{String.valueOf(habitaciones.getNumHab())+","+ habitaciones.getTipo()+","+ String.valueOf(habitaciones.getPiso())};
                            escribir.writeNext(a);
                            nodo = nodo.nNext();
                        }
                    default -> {
                    }
                }
            }
            escribir.close();
        }catch(IOException e){
            
        }
        
    }
    
    
    
}
