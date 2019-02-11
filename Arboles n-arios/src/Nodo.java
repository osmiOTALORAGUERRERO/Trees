import java.util.ArrayList;

public class Nodo {

	private int cantidadHijos;
	private int dato;
	private ArrayList <Nodo> hijos;
	
	public Nodo(int dato) {
		hijos = new ArrayList<Nodo>();
		this.dato = dato;
		this.cantidadHijos = 0;
	}
	
	public int getDato() {
		return dato;
	}
	public void setDato(int dato) {
		this.dato = dato;
	}
	
	public int getCantiadadHijos() {
		return cantidadHijos;
	}
	public void setCantiadadHijos() {
		this.cantidadHijos = hijos.size();
	}
		
	public ArrayList<Nodo> getHijos(){
		return hijos;
	}
	public void setAumentarHijo(Nodo nodo) {
		hijos.add(nodo);
		cantidadHijos = hijos.size();
	}
}
