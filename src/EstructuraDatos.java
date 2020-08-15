
import java.util.Scanner;

/**
 *
 * @author Dany
 */
public class EstructuraDatos {
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args){
        
        // PROGRAMA PRINCIPAL
        
        int estructura; // guardara la opcion elegida del menu principal
        int funcion; // guardara el metodo elegido
        boolean salir = true; // para salir del sistema
        boolean inicio; // para regresar al menu principal (sale de la estructura en la que se encuentre cuando su valor sea falso
        Scanner pincipal = new Scanner(System.in); // para el escanner, lo que el usuario ingrese por teclado
        
        // MENU PRINCIPAL
        do{
           System.out.println("¿Con que estructura de datos desea trabajar?\n");
           System.out.print("1.- Pilas.  ");
           System.out.print("2.- Colas.  ");
           System.out.print("3.- Listas.  ");
           System.out.print("4.- Salir\n");
           System.out.print("Escriba el numero opción deseada: ");
           estructura = pincipal.nextInt(); 
           switch(estructura){ // validaremos la entrada del usuario para saber a donde dirigirlo
               
                case 1: // PILAS
                    System.out.print("\n\nPILAS.\n");
                    inicio = true;
                    Scanner optPila = new Scanner(System.in); // para las opciones de la pila
                    Pilas pila=new Pilas(2);; // creamos la pila (el 2 es su capacidad de almacenamiento)
                    do{ // mostramos menu - en un do, mientras sea verdadero, podra ejecutar metodos de pilas                      
                        System.out.print("1.- Insertar.  ");
                        System.out.print("2.- Eliminar.  ");
                        System.out.print("3.- Mostrar.  ");
                        System.out.print("4.- ¿Esta vacia?.  ");
                        System.out.print("5.- ¿Esta llena?  ");
                        System.out.print("6.- Menu Principal.\n");
                        System.out.print("Escriba el numero de opción deseada: \n\n");
                        funcion = optPila.nextInt(); // guardamos la seleccion del usuario
                        switch(funcion){ // validamos lo ue ingreso por teclado
                            case 1: // insertar
                                pila.insertar(1);
                            break;
                            case 2: // eliminar
                                pila.eliminar(); 
                            break;
                            case 3: // mostrar elementos
                                pila.verElementos(); 
                            break;
                            case 4: // saber si esta vacia
                                if (pila.estaVacia()){
                                   System.out.print("Pila vacia\n"); 
                                }else{
                                    System.out.print("No esta vacia\n");
                                }
                            break;
                            case 5: //saber si esta llena
                                if (pila.estaLlena()){
                                   System.out.print("Pila llena\n"); 
                                }else{
                                    System.out.print("No esta llena\n");
                                }
                            break;
                            case 6: //ir a menu principal
                                inicio = false; 
                            break;
                            default: // cualquier otro valor
                                System.err.println("No existe esa opción"); 
                        }
                    } while(inicio); 
                break;
                //====================================================
                case 2: //Colas
                    System.out.print("\n\nCOLAS.\n");
                    inicio = true; // sera false cuando se regrese al menu principal
                    Scanner optCola = new Scanner(System.in); // guardara las opciones de la estructura colas
                    Colas cola = new Colas(); // creamos la estructura
                    do{ // mostramos el menu mientras se este en esta estructura                        
                        System.out.print("1.- Insertar.  ");
                        System.out.print("2.- Eliminar.  ");
                        System.out.print("3.- Mostrar.  ");
                        System.out.print("4.- ¿Esta vacia?.  ");
                        System.out.print("5.- ¿Esta llena?.  ");
                        System.out.print("6.- Menu Principal.\n");
                        System.out.print("Escriba el numero de la opcion deseada: \n\n");
                        funcion = optCola.nextInt(); // guardamos la opcion que se eligio
                        switch(funcion){ // evaluamos la opcion elegida
                            case 1: //insertar
                                cola.insertar(2); 
                            break;
                            case 2: // eliminar
                                cola.eliminar(); 
                            break;
                            case 3: // mostrar
                                cola.verElementos(); 
                            break;
                            case 4: //esta vacia la cola?
                                if (cola.colaVacia()){
                                   System.out.print("Cola vacia\n"); 
                                }else{
                                    System.out.print("Cola no vacia\n");
                                }
                            break;
                            case 5: //esta llena la cola?
                                if (cola.colaLlena()){
                                   System.out.print("Cola llena\n"); 
                                }else{
                                    System.out.print("Cola no esta llena\n");
                                }
                            break;
                            case 6: //volver a menu principal
                                inicio = false; 
                            break;
                            default: // cuando no se selecciono alguna pcion de las mostradas
                                System.err.println("No existe esa opción"); 
                        }
                    } while(inicio); 

                break;
                //====================================================
                case 3: //Listas
                    Listas lista = new Listas(); // creamos la lista (instancia de listas)
                    System.out.print("\n\nLISTAS ENLAZADAS.\n ");
                    boolean si = true; // falso cuando queramos volver al menu principal
                    do { // mostramos menu
                        System.out.print("1 Insertar al inicio.   ");
                        System.out.print("2 Insertar al final.   ");
                        System.out.print("3 Insertar en posicion dada.   \n");
                        System.out.print("4 Eliminar posicion dada.   ");
                        System.out.print("5 Mostrar.   ");
                        System.out.print("6 Tamaño.   \n");
                        System.out.print("7 ¿Esta vacia?   ");
                        System.out.print("8 Reemplazar dato de una posicion dada.   ");
                        System.out.print("9 Buscar elemento por posicion.   \n");
                        System.out.print("10 Eliminar nodo por un dato dado.   ");
                        System.out.print("11 Buscar elemento de forma iterativa.   ");
                        System.out.print("12 Elemento de búsqueda recursivamente.   \n");
                        System.out.print("13 Salir\n\n");
                        Scanner scanner = new Scanner(System.in); // variable donde se guardara la opcion elegida
                        int eleccion = scanner.nextInt(); // guardamos lo que el usuario introdujo por teclado
                        switch (eleccion) {
                            case 1: // insertar al inicio
                                lista.insertarInicio(scanner.nextInt());
                            break;

                            case 2: // insertar al final
                                lista.insertarFinal(scanner.nextInt());
                            break;

                            case 3: // insertar en posicion dada
                                int posicion = scanner.nextInt();
                                    if (posicion <= 1 || posicion > lista.obtenerTamanio()) {
                                        System.out.println("¡posicion invalida!");
                                    } else {
                                        lista.insertarEnPosicion(posicion, scanner.nextInt());
                                    }
                            break;

                            case 4: // eliminar posicion dada
                                int eliminarPosicion = scanner.nextInt();
                                    if (eliminarPosicion <= 1 || eliminarPosicion > lista.obtenerTamanio()) {
                                        System.out.println("¡posicion invalida!");
                                } else {
                                        lista.eliminarUbicacion(eliminarPosicion);
                                }
                            break;

                            case 5: // mostrar elementos
                                lista.mostrar();
                            break;

                            case 6: // tamaño de lista
                                System.out.println(lista.obtenerTamanio());
                            break;

                            case 7: // saber si esta vacia
                                System.out.println(lista.estaVacia());
                            break;

                            case 8: // reemplazar dato de una posicion dada
                                int reemplazarPosicion = scanner.nextInt();
                                    if (reemplazarPosicion < 1 || reemplazarPosicion > lista.obtenerTamanio()) {
                                        System.out.println("¡posicion invalida!");
                                    } else {
                                        lista.reemplazarDatoenPosicion(reemplazarPosicion, scanner.nextInt());
                                    }
                            break;

                            case 9: // buscar elemento por posicion
                                int buscarPosicion = scanner.nextInt();
                                    if (buscarPosicion < 1 || buscarPosicion > lista.obtenerTamanio()) {
                                        System.out.println("¡posicion invalida!");
                                    } else {
                                        lista.buscarElementoSegunPosicion(buscarPosicion);
                                    }
                                break;

                            case 10: // eliminar nodo por un dato dado
                                lista.eliminarNodoSegunDato(scanner.nextInt());
                            break;

                            case 11: // buscar elemento de forma iterativa
                                lista.buscarElementoIterativamente(scanner.nextInt());
                            break;

                            case 12: // buscar elemento de forma recursiva
                                lista.buscarElementoRecursivamente(lista.inicio, scanner.nextInt(), 0);
                            break;
               
                            case 13: // regresar al menu principal
                                si = false;
                            break;

                            default: // si no se eligio alguna de las opciones dadas
                                System.out.println("Seleccion invalida");
                            break;
                        }
                    } while (si);
                break;
                //====================================================
                case 4: // salir del sistema
                    System.out.println("Salir");
                    salir = false; 
                break;
                //====================================================
                default:
                    System.err.println("Opcion invalida, elija una de las mostradas");
          }
        } while(salir); 
    }
    
}