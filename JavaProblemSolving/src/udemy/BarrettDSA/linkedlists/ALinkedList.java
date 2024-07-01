package udemy.BarrettDSA.linkedlists;

public class ALinkedList {
	private Node head;
	private Node tail;
	private int length=0;

	
	class Node{
		int value;
		Node next;
		
		Node(int value) {
			this.value = value;
		}
	}
	
	ALinkedList(int value){
		Node newNode = new Node(value);
		head = newNode;
		tail = newNode;
		length = 1;
	}
	
	public Node getHead() {
		return head;
	}
	
	public Node getTail() {
		return tail;
	}
	
	public int getLength() {
		return length;
	}
	
	public void printList() {
		Node temp = head;
		while(temp != null) {
			System.out.println(temp.value);
			temp = temp.next;
		}
	}
	
	public void printAll() {
		if(length == 0) {
			System.out.println("Head: null");
			System.out.println("Tail: null");
		}
		else {
			System.out.println("Head: " + head.value);
			System.out.println("Tail: " + tail.value);
		}
		System.out.println("Length: " + length);
		System.out.println("\nLinkedList: ");
		if(length==0) {
			System.out.println("empty");
		}
		else {
			printList();
		}
		
	}
	
	public void append(int value) {
		Node newNode = new Node(value);
		
		if(length == 0) {
			head = newNode;
			tail = newNode;
		}
		else {
			tail.next = newNode;
			tail = newNode;
		}
		length++;
	}
	
	public Node removeLast() {
		if(length == 0) {
			return null;
		}
		Node temp = head;
		Node pre = head;
		
		while(temp.next != null) {
			pre = temp;
			temp = temp.next;
		}
		
		tail = pre;
		tail.next = null;
		length--;
		if(length == 0) {
			head = null;
			tail = null;
		}
		return temp;
	}
	
	public void prepend(int value) {
		Node newNode = new Node(value);
		if(length == 0) {
			head = newNode;
			tail = newNode;
		}
		else {
			newNode.next = head;
			head = newNode;
		}
		length++;
	}
	
	public Node removeFirst() {
		if(length == 0) {
			return null;
		}
		Node temp = head;
		head = head.next;
		temp.next = null;
		length--;
		if(length == 0) {
			tail = null;
		}
		return temp;
	}
	
	public Node get(int index) {
		if(index < 0 || index > length) {
			System.out.println(index + " is out of bounds of Linked List.");
			return null;
		}
		Node temp = head;
		for(int i=0; i < index; i++) {
			temp = temp.next;
		}
		return temp;
	}
	
	public void set(int index, int value) {
		Node temp = get(index);
		if(temp != null) {
			temp.value = value;
		}
	}
	
	public void insert(int index, int value) {
		if(index < 0 || index > length) {
			System.out.println(index + " is out of bounds of Linked List.");
			return;
		}
		if(index == 0) {
			prepend(value);
			return;
		}
		if(index == length) {
			append(value);
			return;
		}
		Node newNode = new Node(value);
		Node temp = get(index - 1);
		newNode.next = temp.next;
		temp.next = newNode;
		length++;
	}
	
	public Node remove(int index) {
		if(index < 0 || index > length) {
			System.out.println(index + " is out of bounds of Linked List.");
			return null;
		}
		if(index == 0) {
			return removeFirst();
		}
		if(index == length) {
			return removeLast();
		}
		Node before = get(index - 1);
		Node temp = before.next;
		before.next = temp.next;
		temp.next = null;
		length--;
		return temp;
	}
	
	public void reverse() {
		Node temp = head;
		head = tail;
		tail = temp; 
		
		Node after = temp.next;
		Node before = null;
		
		for(int i=0; i < length; i++) {
			after = temp.next;
			temp.next = before;
			before = temp;
			temp = after;
		}
		
	}
	
	/*Implement a method called findMiddleNode that returns the middle node of the linked list.

	If the list has an even number of nodes, the method should return the second middle node.
	
	Note: this LinkedList implementation does not have a length member variable.
	
	
	Method signature:
	
	public Node findMiddleNode()
	
	Example:
	
	LinkedList myList = new LinkedList(1);
	myList.append(2);
	myList.append(3);
	myList.append(4);
	myList.append(5);
	Node middleNode = myList.findMiddleNode();
	System.out.println(middleNode.value); // Output: 3
	 
	myList.append(6);
	middleNode = myList.findMiddleNode();
	System.out.println(middleNode.value); // Output: 4
	
	
	When the linked list has an odd number of nodes, like 1 -> 2 -> 3 -> 4 -> 5, the function will find the exact middle node. 
	In this case, it will return the node containing the value 3.
	
	When the linked list has an even number of nodes, there will be two middle nodes. The findMiddleNode function will return the 
	second of these two middle nodes.
	
	For example, if the linked list is 1 -> 2 -> 3 -> 4 -> 5 -> 6, the two middle nodes are 3 and 4. The function will return the 
	node containing the value 4.
	 * 
	 */
	public int findMiddleNode() {
		 Node tortoise = head;
		 Node hare = head;
		 
		 while(hare != null && hare.next != null) {
			 tortoise = tortoise.next;
			 hare = hare.next;
			 hare = hare.next; 
		 }
		 
		 return tortoise.value;
	}
	

}
