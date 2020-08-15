
/**
 * 
 *Las listas enlazadas son más eficientes usando nodos, la estructura de 
 * un nodo esta compuesta por el dato que almacena y un enlace al siguiente
 * nodo, esto simplifica, en mi opinion las listas enlazadas y las
 * operaciones que implementare con ellas:
 * insertar (al inicio, al final, en una posicion dada)
 * eliminar (en cualquier posicion)
 * mostrar (elementos de la lista y el tamaño)
 * saber si esta vacia
 * reemplazar un dato en una posicion determinada
 * eliminar un nodo segun el dato que se de
 * buscar un elemento iterativamente y recursivamente
 * 
 * @author Dany
 */

public class Nodos { // creo la clase Nodos

    // atributos 
    Nodos siguiente; // todo nodo tiene siguiente, que es a donde apunta (al siguiente valor)
    int dato; // es el dato a almacenar
    
    /*  dos constructores */
    // constructor sin argumentos para crear solamente el nodo
    public Nodos() { 
        siguiente = null;
        dato = 0;
    }
    
    // constructor con dos parametros: el valor y el siguiente nodo
    public Nodos(int d, Nodos siguiente) {
        this.dato = d;
        this.siguiente = null;
    }
    
    /*
    * Los metodos predeterminados para
    * establecer (fijar, asignar) y obtener los nodos cuando se requieran
    */
    public Nodos obtenerSiguiente() { // para obtener el nodo siguiente
        return siguiente;
    }

    public void establecerSiguiente(Nodos n) { // para establecer (fijar, asignar) los nodos
        this.siguiente = n;
    }

    public int obtenerDato() { // para obtener el dato del nodo
        return dato;
    }

    public void fijarDato(int dato) { // para fijar el dato del nodo
        this.dato = dato;
    }

}
