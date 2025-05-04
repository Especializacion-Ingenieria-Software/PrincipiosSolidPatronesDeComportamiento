package org.example.visitor;

/**
 * Elemento Concreto (ConcreteElement) - PDF
 */
class PDF implements Archivo {
    private String nombre;
    private int numeroPaginas;
    private boolean tieneSeguridad;

    /**
     * Constructor para archivos PDF
     * @param nombre Nombre del archivo
     * @param numeroPaginas Número de páginas del PDF
     * @param tieneSeguridad Si tiene seguridad habilitada
     */
    public PDF(String nombre, int numeroPaginas, boolean tieneSeguridad) {
        this.nombre = nombre;
        this.numeroPaginas = numeroPaginas;
        this.tieneSeguridad = tieneSeguridad;
    }

    @Override
    public void aceptar(OperacionArchivo visitante) {
        // Llama al método visitar específico para PDFs
        visitante.visitar(this);
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public boolean tieneSeguridad() {
        return tieneSeguridad;
    }
}