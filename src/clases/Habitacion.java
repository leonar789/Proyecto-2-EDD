/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import estructuras.ListaDoble;

/**
 *
 * @author Leonardo
 */
public class Habitacion {
    private int numHab;
    private String tipo;
    private int piso;
    private Cliente ocupante;
    private ListaDoble<Cliente> historial;
    
    public Habitacion(int numHab, String tipo, int piso){
        this.piso=piso;
        this.numHab=numHab;
        this.tipo=tipo;
        this.ocupante=null;
        this.historial=new ListaDoble();
    }
    public void setOcupante(Cliente nCliente){
        this.ocupante=nCliente;
    }
    
    public Cliente getOcupante(){
        return this.ocupante;
    } 
    
    public ListaDoble getHistorial(){
        return this.historial;
    } 
    
    public int getPiso(){
        return this.piso;
    }
    public int getNumHab(){
        return this.numHab;
    }
    public String getTipo(){
        return this.tipo;
    }
    public void agregarAlHistorial(Cliente cliente){
        this.historial.append(cliente);
    }
    
    public String toString(){
        return this.tipo+" - "+this.piso;
    }
}
