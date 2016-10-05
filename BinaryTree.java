import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BinaryTree {
	
	static class TreeNode {
		int key;
		TreeNode left,right;
		
		public TreeNode(int item) {
			key = item;
			left = right = null;
		}
		
	}
	
	TreeNode root;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		String[] entries = str.split(" ");
		
		int[] elements = new int[entries.length];
		
		for(int i = 0; i < entries.length; i++) {
			elements[i] = Integer.parseInt(entries[i]);
		}
		
		BinaryTree tree = new BinaryTree();
		
		tree.root = minimalTree(elements, 0, elements.length - 1);
		
		listOfDepths(tree.root);
		
		//inOrderTraversal(tree.root);
		System.out.println(validateBST(tree.root));
		
		System.out.println(isBalanced(tree.root));
	
	}
	
	public static TreeNode firstCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null || p == null || q ==null) {
			return null;
		}
		if(p.key < root.key && q.key < root.key) {
			return firstCommonAncestor(root.left, p, q);
		}
		else if(p.key > root.key && q.key > root.key) {
			return firstCommonAncestor(root.right, p, q);
		}
		else {
			return root;
		}
	}
	
	public static boolean validateBST(TreeNode root) {
		inOrderTraversal(root);
		for(int i = 1; i < inOrderList.size(); i++) {
			if(inOrderList.get(i) < inOrderList.get(i - 1))
				return false;
		}
		return true;
	}
	
	public static boolean isBalanced(TreeNode root) {
			return helperBalanced(root, 0) >= 0;
	}
	
	public static int helperBalanced(TreeNode root, int height) {
		if( root == null) {
			return height;
		}
		
		int leftTree = helperBalanced(root.left, height + 1);
		int rightTree = helperBalanced(root.right, height + 1);
		if(leftTree < 0 || rightTree < 0 || Math.abs(leftTree - rightTree) > 0) {
			return -1;
		}
		return Math.max(leftTree, rightTree);
	}
    public static List<List<Integer>> result = new ArrayList<>();
	public static  void listOfDepths(TreeNode root) {
		helper(root, 0);
		for( int i = 0; i < result.size(); i++) {
			List<Integer> list = result.get(i);
			LinkedList llist = new LinkedList();
			llist.head = new LinkedList.Node(list.get(0));
			LinkedList.Node curr = llist.head;
			LinkedList.Node next = null;
			for(int j = 1; j < list.size(); j++) {
				next = new LinkedList.Node(list.get(j));
				curr.next = next;
				curr = next;
			}
			
			LinkedList.Node n = llist.head;
			while(n != null) {
				System.out.println(n.data + " ");
				n = n.next;
			}
			
			System.out.println();
		}
	}
	
	public static void helper(TreeNode root, int level) {
		if(root != null) {
			if(level == result.size())
                result.add(new ArrayList<Integer>());
            result.get(level).add(root.key);
            helper(root.left,level+1);
            helper(root.right,level+1);
		}
	}
	public static List<Integer> inOrderList = new ArrayList<Integer>();
	private static void inOrderTraversal(TreeNode node) {
		// TODO Auto-generated method stub
		if(node != null) {
			inOrderTraversal(node.left);
			inOrderList.add(node.key);
			System.out.println(node.key);
			inOrderTraversal(node.right);
		}
	}

	public static TreeNode minimalTree(int array[], int start, int end) {
		
		System.out.println("Creating BST assuming input is given in asc order");
		if(end < start) {
			return null;
		}
		
		int mid = (start + end) / 2;
		TreeNode node = new TreeNode(array[mid]);
		node.left = minimalTree(array, start, mid - 1);
		node.right = minimalTree(array, mid + 1, end);
		return node;
	}

}
