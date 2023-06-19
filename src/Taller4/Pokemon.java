package Taller4;


public class Pokemon {
    private String id;
    private String nombre;
    private String etapa;
    private String evolucionSiguiente;
    private String evolucionPrevia;
    private String tipo1;
    private String tipo2;

    /**
     * Constructor de la clase
     * @param id id del pokemon
     * @param nombre nombre del pokemon
     * @param etapa eatpa del pokemon
     * @param evolucionSiguiente evolucion del pokemon
     * @param evolucionPrevia evolucion del pokemon
     * @param tipo1 tipo de pokemon
     * @param tipo2 tipo de pokemon
     */
    public Pokemon(String id, String nombre, String etapa, String evolucionSiguiente, String evolucionPrevia, String tipo1, String tipo2) {
        this.id = id;
        this.nombre = nombre;
        this.etapa = etapa;
        this.evolucionSiguiente = evolucionSiguiente;
        this.evolucionPrevia = evolucionPrevia;
        this.tipo1 = tipo1;
        this.tipo2 = tipo2;
    }



    /**
     * Obtiene el id del pokemon
     * @return iD del pokemon
     */
    public String getId() {
        return id;
    }

    /**
     * Establece un nuevo id para el pokemon
     * @param id nuevo id del pokemon
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre el pokemon
     * @return Nombre del pokemon
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece un nuevo nomhre para el pokemon
     * @param nombre nuevo nombre del pokemon
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la etapa en la que se encuentra el pokemon
     * @return String con etapa del pokemon
     */
    public String getEtapa() {
        return etapa;
    }


    /**
     * Obtiene la evolucion siguiente del pokemon
     * @return Evolucion siguiente del pokemon
     */
    public String getEvolucionSiguiente() {
        return evolucionSiguiente;
    }


    /**
     * Obtiene la evolucion previa del pokemon
     * @return Previa evolucion del pokemon
     */
    public String getEvolucionPrevia() {
        return evolucionPrevia;
    }

    /**
     * Obtiene el tipo de pokemon que es
     * @return tipo de pokemon
     */
    public String getTipo1() {
        return tipo1;
    }

    /**
     * Obtiene el tipo de pokemon que es
     * @return tipo de pokemon
     */
    public String getTipo2() {
        return tipo2;
    }

}