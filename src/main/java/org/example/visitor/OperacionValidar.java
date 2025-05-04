package org.example.visitor;

/**
 * Visitante Concreto (ConcreteVisitor) - Operación de validación
 */
class OperacionValidar implements OperacionArchivo {

    @Override
    public void visitar(PDF pdf) {
        System.out.println("Validando PDF: " + pdf.getNombre());
        System.out.println("  Verificando integridad del documento");
        System.out.println("  Comprobando estructura de " + pdf.getNumeroPaginas() + " páginas");
        if (pdf.tieneSeguridad()) {
            System.out.println("  Verificando firmas digitales y certificados");
        }
        System.out.println("  PDF validado correctamente");
    }

    @Override
    public void visitar(Excel excel) {
        System.out.println("Validando Excel: " + excel.getNombre());
        System.out.println("  Verificando integridad del documento");
        System.out.println("  Comprobando estructura de " + excel.getNumeroHojas() + " hojas");
        if (excel.tieneFormulas()) {
            System.out.println("  Comprobando fórmulas para detectar errores o referencias circulares");
        }
        System.out.println("  Excel validado correctamente");
    }

    @Override
    public void visitar(Word word) {
        System.out.println("Validando Word: " + word.getNombre());
        System.out.println("  Verificando integridad del documento");
        System.out.println("  Realizando comprobación ortográfica en " + word.getPalabrasTotal() + " palabras");
        if (word.tieneImagenes()) {
            System.out.println("  Validando tamaño y formato de imágenes");
        }
        System.out.println("  Word validado correctamente");
    }
}
