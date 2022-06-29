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

    public static Nodo nuevoArbol(Nodo ramaIzquierda, Object tipoObjeto, Nodo ramaDerecha) {
        return new Nodo(ramaIzquierda, tipoObjeto, ramaDerecha);
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

    // Encontrar número nodos de un árbol binario
    public static int numNodos(Nodo raiz){
        if(raiz == null){
            return 0;
        } else {
            return 1 + numNodos(raiz.getDerecho()) + numNodos(raiz.getIzquierdo());
        }
    }
}
