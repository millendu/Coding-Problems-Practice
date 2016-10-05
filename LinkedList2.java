import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LinkedList2 {

	SinglyLinkedList.Node head;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String str2 = br.readLine();

		String[] entries = str.split(" ");
		String[] entries2 = str2.split(" ");
		
		SinglyLinkedList list = new SinglyLinkedList();
		SinglyLinkedList list2 = new SinglyLinkedList();
		
		list.head = new SinglyLinkedList.Node(Integer.parseInt(entries[0]));
		
		SinglyLinkedList.Node curr = list.head;
		SinglyLinkedList.Node next = null;
		
		for(int i = 1; i < entries.length; i++) {
			next = new SinglyLinkedList.Node(Integer.parseInt(entries[i]));
			curr.next = next;
			curr = next;
		}
		
		list2.head = new SinglyLinkedList.Node(Integer.parseInt(entries2[0]));
		
		SinglyLinkedList.Node curr2 = list2.head;
		SinglyLinkedList.Node next2 = null;
		
		for(int j = 1; j < entries2.length; j++) {
			next2 = new SinglyLinkedList.Node(Integer.parseInt(entries2[j]));
			curr2.next = next2;
			curr2 = next2;
		}
		
		int length1 = 0;
		int length2 = 0;
		
		SinglyLinkedList.Node n = list.head;
		while(n != null) {
			n = n.next;
			length1 = length1 + 1;
		}
		
		n = list2.head;
		while(n != null) {
			n = n.next;
			length2 = length2 + 1;
		}
		
		int d = Math.abs(length2 - length1);
		
		SinglyLinkedList result = new SinglyLinkedList();
		list.reverseList();
		list2.reverseList();
		result.head = sumLists(list.head, list2.head);
		result.reverseList();
		 
//		int result = 0;
//		
//		if(length1 > length2) {
//			result = intersection(list.head, list2.head, d);
//		}
//		else {
//			result = intersection(list2.head, list.head, d);
//		}
//		
//		System.out.println(result);
//		
		SinglyLinkedList.Node n1 = result.head;
		
		while(n1 != null) {
			System.out.print(n1.data + " ");
			n1 = n1.next;
		}
	}
	
	public static int intersection(SinglyLinkedList.Node n1, SinglyLinkedList.Node n2, int d){
		for(int i = 0; i < d; i++) {
			if(n1 == null) {
				return -1;
			}
			n1 = n1.next;
		}
		
		while(n1 != null &&  n2 != null) {
			if(n1.data == n2.data)
				return n1.data;
			n1 = n1.next;
			n2 = n2.next;
		}
		return -1;
		
	}
	
	public static SinglyLinkedList.Node sumLists(SinglyLinkedList.Node n1, SinglyLinkedList.Node n2) {
		
		SinglyLinkedList.Node res = null;
		SinglyLinkedList.Node prev = null;
		SinglyLinkedList.Node temp = null;
		int carry = 0;
		int sum;
		
		while(n1 != null || n2 != null) {
			
			sum = carry + (n1 != null ? n1.data : 0) + (n2 != null ? n2.data : 0);
			
			if(sum >= 10) {
				carry = 1;
			}
			else {
				carry = 0;
			}
			
			sum = sum % 10;
			
			temp = new SinglyLinkedList.Node(sum);
			
			if(res == null) {
				res = temp;
			}
			else {
				prev.next = temp;
			}
			
			prev = temp;
			
			if(n1 != null) {
				n1 = n1.next;
			}
			if(n2 != null) {
				n2 = n2.next;
			}
		}
		
		if(carry > 0) {
			temp.next = new SinglyLinkedList.Node(carry);
		}
		
		return res;
	}

}
