package Taller4;

/**
 * Declaracion de metodos de la clase SistemaPokedexImpl
 */
public interface SistemaPokedex {

    /**
     *
     * @param id
     * @param nombre
     * @param etapa
     * @param evolucionSiguiente
     * @param evolucionPrevia
     * @param tipo1
     * @param tipo2
     * @return
     */
    public boolean agregarPokemon(String id,String nombre, String etapa, String evolucionSiguiente, String evolucionPrevia, String tipo1, String tipo2);


    String[] ordenarAlfabeticamente();
}
