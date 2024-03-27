package com.mycompany.hola2;

//Creador de las Hash Tables colocar en el main
        //ListaDoble Tabla_Reserva[] = new ListaDoble[451];
        //ListaDoble Tabla_Huespedes[] = new ListaDoble[451];

// No eliminar la libreria algunos Strings los convierte en enteros negativos, el abs es valor absluto
import clases.Cliente;
import estructuras.ListaDoble;
import estructuras.NodoDoble;
import static java.lang.Math.abs;

public class HashTable <T> { 
    private ListaDoble[] arreglo;
    private int capacidad;

    public HashTable(int capacidad) {
        this.capacidad = siguientePrimo(capacidad);
        arreglo = new ListaDoble[this.capacidad];
    }
    
    
    
    public void Insertar(Cliente cliente){
        NodoDoble x = new NodoDoble(cliente);
        Integer z = abs((((Cliente) x.get()).getNombre() + ((Cliente) x.get()).getApellido()).hashCode() % capacidad);
        ListaDoble aux = arreglo[z];
        if (aux == null){
            ListaDoble aux2 = new ListaDoble();
            arreglo[z] = aux2;
            arreglo[z].append(cliente);
        }
        else{
            arreglo[z].append(cliente);
        }
        }
    
    public void Eliminar(Cliente cliente){
        NodoDoble x = new NodoDoble(cliente);
        int z = abs((((Cliente) x.get()).getNombre() + ((Cliente) x.get()).getApellido()).hashCode() % capacidad);
        NodoDoble aux = arreglo[z].getFirstNodo();
        while(aux != null){
            if(((Cliente) aux.get()).getNombre().equals(cliente.getNombre()) || ((Cliente) aux.get()).getApellido().equals(cliente.getApellido())){
                arreglo[z].delete(aux);
            }
            aux = aux.nNext();
        }
    }
    
    public ListaDoble Buscar(String n, String a) {
        int z = abs((n + a).hashCode() % capacidad);
        ListaDoble aux = arreglo[z];
        ListaDoble entrega = new ListaDoble();
        NodoDoble aux2 = aux.getFirstNodo();
        while(aux2 != null){
            if(((Cliente) aux2.get()).getNombre().equals(n) || ((Cliente) aux2.get()).getApellido().equals(a)){
                entrega.append((Cliente) aux2.get());
            }
            aux2 = aux2.nNext();
        }
        return entrega;
    }

    public static void Imprimir(Cliente x) {
        System.out.print("Nodo encontrado" + x.getCelular());
    }
  
    @SuppressWarnings("empty-statement")
    private static int siguientePrimo(int numero){
        if (numero % 2 == 0){
            numero++;            
        }
        for (; !esPrimo(numero); numero += 2);
 
        return numero;
    }    
    
    
    private static boolean esPrimo(int numero){
        if (numero == 2 || numero == 3){
            return true;
        }
        if (numero == 1 || numero % 2 == 0){
            return false;            
        }
        for (int i = 3; i * i <= numero; i += 2)
            if (numero % i == 0)
                return false;
        return true;
    }
    
    
}
    



