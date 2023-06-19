package Taller4;

public class NodoPokemon {
    private Pokemon pokemon;
    private NodoPokemon siguiente;
    private NodoPokemon anterior;

    /**
     * Constructor de la clase
     * @param pokemon instancia de la clase pokemon
     */
    public NodoPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
        this.siguiente = null;
        this.anterior = null;
    }

    /**
     * Obtiene el pokemon que tiene el nodo
     * @return pokemon
     */
    public Pokemon getPokemon() {
        return pokemon;
    }

    /**
     * Establece un nuevo pokemon para el nodo
     * @param pokemon
     */
    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    /**
     * Obtiene el siguiente Nodo enlazado
     * @return Siguiente NodoPokemon
     */
    public NodoPokemon getSiguiente() {
        return siguiente;
    }

    /**
     * Establece el siguiente Nodo para enlazar
     * @param siguiente NodoPokemon
     */
    public void setSiguiente(NodoPokemon siguiente) {
        this.siguiente = siguiente;
    }

    /**
     * Obtiene el anterior Nodo enlazado
     * @return Anterior NodoPokemon
     */
    public NodoPokemon getAnterior() {
        return anterior;
    }

    /**
     * Establece el anterior Nodo para enlazar
     * @param anterior NodoPokemon a enlazar
     */
    public void setAnterior(NodoPokemon anterior) {
        this.anterior = anterior;
    }
}