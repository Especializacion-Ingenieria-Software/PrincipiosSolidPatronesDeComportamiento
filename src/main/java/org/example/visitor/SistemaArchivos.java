package org.example.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Estructura para contener múltiples archivos (estructura de objetos)
 */
class SistemaArchivos {
    private List<Archivo> archivos = new ArrayList<>();

    /**
     * Añade un archivo al sistema
     * @param archivo El archivo a añadir
     */
    public void addArchivo(Archivo archivo) {
        archivos.add(archivo);
    }

    /**
     * Aplica una operación a todos los archivos del sistema
     * @param operacion La operación a aplicar
     */
    public void ejecutarOperacion(OperacionArchivo operacion) {
        for (Archivo archivo : archivos) {
            archivo.aceptar(operacion);
        }
    }
}