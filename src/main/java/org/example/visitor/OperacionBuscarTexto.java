package org.example.visitor;

/**
 * Nuevo Visitante (añadido sin modificar las clases Archivo) - Operación de búsqueda
 */
class OperacionBuscarTexto implements OperacionArchivo {
    private String textoBuscado;

    /**
     * Constructor para la operación de búsqueda
     * @param textoBuscado Texto a buscar en los archivos
     */
    public OperacionBuscarTexto(String textoBuscado) {
        this.textoBuscado = textoBuscado;
    }

    @Override
    public void visitar(PDF pdf) {
        System.out.println("Buscando texto en PDF: " + pdf.getNombre());
        System.out.println("  Ejecutando búsqueda OCR en " + pdf.getNumeroPaginas() + " páginas");
        if (pdf.tieneSeguridad()) {
            System.out.println("  AVISO: La seguridad puede limitar la capacidad de búsqueda");
        }
        System.out.println("  Búsqueda de \"" + textoBuscado + "\" completada");
    }

    @Override
    public void visitar(Excel excel) {
        System.out.println("Buscando texto en Excel: " + excel.getNombre());
        System.out.println("  Buscando en celdas y fórmulas de " + excel.getNumeroHojas() + " hojas");
        if (excel.tieneFormulas()) {
            System.out.println("  Incluyendo resultados de fórmulas en la búsqueda");
        }
        System.out.println("  Búsqueda de \"" + textoBuscado + "\" completada");
    }

    @Override
    public void visitar(Word word) {
        System.out.println("Buscando texto en Word: " + word.getNombre());
        System.out.println("  Buscando en contenido principal, encabezados y pies de página");
        System.out.println("  Área de búsqueda: " + word.getPalabrasTotal() + " palabras");
        if (word.tieneImagenes()) {
            System.out.println("  No se puede buscar texto en imágenes sin OCR adicional");
        }
        System.out.println("  Búsqueda de \"" + textoBuscado + "\" completada");
    }
}
