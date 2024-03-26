/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

import clases.Habitacion;
import clases.Cliente;

/**
 *
 * @author Leonardo
 */
public class NodoArbolAVL<T> {
    private T contenido;
    private NodoArbolAVL hijoIzquierdo;
    private NodoArbolAVL hijoDerecho;
    private int altura;
    private int key;
    public NodoArbolAVL (T info){
        this.contenido=info;
        this.altura=1;
        this.hijoDerecho=null;
        this.hijoIzquierdo=null;
        if (info instanceof Cliente){
            this.key=((Cliente) info).getCedula();
        }
        else if (info instanceof Habitacion){
            this.key=((Habitacion) info).getNumHab();
        }
    }
    public int getkey(){
        return this.key;
    }
    public NodoArbolAVL getHijoIzq(){
        return this.hijoIzquierdo;
    }
    public NodoArbolAVL getHijoDer(){
        return this.hijoDerecho;
    }
    public void setHijoDer(NodoArbolAVL n){
         this.hijoDerecho=n;
    }
    public void setHijoIzq(NodoArbolAVL n){
        this.hijoIzquierdo=n;
    }
    public int getAltura(){
        return this.altura;
    }
    public void setAltura(int nH){
        this.altura=nH;
    }

    public T get() {
        return this.contenido;
    }
    
    
}
