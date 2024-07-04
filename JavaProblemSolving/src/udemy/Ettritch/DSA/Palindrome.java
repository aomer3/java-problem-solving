package udemy.Ettritch.DSA;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Palindrome {

	public static void main(String[] args) {
		String input = "racecar";
		System.out.println(checkPalindrome(input));

	}
	
	public static boolean checkPalindrome(String s) {
		//remove white spaces, special chars from string and make lowercase
		StringBuilder word = new StringBuilder();
		String sLowerCase = s.toLowerCase();
		
		LinkedList<Character> list = new LinkedList();

		
		for(int i=0; i < sLowerCase.length(); i++) {
			Character c = sLowerCase.charAt(i);
			if(c >= 'a' && c <= 'z') {
				word.append(c);
				list.push(c);	
			}
		}	
		
		StringBuilder reverse = new StringBuilder();
		
		Iterator<Character> iterator = list.iterator();
		
		while(iterator.hasNext()) {
			reverse.append(list.pop());
		}
		
		if(word.compareTo(reverse) == 0){
			return true;
		}
		else {
			return false;
		}
	}

}
