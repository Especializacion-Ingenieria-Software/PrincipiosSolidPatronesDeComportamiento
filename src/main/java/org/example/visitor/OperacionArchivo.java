package org.example.visitor;

/**
 * Interfaz Visitante (Visitor) - Define métodos de visita para cada tipo de elemento
 */
interface OperacionArchivo {
    /**
     * Realiza una operación en un archivo PDF
     * @param pdf El archivo PDF a procesar
     */
    void visitar(PDF pdf);

    /**
     * Realiza una operación en un archivo Excel
     * @param excel El archivo Excel a procesar
     */
    void visitar(Excel excel);

    /**
     * Realiza una operación en un archivo Word
     * @param word El archivo Word a procesar
     */
    void visitar(Word word);
}