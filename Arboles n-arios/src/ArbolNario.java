
public class ArbolNario {

	private Nodo raiz;
	
	public ArbolNario() {
		raiz = null;
	}
	
	public Nodo insertarRaiz(int dato) {
		raiz = new Nodo(dato);
		return raiz;
	}
	
	public void insertar(Nodo nodo, int dato, int padre) {
		Nodo insertar = new Nodo(dato);
		
		if(nodo.getDato() == padre) {
			nodo.setAumentarHijo(insertar);
		}else {
			for(int i=0; i<nodo.getCantiadadHijos(); i++) {
				if(nodo.getHijos().get(i).getDato() == padre) {
					nodo.getHijos().get(i).setAumentarHijo(insertar);
				}
				else {
					insertar(nodo.getHijos().get(i), dato, padre);
				}
			}
		}
	}
	
	String Arbol = "";
	private String recorrer(Nodo raiz) {
		this.Arbol += raiz.getDato()+"";
		for(int i=0; i<raiz.getCantiadadHijos(); i++) {
			if(i==0)
				Arbol += "{";
			else {
				Arbol += ", ";
			}
			recorrer(raiz.getHijos().get(i));
			if(i == raiz.getCantiadadHijos()-1)
				Arbol += "}";
		}
		return Arbol+"}";
	}
	public String recorrer() {
		Arbol = "{";
		return recorrer(raiz);
	}
	
	public boolean buscarDato(Nodo raiz, int dato, boolean existe) {
		if(raiz.getDato() == dato) {
			existe = true;
		}
		for(int i=0; i<raiz.getCantiadadHijos(); i++) 
		{
			existe = buscarDato(raiz.getHijos().get(i), dato, existe);
		}
		return existe;
	}
	
	public Nodo getRaiz() {
		return raiz;
	}
	
}
