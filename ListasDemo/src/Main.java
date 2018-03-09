import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

import manualImplemetation.ManualLinkedList;
import manualImplemetation.Node;
/***
 * @private Demostracion de listas enlazadas en Java: 
 * @author Ace Homework Developers
 * Usando la Clase LinkedList de Java --> Case 1
 * LinkedList implementada de manera manual --> Case 2
 * @since 08/03/2018
 *
 */
public class Main {
	private static Scanner scan = new Scanner(System.in);
	private static LinkedList<String> linkedList;
	private static ManualLinkedList manualLinkedList;
	private static int mode = 0;
	
	public static void main(String[] args) {
		try{
			mode();
		}catch(InputMismatchException e){ //la excepcion se lanza si el usuario no ingresa un numero.
			System.out.println("\nFavor de ingresar un valor numerico.\n");
			mode();
		}
		try{
			menu();
		}catch(InputMismatchException e){ //la excepcion se lanza si el usuario no ingresa un numero.
			System.out.print("\nFavor de ingresar un valor numerico.\n");
			menu();
		}
	}
	/**
	 * @private Funcion que selecciona el modo o tipo de lista a usar.
	 * Implementacion por Java o Implementacion Manual.
	 */
	public static void mode(){
		do{
			System.out.println("1.-Lista Enlazada por Java\n"
					+ "2.-Lista Enlazada implementacion manual"
					+ "\n\nCon que implementacion desea correr el programa?:");
			mode = scan.nextInt();
		}while(mode > 2 || mode < 1);
	}
	/**
	 * @private Funcion que muestra el menu opciones para gestionar enemigos en una lista enlazada.
	 */
	public static void menu(){
		int option = 0;
		boolean isLooping = true;
		do{
			System.out.println("\n----Enemigos----\n");
			System.out.println("0.-Crear Lista Vacia/Limpiar Lista\n"
					+ "1.-Agregar\n"
					+ "2.-Eliminar\n"
					+ "3.-Reemplazar\n"
					+ "4.-Mostrar Enemigos\n"
					+ "5.-Salir") ;
			System.out.println("Ingrese una opcion: ");
			option = scan.nextInt();
			switch(option){
				case 0:
					inicializarLista();
				break;
				case 1:
					agregarEnemigo();
				break;
				case 2:
					eliminarEnemigo();
				break;
				case 3:
					actualizarEnemigo();
				break;
				case 4:
					mostrarEnemigos();
				break;
				case 5:
					isLooping = false;
				break;
				default:
					System.out.println("Opcion no disponible!\n\n\n");
					menu();
				break;
			}
		}while(isLooping);
	}
	/**
	 * @private Funcion que crea una lista enlazada vacia.
	 */
	public static void inicializarLista(){
		switch(mode){
		case 1:
			linkedList = new LinkedList<String>();
			break;
		case 2:
			manualLinkedList = new ManualLinkedList();
			break;
		}
		System.out.println("Lista creada.");
	}
	/**
	 * @private Funcion que agrega un enemigo a la lista.
	 * Los enemigos son representados como un asterisco. 
	 * Si se desea se puede usar un objeto para representar un enemigo.
	 */
	public static void agregarEnemigo(){
		switch(mode){
		case 1:
			if(linkedList == null){
				System.out.println("La lista no existe.");
				return;
			}
			linkedList.add("*");
			break;
		case 2:
			if(manualLinkedList == null){
				System.out.println("La lista no existe.");
				return;
			}
			manualLinkedList.agregar(new Node("*",null));
			break;
		}
		System.out.println("Enemigo agregado a la lista");
	}
	/**
	 * @private Funcion que elimina un enemigo de la lista en un indice especifico.
	 */
	public static void eliminarEnemigo(){
		int index = 0;
		switch(mode){
		case 1:
			if(linkedList == null){
				System.out.println("La lista no existe.");
				return;
			}
			if(linkedList.isEmpty()){
				System.out.println("La lista no tiene elementos.");
				return;
			}
			mostrarEnemigos();
			System.out.println("\n\nIngrese el indice del enemigo que desea eliminar:");
			index = scan.nextInt();
			linkedList.remove(index-1);
			break;
		case 2:
			if(manualLinkedList == null){
				System.out.println("La lista no existe.");
				return;
			}
			if(manualLinkedList.isEmpty()){
				System.out.println("La lista no tiene elementos.");
				return;
			}
			mostrarEnemigos();
			System.out.println("\n\nIngrese el indice del enemigo que desea eliminar:");
			index = scan.nextInt();
			manualLinkedList.eliminar(index-1);
			break;
		}
		System.out.println("Enimigo "+index+" Eliminado!");
	}
	/**
	 * @private Funcion que modifica el symbolo del enemigo
	 */
	public static void actualizarEnemigo(){
		int index = 0;
		String symbol = "";
		switch(mode){
		case 1:
			if(linkedList == null){
				System.out.println("La lista no existe.");
				return;
			}
			if(linkedList.isEmpty()){
				System.out.println("La lista no tiene elementos.");
				return;
			}
			mostrarEnemigos();
			System.out.println("Ingrese el Inidce del enemigo que desee modificar:");
			index = scan.nextInt();
			System.out.println("Ingresar el nuevo simbolo para el enemigo:");
			symbol = scan.next();
			linkedList.set(index-1, symbol);
			break;
		case 2:
			if(manualLinkedList == null){
				System.out.println("La lista no existe.");
				return;
			}
			if(manualLinkedList.isEmpty()){
				System.out.println("La lista no tiene elementos.");
				return;
			}
			mostrarEnemigos();
			System.out.println("Ingrese el Inidce del enemigo que desee modificar:");
			index = scan.nextInt();
			System.out.println("Ingresar el nuevo simbolo para el enemigo:");
			symbol = scan.next();
			manualLinkedList.actualizar((index-1), new Node(symbol,null));
			break;
		}
		System.out.println("Enimigo Actualizado!");
	}
	/**
	 * @private Funcion que muestra enemigos en la lista.
	 */
	public static void mostrarEnemigos(){
		switch(mode){
		case 1:
			if(linkedList == null){
				System.out.println("La lista no existe.");
				return;
			}
			if(linkedList.isEmpty()){
				System.out.println("La lista no tiene elementos.");
				return;
			}
			System.out.println("----Enemigos----\n\n");
			for(int i = 0; i < linkedList.size(); i++){
				System.out.println((i+1)+".- "+linkedList.get(i)+"\n");
			}
			break;
		case 2:
			if(manualLinkedList == null){
				System.out.println("La lista no existe.");
				return;
			}
			if(manualLinkedList.isEmpty()){
				System.out.println("La lista no tiene elementos.");
				return;
			}
			System.out.println("----Enemigos----\n\n");
			int i = 0;
			Node temp = manualLinkedList.getHead();
			System.out.println((i+1)+".- "+temp.getData()+"\n");
			i++;
			temp = temp.getNext();
			while(temp != null){
				System.out.println((i+1)+".- "+temp.getData()+"\n");
				temp = temp.getNext();
				i++;
			}
			break;
		}
	}
}
