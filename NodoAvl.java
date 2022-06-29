public class NodoAvl extends Nodo{
    int factorEquilibrio;
    
    public NodoAvl(Object objetoCualquiera){
        super(objetoCualquiera);
        factorEquilibrio = 0;
    }

    public NodoAvl(Object objetoCualquiera, NodoAvl ramaIzquierda, NodoAvl ramaDerecha){
        super(ramaIzquierda, objetoCualquiera, ramaDerecha);
        factorEquilibrio = 0;
    }
}
