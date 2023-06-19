package Taller4;

import ucn.ArchivoEntrada;
import ucn.Registro;
import ucn.StdIn;
import ucn.StdOut;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.SplittableRandom;

/**
 * Clase que instancia los sistemas principales del programa
 */
public class SistemaPokedexImpl implements SistemaPokedex{
    private ListaPokemon listaPokemon;


    /**
     * Constructor de la clase
     */
    public SistemaPokedexImpl() {
        this.listaPokemon = new ListaPokemon();
    }


    /**
     * Metodo que lee el archivo de entrada
     * @param arc instancia de sistemaPokedex
     */
    @Override
    public void lecturaArchivo(String arc) {
        try {
            ArchivoEntrada archivoEntrada = new ArchivoEntrada(arc);

            //Se lee el archivo hasta el final
            while (!archivoEntrada.isEndFile()) {
                Registro registro = archivoEntrada.getRegistro();

                //Se verifica si el registro no es nulo
                if (registro != null) {
                    //Se obtienen los datos del registro
                    String id = registro.getString();
                    String nombre = registro.getString();
                    String etapa = registro.getString();
                    String evoSiguiente = registro.getString();
                    String evoPrevia = registro.getString();
                    String tipo1 = registro.getString();
                    String tipo2 = registro.getString();

                    //Se agrega el Pokémon
                    agregarPokemon(id,nombre,etapa,evoSiguiente,evoPrevia,tipo1,tipo2);
                }
            }

        } catch (IOException e) {
            StdOut.println("⚠️ Ha ocurrido un problema ⚠️");
        }
    }

    /**
     * Método de Búsqueda según un rango, con ordenamiento creciente según ID
     * @param inicioRango Variable de inicio ingresada por usuario
     * @param finRango Variable de fin ingresada por usuario
     */

    @Override
    public void PokemonsRango(int inicioRango, int finRango) {
        StdOut.println("""
                ****DESPLEGAR POR RANGO****
                
                Ingrese el rango mínimo que desea ver ->
                
                """);
        inicioRango = StdIn.readInt();

        StdOut.println("""
                
                Ingrese el rango máximo que desea ver ->
                
                """);
        finRango = StdIn.readInt();

        //Se obtiene la lista Pokémon ordenada según el rango
        List<Pokemon> ordenID = listaPokemon.ordenarRangoID(inicioRango, finRango);

        //Se comprueba las condiciones
        if (ordenID == null || inicioRango < 0 || finRango > 152) {
            StdOut.println("No se ha encontrado ningún Pokémons o ha ingresado un valor erroneo");

        } else {
            StdOut.println("Los Pokémons pertenecientes al Rango ["+inicioRango+"-"+finRango+"] son: ");

            //Se itera sobre la lista de Pokémon
            for (Pokemon pokemon : ordenID) {
                StdOut.println(pokemon);
                StdOut.println(" ");
            }
        }
    }

    /**
     * Método de Ordenamiento de Pokémons de forma Alfabética
     */

    @Override
    public void PokemonsAlfabetico() {
        StdOut.println("""
                ****Desplegando pokemon (Ordenados alfabeticamente)****
                
                """);

        //Se obtiene la lista Pokémon ordenada alfábeticamente
        List<Pokemon> ordenamientoAZ = listaPokemon.ordenAlfabetico();
        StdOut.println("Pokémons almacenados en el sistema (Ordenados Alfabéticamente): ");

        //Se itera sobre la lista ordenada
        for (Pokemon pokemon : ordenamientoAZ) {
            StdOut.println(pokemon);
            StdOut.println(" ");
        }
    }

    /**
     *Método de Búsqueda por tipo de Pokémon
     * @param tipo Variable ingresada por usuario
     */
    @Override
    public void PokemonsTipo(String tipo) {
        //Se le solicita al usuario el tipo de Pokémon a buscar
        tipo = StdIn.readString();

        //Buscamos el Pokémon por 'tipo' en la lista de Pokémon
        List<Pokemon> pokeTipo = listaPokemon.buscarPorTipo(tipo);
        //Se busca el Pokémon según el tipo
        if (pokeTipo == null) {
            StdOut.println("No se ha encontrado ningún Pokémon del tipo "+tipo);

        } else {
            StdOut.println("Pokémons del tipo "+tipo+" son: ");

            //Desplegar infromación de cada Pokémon encontrado
            for (Pokemon pokemon : pokeTipo) {
                StdOut.println(pokemon);
                StdOut.println(" ");
            }
        }
    }

    /**
     * Método Búsqueda de Pokémones de Primera Generación con ordenamiento decreciente
     */
    @Override
    public void PokemonsPrimeraEvolucion() {
        StdOut.println("""
                
                ****Desplegamiento Pokémons 'Primera Evolución'****
                -> ¡Ordenado de forma decreciente según ID!
                
                """);

        //Obtiene la lista de Pokémon de primera evolución en orden decreciente según su ID
        List<Pokemon> ordenDecreciente = listaPokemon.ordenamientoPrimeraEvolucion();
        StdOut.println("Pokémons de Primera Generación (Ordenados de forma Decreciente según su ID): ");
        //Iteramos sobre la lista de Pokémon de primera evolución
        for (Pokemon pokemon : ordenDecreciente) {
            StdOut.println(pokemon);
            StdOut.println(" ");
        }
    }

    /**
     * Método Búsquda Personalizada de Pokémons según su nombre o ID a base del criterio del usuario
     * @param opcion Variable de lectura de opción del usuario
     */
    @Override
    public void BuscarPokemons(String opcion) {
        boolean buscar = true;

        while (buscar) {
            StdOut.println("""
                
                ****BUSQUEDA PERSONALIZADA****
                
                [A] Buscar por nombre
                [B] Buscar por ID
                [C] Volver al menu principal
                
                """);
            opcion = StdIn.readString();

            try {
                if (opcion.equalsIgnoreCase("a")) {
                    StdOut.println("Ingrese el nombre del Pokémon");
                    String nombre = StdIn.readString();
                    Pokemon pokemon = listaPokemon.buscarNombre(nombre);

                    //Si se encuentra el Pokémon con el nombre indicado, se despliegan los datos
                    if (pokemon != null) {
                        StdOut.println("*** Información Pokémon "+nombre+" ***");
                        StdOut.println("ID: "+pokemon.getId());
                        StdOut.println("Nombre: "+pokemon.getNombre());
                        StdOut.println("Etapa: "+pokemon.getEtapa());
                        StdOut.println("Primera Evolución: "+pokemon.getEvolucionPrevia());
                        StdOut.println("Segunda Evolución: "+pokemon.getEvolucionSiguiente());
                        StdOut.println("Tipo 1: "+pokemon.getTipo1());
                        StdOut.println("Tipo 2: "+pokemon.getTipo2());
                        StdOut.println(" ");

                        boolean infoEvolucion = true;
                        while (infoEvolucion) {
                            StdOut.println("¿Desea conocer la información sobre la evolución del Pokémon " + nombre + "? (Si/No)");
                            String respuestaE = StdIn.readString();

                            if (respuestaE.equalsIgnoreCase("si")) {
                                if (pokemon.getEvolucionPrevia() != null) {
                                    //Desplegar información sobre primera evolución
                                    StdOut.println("-> Información sobre su primera evolución: ");
                                    pokemon = listaPokemon.buscarNombre(pokemon.getEvolucionPrevia());

                                    if (pokemon != null) {
                                        StdOut.println(pokemon);
                                        StdOut.println(" ");
                                    }
                                }

                                if (pokemon.getEvolucionPrevia() != null) {
                                    //Desplegar información sobre segunda evolución
                                    StdOut.println("-> Información sobre su segunda evolución: ");
                                    pokemon = listaPokemon.buscarNombre(pokemon.getEvolucionPrevia());

                                    if (pokemon != null) {
                                        StdOut.println(pokemon);
                                        StdOut.println(" ");
                                    }
                                }

                            } else if (respuestaE.equalsIgnoreCase("no")) {
                                //El usuario no desea conocer más información de evolución :c
                                infoEvolucion = false;

                            } else {
                                //Validación de dato erroneo
                                StdOut.println("Respuesta Invalida. Por favor responder 'Si' o 'No'");
                            }

                        }

                    } else {
                        //No se encontro ningún Pokémon con ese nombre
                        StdOut.println("No se ha encontrado ningún Pokémon con el nombre ingresado");
                    }


                } else if (opcion.equalsIgnoreCase("b")) {
                    StdOut.println("Ingrese la ID del Pokémon");
                    String id = StdIn.readString();
                    Pokemon pokemon = listaPokemon.buscarID(id);

                    //Si se encuentra el Pokémon con la ID indicado, se despliegan los datos
                    if (pokemon != null) {
                        StdOut.println("*** Información Pokémon "+id+" ***");
                        StdOut.println("ID: "+pokemon.getId());
                        StdOut.println("Nombre: "+pokemon.getNombre());
                        StdOut.println("Etapa: "+pokemon.getEtapa());
                        StdOut.println("Primera Evolución: "+pokemon.getEvolucionPrevia());
                        StdOut.println("Segunda Evolución: "+pokemon.getEvolucionSiguiente());
                        StdOut.println("Tipo 1: "+pokemon.getTipo1());
                        StdOut.println("Tipo 2: "+pokemon.getTipo2());
                        StdOut.println(" ");

                        boolean infoEvolucion = true;
                        while (infoEvolucion) {
                            StdOut.println("¿Desea conocer la información sobre la evolución del Pokémon con " + id + "? (Si/No)");
                            String respuestaE = StdIn.readString();

                            if (respuestaE.equalsIgnoreCase("si")) {
                                if (pokemon.getEvolucionPrevia() != null) {
                                    //Desplegar información sobre primera evolución
                                    StdOut.println("-> Información sobre su primera evolución: ");
                                    pokemon = listaPokemon.buscarID(pokemon.getEvolucionPrevia());

                                    if (pokemon != null) {
                                        StdOut.println(pokemon);
                                        StdOut.println(" ");
                                    }
                                }

                                if (pokemon.getEvolucionPrevia() != null) {
                                    //Desplegar información sobre segunda evolución
                                    StdOut.println("-> Información sobre su segunda evolución: ");
                                    pokemon = listaPokemon.buscarID(pokemon.getEvolucionPrevia());

                                    if (pokemon != null) {
                                        StdOut.println(pokemon);
                                        StdOut.println(" ");
                                    }
                                }

                            } else if (respuestaE.equalsIgnoreCase("no")) {
                                //El usuario no desea conocer más información de evolución :c
                                infoEvolucion = false;

                            } else {
                                //Validación de dato erroneo
                                StdOut.println("Respuesta Invalida. Por favor responder 'Si' o 'No'");
                            }
                        }

                    } else {
                        //No se encontro ningún Pokémon con esa ID
                        StdOut.println("No se ha encontrado ningún Pokémon con la ID ingresado");
                    }


                } else if (opcion.equalsIgnoreCase("c")) {
                    buscar = false;

                } else {
                    StdOut.println("Respuesta Invalida");
                }

            } catch (NumberFormatException e) {
                StdOut.println("Se ha ingresado un dato erroneo...");
            }
        }
    }



    /**
     * Este método se encarga de agregar el Pokémon a la lista
     * @param id id del pokemon
     * @param nombre nombre del pokemon
     * @param etapa etapa del pokemon
     * @param evolucionSiguiente siguiente evolucion del pokemon
     * @param evolucionPrevia anterior evolucion del pokemon
     * @param tipo1  tipo de pokemon
     * @param tipo2 tipo de pokemon
     * @return lista con el pokemon agregado
     */
    @Override
    public boolean agregarPokemon(String id, String nombre, String etapa, String evolucionSiguiente, String evolucionPrevia, String tipo1, String tipo2) {
        return this.listaPokemon.agregar(new Pokemon(id, nombre, etapa, evolucionSiguiente, evolucionPrevia, tipo1, tipo2));
    }
}





