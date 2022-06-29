public class Nodo{
    protected Object tipoObjeto;
    protected Nodo izquierdo;
    protected Nodo derecho;

    public Nodo(Object tipoObjeto){
        this.tipoObjeto = tipoObjeto;
        izquierdo = derecho = null;
    }

    public Nodo(Nodo ramaIzquierda, Object tipoObjeto, Nodo ramaDerecha){
        this.tipoObjeto = tipoObjeto;
        this.izquierdo = ramaIzquierda;
        this.derecho = ramaDerecha;
    }

    public Object getRaiz(){
        return tipoObjeto;
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

    public void visitar(){        
        System.out.println(tipoObjeto.toString());
    }

}