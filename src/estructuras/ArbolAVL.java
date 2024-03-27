/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

import clases.Habitacion;

/**
 *
 * @author Leonardo
 */
public class ArbolAVL<T> {
    private NodoArbolAVL<T> raiz;

    public ArbolAVL() {
        this.raiz = null;
    }
    
    //a continuación, getters y setters
    public NodoArbolAVL getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoArbolAVL root) {
        this.raiz = root;
    }
   
    public boolean esVacio(){
        return raiz == null;  
       
    }
   
    public NodoArbolAVL getMin(NodoArbolAVL nodo){
        if (esVacio()){
            return null;
        }
        while(nodo.getHijoIzq() != null){
            nodo = nodo.getHijoIzq();
        }
        return nodo;
    }
   
     public NodoArbolAVL getMax(NodoArbolAVL nodo){
        if (esVacio()){
            return null;
        }
        while(nodo.getHijoDer()!= null){
            nodo = nodo.getHijoDer();
        }
        return nodo;
    }
     
    public NodoArbolAVL getMaxandDelete(NodoArbolAVL nodo){
        if (esVacio()){
            return null;
        }
        while(nodo.getHijoDer().getHijoDer()!= null){
            nodo = nodo.getHijoDer();
        }
        NodoArbolAVL temp = nodo.getHijoDer();
        nodo.setHijoDer(null);
        return temp;
    }
    
    //llamada a la funcion insertar
    public void insertar(Object element){
        NodoArbolAVL<T> nodo = new NodoArbolAVL(element);
        setRaiz(insertar(nodo, this.getRaiz()));
    }
    //funcion que insera un elemento en el arlbol como una hoja
    public NodoArbolAVL insertar(NodoArbolAVL newnodo, NodoArbolAVL root) {
        if (root == null){
            return newnodo;
        } else if (newnodo.getkey() > root.getkey()){
            root.setHijoDer(insertar(newnodo, root.getHijoDer()));
        } else if (newnodo.getkey() < root.getkey()) {
            root.setHijoIzq(insertar(newnodo, root.getHijoIzq()));
        }else {
            return newnodo;
        }
        actualizarAltura(root);
        return rotacion(root);
    }
    
    //llamada a la funcion borrar
    public void borrar(int key) {
        setRaiz(borrar(key, ArbolAVL.this.getRaiz()));
    }
    
    //funcion que se encarga de borrar un nodo de la lista.
    public NodoArbolAVL borrar(int key, NodoArbolAVL nodo){
        if (nodo == null) {
            return null;
        }else if (key > nodo.getkey()){
            nodo.setHijoDer(borrar (key, nodo.getHijoDer()));
        }else if (key < nodo.getkey()) {
            nodo.setHijoIzq(borrar (key, nodo.getHijoIzq()));
        } else {
            //Caso 1. tiene un solo hijo
            if (nodo.getHijoIzq() == null) {
                return nodo.getHijoDer();
            } else if (nodo.getHijoDer() == null) {
                return nodo.getHijoIzq();
            }
            //Caso 2. tiene dos hijos
            NodoArbolAVL replacement = getMaxandDelete(nodo.getHijoIzq());
            replacement.setHijoDer(nodo.getHijoDer());
            replacement.setHijoIzq(nodo.getHijoIzq());
            if (this.getRaiz().getkey() == key){
                setRaiz(replacement);
            }
            nodo = replacement;
        }
       
        actualizarAltura(nodo);
        return rotacion(nodo);
    }
    
    //devuelve la altura de un nodo
    public int altura(NodoArbolAVL nodo){
        return nodo!= null ? nodo.getAltura() :0;
    }
    
    //permite actualizar la altura de un nodo
    public void actualizarAltura (NodoArbolAVL nodo){
        int maxHeight = Math.max(altura(nodo.getHijoIzq()), altura(nodo.getHijoDer()));
        nodo.setAltura(maxHeight + 1);
    }
    
    //funcion que verifica si un nodo necesita rotar
    public NodoArbolAVL rotacion (NodoArbolAVL nodo) {
        int bf = factorEquilibrio(nodo);
        //Case 1: left heavy
        if (bf > 1){
            if (factorEquilibrio(nodo.getHijoIzq()) < 0){
                nodo.setHijoIzq(rotarIzquierda(nodo.getHijoIzq()));
            }
            return rotarDerecha(nodo);
           
        }// Case 2: right heavy
        else if (bf < -1) {
            if (factorEquilibrio(nodo.getHijoDer()) > 0){
                nodo.setHijoDer(rotarDerecha(nodo.getHijoDer()));
            }
            return rotarIzquierda(nodo);
        }
        return nodo;
    }
    
    //verifica que un nodo está en equilibrio restando las alturas de sus hijos
    public int factorEquilibrio (NodoArbolAVL nodo){
        return nodo != null ? altura(nodo.getHijoIzq()) - altura(nodo.getHijoDer()) : 0;
       
    }
    
    //rotacion simple a la derecha
    public NodoArbolAVL rotarDerecha(NodoArbolAVL nodo){
        NodoArbolAVL left = nodo.getHijoIzq();
        NodoArbolAVL leftright = left.getHijoDer();
        left.setHijoDer(nodo);
        nodo.setHijoIzq(leftright);
        actualizarAltura(nodo);
        actualizarAltura (left);
        return left;
    }
    
    //rotacion simple a la izquierda
    public NodoArbolAVL rotarIzquierda (NodoArbolAVL nodo){
        NodoArbolAVL right = nodo.getHijoDer();
        NodoArbolAVL rightleft = right.getHijoIzq();
        right.setHijoIzq(nodo);
        nodo.setHijoDer(rightleft);
        actualizarAltura(nodo);
        actualizarAltura (right);
        return right;
    }
    
    //busqueda en el Arbol AVL
    public Object buscar (int key, NodoArbolAVL root){
        if (root == null) {
            return null;
        }
        if (key > root.getkey()){
            return buscar(key, root.getHijoDer());
        }else if (key < root.getkey()) {
            return buscar(key, root.getHijoIzq());
        }else {
            return root.get();
        }
        
    }
    //recorrido inOrder para verificar que se construyó correctamente el arbol
    public void inOrder(NodoArbolAVL root) {
        if (root!= null){
            inOrder(root.getHijoIzq());
            System.out.println(root.getkey() + " - "+root.get().toString());
            inOrder(root.getHijoDer());
        }
    }
   
}
   
 

