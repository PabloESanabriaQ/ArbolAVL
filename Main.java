public class Main {
    public static void main(String[] args) throws Exception {
        
    ArbolBinario arbol;
    Nodo a1, a2, a;
    PilaVector pila = new PilaVector();

    a1 = ArbolBinario.nuevoArbol(null, new Perro("Floki", "Lou"), null);
    a2 = ArbolBinario.nuevoArbol(null, new Perro("Rocki", "Lou"), null);
    a = ArbolBinario.nuevoArbol(a1, new Perro("Lena", "Emma"), a2);

    pila.insertar(a);

    a1 = ArbolBinario.nuevoArbol(null, new Perro("Neo", "Vale"), null);
    a2 = ArbolBinario.nuevoArbol(null, new Perro("Pitu", "Vale"), null);
    a = ArbolBinario.nuevoArbol(a1, new Perro ("Birra", "Mica"), a2);

    pila.insertar(a);

    a2 = (Nodo) pila.quitar();
    a1 = (Nodo) pila.quitar();
    a = ArbolBinario.nuevoArbol(a1,new Perro("Nerom", "Agus"), a2);
    arbol = new ArbolBinario(a);

    System.out.println("");
    System.out.println("Recorrido en preorden:");
    System.out.println("");
    arbol.preorden(a);
    System.out.println("");
    System.out.println("Recorrido en orden:");
    System.out.println("");
    arbol.inorden(a);
    System.out.println("");
    System.out.println("Recorrido en posorden:");
    System.out.println("");
    arbol.postorden(a);

    }

}
