package Tema6;

class PublicacionTexto implements PublicacionConReaccion {
    @Override public void publicar() { System.out.println("Escribiendo estado en el muro..."); }
    @Override public void compartir() { System.out.println("Retuiteando texto."); }
    @Override public void comentar(String texto) { System.out.println("Nuevo comentario: " + texto); }
}
