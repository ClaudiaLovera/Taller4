package Taller4;

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

    public boolean agregar(Pokemon pokemon)
    {

        NodoPokemon nuevoNodo = new NodoPokemon(pokemon);
        if (estaVacia())
        {
            this.head = nuevoNodo;
            this.tail = nuevoNodo;
            this.tamanio++;
            return true;
        }

        nuevoNodo.setSiguiente(this.head);
        this.head.setAnterior(nuevoNodo);
        this.tamanio++;
        return true;
    }

    public boolean buscar(String nombre)
    {
        if (estaVacia()) {
            return false;
        }
        NodoPokemon aux = this.head;
        for(aux = this.head; aux != null;aux =aux.getSiguiente()){
            if(aux.getPokemon().getNombre().equalsIgnoreCase(nombre)){
                return true;
            }

        }

        return false;
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
