import java.io.IOException;
import java.util.Vector;

public class PilaVector {
    private static final int INICIAL = 19;
    private int cima;
    private Vector<Perro> listaPila;

    public PilaVector(){
        cima = -1;
        listaPila = new Vector<>(INICIAL);
    }

    public void insertar(Perro perrito) throws IOException{
        cima++;
        listaPila.addElement(perrito);
    }

    public Perro quitar() throws Exception{
        Perro aux;
        if(pilaVacia()){
            throw new Exception("Pila vacía, no se puede extraer.");
        }
        aux = listaPila.elementAt(cima);
        listaPila.removeElementAt(cima);
        cima--;
        return aux;
    }

    public Perro cimaPila()throws Exception {
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
