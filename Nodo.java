public class Nodo{
    protected Perro perrito;
    protected Nodo izquierdo;
    protected Nodo derecho;

    public Nodo(Perro perrito){
        this.perrito = perrito;
        izquierdo = derecho = null;
    }

    public Nodo(Nodo ramaIzquierda, Perro perrito, Nodo ramaDerecha){
        this.perrito = perrito;
        this.izquierdo = ramaIzquierda;
        this.derecho = ramaDerecha;
    }


    public Perro getPerrito() {
        return this.perrito;
    }

    public void setPerrito(Perro perrito) {
        this.perrito = perrito;
    }

    public Nodo getIzquierdo() {
        return this.izquierdo;
    }

    public void setIzquierdo(Nodo izquierdo) {
        this.izquierdo = izquierdo;
    }

    public Nodo getDerecho() {
        return this.derecho;
    }

    public void setDerecho(Nodo derecho) {
        this.derecho = derecho;
    }

}