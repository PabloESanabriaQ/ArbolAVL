public class Nodo{
    protected Object objetoCualquiera;
    protected Nodo izquierdo;
    protected Nodo derecho;

    public Nodo(Object objetoCualquiera){
        this.objetoCualquiera = objetoCualquiera;
        izquierdo = derecho = null;
    }

    public Nodo(Nodo ramaIzquierda, Object objetoCualquiera, Nodo ramaDerecha){
        this.objetoCualquiera = objetoCualquiera;
        this.izquierdo = ramaIzquierda;
        this.derecho = ramaDerecha;
    }

    public Object getRaiz(){
        return objetoCualquiera;
    }

    public void setRaiz(Object nuevoObjetoRaiz){
        this.objetoCualquiera = nuevoObjetoRaiz;
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
        System.out.println(objetoCualquiera.toString());
    }

}