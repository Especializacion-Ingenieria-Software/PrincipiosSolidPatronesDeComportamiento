package org.example.visitor;

/**
 * Visitante Concreto (ConcreteVisitor) - Operación de impresión
 */
class OperacionImprimir implements OperacionArchivo {

    @Override
    public void visitar(PDF pdf) {
        System.out.println("Imprimiendo PDF: " + pdf.getNombre());
        System.out.println("  Configuración: Doble cara, con " + pdf.getNumeroPaginas() + " páginas");
        if (pdf.tieneSeguridad()) {
            System.out.println("  AVISO: Este PDF tiene seguridad. Solicitando credenciales...");
        }
        System.out.println("  Enviando a la impresora...");
    }

    @Override
    public void visitar(Excel excel) {
        System.out.println("Imprimiendo Excel: " + excel.getNombre());
        System.out.println("  Configuración: Ajustando " + excel.getNumeroHojas() + " hojas para optimizar papel");
        if (excel.tieneFormulas()) {
            System.out.println("  Incluyendo resultados de fórmulas en la impresión");
        }
        System.out.println("  Enviando a la impresora...");
    }

    @Override
    public void visitar(Word word) {
        System.out.println("Imprimiendo Word: " + word.getNombre());
        System.out.println("  Configuración: Documento de texto con " + word.getPalabrasTotal() + " palabras");
        if (word.tieneImagenes()) {
            System.out.println("  Configurando calidad alta para las imágenes incluidas");
        }
        System.out.println("  Enviando a la impresora...");
    }
}