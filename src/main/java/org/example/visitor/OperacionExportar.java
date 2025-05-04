package org.example.visitor;

/**
 * Visitante Concreto (ConcreteVisitor) - Operación de exportación
 */
class OperacionExportar implements OperacionArchivo {

    @Override
    public void visitar(PDF pdf) {
        System.out.println("Exportando PDF: " + pdf.getNombre());
        System.out.println("  Opciones disponibles: Exportar a imagen, texto plano o HTML");
        if (pdf.tieneSeguridad()) {
            System.out.println("  AVISO: La seguridad puede limitar algunas opciones de exportación");
        }
        System.out.println("  Exportación completada");
    }

    @Override
    public void visitar(Excel excel) {
        System.out.println("Exportando Excel: " + excel.getNombre());
        System.out.println("  Opciones disponibles: CSV, XML, JSON, PDF");
        if (excel.tieneFormulas()) {
            System.out.println("  Las fórmulas se han convertido en valores estáticos en la exportación");
        }
        System.out.println("  Exportación completada");
    }

    @Override
    public void visitar(Word word) {
        System.out.println("Exportando Word: " + word.getNombre());
        System.out.println("  Opciones disponibles: PDF, TXT, RTF, HTML");
        if (word.tieneImagenes()) {
            System.out.println("  Las imágenes se han incluido en la exportación");
        }
        System.out.println("  Exportación completada");
    }
}