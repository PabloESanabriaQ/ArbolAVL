public class NodoAvl extends Nodo{
    int factorEquilibrio;
    
    public NodoAvl(Object valor){
        super(valor);
        factorEquilibrio = 0;
    }

    public NodoAvl(Object valor, NodoAvl ramaIzquierda, NodoAvl ramaDerecha){
        super(ramaIzquierda, valor, ramaDerecha);
        factorEquilibrio = 0;
    }
}
