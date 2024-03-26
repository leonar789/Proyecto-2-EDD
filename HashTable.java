package com.mycompany.hola2;

//Creador de las Hash Tables colocar en el main
        //ListaDoble Tabla_Reserva[] = new ListaDoble[451];
        //ListaDoble Tabla_Huespedes[] = new ListaDoble[451];

// No eliminar la libreria algunos Strings los convierte en enteros negativos, el abs es valor absluto
import static java.lang.Math.abs;

public class HashTable <T> { 
    private NodoDoble<T> pFirst;
    private NodoDoble<T> pLast;
    private int len;
    public HashTable(){
        pFirst=null;
        len=0;
        pLast=null;
}
    public static void Insertar(ListaDoble[] Hash, Cliente cliente){
        NodoDoble x = new NodoDoble(cliente);
        Integer z = abs((((Cliente) x.contenido).nombre + ((Cliente) x.contenido).apellido).hashCode() % 449);
        ListaDoble aux = Hash[z];
        if (aux == null){
            ListaDoble aux2 = new ListaDoble();
            Hash[z] = aux2;
            Hash[z].append(x);
        }
        else{
            Hash[z].append(x);
        }
        }
    
    public static void Eliminar(ListaDoble[] Hash, Cliente cliente){
        NodoDoble x = new NodoDoble(cliente);
        int z = abs((((Cliente) x.contenido).nombre + ((Cliente) x.contenido).apellido).hashCode() % 449);
        NodoDoble aux = Hash[z].pFirst;
        NodoDoble aux2 = Hash[z].pLast;
        if (((NodoDoble) aux.contenido).contenido == cliente){
            Hash[z].deleteFirst();
        }
        else{
            if (((NodoDoble) aux2.contenido).contenido == cliente){
                Hash[z].deleteLastone();
            }
            else{
                Hash[z].delete(x);
            }
        }
    }
    
    public static void Buscar(ListaDoble[] y,String n, String a) {
        int z = abs((n + a).hashCode() % 449);
        ListaDoble aux = y[z];
        NodoDoble aux2 = aux.pFirst;
        while (aux2 != null){
            NodoDoble aux3 = (NodoDoble) aux2.contenido;
            if (((Cliente) aux3.contenido).nombre == n){
                if (((Cliente) aux3.contenido).apellido == a){
                    Imprimir((Cliente) aux3.contenido);
                }
            }
            aux2 = aux2.next;
        }
    }
    public static void Imprimir(Cliente x) {
        System.out.print("Nodo encontrado" + x.getCelular());
    }
}
    



