package Taller4;

/**
 * Clase que contiene los pokemones
 */
public class ListaPokemon {

    private NodoPokemon head;
    private int tamanio;

    /**
     * Constructor de la clase
     */
    public ListaPokemon() {
        this.head = null;
        this.tamanio = 0;
    }

    /**
     * Verifica si la lista esta vacia
     * @return True si esta vacia
     */
    public boolean estaVacia(){
        return this.head == null;
    }

    /**
     * Obtiene la cantidad de elementos en la lista
     * @return cantidad de elementos
     */
    public int getTamanio(){
        return this.tamanio;
    }
}
