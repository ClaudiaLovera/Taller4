package Taller4;

import com.sun.management.UnixOperatingSystemMXBean;

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

    public boolean agregar(Pokemon pokemon)
    {

        NodoPokemon nuevoNodo = new NodoPokemon(pokemon);
        if (estaVacia())
        {
            this.head = nuevoNodo;
            this.head.setSiguiente(this.head);
            this.head.setAnterior(this.head);
            this.tamanio++;
            return true;
        }
        nuevoNodo.setSiguiente(this.head);
        nuevoNodo.setAnterior(this.head.getAnterior());
        this.head.getAnterior().setSiguiente(nuevoNodo);
        this.head.setAnterior(nuevoNodo);
        this.tamanio++;
        return true;
    }

    public NodoPokemon buscar(String nombre)
    {
        if (estaVacia())
        {
            return null;
        }
        NodoPokemon aux = this.head;
        while (aux.getSiguiente() != this.head)
        {
            if (aux.getPokemon().getNombre().equalsIgnoreCase(nombre))
            {
                break;
            }
            aux = aux.getSiguiente();
        }
        return aux.getPokemon().getNombre().equalsIgnoreCase(nombre) ? aux : null;

    }

    public NodoPokemon buscar(int posicion){
        if (estaVacia())
        {
            return null;
        }
        if (posicion<0 || posicion>=this.tamanio)
        {
            return null;
        }
        NodoPokemon aux = this.head;
        for (int i = 0; i <posicion; i++)
        {
            aux = aux.getSiguiente();
        }
        return aux;

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
