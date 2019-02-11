
public class Arbol {

	private Nodo raiz;
	private int size;
	private int internos;
	private String strInternos;
	private int suma;
	
	public Arbol() {
		raiz = null;
	}
	
	public void addNodo(int dato) {
		Nodo nuevo = new Nodo(dato);
		if(raiz == null) {
			raiz = nuevo;
		}else {
			Nodo auxiliar = raiz;
			Nodo padre;
			while(true) {
				padre = auxiliar;
				if(dato<auxiliar.getDato()) {
					auxiliar = auxiliar.getIzquierda();
					if(auxiliar == null) {
						padre.setIzquierda(nuevo);
						return;
					}
				}
				else {
					auxiliar = auxiliar.getDerecha();
					if(auxiliar == null) {
						padre.setDerecha(nuevo);
						return;
					}
				}
			}
		}
	}
	
	public int sizeArbol() {
		size = -1;
		sizeArbol(raiz);
		return size+1;
	}
	private void sizeArbol(Nodo auxiliar) {
		if(auxiliar != null) {
			size++;
			suma += auxiliar.getDato();
			sizeArbol(auxiliar.getDerecha());
			sizeArbol(auxiliar.getIzquierda());
		}
	}
	
	public void nodoMayor() {
		Nodo mayor;
		if(raiz != null) {
			mayor = raiz;
			while(mayor.getDerecha() != null) {
				mayor = mayor.getDerecha();
			}
		}
		else {
			System.out.println("Nodo Mayor: Arbol Vacio");
			return;
		}
		System.out.println("Nodo Mayor: " + mayor.getDato());
	}
	
	public int cantInternos() {
		strInternos = "";
		internos = -1;
		cantInternos(raiz);
		return internos+1;
	}
	private void cantInternos(Nodo internos) {
		if(internos != null) {
			if(internos.getIzquierda() != null || internos.getDerecha() != null) {
				if(!internos.equals(raiz)) {
					this.internos++;
					strInternos += internos.getDato()+" ";
				}
				cantInternos(internos.getDerecha());
				cantInternos(internos.getIzquierda());
			}
		}
	}
	public String getStrInternos() {
		return strInternos;
	}
	
	private void inOrden(Nodo recorrer) {
		if(recorrer != null) {
			inOrden(recorrer.getIzquierda());
			System.out.print(recorrer.getDato()+" ");
			inOrden(recorrer.getDerecha());
		}
	}
	public void inOrden() {
		inOrden(raiz);
		System.out.println();
	}
	
	public double getPromedio() {
		suma = 0;
		sizeArbol();
		return (double)suma/(size+1);
	}
}
