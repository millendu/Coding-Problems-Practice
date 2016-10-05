import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DoublyLinkedList {
	
	Node head;
	
	static class Node {
		int data;
		Node next;
		Node prev;
		
		Node(int d) {
			data = d;
			next = null;
			prev = null;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		String[] entries = str.split(" ");
		
		DoublyLinkedList list = new DoublyLinkedList();
		
		list.head = new Node(Integer.parseInt(entries[0]));
		
		Node curr = list.head;
		Node n = null;
		Node p = null;
		
		for(int i = 1; i < entries.length; i++) {
			n = new Node(Integer.parseInt(entries[i]));
			curr.next = n;
			n.prev = curr;
			p = curr;
			curr = n;
			
		}
		
		Node start = list.head;
		
		while(start != null) {
			System.out.print(start.data + " --> ");
			start = start.next;
		}
		System.out.println();
		//list.insertAtEnd(8);
		//list.insertAtIndex(8, 1);
		//list.deleteNode(4);
		list.reverse();
		
		start = list.head;
		
		while(start != null) {
			System.out.print(start.data + " --> ");
			start = start.next;
		}
		
	}
	
	public void insertAtEnd(int d){
		Node curr = this.head;
		
		while(curr.next != null) {
			curr = curr.next;
		}
		
		curr.next = new Node(d);
		curr.next.prev = curr;
	}
	
	public void insertAtIndex(int data, int index) {
		Node curr = this.head;
		
		int length = 0;
		
		while(curr != null){
			curr = curr.next;
			length++;
		}
		
		if(index > length) {
			return;
		}
		
		if(index == 1) {
			curr = this.head;
			Node n = new Node(data);
			n.next = curr;
			curr.prev = n;
			this.head = n;
		}
		else {
			int i =1;
			curr = this.head;
			while(i < index - 1) {
				curr = curr.next;
				i++;
			}
			Node n = new Node(data);
			n.next = curr.next;
			n.prev = curr;
			curr.next.prev = n;
			curr.next = n;
		}
	}
	
	public void deleteNode(int d) {
		Node curr = this.head;
		
		while(curr.data != d) {
			curr = curr.next;
		}
		
		curr.next.prev = curr.prev;
		curr.prev.next = curr.next;
		
	}
	
	public void reverse() {
		Node curr = this.head;
		Node next;
		Node prev = null;
		
		while(curr != null) {
			next = curr.next;
			prev = curr.prev;
			curr.next = prev;
			curr.prev = next;
			prev = curr;
			curr = next;
		}
		
		this.head = prev;
		
	}

}
