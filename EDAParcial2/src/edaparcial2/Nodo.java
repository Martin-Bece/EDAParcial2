package edaparcial2;

public class Nodo {
    String palabra;
    int contador = 1;
    Nodo izq, der;
    
    public Nodo(String palabra){
        this.palabra = palabra;
        this.contador = contador;
        izq = null;
        der = null;
    }
}
