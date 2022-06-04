import java.io.IOException;
import java.util.Vector;

public class PilaVector {
    private static final int INICIAL = 19;
    private int cima;
    private Vector<Nodo> listaPila;

    public PilaVector(){
        cima = -1;
        listaPila = new Vector<>(INICIAL);
    }

    public void insertar(Nodo nodo) throws IOException{
        cima++;
        listaPila.addElement(nodo);
    }

    public Nodo quitar() throws Exception{
        Nodo aux;
        if(pilaVacia()){
            throw new Exception("Pila vacía, no se puede extraer.");
        }
        aux = listaPila.elementAt(cima);
        listaPila.removeElementAt(cima);
        cima--;
        return aux;
    }

    public Nodo cimaPila()throws Exception {
        if(pilaVacia()){
            throw new Exception("Pila vacía, no se puede extraer.");
        }
        return listaPila.elementAt(cima);
    }

    private boolean pilaVacia() {
        return cima == -1;
    }

    public void limpiarPila() throws Exception {
        while(!pilaVacia()){
            quitar();
        }
    }
}
