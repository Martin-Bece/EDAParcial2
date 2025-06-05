package edaparcial2;

public class EDAParcial2 {

    public static void main(String[] args) {
        Arbol a = new Arbol();
        
//        a.insertar("Pancreas");
//        a.insertar("Las");
//        a.insertar("La");
//        a.insertar("Pancreas");
//        a.insertar("Oscilacion");
//        a.insertar("Aracnido");
//        a.insertar("Bulgaria");
//        a.insertar("Petrificado");
//        
        a.inOrden();
        
        DiscursoAnalisis d = new DiscursoAnalisis();
        
        String texto = "Área hola que onda esto es un texto para probar el metodo de dividir palabras dentro de un discurso";
        
        String[]arroba = d.DividirTexto(texto);
        
        for (int i = 0; i < arroba.length; i++) {
            a.insertar(arroba[i]);
        }
        
        a.inOrden();
        
    }
    
}
