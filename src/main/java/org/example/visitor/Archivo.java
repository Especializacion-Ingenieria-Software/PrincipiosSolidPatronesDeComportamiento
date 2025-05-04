package org.example.visitor;


/**
 * Interfaz Elemento (Element) - Define la operación "accept" que toma un Visitante
 */

interface Archivo {
    /**
     * Acepta un visitante que realizará operaciones sobre este archivo (Interfaz)
     * @param visitante El visitante que procesará este archivo
     */
    void aceptar(OperacionArchivo visitante);

    /**
     * @return El nombre del archivo
     */
    String getNombre();
}