package manualImplemetation;
/**
 * @private ManualLinkedList Clase que representa una lista enlazada.
 * @author Ace Homework Developers
 * @since 08/03/2018
 */
public class ManualLinkedList {
	private Node head;

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}
	/**
	 * @private Funcion para agregar elementos a la lista. Los nuevos elementos son agregados al principio de la lista
	 * @param node Elemento a agregar a la lista.
	 */
	public void agregar(Node node){
		if(head == null){
			head = node;
			return;
		}
		node.setNext(head);
		head = node;
	}
	/**
	 * @private Funcion para eliminar elementos de la lista. 
	 * @param indice Indice del elemento a eliminar
	 */
	public void eliminar(int indice){
		if(head == null){
			System.out.println("Lista Vacia.");
			return;
		}
		if(indice == 0){ //Si deseamos eliminar el primer elemento. El nuevo primer elemento sera el siguiente elemento del nodo que se elimino.
			head = head.getNext();
			return;
		}
		Node temp = head;
		Node prev = null;
		int i = 1;
		while(temp.getNext() != null){ //Buscando el nodo a eliminar, el cual es representado por la variable temp.
			prev = temp;
			temp = temp.getNext();
			if(i == indice){
				break;
			}
			i++;
		}
		prev.setNext(temp.getNext()); //El nodo previo ahora apunta al nodo siguiente del nodo que se desea eliminar.
	}
	/**
	 * @private Funcion que reemplaza un nodo por otro en un indice especifico
	 * @param indice El indice del nodo a modificar
	 * @param node El nuevo nodo a insertar
	 */
	public void actualizar(int indice, Node node){
		if(getHead() == null){
			System.out.println("Lista Vacia.");
			return;
		}
		if(indice == 0){
			node.setNext(head.getNext());
			setHead(node);
			return;
		}
		Node temp = head;
		Node prev = null;
		int i = 1;
		while(temp.getNext() != null){
			prev = temp;
			temp = temp.getNext();
			if(i == indice){
				break;
			}
			i++;
		}
		prev.setNext(node); //El siguiente nodo del nodo previo ahora sera nuestro nodo nuevo.
		node.setNext(temp.getNext()); //El nodo nuevo tiene como nodo siguiente el nodo siguiente del nodo reemplazado.
	}
	/**
	 * @private Funcion que checa si la lista esta vacia
	 * @return Verdadero si la lista esta vacia y Falso si es lo contrario.
	 */
	public boolean isEmpty(){
		return head==null;
	}
}
