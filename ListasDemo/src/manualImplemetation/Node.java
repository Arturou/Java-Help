package manualImplemetation;
/**
 * @private Node Clase que representa un elemento en la lista enlazada.
 * Esta clase puede ser cualquier otra clase que guste, por ser demostracion se creo una clase nodo.
 * @author Ace Homework Developers
 * @since 08/03/2018
 */
public class Node {
	private String data;
	private Node next;
	public Node(String data, Node next){
		this.data = data;
		this.next = next;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
}
