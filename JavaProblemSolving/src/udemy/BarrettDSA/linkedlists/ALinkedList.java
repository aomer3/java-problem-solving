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
	
	In this problem, you should use the slow and fast pointer technique (also known as Floyd's Tortoise and Hare algorithm) to efficiently detect the presence of a loop in the linked list.
	 * 
	 */
	public int findMiddleNode() {
		 Node fast = head;
		 Node slow = head;
		 
		 while(fast != null && fast.next != null) {
			 slow = slow.next;
			 fast = fast.next;
			 fast = fast.next; 
		 }
		 
		 return slow.value;
	}
	
	/*Write a method called hasLoop that is part of the linked list class.

	The method should be able to detect if there is a cycle or loop present in the linked list.
	
	You are required to use Floyd's cycle-finding algorithm (also known as the "tortoise and the hare" algorithm) to detect the loop.
	
	This algorithm uses two pointers: a slow pointer and a fast pointer. The slow pointer moves one step at a time, while the fast pointer moves two steps at a time. If there is a loop in the linked list, the two pointers will eventually meet at some point. If there is no loop, the fast pointer will reach the end of the list.
	
	The method should follow these guidelines:
	
	
	
	Create two pointers, slow and fast, both initially pointing to the head of the linked list.
	
	Traverse the list with the slow pointer moving one step at a time, while the fast pointer moves two steps at a time.
	
	If there is a loop in the list, the fast pointer will eventually meet the slow pointer. If this occurs, the method should return true.
	
	If the fast pointer reaches the end of the list or encounters a null value, it means there is no loop in the list. In this case, the method should return false.
	
	
	
	Output:
	
	Return true if the linked list has a loop.
	
	Return false if the linked list does not have a loop.
	
	
	
	Constraints:
	
	You are not allowed to use any additional data structures (such as arrays) or modify the existing data structure.
	
	You can only traverse the linked list once.
	
	
	Method signature:
	
	public boolean hasLoop()
	
	
	If your Linked List contains a loop, it indicates a flaw in its implementation. This situation can manifest in several ways:	
	 * 
	 */
	public boolean hasLoop() {
		Node fast = head;
		Node slow = head;
		
		while(fast != null && fast.next !=null) {
			slow = slow.next;
			fast = fast.next;
			fast = fast.next;
			if(fast == slow) {
				return true;
			}
		}
		
		return false;
	}
	
	/*Implement a method called findKthFromEnd that returns the k-th node from the end of the list.

		If the list has fewer than k nodes, the method should return null.
		
		Note: This implementation of the Linked List class does not have the length attribute.
		
		Method signature:
		
		public Node findKthFromEnd(int k)
		
		
		Example:
		
		LinkedList myList = new LinkedList(1);
		myList.append(2);
		myList.append(3);
		myList.append(4);
		myList.append(5);
		 
		Node result = myList.findKthFromEnd(2); // Output: Node with value 4
		 
		result = myList.findKthFromEnd(5); // Output: Node with value 1
		 
		result = myList.findKthFromEnd(6); // Output: null
		
		
		Note:
		
		In this problem, you should use the two-pointer technique to efficiently find the k-th node from the end of the linked list.


	 * 
	 */
	public Node findKthFromEnd(int k) {
		Node fast = head;
		Node slow = head;
		
		for(int i=0; i < k; i++) {
			if(fast == null) {
				return null;
			}
			fast = fast.next;
		}
		
		while(fast != null) {
			slow = slow.next;
			fast = fast.next;
		}
		
		return slow;
 
    }
	
	/*This Linked List problem is significantly more challenging than the ones we've tackled so far. It's common for students at this stage to find this exercise demanding, so don't worry if you're not ready to tackle it yet. It's perfectly okay to set it aside and revisit it later when you feel more confident.

	If you decide to take on this challenge, I strongly advise using a hands-on approach: grab a piece of paper and visually map out each step.
	
	This problem requires a clear understanding of how elements in a Linked List interact and move. By now, you've observed numerous Linked List animations in the course, which have prepared you for this moment.
	
	This exercise will be a true test of your ability to apply those concepts practically. Remember, patience and persistence are key here!
	
	Now, here is the exercise:
	
	___________________________________
	
	
	
	You have a singly linked list that DOES NOT HAVE A TAIL POINTER  (which will make this method simpler to implement).
	
	Given a value x you need to rearrange the linked list such that all nodes with a value less than x come before all nodes with a value greater than or equal to x.
	
	Additionally, the relative order of nodes in both partitions should remain unchanged.
	
	
	Constraints:
	
	The solution should traverse the linked list at most once.
	
	The solution should not create a new linked list.
	
	
	Input:
	
	A singly linked list and an integer x.
	
	
	Output:
	
	The same linked list but rearranged as per the above criteria.
	
	
	Function signature:
	
	public void partitionList(int x);
	
	
	Details:
	
	The function partitionList takes an integer x as a parameter and modifies the current linked list in place according to the specified criteria. If the linked list is empty (i.e., head is null), the function should return immediately without making any changes.
	
	
	
	Example 1:
	
	Input:
	
	Linked List: 3 -> 8 -> 5 -> 10 -> 2 -> 1 x: 5
	
	Process:
	
	Values less than 5: 3, 2, 1
	
	Values greater than or equal to 5: 8, 5, 10
	
	Output:
	
	Linked List: 3 -> 2 -> 1 -> 8 -> 5 -> 10
	 * 
	 */

}
