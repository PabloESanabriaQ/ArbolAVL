public class ArbolBinario {
    protected Nodo raiz;

    public ArbolBinario() {
        raiz = null;
    }

    public ArbolBinario(Nodo raiz) {
        this.raiz = raiz;
    }

    public Nodo getRaiz() {
        return this.raiz;
    }

    public boolean estaVacio() {
        return raiz == null;
    }

    public static Nodo nuevoArbol(Nodo ramaIzquierda, Perro perrito, Nodo ramaDerecha) {
        return new Nodo(ramaIzquierda, perrito, ramaDerecha);
    }

    // Recorrido de un árbol binario en preorden
    public static void preorden(Nodo r) {
        if (r != null) {
            r.visitar();
            preorden(r.getIzquierdo());
            preorden(r.getDerecho());
        }
    }

    // Recorrido de un árbol binario en inorden
    public static void inorden(Nodo r) {
        if (r != null) {
            inorden(r.getIzquierdo());
            r.visitar();
            inorden(r.getDerecho());
        }
    }

    // Recorrido de un árbol binario en postorden
    public static void postorden(Nodo r) {
        if (r != null) {
            postorden(r.getIzquierdo());
            postorden(r.getDerecho());
            r.visitar();
        }
    }
}
