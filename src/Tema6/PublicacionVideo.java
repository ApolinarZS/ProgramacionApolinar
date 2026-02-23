package Tema6;

class PublicacionVideo implements PublicacionConReaccion, AbrirPublicacion {
    @Override public void publicar() { System.out.println("Procesando y subiendo vídeo MP4..."); }
    @Override public void compartir() { System.out.println("Enviando vídeo por mensaje directo."); }
    @Override public void comentar(String texto) { System.out.println("Comentario en el vídeo: " + texto); }
    @Override public void abrir() { System.out.println("Reproduciendo vídeo..."); }
}
