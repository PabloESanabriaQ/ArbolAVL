public class ArbolBinario {
    protected Nodo raiz;

    public ArbolBinario(){
        raiz = null;
    }

    public ArbolBinario(Nodo raiz){
        this.raiz = raiz;
    }


    public Nodo getRaiz() {
        return this.raiz;
    }

    public boolean estaVacio(){
        return raiz == null;
    }
    
    public static Nodo nuevoArbol(Nodo ramaIzquierda, Perro perrito, Nodo ramaDerecha){
        return new Nodo(ramaIzquierda, perrito, ramaDerecha);
    }
}
