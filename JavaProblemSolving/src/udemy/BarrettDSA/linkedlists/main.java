package udemy.BarrettDSA.linkedlists;

public class main {

	public static void main(String[] args) {
		
		ALinkedList alist = new ALinkedList(1);
		
		alist.append(2);
		alist.append(3);
		alist.append(4);
		alist.append(5);
//		alist.append(6);
		
		alist.printAll();
		System.out.println("Middle: " + alist.findMiddleNode());
	}

}
