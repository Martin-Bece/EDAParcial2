package edaparcial2;

import java.util.List;

public class DiscursoAnalisis {

    private static int maxContador = 0;
    private static String palabraMasRepetida = "";

    public DiscursoAnalisis() {
    }

    public String[] DividirTexto(String discurso) {
        String texto;
        texto = discurso.toLowerCase();
        texto = texto.replaceAll("[.,;:!?\"()\\[\\]{}<>¡¿–—]", "");
        texto = texto.replaceAll("\\s+", " "); 
        return texto.trim().split(" ");
    }

    public void SaberPalabraMasRepetida(Arbol arbol, List<String> monosilabas) {
        maxContador = 0;
        palabraMasRepetida = "";

        buscarMasRepetida(arbol.getRaiz(), monosilabas);

        if (!palabraMasRepetida.equals("") && maxContador > 1) {
            System.out.println("La palabra más repetida es: \"" + palabraMasRepetida + "\" con " + (maxContador) + " repeticiones.");
        } else {
            System.out.println("No hay palabra más repetida (Hay mas de 1 palabra con repeticiones maximas o solo se ingresaron monosilabos).");
        }
    }

    private void buscarMasRepetida(Nodo nodo, List<String> monosilabas) {
        if (nodo == null) {
            return;
        }

        buscarMasRepetida(nodo.izq, monosilabas);

        if (!monosilabas.contains(nodo.palabra.toLowerCase()) && nodo.contador > maxContador) {
            maxContador = nodo.contador;
            palabraMasRepetida = nodo.palabra;
        }

        buscarMasRepetida(nodo.der, monosilabas);
    }

    public void saberCuantasPalabrasNegativasYPositivasSeUsan(Arbol arbol, List<String> palabrasInteligentes, List<String> palabrasNegativas) {
        int[] resultados = contarPalabras(arbol.getRaiz(), palabrasInteligentes, palabrasNegativas);
        int contadorInteligentes = resultados[0];
        int contadorNegativas = resultados[1];

        System.out.println("Cantidad de palabras inteligentes usadas: " + contadorInteligentes);
        System.out.println("Cantidad de palabras negativas usadas: " + contadorNegativas);
    }

    private int[] contarPalabras(Nodo nodo, List<String> palabrasInteligentes, List<String> palabrasNegativas) {
    int contadorInteligentes = 0;
    int contadorNegativas = 0;

    if (nodo != null) {
        int[] izquierda = contarPalabras(nodo.izq, palabrasInteligentes, palabrasNegativas);
        int[] derecha = contarPalabras(nodo.der, palabrasInteligentes, palabrasNegativas);

        contadorInteligentes += izquierda[0] + derecha[0];
        contadorNegativas += izquierda[1] + derecha[1];

        String palabra = nodo.palabra.toLowerCase();

        if (palabrasInteligentes.contains(palabra)) {
            contadorInteligentes += nodo.contador;
            System.out.println("Palabra inteligente encontrada: " + palabra + " (" + nodo.contador + " veces)");
        } 
        if (palabrasNegativas.contains(palabra)) {
            contadorNegativas += nodo.contador;
            System.out.println("Palabra negativa encontrada: " + palabra + " (" + nodo.contador + " veces)");
        }
    }

    return new int[] {contadorInteligentes, contadorNegativas};
}


}

    

