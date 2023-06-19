package Taller4;

/**
 * Declaracion de metodos de la clase SistemaPokedexImpl
 */
public interface SistemaPokedex {

    /**
     * Método qee despliega los pokemon segun el rango indicado por el usuario
     * @param inicioRango  inicio del rango a desplegar
     * @param finRango fin del rango a desplegar
     */

    void PokemonsRango(int inicioRango, int finRango);

    /**
     * Método que ordena los pokemon en orden alfabetico
     */
    void PokemonsAlfabetico();

    /**
     * Método que despliega los pokemon segun el tipo indicado por el usuario
     * @param tipo tipo de pokemon
     */

    void PokemonsTipo(String tipo);

    /**
     * Método que despliega los pokemon que poseen una primera evolución
     */
    void PokemonsPrimeraEvolucion();

    /**
     * Método que despliega los resultados de la búsqueda personalizada según las opciones ingresadas por el usuario
     * @param opcion Variable de opción para el usuario
     */
    void BuscarPokemons(String opcion);

    /**
     * Método que agrega los pokemon a la lista
     * @param id id del pokemon
     * @param nombre nombre del pokemon
     * @param etapa etapa del pokemon
     * @param evolucionSiguiente siguiente evolucion del pokemon
     * @param evolucionPrevia evolucion anterior del pokemon
     * @param tipo1 tipo de pokemon
     * @param tipo2 tipo de pokemon
     * @return lista con los pokemon agregados
     */
    boolean agregarPokemon(String id, String nombre, String etapa, String evolucionSiguiente, String evolucionPrevia, String tipo1, String tipo2);


    /**
     *Realiza la lectura de archivo y agrega los Pokémon al sistema Pokedex
     * @param sistemaPokedex Sistema Pokedex donde se agregan los Pokémon
     */
    void lecturaArchivo(String sistemaPokedex);


}