package udemy.BarrettDSA.linkedlists;

public class main {

	public static void main(String[] args) {
		
		ALinkedList alist = new ALinkedList(4);
		
		alist.prepend(9);
		alist.insert(1, 5);
		
		alist.printAll();
	}

}
