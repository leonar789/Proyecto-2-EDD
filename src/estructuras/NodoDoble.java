/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

/**
 *
 * @author Leonardo
 */
public class NodoDoble<T> {
    private T contenido;
    private NodoDoble<T> next;
    private NodoDoble<T> prev;
    
    public NodoDoble(T contenido){
        this.contenido=contenido;
        this.next=null;
        this.prev=null;
    }
    
    //retorna el siguiente nodo
    public NodoDoble<T> nNext (){
        return this.next;
    }
    
    //retorna el nodo anterior
    public NodoDoble<T> nPrev(){
        return this.prev;
    }
    
    //permite modificar el contenido de un nodo
    public void setData(T data){
        this.contenido=data;
    }
    
    //permite indicar cual es el siguiente nodo
    public void setNext(NodoDoble<T> pNext){
        this.next=pNext;
    }
    
    //permite indicar cual es el nodo anterior
    public void setPrev(NodoDoble<T> pPrev){
        this.prev=pPrev;
    }
    
    //retorna el contenido del nodo
    public T get(){
        return this.contenido;
    }
}
