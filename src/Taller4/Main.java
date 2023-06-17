package Taller4;
import edu.princeton.cs.stdlib.StdPicture;
import ucn.ArchivoEntrada;
import ucn.*;
import ucn.Registro;
import java.io.IOException;


public class Main {

    public static void menuPrincipal(SistemaPokedex sistemaPokedex){
        String opcion = "X";
        while(!opcion.equalsIgnoreCase("F")){
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

            opcion = StdIn.readString();
            switch(opcion){
                case "A" -> desplegarPorRango(sistemaPokedex);
                case "B" -> desplegarTodo(sistemaPokedex);
                case "C" -> desplegarPorTipo();
                case "D" -> desplegarPrimeraEvolucion();
                case "E" -> MenuBusquedaPersonalizada();
                case "F" -> StdOut.println("""
                        Gracias por entrar al sistema
                        """);
            }
        }

    }

    public static void desplegarPorRango(SistemaPokedex sistemaPokedex){
        int opcion;
        StdOut.println("""
                ****DESPLEGAR POR RANGO****
                
                Ingrese el rango maximo que desea ver ->
                
                """);
        opcion = StdIn.readInt();

        while(opcion < 152 && opcion > 0){
            StdOut.println();

        }
        StdOut.println("Rango invalido, ingrese su opcion nuevamente");
        return;


    }
    public static void desplegarTodo(SistemaPokedex sistemaPokedex){
        StdOut.println("""
                ****Desplegando pokemon (Ordenados alfabeticamente)****
                
                """);
        String[] vecInfo = sistemaPokedex.ordenarAlfabeticamente();
        if(vecInfo == null)
        {
            StdOut.println("[!][!] No hay pokemon en la pokedex [!][!]");
                    return;
        }
        for (String nombre : vecInfo)
        {
            StdOut.println("\n"+nombre);
        }


    }

    public static void desplegarPorTipo(){
        String opcion;
        StdOut.println("""
                ****DESPLEGAR POR TIPO****
                
                Ingrese el tipo que desea ver ->
                
                """);
        opcion = StdIn.readString();



    }

    public static void desplegarPrimeraEvolucion(){
        //Usar arrayList para guardar los pokemon que tienen primera evolucion

    }
    public static void MenuBusquedaPersonalizada(){

        String opcion = "X";
        while(!opcion.equalsIgnoreCase("C")){
            StdOut.println("""
                
                ****BUSQUEDA PERSONALIZADA****
                
                [A] Buscar por nombre
                [B] Buscar por ID
                [C] Volver al menu principal
                """);

            opcion = StdIn.readString();
            switch (opcion){
                case "A" -> busquedaPorNombre();
                case "B" -> busquedaporID();
                case "C" -> StdOut.println("Volviendo al menu principal...");
            }
        }

    }

    private static void busquedaporID() {
    }

    private static void busquedaPorNombre() {
        
    }


    public static void leerArchivo(SistemaPokedex sistemaPokedex) throws IOException{
        ArchivoEntrada archivoEntrada = new ArchivoEntrada("kanto.txt");

        while (!archivoEntrada.isEndFile()) {

            Registro registro = archivoEntrada.getRegistro();
            if(registro != null){

                String id = registro.getString();
                String nombre = registro.getString();
                String etapa = registro.getString();
                String evoSiguiente = registro.getString();
                String evoPrevia = registro.getString();
                String tipo1 = registro.getString();
                String tipo2 = registro.getString();

               agregarPokemon(id,nombre,etapa,evoSiguiente,evoPrevia,tipo1,tipo2,sistemaPokedex);



            }
            }
            

        }







    public static void main(String[] args) throws IOException {
        SistemaPokedex sistemaPokedex = new SistemaPokedexImpl();
        sistemasPrincipales(sistemaPokedex);

    }

    private static boolean agregarPokemon(String id,String nombre, String etapa, String evolucionSiguiente, String evolucionPrevia, String tipo1, String tipo2, SistemaPokedex sistemaPokedex){
        return true;
    }
    private static boolean ordenarAlfabeticamente(){
        return true;

    }

    public static void sistemasPrincipales(SistemaPokedex sistemaPokedex) throws IOException {
        leerArchivo(sistemaPokedex);
        menuPrincipal(sistemaPokedex);
        StdOut.println();

    }





}