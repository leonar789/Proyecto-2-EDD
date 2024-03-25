/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import estructuras.ArbolAVL;
import estructuras.Cliente;

/**
 *
 * @author Leonardo
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArbolAVL arbol=new ArbolAVL();
        for(int i=0; i<100; i++){
            Cliente a= new Cliente((int)Math.floor(Math.random()*10000),"carlos","carlos","carlos","carlos","carlos","carlos","carlos","carlos");
            arbol.insertar(a);
        }
        Cliente c= new Cliente(1234,"josefa","Dominga","carlos","carlos","carlos","carlos","carlos","carlos");
        arbol.insertar(c);
        arbol.inOrder(arbol.getRaiz());
        arbol.borrar(1234);
        arbol.inOrder(arbol.getRaiz());
    }
    
}
