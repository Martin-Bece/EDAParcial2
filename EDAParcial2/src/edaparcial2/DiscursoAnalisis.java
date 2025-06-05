package edaparcial2;

public class DiscursoAnalisis {

    public DiscursoAnalisis() {
    }
    
    public String[] DividirTexto(String discurso){
        
        String texto = discurso.toLowerCase();
        
        texto = texto.replaceAll("[^a-záéíóúñ]+", " ");
        
        String[] palabras = texto.trim().split("\\s+");
        
        return palabras;
    }
    
}
