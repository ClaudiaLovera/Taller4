package Taller4;

import java.util.ArrayList;
import java.util.Deque;

/**
 * Cñase que instancia los sistemas principales del programa
 */
public class SistemaPokedexImpl implements SistemaPokedex{
    private ListaPokemon listaPokemon;

    //private ArrayList<Pokemon> pokemonList;


    /**
     * Constructor de la clase
     */
    public SistemaPokedexImpl() {
        this.listaPokemon = new ListaPokemon();

    }


    public String[] ordenarAlfabeticamente(){
        if(this.listaPokemon.getTamanio() == 0){
            return null;
        }

        String[] vecInfo = new String[this.listaPokemon.getTamanio()];
        for(int i = 0; i < vecInfo.length;i++){
            vecInfo[i] = this.listaPokemon.buscar(i).getPokemon().getNombre();

            for (int j = 0; j < vecInfo.length-1; j++)
            {
                if(vecInfo[j].compareToIgnoreCase(vecInfo[j+1])>0)
                {
                    String aux = vecInfo[j];
                    vecInfo[j] = vecInfo[j+1];
                    vecInfo[j+1] = aux;
                }
            }
        }
        return vecInfo;

    }

    @Override
    public boolean agregarPokemon(String id, String nombre, String etapa, String evolucionSiguiente, String evolucionPrevia, String tipo1, String tipo2) {

        return this.listaPokemon.agregar(new Pokemon(id, nombre, etapa, evolucionSiguiente, evolucionPrevia, tipo1, tipo2));

    }


}
