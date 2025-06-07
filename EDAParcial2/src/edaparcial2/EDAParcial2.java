package edaparcial2;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class EDAParcial2 {

    public static void main(String[] args) {
        Arbol Arbol = new Arbol();
        DiscursoAnalisis Discurso = new DiscursoAnalisis();

        String opcion;
        boolean flag = false;
        String texto = null;
        String[] palabras = {};
        Scanner leer = new Scanner(System.in);

        List<String> palabrasInteligentes = Arrays.asList(
                "preciso", "variado", "lógico", "creativo", "efímero", "inefable", "serendipia",
                "melifluo", "ataraxia", "perdurable", "inmenso", "extraordinario", "feliz", "optimista",
                "exitoso", "brillante", "acendrado", "alba", "epifanía", "nostal", "ineludible",
                "perspicaz", "inequívoco", "meticuloso", "disruptivo", "convergencia", "inherente",
                "pragmático", "ambiguo"
        );

        List<String> palabrasNegativas = Arrays.asList(
                "realmente", "literalmente", "siempre", "cosa", "fui", "súper", "re", "muy", "nada",
                "todo", "coso", "onda", "tipo", "así", "mal", "bien", "groso", "nivel", "posta", "viste"
        );

        List<String> monosilabas = Arrays.asList(
                "el", "la", "lo", "en", "de", "y", "o", "a", "es", "un", "yo", "tu", "mi", "me", "te", "si",
                "no", "ni", "ya", "fue", "sol", "pan", "que", "con", "del"
        );

        do {
            System.out.println("\n--- Menú de Análisis de Discurso ---");
            System.out.println("1. Ingresar un texto/discurso");
            System.out.println("2. Saber la cantidad de palabras usadas");
            System.out.println("3. Saber la palabra que más se repite (omitiendo artículos y monosílabos)");
            System.out.println("4. Saber cuántas palabras negativas o poco inteligentes se usan");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = leer.nextLine().trim();

            if ((texto == null || texto.isEmpty()) && !opcion.equals("1") && !opcion.equals("5")) {
                System.out.println("No hay discurso. Por favor ingrese el discurso para usar las demas opciones.");
            } else {

                switch (opcion) {

                    case "1":
                        Arbol.vaciar();
                        System.out.println("Ingresa el discurso: ");
                        texto = leer.nextLine();
                        palabras = Discurso.DividirTexto(texto);
                        for (String palabra : palabras) {
                            Arbol.insertar(palabra);
                        }
                        System.out.println("Discurso ingresado con exito.");
                        Arbol.inOrden();
                        break;

                    case "2":
                        System.out.println("Cantidad de palabras usadas: " + palabras.length);
                        break;

                    case "3":
                        Discurso.SaberPalabraMasRepetida(Arbol, monosilabas);
                        break;
                    case "4":
                        Discurso.saberCuantasPalabrasNegativasYPositivasSeUsan(Arbol, palabrasInteligentes, palabrasNegativas);
                        break;
                    case "5":
                        System.out.println("Saliendo de la aplicación");
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, intente de nuevo.");
                }
            }

        } while (!opcion.equals("5"));
        leer.close();

    }
}
