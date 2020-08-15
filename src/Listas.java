
/**
 * 
 * La clase listas es para crear nuestra lista con los nodos (dato y 
 * enlace al siguiente nodo), en estructuras de datos las listas tienen un inicio (tambien
 * llamado cabeza) y un final (fin, cola, fin de lista) Cuando se crea
 * una lista, esta claro que no tendra en un inicio elementos, estos 
 * se añadiran. Por lo que inicializamos el inicio y fin como nulos
 * 
 * @author Dany
 */

public class Listas { // creamos la clase lista
    
    // inicializamos el inicio, fin y tamaño
    // toda lista enlazada tiene un puntero al inicio y otro al fin y un tamaño inicial
    //    Nodos inicio = null; 
    //    Nodos fin = null;
    //    int tamanio = 0;
    Nodos inicio; 
    Nodos fin;
    int tamanio;

    // constructor que inicializa el inicio, fin y tamaño de la lista
    public Listas() {
        inicio = null;
        fin = null;
        tamanio = 0;
    }
    
    // metodo para insertar al inicio de la lista
    public void insertarInicio(int dato){  // le pasamos por parametro el dato que se va a insertar
        Nodos nodo = new Nodos(dato, null); // creamos el nodo con el valor que se le pasa por parametro
        // al crear por primera vez la lista, sabemos que no hay ningun nodo hasta que lo agreguemos
        if (inicio == null) { // si el puntero inicio (la cabeza de la lista) no tiene ningun valor, significa lista vacia
            inicio = nodo; // le asignamos el nodo que creamos (sera el primero en insertar)
            fin = inicio; // como es el primer y unico nodo, ese nodo es el inicio y fin, no tiene apuntador a ningun otro
        // si la lista ya existia, lo que queremos es insertar el nodo al inicio
        } else { 
            // cuando se añade un valor al inicio de la lista, este es el orden:
            // 1. creamos el nodo y le asignamos valor (ya lo hicimos en la linea 32)
            // 2. enlazamos el puntero del nodo crado al inicio
            // 3. inicio le asignamos el nuevo valor, ahora tenemos un nuevo valor en inicio
            nodo.establecerSiguiente(inicio); 
            inicio = nodo;
        }
        tamanio++; // incrementamos el tamaño del nodo
    }
    
    // metodo para insertar al final de la lista - funciona parecido al metodo insertarInicio
    public void insertarFinal(int dato){ // le pasamos por parametro el dato que se le va a insertar al final de la lista
        Nodos nodo = new Nodos(dato, null); // creamos el nodo con el valor (pasado por parametro)
        if (inicio == null) { // si la lista esta vacia
            inicio = nodo; // el nodo creado y su valor sera l cabeza (inicio)
            fin = nodo; // y el fin
        // si la lista ya existia, lo que queremos hacer es insertar el nodo al final
        } else { 
            // cuando se añade un valor al final de la lista, este es el orden:
            // 1. creamos el nodo y le asignamos valor (ya lo hicimos en la linea 51)
            // 2. enlazamos el puntero del nodo crado al final
            // 3. a final le asignamos el nuevo valor, ahora tenemos un nuevo valor en final
            fin.establecerSiguiente(nodo); 
            fin = nodo; 
        }
        tamanio++; // incrementamos el tamaño de la lista
    }
    
    // metodo para insertar un nodo en una posicion dada
    // le pasamos por parametro la ubicacion en donde se desea insertar y el valor del dato a insertar
    public void insertarEnPosicion(int ubicacion, int dato){                                                              
        Nodos nodo = new Nodos(dato, null); // creamos el nodo y por parametro el dato a insertar
        Nodos puntero = inicio; // creamos un apuntador y le asignamos inicio        
        ubicacion = ubicacion - 1; // la ubicacion (pasada por parametro) le asignamos -1. 
                                   // -1 es el valor inicial (el valor del extremo de inicio
                                   //                  ________________________
                                   //   aqui esta -1  |_____|_____|_____|_____|  
        
        // el siguiente bucle (ciclo for) me permitira recorrer la lista buscando la ubicacion dada por parametro
        for (int i = 1; i < tamanio; i++) { 
            if (i == ubicacion) { // si el valor de i es igual al valor de ubicacion, es decir, ya lo encontro                
                Nodos temporal = puntero.obtenerSiguiente(); // creo un nodo temporal y de valor asigno el valor de siguiente
                puntero.establecerSiguiente(nodo); // al puntero le fijo el nodo 
                nodo.establecerSiguiente(temporal); // y al nodo le fijo el valor de temporal
                break; // salimos, pues la condicion se ha cumplido
            }
            puntero = puntero.obtenerSiguiente(); // asigno el valor siguiente a puntero y volvemos al ciclo por la siguiente vuelta
        }
        tamanio++; // incrementamos el tamaño de la lista
    }

    // este metodo reemplaza el dato de una posicion
    // le pasamos por parametro la ubicacion del dato a reemplazar y el nuevo dato
    public void reemplazarDatoenPosicion(int ubicacion, int dato) { 
        if (inicio == null) { // si inicio es null, es decir, no hay elementos en la lista
            System.out.println("¡VACIO!"); // entonces no hay nada que reemplazar y mando mensaje
            return; // retorno
        }
        
        // en caso contrario
        // al puntero le asigno el valor de inicio (el inicio de la lista para recorrer hasta encontrar lo que deseo reemplazar)
        Nodos puntero = inicio; 
        for (int i = 1; i < tamanio; i++) { // inicio, condicion, incremento
            if (i == ubicacion) { // si ya encontro la ubicacion
                puntero.fijarDato(dato); // fijo el dato nuevo
            }
            puntero = puntero.obtenerSiguiente();// sino, le asigno el siguiente valor a puntero y sigue la siguiente vuelta del ciclo
        }
    }
    
    // para eliminar una ubicacion
    // de parametro le pasamos la ubicacion que queremos eliminar
    public void eliminarUbicacion(int ubicacion) {
        // 1. si inicio es nulo, significa que la lista esta vacia, nada que eliminar
        if (inicio == null) { 
            System.out.println("¡VACIO!"); // mando mensaje
            return; // retorno
        }
        
        // 2.  si la ubicacion es igual al tamaño de la lista (por ejemplo ubicaion 4 , tamaño 4
        if (ubicacion == tamanio) { 
            // creo dos punteros y les asigno inicio
            Nodos inicioPuntero = inicio; 
            Nodos finPuntero = inicio; 
            while (inicioPuntero != null){ // mientras que el nodo inicio no sea nulo
                finPuntero = inicioPuntero; // al nodo fin le asigno el inicio en cada iteracion
                inicioPuntero = inicioPuntero.obtenerSiguiente(); // obtengo el valr del siguiente puntero y se lo asigno a inicio
            }
            // al salir, significa que ya encontro la ubicacion a eliminar
            fin = finPuntero; // a fin le asigno el ultimo valor asignado a finpuntero (obtenido del bucle anterior)
            fin.establecerSiguiente(null);// quito el puntero siguiente (al asignarlo como null
            tamanio--; // ya que quite la ubicacion, debo decrementar el tamaño de la lista
            return; // retorno
        }
        
        // 3. esta ultima es para cuando la ubicacion es mayor o menor que tamaño y que por lo menos haya un elemento
        Nodos puntero = inicio; // creo nodo y le asigno inicio (null)
        ubicacion = ubicacion - 1; // mismos comentarios que linea 72
        for (int i = 1; i < tamanio; i++) { // ciclo para recorrer la lista
            
            // si ya encontro la ubicacion del elemento a eliminar
            if (i == ubicacion) {
                Nodos temporal = puntero.obtenerSiguiente(); //creo un nodo temporal y de valor el puntero a siguiente
                temporal = temporal.obtenerSiguiente(); // igual, asignoa temporal el puntero a siguiente
                puntero.establecerSiguiente(temporal); // fijamos el valor de temporal como el puntero a siguiente
                break; // salir del bucle
            }
            puntero = puntero.obtenerSiguiente(); // asignamos el siguiente puntero de nodo a puntero y sigue el bucle
        }
        tamanio--; // decrementamos el amaño de la lista
    }
    
    // eliminar un nodo segun el dato que le demos por parametro
    public void eliminarNodoSegunDato(int dato){
        // 1. si inicio es null significa que la lista eta vacia, nada que eliminar
        if (inicio == null) { 
            System.out.println("¡VACIO!");
            return;
        }
        
        // 2. si el dato buscado esta al inicio (inicio.obtenerdato) y su puntero (inicio.obtenersiguiente)
        // es nulo, significa que solo hay un elemento de la lista
        if (inicio.obtenerDato() == dato && inicio.obtenerSiguiente() == null) {
            inicio = null; // inicio lo ponemos como nulo
            fin = null; // de igual manera fin
            tamanio--; // y decrementamos el tamaño de la lista
            return; // retorno
        }
        // 3. si el dato buscado esta al inicio (inicio.obtenerdato) y su puntero (inicio.obtenersiguiente)
        // es diferente de nulo, significa que el nodo a eliminar esta en el primero, pero hay mas elementos de la lista 
        if (inicio.obtenerDato() == dato && inicio.obtenerSiguiente() != null) {
            inicio = inicio.obtenerSiguiente(); // le asignamos a inicio el puntero siguiente
            tamanio--; // reducimos el tamaño
            return; // retorno
        }
        
        // 4. si el dato buscado esta al final (fin.obtenerdato)
        if (fin.obtenerDato() == dato) {
            Nodos inicioPuntero = inicio; // creo nodo y asigno el valor de inicio
            Nodos finPuntero = inicio; // de igual manera para el nodo fin

            inicioPuntero = inicioPuntero.obtenerSiguiente(); // copiamos a iniciopuntero el valor de siguiente
            // mientras que el puntero siguiente no sea nulo, es decir, no llegue al final de la lista
            while (inicioPuntero.obtenerSiguiente() != null) { 
                finPuntero = inicioPuntero; // asignamos a finpuntero el inicio
                inicioPuntero = inicioPuntero.obtenerSiguiente(); // y a inicio el valor obtenido de siguiente
            }
            fin = finPuntero; // a fin le insertamos el valor de finpuntero  (obtenido del bucle)
            fin.establecerSiguiente(null); // al puntero de fin le asignamos nulo, que no es mas que el fin de la lista
            tamanio--; // decrementamos el tamaño de la lista
            return; // retorno
        }
        
        // 5. buscar el dato dentro de la lista
        Nodos inicioPuntero = inicio; // creamos el nodo y le asignamos inicio
        Nodos punteroAnterior = inicioPuntero; // al puntero anterior le asignamos el puntero inicio
        inicioPuntero = inicioPuntero.obtenerSiguiente(); // inicilizamos el puntero de inicio con el puntero al nodo siguiente
        // mientras el dato del puntero (de inicio) sea diferente de dato a buscar y que no lleguemos al final de la lista
        while (inicioPuntero.obtenerDato() != dato && inicioPuntero.obtenerSiguiente() != null) {
            punteroAnterior = inicioPuntero; // asignamos al puntero anterior el inicio dle puntero
            inicioPuntero = inicioPuntero.obtenerSiguiente(); // obtenemos el nodo siguiente y se lo asignamos a iniciopuntero
        }
        
        // si encontramos el dato
        if (inicioPuntero.obtenerDato() == dato) {
            Nodos temporal = punteroAnterior.obtenerSiguiente(); // creamos temporal y le asignamos el nodo siguiente
            temporal = temporal.obtenerSiguiente(); // ahora actualizamos a temporal haciendo que apunte al nodo siguiente
            punteroAnterior.establecerSiguiente(temporal); // ahora al puntero anterior le fijamos el puntero siguiente de temporal
            tamanio--; // decrementamos el tamaño de la lista
            return; // retorno
        }
        
        // si el dato no lo encontramos
        System.out.println(dato + " NO ENCONTRADO");
    }

    // metodo para mostrar los elementos de la lista
    public void mostrar() { 
        if (inicio == null) { // si inicio es nulo, significa que esta vacia la lista
            System.out.println("¡VACIO"); // mensaje
            return; // retorno
        }
        
        // si el puntero de inicio va a nulo, significa que solo hay un elemento de la lista
        if (inicio.obtenerSiguiente() == null) {
            System.out.println(inicio.obtenerDato()); // mostramos el elemento
            return; // retorno
        }
        
        // si hay mas elementos (ya checamos si la lista es nula o si solo tiene uno a traves del puntero de inicio que vaya a nulo
        Nodos puntero = inicio; // creamos puntero y lo inicializamos a nulo
        System.out.print(puntero.obtenerDato() + "->"); // obtenems el dato del primer puntero y lo escribimos en pantalla
        puntero = inicio.obtenerSiguiente(); // ahora a puntero le asignamos el valor de siguiente, es decir, al siguiente puntero
        // u bucle para recorrer los demas punteros. mientras no sean nulos se recorreran y se mostraran
        while (puntero.obtenerSiguiente() != null) {
            System.out.print(puntero.obtenerDato() + "->"); // muestro el siguiente dato
            puntero = puntero.obtenerSiguiente(); // asigno el siguiente puntero al puntero creado
        }
        System.out.println(puntero.obtenerDato() + "\n"); // salto de linea ya que acabe de mostrar os valores
    }
    
    // metodo para buscar elementos segun su posición, le paso por parametro la ubicacion a buscar
    public void buscarElementoSegunPosicion(int ubicacion) {
        if (ubicacion == 1) { // si ubicacion es igual a 1 significa que esta en la primera posicion
            System.out.println("Elemento en " + ubicacion + " es : " + inicio.obtenerDato()); // lo muestro
            return; // retorno
        }
        
        // si la ubicacion es igual que el tamaño, por ejemplo, el tamaño es igual a 4 y la ubicacion 4, esta al final
        if (ubicacion == tamanio) { 
            System.out.println("Elemento en " + ubicacion + " es : " + fin.obtenerDato()); // lo muestro
            return; // retorno
        }
        
        // si no esta al final y tampoco al inicio
        Nodos puntero = inicio; // asigno inicio a nodo puntero
        for (int i = 1; i < tamanio; i++) { // bucle para recorrer hasta que mi contador sea menor que el tamaño de la lista
            if (i == ubicacion) { // si lo encuentra
                System.out.println("Elemento en " + ubicacion + " es : " + puntero.obtenerDato()); // lo muestro
                break; // salgo del bucle
            }
            puntero = puntero.obtenerSiguiente(); // asigno el siguiente puntero a puntero
        }
    }
    
    /* los siguientes dos metodos son de busqueda, uno es busqueda iterativamente, esto significa que vamos a iterar, 
    *  1. La iteracion la hemos visto desde la asignatura pasada (POO I), iterar no es mas que usar un bucle e ir iterando hasta 
    *  encontrar la solucion, en otras palabras, buscaremos desde el inicio con un bucle hasta encontrar el elemento
    *  2. Recursividad, la busqueda recursiva es la funcion que se llama asi misma, reduciendo, en nuestro caso, la busqueda 
    *  desde arriba hacia abajo, obteniendo un problema mas simpe hasta encontrar la solucion. Empezare con la busqueda iterativa
    */
    
    // metodo para buscar el elemento dado por parametro de manera iterativa
    public void buscarElementoIterativamente(int dato) {

        if (estaVacia()) { // si esta vacia (el metodo para saber si esta vacia (devuelve valor boleano) esta en la linea 329
            System.out.println("¡VACIO!"); // mensaje indicando que esta vacia
            return; // retorno
        }
        
        // si el dato es igual a lo que nos devuelve el metodo obtener dato del nodo inicio
        // dicho de otra manera, si el dato es igual al dato de inicio 
        if (inicio.obtenerDato() == dato) { 
            System.out.println(dato + " encontrado en " + 1 + " ubicacion"); // lo mostramos
            return; // retorno
        }
        
        // si el puntero de inicio es diferente de nulo (significa que hay mas nodos) y el dato del final es igual 
        // al dato buscado, en otras palabras , si el dato esta al final
        if (inicio.obtenerSiguiente() != null && fin.obtenerDato() == dato) {
            System.out.println(dato + " encontrado en " + tamanio + " ubicacion"); // lo mostramos
            return; // retorno
        }
        
        // aqui viene la iteracion
        Nodos inicioPuntero = inicio; // creamos un nodo y le asignamos inicio
        int ubicacion = 0; // variable ubicacion inicializada a 0 ( esta guardara la ubicacion ya que haya sido encontrada
        // mientras que el puntero que recorrera no sea null (no haya llegado al final
        while (inicioPuntero.obtenerSiguiente() != null) { 
            ++ubicacion; // primeramente incrementamos ubicacion
            // si encuentra el dato (el dato pasado por parametro sea igual al dato del puntero que itera
            if (inicioPuntero.obtenerDato() == dato) { 
                break; // salimos
            }
            inicioPuntero = inicioPuntero.obtenerSiguiente(); // asignamos el siguiente puntero al puntero para la siguiente iteracion
        }
        if (inicioPuntero.obtenerDato() == dato) { // si el dato es igual al dato del puntero (se encontro)
            System.out.println(dato + " encontrado en " + ubicacion); // lo mostramos
            return; // retorno
        }

        System.out.println(dato + " ¡no encontrado!"); // si no lo encontramos, mensaje
    }
    
    // metodo para buscar el elemento dado por parametro de manera recursiva 
    // (parametros: creamos un nodo inicio; el dato a buscar y un contador)
    public void buscarElementoRecursivamente(Nodos inicio, int dato, int contador) {

        if (estaVacia()) { // si esta vacia es igual a true (metodo en linea 338)
            System.out.println("¡VACIO!"); // Mensaje de error
            return;// retorno
        }
        if (inicio.obtenerDato() == dato) { // si esta al inicio
            System.out.println(dato + " encontrado en " + (++contador)); // lo mostramos e incrementamos el valor de contador
            return; // retorno
        }
        if (inicio.obtenerSiguiente() == null) { // si el punerto de inicio es nulo, significa que no hay mas nada que buscar
            System.out.println(dato + " no encontrado"); // mostramos el dato
            return; // retorno
        }
        // un metodo recursivo se llama asi mismo redusiendo la busqueda, como lo explique en la linea 267
        // llamamos el mismo metodo y le pasamos por parametro el parametro del nodo de inicio (este ira cambiando), el dato a buscar
        // y el contador qe se ira incrementando
        buscarElementoRecursivamente(inicio.obtenerSiguiente(), dato, ++contador); 
    }
    
    // metodo para obtener el tamaño de la lista
    public int obtenerTamanio() {
        return tamanio;
    }
    
    // metodo para saber si la lista esta vacia
    public boolean estaVacia() {
        return inicio == null; // si inicio es igual a nulo
    }
}