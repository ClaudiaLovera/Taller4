package Taller4;
import edu.princeton.cs.stdlib.StdPicture;
import ucn.ArchivoEntrada;
import ucn.*;
import ucn.Registro;
import java.io.IOException;

//Claudia Lovera 21.08.288-3
//Antonia Flores 21.202.798-7
public class Main {
    public static void menuPrincipal(SistemaPokedex sistemaPokedex){
        SistemaPokedex sistemaPokedex1 = new SistemaPokedexImpl();
        sistemaPokedex1.lecturaArchivo("kanto.txt");

        boolean ejecuciónPrograma = true;
        while (ejecuciónPrograma) {
            StdOut.println(""" 
                ****POKEDEX****
                
                [A] Desplegar pokemon por rango de numeros
                [B] Desplegar todos los pokemon
                [C] Desplegar pokemon segun tipo
                [D] Desplegar pokemon que solo tienen primera evolucion
                [E] Busqueda personalizada
                [F] Salir de la pokedex
                -> Ingrese su opcion:
                """);

            String opcion = StdIn.readString();
            switch (opcion) {
                case "A", "a" -> {
                    StdOut.println("""
                            ****DESPLEGAR POR RANGO****
                                            
                            Ingrese el rango mínimo que desea ver ->
                                            
                            """);
                    int inicioRango = StdIn.readInt();
                    StdOut.println("""
                                            
                            Ingrese el rango máximo que desea ver ->
                                            
                            """);
                    int finRango = StdIn.readInt();
                    sistemaPokedex.PokemonsRango(inicioRango, finRango);
                }
                case "B", "b" -> sistemaPokedex.PokemonsAlfabetico();
                case "C", "c" -> {
                    StdOut.println("""
                            ****DESPLEGAR POR TIPO****
                                            
                            Ingrese el tipo que desea ver ->
                                            
                            """);
                    String tipo = StdIn.readString();
                    sistemaPokedex.PokemonsTipo(tipo);
                }
                case "D", "d" -> sistemaPokedex.PokemonsPrimeraEvolucion();
                case "E", "e" -> sistemaPokedex.BuscarPokemons(opcion);
                case "F", "f" -> {
                    ejecuciónPrograma = false;
                    StdOut.println("""
                            Gracias por entrar al sistema
                            """);
                }
                default -> StdOut.println("Ingrese una opción válida");
            }
        }

    }

    /**
     * Main del sistema
     * @param args
     * @throws IOException captura los errores
     */

    public static void main(String[] args) throws IOException {
        SistemaPokedex sistemaPokedex = new SistemaPokedexImpl();
        sistemasPrincipales(sistemaPokedex);

    }

    /**
     * Metodo que llama a los metodos principales del sistema
     * @param sistemaPokedex instancia de SistemaPokedexImpl
     * @throws IOException captura las excepciones de campos en el txt
     */

    public static void sistemasPrincipales(SistemaPokedex sistemaPokedex) throws IOException {
        sistemaPokedex.lecturaArchivo("kanto.txt");
        menuPrincipal(sistemaPokedex);
        StdOut.println();

    }

    //SUBPROGRAMAS

    /**
     * Metodo para agregar pokemon a la lista
     * @param id del pokemon
     * @param nombre nombre del pokemon
     * @param etapa etapa en la que se encuentra el pokemon
     * @param evoSiguiente evolucion siguiente del pokemon
     * @param evoPrevia evolucion previa del pokemon
     * @param tipo1 tipo de pokemon
     * @param tipo2 tipo de pokemon
     * @param sistemaPokedex instancia del sistemaPokedexImpl
     * @return lista con el pokemon agregado
     */
    private static boolean agregarPokemon(String id,String nombre,String etapa, String evoSiguiente,String evoPrevia,String tipo1, String tipo2,SistemaPokedex sistemaPokedex){
        sistemaPokedex.agregarPokemon(id,nombre,etapa,evoSiguiente,evoPrevia,tipo1,tipo2);

        return true;
    }

    /**
     * Metodo que desplega los pokemon de acuerdo a el rango ingresado por el usuario
     * @param inicioRango inicio del rango
     * @param finRango fin del rango
     * @param sistemaPokedex instancia del sistemaPokedexImpl
     */
    private static void PokemonsRango(int inicioRango, int finRango,SistemaPokedex sistemaPokedex){

        sistemaPokedex.PokemonsRango(inicioRango,finRango);

    }

    /**
     * Metodo que desplega los pokemon de acuerdo al tipo ingresado por el usuario
     * @param tipo tipo de pokemon
     * @param sistemaPokedex instancia del sistemaPokedexImpl
     * @return
     */
    private static boolean desplegarTipo(String tipo,SistemaPokedex sistemaPokedex){
        sistemaPokedex.PokemonsTipo(tipo);
        return true;
    }
}