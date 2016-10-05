import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class LinkedList {

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
		
		LinkedList list = new LinkedList();
		
		list.head = new Node(Integer.parseInt(entries[0]));
		
		Node curr = list.head;
		Node next = null;
		
		for(int i = 1; i < entries.length; i++) {
			next = new Node(Integer.parseInt(entries[i]));
			curr.next = next;
			curr = next;
		}
		
		Node n = list.head;
		
		while(n != null) {
			System.out.println(n.data + " ");
			n = n.next;
		}

		n = list.head;

		System.out.println(loop(n));
		System.out.println(kthLast(n,2));
		removeDups(n);
		deleteMiddleNode(n, 3);
		
		n = list.head;
		
		while(n != null) {
			System.out.println(n.data + " ");
			n = n.next;
		}
	}
	
	public static boolean loop(Node n) {
		Node slow = n;
		Node fast = n;
		while(slow != null && fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
			
			if(slow == fast) {
				return true;
			}
		}
		return false;
	}
	
	public static void removeDups(Node n) {
		HashSet<Integer> set = new HashSet<Integer>();
		Node prev = null;
		while(n != null) {
			if(set.contains(n.data)) {
				prev.next = n.next;
			}
			else {
				set.add(n.data);
				prev = n;
			}
			n = n.next;
		}
	}

	public static int kthLast(Node n, int k) {
		Node start = n;
		Node kth = n;
		
		for(int i = 0; i < k; i++) {
			start = start.next;
		}
		
		while(start != null) {
			start = start.next;
			kth = kth.next;
		}
		return kth.data;
	}
	
	public static void deleteMiddleNode(Node head, int value) {
		Node n = head;
		Node prev = null;
		while(n != null) {
			if(n.data == value) {
				prev.next = n.next;
			}
			else {
				prev = n;
			}
			n = n.next;
		}
	}
}
