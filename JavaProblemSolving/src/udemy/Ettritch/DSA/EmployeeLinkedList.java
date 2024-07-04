package udemy.Ettritch.DSA;

public class EmployeeLinkedList {
	private EmployeeNode head;
	private int size;
	
	public void addToFront(Employee employee) {
		EmployeeNode node = new EmployeeNode(employee);
		node.setNext(head);
		head = node;
		size++;
	}
	
	public EmployeeNode removeFromFront() {
		if(isEmpty()) return null;
		head = head.getNext();
		size--;
		return head;
	}
	
	public int getSize() {
		return size;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public void printList() {
		EmployeeNode current = head;
		while(current != null) {
			System.out.print(current + ", ");
			current = current.getNext();
		}
	}

}
