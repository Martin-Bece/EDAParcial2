package edaparcial2;

import java.util.Scanner;

public class EDAParcial2 {
    
    public static void main(String[] args) {
        Arbol a = new Arbol();
         
        String opcion;
        Scanner leer=new Scanner (System.in);

        do {
            System.out.println("\n--- Menú de Análisis de Discurso ---");
            System.out.println("1. Ingresar un texto/discurso");
            System.out.println("2. Saber la cantidad de palabras usadas");
            System.out.println("3. Saber la palabra que más se repite (omitiendo artículos y monosílabos)");
            System.out.println("4. Saber cuántas palabras negativas o poco inteligentes se usan");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = leer.nextLine();

            switch (opcion) {
                case "1":
                    //ingresarTexto();
                    break;
                case "2":
                    //saberCantidadPalabrasUsadas();
                    break;
                case "3":
                    //saberPalabraMasRepetida();
                    break;
                case "4":
                    //saberCuantasPalabrasNegativasSeUsan();
                    break;        
                case "5":
                    System.out.println("Saliendo de la aplicación");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        } while (!opcion.equals("5"));
        leer.close();
    
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