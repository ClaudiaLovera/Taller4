package Taller4;
import ucn.ArchivoEntrada;
import ucn.ArchivoSalida;
import ucn.*;
import java.io.File;
import java.io.FileNotFoundException;
import ucn.Registro;
import java.io.IOException;
import java.util.*;


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
                case "A" -> desplegarPorRango();
                case "B" -> desplegarTodo();
                case "C" -> desplegarPorTipo();
                case "D" -> desplegarPrimeraEvolucion();
                case "E" -> MenuBusquedaPersonalizada();
                case "F" -> StdOut.println("""
                        Gracias por entrar al sistema
                        """);
            }
        }

    }

    public static void desplegarPorRango(){

    }
    public static void desplegarTodo(){

    }

    public static void desplegarPorTipo(){

    }

    public static void desplegarPrimeraEvolucion(){

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


    public static void leerArchivo() throws IOException{
        ArchivoEntrada archivoEntrada = new ArchivoEntrada("kanto.txt");

        List<String> listaPokemon = new ArrayList<>();


        while (!archivoEntrada.isEndFile()) {
            Registro registro = archivoEntrada.getRegistro();

            int id = registro.getInt();
            String nombre = registro.getString();
            String etapa = registro.getString();
            String evoSiguiente = registro.getString();
            String evoPrevia = registro.getString();
            String tipo1 = registro.getString();
            String tipo2 = registro.getString();

            listaPokemon.add(nombre);
        }
        archivoEntrada.close();

        Collections.sort(listaPokemon, new Comparator<String>() {
            public int compare(String linea1, String linea2) {
                return linea1.compareToIgnoreCase(linea2);
            }
        });

        // Imprimir líneas ordenadas
        for (String linea : listaPokemon) {
            System.out.println(linea);
        }

    }

    public static void main(String[] args) throws IOException {
        leerArchivo();
    }


}