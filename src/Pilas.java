
/**
 *
 * Para ejemplificar las pilas, podemos pensar en una maquina despachadore de 
 * productos Bimbo, si las conocen, sabran que van metiendo los productos
 * y estos se van acomodando del final hasta el principio, dicho de otra manera
 * se van empujando de adelante hacia atras, por lo que podemos decir que
 * el primero que se inserta, sera el ultimo en salir
 * 
 * @author Dany
 */

public class Pilas{ // clase principal
    
    // inicializamos valores
    private int top; // la cima de la pila, por donde entraran todos los elementos
    private int capacidad; // la capacidad de la fila
    private int[] array; // el arreglo para guardar los elementos (o podriamos decir que es la pila donde se guardaran los elementos

    public Pilas(int cap) { // el constructor, de parametro la capacidad de la pila
        capacidad = cap; // le asignamos a capacidad lo que se pase por parametro
        array = new int[capacidad]; // al arreglo le decimos (asignamos) su longitud
        top = -1; // inicializamos la cima (como no hay aun nada, la cima es -1)
    }

    public void insertar(int dato) { // metodo para insertar datos (elementos), de parametro el dato a insertar
        if (estaLlena()){ // si la pila esta lllena (,etodo en linea 43)
            incrementarArreglo();      //incrementamos su capacidad
        }
        array[++top] = dato;    //e insertamos el dato
    }

    public void incrementarArreglo() { // metodo para incrementar el arreglo (esto cuando se desea insertar nuevo elemento
                                       // y ya no hay espacio.
        int tamanio_actual = top + 1; // variable tamaño actual le asignamos el valor de la cima + 1
        int[] new_array = new int[tamanio_actual * 2]; // al nuevo arreglo le asignamos el tamaño actual multiplicado por 2
        for(int i=0; i<tamanio_actual; i++){ 
            new_array[i] = array[i]; // ciclo para ir asignando los valores existentes al nuevo arreglo
        }
        array = new_array; //referenciamos al nuevo arreglo
        capacidad = new_array.length; // variable capacidad le damos el valor de la longitud del nuevo arreglo
    }

    public boolean estaLlena() { // metodo que nos servira para determinar si la cola esta llena
        return (capacidad == top+1); // regresa verdadero si la capacidad es igual al tope (la cima +1)
    }

    public int eliminar() { // metodo para eliminar elementos
        if (estaVacia()) { // si esta vacia
            System.out.println("La pila esta vacia"); // mensaje indicando que esta vaci
            return -1; // retorno
        } else { // si no esta vacia
            reducirTamanio(); // ejecutamos el metodo para checar si el tamaño puede ser reducido (ver metodo en linea 58)
            return array[top--]; // decrementamos el arreglo
        }
    }

    public void reducirTamanio() { // metodo para reducir el tamaño
        int longitud_actual = top+1; // creamos una nueva variable y le asignamos el valor de la cima + 1
        if (longitud_actual < capacidad / 2) { // si el valor que acabamos de asignar es menor que la media de la capacidad
            int[] nuevo_arreglo = new int[capacidad / 2]; // creamos nuevo arreglo con longitud de la media de la capacidad actual
            // decidi utilizar una funcion de sistema llamada arraycopy, para copiar los valores de un array a otro
            // la sintaxis va asi:
            // System.aaraycopy(arreglo origen, desde donde, arreglo destino, desde, hasta
            System.arraycopy(array, 0, nuevo_arreglo, 0, nuevo_arreglo.length);
            array = nuevo_arreglo; // asigno nuevo arreglo a array
            capacidad = nuevo_arreglo.length; // y a la capacidad la longitud del nuevo arreglo
        }
    }

    public boolean estaVacia() { // metodo para saber si la pila esta vacia
        return (top == -1); // regresa verdadero si la cima es igual a -1         
    }
    
    public void verElementos() { // metodo para ver los elementos de la pila
        for (int i = 0; i <= top; i++) { // recorremos la pila para ir mostrando los elementos
            System.out.print(array[i] + "=>"); // mostramos el valor y unos caracteres para el siguiente valor
        }
        System.out.println(); // imprimimos un salto de linea
        System.out.println("Tamaño:" + array.length); // mostramos el tamaño actual
    }
    
}
