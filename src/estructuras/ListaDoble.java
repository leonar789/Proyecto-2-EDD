/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

/**
 *
 * @author Leonardo
 */
public class ListaDoble<T> {
     private NodoDoble<T> pFirst;
    private NodoDoble<T> pLast;
    private int len;
    public ListaDoble(){
        this.pFirst=null;
        this.len=0;
        this.pLast=null;
    }

    //verifica que una lista no esté vacia
    public boolean esVacia() {
        return this.pFirst==null;
    }
    
    //método para optener el  primer nodo
    public NodoDoble<T> getFirstNodo(){
        return pFirst;
    }
    
    //método para optener el contenido del primer nodo
    public T getPrimero() {
        return pFirst.get();
    }
    
    //método para optener el contenido del último nodo
    public T getFinal() {
        return pLast.get();
    }

    //método que retorna null
    public T Ultimo() {
         return null;
    }

    //agrega elementos a una lista
    public void append(T nuevo) {
        NodoDoble<T> nNodo=new NodoDoble(nuevo);
        if (pFirst==Ultimo()){
            pFirst=nNodo;
            pLast=nNodo;
         
        }
        else{
            pLast.setNext(nNodo);
            nNodo.setPrev(pLast);
            pLast=nNodo;

           
        }
        len++;
    }


    //busca un nodo por indice
    public NodoDoble<T> searchByIndex(int n) {
        if (len-1<n){
            return null;
            
        }
        else{
            int i=0;
            NodoDoble<T> valor;
            if (n<=this.getLen()-1){
                valor= pFirst;
                while (i!=n){
                valor=valor.nNext();
                i++;
                }
            }
            else{
                n=this.getLen()-1-n;
                valor= pLast;
                while (i!=n){
                valor=valor.nPrev();
                i++;
                }
            }
            return valor;
        }
    }
    

    //verifica si un elemento está presente en la lista
    public Boolean isPresent(T key) {
        NodoDoble<T> aux= pFirst;
        Boolean presente=false;
        while (aux!=Ultimo()){

            if(aux.get()==key){
                presente=true;
            }
            aux=aux.nNext();
        }
        return presente;
    }

    //permite obtener el nodo en el que se encuentra un determinado elemento
    public NodoDoble<T> searchByKey(T key) {
        if (this.isPresent(key)){
            NodoDoble<T> valor= pFirst;
            while (valor.get()!=key){
                valor=valor.nNext();
            }
            return valor;
        }
        return null;
    }

    //devuelve el contenido de un nodo a partir de su indice
    public T getByIndex(int n) {
        if (n>=0 && n<this.getLen()){
            return this.searchByIndex(n).get();
        }
        else{
            System.out.println("Fuera de rango");
            return null;
        }
    }

    //borra el último de la lista
    public void deleteLastone() {
        if(this.pFirst == this.pLast && this.pFirst != null){
            this.pFirst = null;
            this.pLast = null;
            this.len--;
        }
        else if (!this.esVacia()){
            NodoDoble<T> aux= pLast.nPrev();
            aux.setNext(null);
            this.pLast=aux;
            len--;    
            }
    }

    //borra un nodo de la lista dado el nodo
    public void delete(NodoDoble<T> pNodo){
        if (pNodo==pFirst){
            deleteFirst();
        }
        else if (pNodo==pLast){
            deleteLastone();
        }
        else{
            pNodo.nNext().setPrev(pNodo.nPrev());
            pNodo.nPrev().setNext(pNodo.nNext());
            this.len--;
        }
        
    }

    //borra el primer nodo de la lista
    public void deleteFirst() {
        if (!esVacia()){
            if (pFirst.nNext()==null){
                pFirst=null;
                pLast=null;
            }
            else{
                pFirst.nNext().setPrev(null);
                this.pFirst=pFirst.nNext();
            }
            this.len--;
        }
    }
    
    
    //borra un elemento de la lista dado su indice
    public void deleteByIndex(int index) {
        if (index==0){
            this.deleteFirst();
        }
        else if (index==len-1){
            this.deleteLastone();
        }
        else if (index<len-1){
            NodoDoble<T> aux=this.searchByIndex(index);
            this.delete(aux);
        }
    }

    //borra un elemento de la lista dado su contenido
    public void deleteByKey(T key) {
        NodoDoble <T> aux= pFirst;
        
        while (aux!=null){
            if (aux.get()==key){
                this.delete(aux);
                }
            aux=aux.nNext();
            }
                
    } 
    
    //retorna el tamaño de la lista
    public int getLen() {
        return this.len;
    }
  
    public void EstadoHistorico(ListaDoble clientes, ListaDoble historicos) {
        NodoDoble cliente = clientes.getFirstNodo();
        while(cliente != null){
            int numero = ((Cliente) cliente.get()).getHabitacion();
            NodoDoble habitacion = this.getFirstNodo();
            while(habitacion != null){
                if(numero == ((Habitacion) habitacion.get()).getNumHab()){
                    ((Habitacion) habitacion.get()).setOcupante((Cliente) cliente.get());
                    break;
                }
                habitacion = habitacion.nNext();
            }
            cliente = cliente.nNext();
        }
        NodoDoble habitacion = this.getFirstNodo();
        while(habitacion != null){
            int numero = ((Habitacion) habitacion.get()).getNumHab();
            NodoDoble historico = historicos.getFirstNodo();
            while(historico != null){
                if(numero == ((Cliente) historico.get()).getHabitacion()){
                    ((Habitacion) habitacion.get()).agregarAlHistorial((Cliente) historico.get());
                }
                historico = historico.nNext();
            }
            habitacion = habitacion.nNext();
        }        
    }     
    
}
