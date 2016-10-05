import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SinglyLinkedList {
	
	Node head;
	
	static class Node {
		int data;
		Node next;
		
		Node(int d) {
			data = d;
			next = null;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		String[] entries = str.split(" ");
		
		SinglyLinkedList list = new SinglyLinkedList();
		
		list.head = new Node(Integer.parseInt(entries[0]));
		
		Node curr = list.head;
		Node n = null;
		
		for(int i = 1; i < entries.length; i++) {
			n = new Node(Integer.parseInt(entries[i]));
			curr.next = n;
			curr = n;
		}
		
		Node start = list.head;
		
		while(start != null) {
			System.out.print(start.data + "-->");
			start = start.next;
		}
		System.out.println();
		
		//list.insertAtEnd(7);
		//list.insertAtIndex(7, 4);
		//list.deleteNumber(1);
		//list.reverseList();
		start = list.head;
		
		while(start != null) {
			System.out.print(start.data + "-->");
			start = start.next;
		}
		
		System.out.println(list.kthLastNode(3));

	}
	
	public void insertAtEnd(int d) {
		 Node curr = this.head;
		 
		 while(curr.next != null) {
			 curr = curr.next;
		 }
		 
		 curr.next = new Node(d);
	}
	
	public void insertAtIndex(int data, int index) {
		Node curr = this.head;
		
		int i = 1;
		
		while(i < index - 1) {
			curr = curr.next;
			i++;
		}
		
		Node n = new Node(data);
		
		n.next = curr.next;
		curr.next = n;
	}
	
	public void deleteNumber(int data) {
		Node curr  = this.head;
		
		if(curr.data == data) {
			this.head = curr.next;
			return;
		}
		
		while(curr.next.data != data) {
			curr = curr.next;
		}
		
		curr.next = curr.next.next;
	}
	
	public void reverseList() {
		Node curr = this.head;
		Node next;
		Node prev = null;
		
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		
		this.head = prev;
	}
	
	public int kthLastNode(int k){
		Node curr = this.head;
		
		int length = 0;
		
		while(curr != null){
			curr = curr.next;
			length++;
		}
		
		if(k > length) {
			return -1;
		}
		
		Node ptr1 = this.head;
		Node ptr2 = this.head;
		
		int i = 0;
		
		while(i < k) {
			ptr2 = ptr2.next;
			i++;
		}
		
		while(ptr2 != null){
			ptr2 = ptr2.next;
			ptr1 = ptr1.next;
		}
		
		return ptr1.data;
	}

}
