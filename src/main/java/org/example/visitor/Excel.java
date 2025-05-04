package org.example.visitor;

/**
 * Elemento Concreto (ConcreteElement) - Excel
 */
class Excel implements Archivo {
    private String nombre;
    private int numeroHojas;
    private boolean tieneFormulas;

    /**
     * Constructor para archivos Excel
     * @param nombre Nombre del archivo
     * @param numeroHojas Número de hojas de cálculo
     * @param tieneFormulas Si contiene fórmulas
     */
    public Excel(String nombre, int numeroHojas, boolean tieneFormulas) {
        this.nombre = nombre;
        this.numeroHojas = numeroHojas;
        this.tieneFormulas = tieneFormulas;
    }

    @Override
    public void aceptar(OperacionArchivo visitante) {
        // Llama al método visitar específico para Excel
        visitante.visitar(this);
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    public int getNumeroHojas() {
        return numeroHojas;
    }

    public boolean tieneFormulas() {
        return tieneFormulas;
    }
}