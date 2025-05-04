package org.example.visitor;

/**
 * Elemento Concreto (ConcreteElement) - Word
 */
class Word implements Archivo {
    private String nombre;
    private int palabrasTotal;
    private boolean tieneImagenes;

    /**
     * Constructor para archivos Word
     * @param nombre Nombre del archivo
     * @param palabrasTotal Recuento de palabras
     * @param tieneImagenes Si contiene imágenes
     */
    public Word(String nombre, int palabrasTotal, boolean tieneImagenes) {
        this.nombre = nombre;
        this.palabrasTotal = palabrasTotal;
        this.tieneImagenes = tieneImagenes;
    }

    @Override
    public void aceptar(OperacionArchivo visitante) {
        // Llama al método visitar específico para Word
        visitante.visitar(this);
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    public int getPalabrasTotal() {
        return palabrasTotal;
    }

    public boolean tieneImagenes() {
        return tieneImagenes;
    }
}