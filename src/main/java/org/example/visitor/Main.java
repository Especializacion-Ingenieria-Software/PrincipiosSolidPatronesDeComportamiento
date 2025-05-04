package org.example.visitor;

public class Main {

    public static void main(String[] args) {
        SistemaArchivos sistema = new SistemaArchivos();

        sistema.addArchivo(new PDF("Informe2025.pdf", 100, true));
        sistema.addArchivo(new Excel("Informe2025.xlsx", 26, true));
        sistema.addArchivo(new Word("Informe2025.docx", 2500, true));
        sistema.addArchivo(new PDF("Manuales.pdf", 100, false));


        System.out.println("======= DEMOSTRANDO EL PATRÓN VISITOR =======");

        OperacionArchivo impresion = new OperacionImprimir();
        OperacionArchivo exportacion = new OperacionExportar();
        OperacionArchivo validacion = new OperacionValidar();
        OperacionArchivo busqueda = new OperacionBuscarTexto("confidencial");

        // Ejecutar diferentes operaciones en todos los archivos
        System.out.println("\n>> OPERACIÓN DE IMPRESIÓN <<");
        sistema.ejecutarOperacion(impresion);

        System.out.println("\n>> OPERACIÓN DE EXPORTACIÓN <<");
        sistema.ejecutarOperacion(exportacion);

        System.out.println("\n>> OPERACIÓN DE VALIDACIÓN <<");
        sistema.ejecutarOperacion(validacion);

        System.out.println("\n>> OPERACIÓN DE BÚSQUEDA DE TEXTO <<");
        sistema.ejecutarOperacion(busqueda);

        System.out.println("\n======= FIN DE LA DEMOSTRACIÓN =======");

        /*
         * OBSERVACIÓN IMPORTANTE:
         *
         * Hemos podido añadir la operación de búsqueda sin modificar ninguna
         * de las clases de Archivo existentes. Esto demuestra el principal
         * beneficio del patrón Visitor: separar los algoritmos de las estructuras
         * de objetos sobre las que operan.
         */


        /*
        * Estructura del patrón
        El patrón Visitor consta de cuatro elementos principales:

        Interfaz Elemento (Archivo): Define la operación aceptar() que permite a los visitantes procesar el elemento.
        Elementos Concretos (PDF, Excel, Word): Implementan la interfaz Archivo y contienen los datos específicos de cada tipo de documento.
        Interfaz Visitante (OperacionArchivo): Define métodos visitar() específicos para cada tipo de elemento.
        Visitantes Concretos (OperacionImprimir, OperacionExportar, etc.): Implementan la interfaz Visitante con operaciones específicas para cada tipo de elemento.
        * */

    }
}
