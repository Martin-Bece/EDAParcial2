package edaparcial2;

import java.util.ArrayList;

class Arbol {
    Nodo raiz;

    public Arbol() {
        raiz = null;
    }

    public void insertar(String palabra) {
        palabra = palabra.toLowerCase();
        if (raiz == null) {
            raiz = new Nodo(palabra);
        } else {
            insertarAux(raiz, palabra);
        }
    }

    private void insertarAux(Nodo actual, String palabra) {
        int cmp = palabra.compareTo(actual.palabra);
        if (cmp == 0) {
            actual.contador++;
        } else if (cmp < 0) {
            if (actual.izq == null) {
                actual.izq = new Nodo(palabra);
            } else {
                insertarAux(actual.izq, palabra);
            }
        } else {
            if (actual.der == null) {
                actual.der = new Nodo(palabra);
            } else {
                insertarAux(actual.der, palabra);
            }
        }
    }
    
    public ArrayList<String> inOrden() {
        ArrayList<String> list = new ArrayList<>();
        inOrdenAux(raiz, list);
        return list;
    }

    private void inOrdenAux(Nodo nodo, ArrayList<String> list) {
        if (nodo != null) {
            inOrdenAux(nodo.izq, list);
            list.add(nodo.palabra);
            System.out.println(" - " + nodo.palabra);
            inOrdenAux(nodo.der, list);
        }
    }
}
