public class Main {
    static final int TOPEMAX = 999;
    public static void main(String [] a) throws Exception {
        ArbolAvl avl = new ArbolAvl();
		Numero elemento;
		int numNodos;
		while (altura(avl.raizArbol()) < 5) {
            elemento = new Numero((int)(Math.random()*TOPEMAX) + 1);
            avl.insertar(elemento);
        }
        numNodos = visualizar(avl.raizArbol());
		System.out.println("\n Número de nodos: " + numNodos);
    }

    static int visualizar (NodoAvl r){ //escribir claves de árbol
		 if (r != null) {
            int cuantosIzquierda, cuantosDerecha;
            cuantosIzquierda = visualizar((NodoAvl)r.getIzquierdo());
            System.out.print(r.getRaiz());
            cuantosDerecha = visualizar((NodoAvl)r.getDerecho());
            return cuantosIzquierda + cuantosDerecha + 1;
        } else{
            return 0;
        }
    }
    
    static int altura(NodoAvl r) {// calcula y devuelve altura
        if (r != null){
            return mayor(altura((NodoAvl)r.getIzquierdo()), altura((NodoAvl)r.getDerecho())) + 1;
        }
		 else {
            return 0;
         }
        }
        
    static int mayor (int x, int y){
        return (x > y ? x : y);
    }
    
}
