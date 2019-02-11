import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scann = new Scanner(System.in);
		ArbolNario AN_a;
		ArbolNario AN_b;
		
		int opcion; 
		
		do{			
			System.out.println("1. Iniciar Arbol \n0. Salir");
			opcion = scann.nextInt();
			switch (opcion) {
				case 0:	System.out.println("END");	break;
					
				case 1:
					System.out.println("Arbol A");
					AN_a = crearArbol();
					System.out.println("Arbol B");
					AN_b = crearArbol();
					if(mismaEstructuraArbol(AN_a.getRaiz(), AN_b.getRaiz(), false))
						System.out.println("Los arboles N-arios A y B SI tienen la misma estructura");
					else
						System.out.println("Los arboles N-arios A y B NO tienen la misma estructura");
					System.out.println("Vista");
					System.out.println("Arbol A: "+AN_a.recorrer());
					System.out.println("Arbol B: "+AN_b.recorrer());
					break;
					
				default: System.out.println("Opcion incorrecta "); break;
			}
		}while(opcion != 0);

	}

	public static ArbolNario crearArbol() {
		Scanner scann = new Scanner(System.in);
		ArbolNario nuevoArbol = new ArbolNario();
		Nodo raiz;
		
		int opcion;
		int dato;
		int padre;
		
		System.out.println("Ingrese el dato de la raiz");
		raiz = nuevoArbol.insertarRaiz(scann.nextInt());
		
		do {
			System.out.println("1. Ingresar dato \n0. Terminar");
			opcion = scann.nextInt();
			switch(opcion) {
				case 0:	System.out.println("<---");	break;
				
				case 1:	
					if(raiz.getHijos().isEmpty()) {
						System.out.print("Ingrese un dato: ");
						dato = scann.nextInt();
						nuevoArbol.insertar(raiz, dato, raiz.getDato());
					}else {
						System.out.print("Pretendientes a padre: ");
						System.out.println(nuevoArbol.recorrer());
						do {
							System.out.print("Escoja un padre: ");
							padre = scann.nextInt();
							if(!nuevoArbol.buscarDato(raiz, padre, false))
								System.out.println("El padre "+padre+" no existe");
						}while(!nuevoArbol.buscarDato(raiz, padre, false));
						System.out.print("Ingrese un dato: ");
						dato = scann.nextInt();
						nuevoArbol.insertar(raiz, dato, padre);
					}	
					break;
					
				default: System.out.println("Opcion incorrecta"); break;
			}
			
		}while(opcion != 0);
		
		return nuevoArbol;
	}
	
	public static boolean mismaEstructuraArbol(Nodo a, Nodo b, boolean estructura) {
		
		boolean igual = estructura;
		
		if(a.getCantiadadHijos() == b.getCantiadadHijos()) {
			igual = true;
		}else {
			return false;
		}
		
		for(int i=0; i<a.getCantiadadHijos(); i++) {
			igual = mismaEstructuraArbol(a.getHijos().get(i), b.getHijos().get(i), igual);
		}
		
		return igual;
	}
}
