public class ArbolAvl {

	NodoAvl raiz;

	public ArbolAvl() {
		raiz = null;
	}

	public NodoAvl raizArbol() {
		return raiz;
	}

	private NodoAvl rotacionII(NodoAvl n, NodoAvl n1) {
		n.setIzquierdo(n1.getDerecho());
		n1.setDerecho(n);
		// actualización de los factores de equilibrio
		if (n1.factorEquilibrio == -1) // se cumple en la inserción
		{
			n.factorEquilibrio = 0;
			n1.factorEquilibrio = 0;
		} else {
			n.factorEquilibrio = -1;
			n1.factorEquilibrio = 1;
		}
		
		return n1;
	}

	private NodoAvl rotacionDD(NodoAvl n, NodoAvl n1) {
		n.setDerecho(n1.getIzquierdo());
		n1.setIzquierdo(n);
		// actualización de los factores de equilibrio
		if (n1.factorEquilibrio == +1) // se cumple en la inserción
		{
			n.factorEquilibrio = 0;
			n1.factorEquilibrio = 0;
		} else {
			n.factorEquilibrio = +1;
			n1.factorEquilibrio = -1;
		}

		return n1;
	}

	private NodoAvl rotacionID(NodoAvl n, NodoAvl n1) {
		NodoAvl n2;

		n2 = (NodoAvl) n1.getDerecho();
		n.setIzquierdo(n2.getDerecho());
		n2.setDerecho(n);
		n1.setDerecho(n2.getIzquierdo());
		n2.setIzquierdo(n1);
		// actualización de los factores de equilibrio
		if (n2.factorEquilibrio == +1){
			n1.factorEquilibrio = -1;
		} else{
			n1.factorEquilibrio = 0;
		}
		if (n2.factorEquilibrio == -1){
			n.factorEquilibrio = 1;
		} else{
			n.factorEquilibrio = 0;
		}
		n2.factorEquilibrio = 0;

		return n2;
	}

	private NodoAvl rotacionDI(NodoAvl n, NodoAvl n1){
		NodoAvl n2;
		n2 = (NodoAvl)n1.getIzquierdo();
		n.setDerecho(n2.getIzquierdo());
		n2.setIzquierdo(n);
		n1.setIzquierdo(n2.getDerecho());
		n2.setDerecho(n1);
		 // actualización de los factores de equilibrio
		 if (n2.factorEquilibrio == +1){
			n.factorEquilibrio = -1;
		} else{
			n.factorEquilibrio = 0;
		}
		if (n2.factorEquilibrio == -1){
			n1.factorEquilibrio = 1;
		} else{
			n1.factorEquilibrio = 0;
		}
		n2.factorEquilibrio = 0;

		return n2;
	}
}