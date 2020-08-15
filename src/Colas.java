
/**
 *
 * Las colas se pueden ejemplificar pensando en una fila, donde el primero que llega es el primero que sale
 * la fila para la compra de tortillas, el que llega al final sera el ultimo que salga.
 * Los valores solo se pueden insertar al final (en la cola) y los valores que se vayan 
 * sacando solo podran ser eliminados al principio de la cola (o de la fila)
 * 
 * @author Dany
 */

// clase principal
public class Colas {
    
    // atributos iniciales ... todos los inicializamos segun sus caracteristicas, por ejemplo, el frente debe ser
    // en un inicio cero por que la fila esta vacia, y asi los demas segun caracteristicas
    private final int LONGITUD = 6; // la longitud del arreglo
    int arreglo[]; // el arreglo
    int frente = 0; // el frente de la fila
    int posterior = -1; // la parte posterior de la fila
    int tamanioActual = 0; // el tamaño actual (este cambiara conforme se vaya añadiendo elementos)
     
    public Colas(){ // el constructor
        arreglo = new int[this.LONGITUD]; // al arreglo le asignamos su longitud
    }
 
    public void insertar(int elemento) { // Este metodo añade un elemento al final de la cola.
         
        if (colaLlena()) { // si devuelve verdadero (metodo en linea 63) significa que la cola esta llena
            System.out.println("La cola esta llena, incrementando LONGITUD..."); // mando mensaje
            incrementarLongitud(); // incremento la longitud de la fila (metodo en linea 83)
        }
        posterior++; // incremento la parte posterior
        // si la parte posterior es mayor o igual que el arreglo y el tamaño actual de la fila es diferente de la longitud del arreglo
        if(posterior >= arreglo.length && tamanioActual != arreglo.length){
            posterior = 0; // asigno cero a posterior
        }
        arreglo[posterior] = elemento; // fijo el elemento en la parte posterior (añado el elemento en la cola)
        tamanioActual++; // incremento el tamaño actual
        System.out.println("Insertando: " + elemento); // mensaje del elemento insertado
    }
 
    public void eliminar() { // Este metodo elimina el elemento inicial y/o el que esta en la cima de la cola
        if (colaVacia()) { // si la cola esta vacia (metodo en linea 73) no hay nada que eliminar
            System.out.println("Cola vacia ! No hay elementos que eliminar"); // mando mensaje
        } else { // en caso contrario
            frente++; // a frente lo incremento
            if(frente > arreglo.length-1){ // si frente es mayor que la longitud del arreglo -1
                System.out.println("Eliminando: "+arreglo[frente-1]); // eliminio el frente y unico valor
                frente = 0; // como era el unico, ahora frente vale cero
            } else { // sino
                System.out.println("Eliminando: "+arreglo[frente-1]); // tambien lo elimino
            }
            tamanioActual--; // pero como no era el unico valor, solo lo decremento
        }
    }
        
    public boolean colaLlena(){ // Este metodo verifica si la sola esta llena
        boolean estado = false; // variable de tipo boleano la inicializamos en falso (false)
        if (tamanioActual == arreglo.length){ // si el tamaño actual es igual a la longitud del arreglo
                                              // es decir, si el arreglo es de 3, y el tamaño es 3, es decir, ya llenamos 
                                              // el arreglo
            estado = true; // cambiamos el estado a verdadero 
        }
        return estado; // regresamos estado ( falso si la cola no esta llena, verdadero en caso conntrario
    }
     
    public boolean colaVacia(){ // Este metodo checa si la cola esta o no vacia
        boolean estado = false; // variable de tipo boleano, la inicializamos en falso
        if (tamanioActual == 0){ // si el tamaño actual es 0, es decir, el arreglo no tiene elementos
            estado = true; // cambiaos la variable estado a verdadero
        }
        return estado; // regresamos la variable
    }
    
    public void verElementos() { // metodo para ver los elementos de la pila
        for (int i = 0; i < tamanioActual; i++) { // recorremos la pila para ir mostrando los elementos
            //i++;
            System.out.print(arreglo[i] + "=>"); // mostramos el valor y unos caracteres para el siguiente valor
        }
        System.out.println(); // imprimimos un salto de linea
        System.out.println("Tamaño:" + arreglo.length); // mostramos el tamaño actual
    }
     
    private void incrementarLongitud(){ // metodo para incrementar la lingotud si llegamos a su maxima capacidad
         
        int nuevaLONGITUD = this.arreglo.length*2; // variable que guardara la longitud del arreglo actual multiplicado por dos
        int[] nuevoArreglo = new int[nuevaLONGITUD]; // al nuevo arreglo le asigno la nueva longitud (creada una linea arriba)
        // aqui copiaremos y asignaremos mediante iteracion los valores al arreglo con nueva longitud
        int tmpfrente = frente; // creamos variable temporal y le asignamos el frente
        int indice = -1; // creamos un indice (que se incrementara al ir llenando) y ke asignamos -1 
                         // (es decir, el indice lo colocamos al inicio)
        while(true){ // bucle : mientras sea verdadero (vamos a rcorrer y asignar los valores al arreglo aumentado
            nuevoArreglo[++indice] = this.arreglo[tmpfrente]; // al nuevo arreglo en el primer indice ( [0] ), le  asignamos
                                                              // el valor temporal del arreglo
            tmpfrente++; // incrementamos el frente (el temporal, no el actual)
            if(tmpfrente == this.arreglo.length){ // si el valor del frente temporal es igual a la longitud del arreglo
                tmpfrente = 0; // entonces el frente (temporal) sera cero
            }
            if(tamanioActual == indice+1){ // si el tamaño actual es igual a el indice +1 (recordemos que estamos en el bucle
                                           // e indice se ira incrementando, es + 1 por que cuando lo inicializamos
                                           // lo pusimos al inicio de la fila (-1) )
                break; // salimos
            }
        }
        // debemos hacer cola al nuevo arreglo
        this.arreglo = nuevoArreglo; // al arreglo le asignamos el nuevo arreglo
        System.out.println("Nuevo tamaño de cola: "+this.arreglo.length); // mostramos el nuevo tamaño de la cola (o fila)
        //reiniciamos los valores del frente y posterior 
        this.frente = 0;
        this.posterior = indice; 
}
}