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


	public void insertar (Object valor)throws Exception {
		Comparador dato;
		Logical h = new Logical(false); // intercambia un valor booleano
		dato = (Comparador) valor;
		raiz = insertarAvl(raiz, dato, h);
	}

	private NodoAvl insertarAvl(NodoAvl raiz, Comparador dt, Logical h) throws Exception {
		NodoAvl n1;
	if (raiz == null){
			 raiz = new NodoAvl(dt);
			 h.setLogical(true);
	} else if (dt.menorQue(raiz.getRaiz())) {
			 NodoAvl iz;
			 iz = insertarAvl((NodoAvl) raiz.getIzquierdo(), dt, h);
			 raiz.setIzquierdo(iz);
			 // regreso por los nodos del camino de búsqueda
			 if (h.booleanValue()){
				 // decrementa el fe por aumentar la altura de rama izquierda
				 switch (raiz.factorEquilibrio){
					case 1:
						 raiz.factorEquilibrio = 0;
						 h.setLogical(false);
						 break;		
					case 0:				
						raiz.factorEquilibrio = -1;
						break;
					case -1: // aplicar rotación a la izquierda
						 n1 = (NodoAvl)raiz.getIzquierdo();
						 if (n1.factorEquilibrio == -1)
							 raiz = rotacionII(raiz, n1);
						 else
							 raiz = rotacionID(raiz, n1);
						 h.setLogical(false);
				 }
			 }
	} else if (dt.mayorQue(raiz.getRaiz())) {
			 NodoAvl dr;
			 dr = insertarAvl((NodoAvl)raiz.getDerecho(), dt, h);
			 raiz.setDerecho(dr);
			 // regreso por los nodos del camino de búsqueda
			if (h.booleanValue()){
				 // incrementa el fe por aumentar la altura de rama izquierda
				 switch (raiz.factorEquilibrio) {
					case 1:		 // aplicar rotación a la derecha
						 n1 = (NodoAvl)raiz.getDerecho();
						 if (n1.factorEquilibrio == +1){
							raiz = rotacionDD(raiz, n1);
						 } else {
							raiz = rotacionDI(raiz,n1);
						 }
						 h.setLogical(false);
						break;
					case 0:
				 		raiz.factorEquilibrio = +1;
					 	break;			
					case -1:
						raiz.factorEquilibrio = 0;
						h.setLogical(false);				
			 	}
		 	}
	} else{
			throw new Exception("No puede haber claves repetidas " );
		}
		return raiz;
	}

	public void eliminar (Object valor) throws Exception {
		Comparador dato;
		dato = (Comparador) valor;
		Logical flag = new Logical(false);
		raiz = borrarAvl(raiz, dato, flag);
	}

	private NodoAvl borrarAvl(NodoAvl r, Comparador clave, Logical cambiaAltura) throws Exception {
		if (r == null) {
			throw new Exception (" Nodo no encontrado ");
		} else if (clave.menorQue(r.getRaiz())) {
			NodoAvl iz;
			iz = borrarAvl((NodoAvl)r.getIzquierdo(), clave, cambiaAltura);
			r.setIzquierdo(iz);
			if (cambiaAltura.booleanValue()){
				r = equilibrar1(r, cambiaAltura);
			}
		} else if (clave.mayorQue(r.getRaiz())) {
			NodoAvl dr;
			dr = borrarAvl((NodoAvl)r.getDerecho(), clave, cambiaAltura);
			r.setDerecho(dr);
			if (cambiaAltura.booleanValue()){
				r = equilibrar2(r, cambiaAltura);
			}
		} else // Nodo encontrado
		{
			NodoAvl q;
			q = r;
			// nodo a quitar del árbol
			if (q.getIzquierdo()== null)
			{
			 r = (NodoAvl) q.getDerecho();
			 cambiaAltura.setLogical(true);
			} else if (q.getDerecho() == null){
				r = (NodoAvl) 
				q.getIzquierdo();
				cambiaAltura.setLogical(true);
			}
			else { 			 // tiene rama izquierda y derecha
				NodoAvl iz;
			 iz = reemplazar(r, (NodoAvl)r.getIzquierdo(), cambiaAltura);
			 r.setIzquierdo(iz);
			 if (cambiaAltura.booleanValue()){
				r = equilibrar1(r, cambiaAltura);
			 }
			}
			q = null;
		}
		return r;
	}

	private NodoAvl reemplazar(NodoAvl n, NodoAvl act, Logical cambiaAltura){
		if (act.getDerecho() != null){
			NodoAvl d;
			d = reemplazar(n, (NodoAvl)act.getDerecho(), cambiaAltura);
			act.setDerecho(d);
			if (cambiaAltura.booleanValue()){
				act = equilibrar2(act, cambiaAltura);
			}
		} else {
			n.setRaiz(act.getRaiz());
			n = act;
			act = (NodoAvl)act.getIzquierdo();
			n = null;
			cambiaAltura.setLogical(true);
		}
		return act;
	}

	private NodoAvl equilibrar1(NodoAvl n, Logical cambiaAltura) {
		NodoAvl n1;
		switch (n.factorEquilibrio){
			case -1:
			n.factorEquilibrio = 0;
			break;

			case 0: 
			n.factorEquilibrio = 1;
			cambiaAltura.setLogical(false);
			break;
			
			case +1 : //se aplicar un tipo de rotación derecha
			n1 = (NodoAvl)n.getDerecho();
			if (n1.factorEquilibrio >= 0){
				//la altura no vuelve a disminuir
				if (n1.factorEquilibrio == 0){
					cambiaAltura.setLogical(false);
				}
				n = rotacionDD(n, n1);
			}
			else{
				n = rotacionDI(n, n1);
			}
			break;
			}
			return n;
	}

	private NodoAvl equilibrar2(NodoAvl n, Logical cambiaAltura){
		NodoAvl n1;
		switch (n.factorEquilibrio){
			case -1: // Se aplica un tipo de rotación izquierda
			n1 = (NodoAvl)n.getIzquierdo();
			if (n1.factorEquilibrio <= 0){
				if (n1.factorEquilibrio == 0){
					cambiaAltura.setLogical(false);
				}
				n = rotacionII(n, n1);
			} else{
				n = rotacionID(n,n1);
			}
			break;
			case 0 : n.factorEquilibrio = -1;
			cambiaAltura.setLogical(false);
			break;
			case +1 : n.factorEquilibrio = 0;
			break;
		}
		return n;
	}
}