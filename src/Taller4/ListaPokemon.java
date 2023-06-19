package Taller4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Clase que contiene los pokemones
 */
public class ListaPokemon {

    private NodoPokemon head;
    private NodoPokemon tail;

    private int tamanio;

    /**
     * Constructor de la clase
     */
    public ListaPokemon() {
        this.head = null;
        this.tail = null;
        this.tamanio = 0;
    }

    /**
     * Verifica si la lista esta vacia
     * @return True si esta vacia
     */

    public boolean estaVacia(){
        return this.head == null;
    }

    //Método para agregar un Pokémon
    public boolean agregar(Pokemon pokemon) {
        NodoPokemon nuevoNodo = new NodoPokemon(pokemon);

        if (estaVacia()) {
            //Si la lista esta vacia, el nuevo nodo se convierte tanto en la cabeza como en la cola
            this.head = nuevoNodo;
            this.tail = nuevoNodo;
            this.tamanio++;
            return true;
        }

        /* Si la lista no está vacía, se agrega el nuevo nodo al final.
          Se establece el enlace entre el nuevo nodo y el nodo anterior */
        nuevoNodo.setSiguiente(this.tail);

        //Establecemos el enlace entre el nodo actual de la cola y el nuevo nodo
        this.tail.setSiguiente(nuevoNodo);

        //El nuevo nodo se convierte en la cola de la lista
        this.tail = nuevoNodo;
        this.tamanio++;
        return true;
    }

    //BUSQUEDA PERSONALIZADA


    /**
     * Método para buscar un Pokemon según su ID
     * @param id id del pokemon
     * @return pokemon encontrado
     */
    public Pokemon buscarID (String id) {
        NodoPokemon aux = head;

        //Recorre la lista mientras no esté vacía
        while (aux != null) {
            //Compara el ID del Pokémon en el nodo actual con el ID buscado
            if (aux.getPokemon().getId().equalsIgnoreCase(id)) {
                //Si se encuentra el ID ingresado por el usuario, se devuelve el Pokémon correspondiente
                return aux.getPokemon();
            }

            //Simplemente avanza hacía el siguiente nodo
            aux = aux.getSiguiente();
        }

        //Si no se encuentra la ID, se devuelve null
        return null;
    }



    /**
     * Método para buscar un Pokémon según su nombre
     * @param nombre nombre del pokemon
     * @return el pokemon encontrado segun el nombre
     */
    public Pokemon buscarNombre(String nombre) {
        NodoPokemon aux = head;

        //Recorre la lista mientras el nodo aux no sea nulo
        while (aux != null) {
            //Comprobamos si el nombre del Pokémon en el nodo actual es igual nombre buscado
            if(aux.getPokemon().getNombre().equalsIgnoreCase(nombre)) {
                //Si se encuentra el nombre, retorna el Pokémon
                return aux.getPokemon();
            }

            //Si no se encontró el nombre correspondiente, se retorna un null
            aux = aux.getSiguiente();
        }

        return null;
    }
    //FIN DE BUSQUEDA PERSONALIZADA


    /**
     * Método para buscar según un tipo en particular utilizando ArrayList<>
     * @param tipo tipo de pokemon
     * @return tipo de pokemon encontrado
     */

    public List<Pokemon> buscarPorTipo(String tipo) {
        //Se crea una lista ArrayList<> con el fin de almacenar los Pokémon encontrados
        List<Pokemon> pokeTipo = new ArrayList<>();
        NodoPokemon actual = head;

        while (actual != null) {
            //Se comprueba si el tipo del Pokémon 'actual' coincide con alguno de los dos tipos
            if(actual.getPokemon().getTipo1().equalsIgnoreCase(tipo) || actual.getPokemon().getTipo2().equalsIgnoreCase(tipo)) {
                //En el caso de que coincidan, se agrega el Pokémon a la lista para ser desplegado
                pokeTipo.add(actual.getPokemon());
            }

            //Se avanza al siguiente nodo
            actual = actual.getSiguiente();
        }

        //Se regresa la lista con los respectivos Pokémons encontrados
        return pokeTipo;
    }


    /**
     * Ordenar los Pokémons según su ID para desplegar por rango con ArrayList<>
     * @param inicioRango inicio del rango para buscar
     * @param finRango fin del rango a buscar
     * @return pokemon que se encuentren en el rango
     */

    public List<Pokemon> ordenarRangoID(int inicioRango, int finRango) {
        //Creamos una lista para guardar los Pokémon ordenados por su ID
        List<Pokemon> ordenID = new ArrayList<>();
        NodoPokemon actual = head;

        //Ciclo mientras la ID actual no esté vacía
        while (actual != null) {
            //Se comprueba que si la ID actual se encuentra detro del rango especificado por el usuario
            if (Integer.parseInt(actual.getPokemon().getId()) >= inicioRango && Integer.parseInt(actual.getPokemon().getId()) <= finRango) {
                //Si se encuentra en el rango, agregamos el Pokémon a la lista ordenID
                ordenID.add(actual.getPokemon());
            }

            actual = actual.getSiguiente();
        }

        //Ordenamiento burbuja de forma creciente según su ID
        int n = ordenID.size();
        for (int i = 0; i < n -1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                Pokemon p1 = ordenID.get(j);
                Pokemon p2 = ordenID.get(j + 1);

                //Utilizamos 'Interger.parseInt()' para convertir la ID a tipo int, para realizar la comparación
                if (Integer.parseInt(p1.getId()) > Integer.parseInt(p2.getId())) {
                    //Se reposicionan los elementos para que esten en el orden que queremos
                    ordenID.set(j, p2);
                    ordenID.set(j + 1, p1);
                }
            }
        }

        //Regresamos la lista ordenada por ID (No se encuentra en orden creciente)
        return ordenID;
    }




    /**
     * Método para Ordenar todos los Pokémons de forma alfabética con uso de Array<>
     * @return lista de pokemon ordenados alfabeticamente
     */
    public List<Pokemon> ordenAlfabetico() {
        //Lista para almacenar los Pokémons
        List<Pokemon> ordenamientoAZ = new ArrayList<>();
        NodoPokemon actual = head;

        while (actual != null) {
            //Agregamos el Pokémon actual a la lista de ordenamiento
            ordenamientoAZ.add(actual.getPokemon());
            actual = actual.getSiguiente();
        }

        //Ordenamos alfabeticamente utilizando el método ordenamiento burbuja
        int n = ordenamientoAZ.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                //Utilizamos el método .get() para acceder al elemento de la lista
                Pokemon p1 = ordenamientoAZ.get(j);
                Pokemon p2 = ordenamientoAZ.get(j+1);

                if (p1.getNombre().compareToIgnoreCase(p1.getNombre()) >0) {
                    //Se intercambian los elementos para ordenarlos utilizando el método .set()
                    ordenamientoAZ.set(j, p2);
                    ordenamientoAZ.set(j +1, p1);
                }
            }
        }

        //Devolvemos la lista Pokémon ordenada alfabeticamente
        return ordenamientoAZ;
    }



    /**
     * Ordenamiento decreciente de ID para los Pokémones de Primera Evolución utilizando ArrayList<>
     * @return pokemon ordenado segun su ID en orden decreciente
     */
    public List<Pokemon> ordenamientoPrimeraEvolucion() {
        //Se crea una nueva lista para almacenar los Pokémon
        List<Pokemon> ordenDecreciente = new ArrayList<>();
        NodoPokemon actual = head;

        //Recorre la lista de Pokémon
        while (actual != null) {
            //Se Verifica si el Pokémon actual se encuentra en la etapa de 'Primera evolución'
            if (actual.getPokemon().getEtapa().equalsIgnoreCase("Primera Evolución")) {
                //Agrega el Pokémon a la lista
                ordenDecreciente.add(actual.getPokemon());
            }

            //Se mueve al siguiente nodo
            actual = actual.getSiguiente();
        }

        //Ordenamos de forma decreciente utilizando el método ordenamiento burbuja
        int n = ordenDecreciente.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                Pokemon p1 = ordenDecreciente.get(j);
                Pokemon p2 = ordenDecreciente.get(j+1);

                //Comparamos las ID de los Pokémon para determinar el orden
                if (p2.getId().compareToIgnoreCase(p1.getId()) > 0) {
                    //Intercambia las posiciones para que sean decreciente
                    ordenDecreciente.set(j, p2);
                    ordenDecreciente.set(j+1, p1);
                }
            }
        }

        //Devuelve la lista ordenada de Pokémon en forma decreciente
        return ordenDecreciente;
    }

    /**
     * Obtiene la cantidad de elementos en la lista
     * @return cantidad de elementos
     */
    public int getTamanio(){
        return this.tamanio;
    }

}