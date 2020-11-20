class Node<E> {
	E data;
	Node<E> next;
	Node<E> previous;
}

public class LinkedListDemo<E> {
	private Node<E> head = null;
	private Node<E> tail = null;
	private Node<E> temp = null;
	
	private int counter = 0;
	
	LinkedListDemo() {}
	
	public Node<E> getHead() {
		return head;
	}
	
	public Node<E> getTail() {
		return tail;
	}
		
	public void add(E elem) {
		// First element
		if (head == null) {
			head = new Node<E>();
			head.data = elem;
			tail = head;
			head.next = tail;
			tail.previous = head;
			tail.next = head;
		} else {
			tail.next = new Node<E>(); // Creo nuevo nodo
			temp = tail;	// Guardo nodo tail para usarlo luego
			tail = tail.next;	// Asigno como tail el nuevo nodo creado
			tail.previous = temp; // Asigno como previo a tail el antiguo tail
			tail.next = head;
			tail.data = elem; // Guardo elemento del nuevo nodo
		}
		
		counter++;
	}
	
	public void add(E elem, int index) {
		if (index >= size() || index < 0) {
			System.out.println("Cannot insert element: out of bound");
			return;
		} else if (index == (size() - 1)) {
			add(elem);
		} else if (index == 0) {
			Node<E> temp = new Node<E>();
			temp.data = elem;
			temp.next = head;
			head.previous = temp;
			head = temp;
			counter++;
		} else {
			temp = head.next;

			for (int i = 1; i < index; i++) {
				temp = temp.next;
			}
			
			Node<E> newNode = (temp.previous.next = new Node<E>());
			newNode.data = elem;
			newNode.next = temp;
			newNode.previous = temp.previous;
			temp.previous = newNode;
						
			counter++;
		}
	}
	
	public E getElement(int index) {
		assert(index >= 0 && index < size()); // Force valid index
		
		if (index == size()) {
			return tail.data;
		} else if (index == 0) {
			return head.data;
		} else {
			temp = head.next;

			for (int i = 1; i < index; i++) {
				temp = temp.next;
			}
			return temp.data;
		}
	}
	
	public int size() {
		return counter;
	}
	
	public void detectCycleList(Node<E> startNode) {		
		if (head == null || startNode == null) return;
		
		temp = startNode.next;
		
		for (; temp != startNode; temp = temp.next) {
		}
			
		System.out.println("Cycle detected");
	}
	
	public void printLinkedList() {
		System.out.println("=== Printing LinkedList ===");
		
		System.out.println(head.data.toString());
		
		for (temp = head.next; temp != head; temp = temp.next) {
			System.out.println(temp.data.toString());
		}
		
		System.out.println("=== +++++++++++++++++++ ===");
		System.out.println();
	}
}
