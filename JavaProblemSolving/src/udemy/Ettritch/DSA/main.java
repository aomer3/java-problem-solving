package udemy.Ettritch.DSA;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class main {

	public static void main(String[] args) {
		Employee homer = new Employee("Homer", "Simpson", 44);
		Employee marge = new Employee("Marge", "Simpson", 42);
		Employee lisa = new Employee("Lisa", "Simpson", 10);
		Employee bart = new Employee("Bart", "Simpson", 8);

		//ArrayList
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(homer);
		employeeList.add(marge);
		employeeList.add(lisa);
		employeeList.add(bart);
		
//		employeeList.forEach(employee -> System.out.println(employee));
		
//		System.out.println(employeeList.indexOf(new Employee("Clark", "Kent", 68)));
		
		//LinkedList
		EmployeeLinkedList list = new EmployeeLinkedList();
		list.addToFront(homer);
		list.addToFront(marge);
		list.addToFront(lisa);
		list.addToFront(bart);
				
		list.removeFromFront();
//		list.printList();
		
		//Java LinkedList implementation 
		LinkedList<Employee> employees = new LinkedList<>();
		employees.addFirst(homer);
		employees.addFirst(marge);
		employees.addFirst(lisa);
		employees.addFirst(bart);
		
//		Iterator it = employees.iterator();
//		
//		while(it.hasNext()) {
//			System.out.println(it.next());
//		}
		
		//Stack using Array implementation , O(n) operations 
		ArrayStack astack = new ArrayStack(4);
		astack.push(homer);
		astack.push(marge);
		astack.push(lisa);
		astack.push(bart);
		
//		System.out.println("ArrayStack Peek: " + astack.peek());
//		System.out.println("ArrayStack Poppped: " + astack.pop());
//		astack.printStack();
		
		//Stack using a LinkedList implementation - better to use this b/c O(1) operations
		LinkedStack lstack = new LinkedStack();
		lstack.push(homer);
		lstack.push(marge);
		lstack.push(lisa);
		lstack.push(bart);
		
		System.out.println("LinkedStack Peek: " + lstack.peek());
		System.out.println("LinkedStack Poppped: " + lstack.pop());
		lstack.printStack();
		
	}

}

