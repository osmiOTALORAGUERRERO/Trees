import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Arbol arBinario;
		Scanner scann = new Scanner(System.in);
		int opcion1;
		int opcion2;
		int datoArbol;
		
		do {
			arBinario = new Arbol();
			do {
				System.out.println("Escoja una opcion \n1.Agregar Dato \n0.Terminar");
				opcion2 = scann.nextInt();
					switch (opcion2) {
						case 1:
							System.out.print("Ingrese un dato:  ");
							datoArbol = scann.nextInt();
							arBinario.addNodo(datoArbol);
							break;
						
						case 0:
							arBinario.inOrden();
							System.out.println("Nodos totales del arbol binario:  "+arBinario.sizeArbol());
							System.out.println("Nodos internos del arbol binario:  "+arBinario.cantInternos()+" ("+arBinario.getStrInternos()+")");
							System.out.print("Nodo con el mayor dato:  ");
							arBinario.nodoMayor();
							System.out.println("Promedio de los datos:  "+ arBinario.getPromedio());
							System.out.println();
							System.out.println("<---");
							break;
						
						default: System.out.println("Opcion no disponible"); break;
					}
				
			}while(opcion2 != 0);
			System.out.println("0.Terminar \n1.Continuar");
			opcion1 = scann.nextInt();
		}while(opcion1 == 1);
	}
}
