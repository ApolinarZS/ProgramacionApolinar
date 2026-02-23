package Tema6;

class PublicacionFoto implements PublicacionConReaccion, AbrirPublicacion {
    @Override public void publicar() { System.out.println("Subiendo imagen JPG..."); }
    @Override public void compartir() { System.out.println("Compartiendo foto en Stories."); }
    @Override public void comentar(String texto) { System.out.println("Comentario en la foto: " + texto); }
    @Override public void abrir() { System.out.println("Ampliando foto a pantalla completa."); }
}
