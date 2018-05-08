package pers.lxs.datastructure;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class BinaryTreeTraversal {
	
	@Test
	public void test() {
		
		int[] array = new int[]{1,2,3,4,5,6,7,8,9};
		
		Node root = buildTree(array);
		
		System.out.println("Preorder Traversal: ");
		preTraversal(root);
		System.out.println();
		
		System.out.println("Inorder Traversal: ");
		inTraversal(root);
		System.out.println();
		
		System.out.println("Postorder Traversal: ");
		postTraversal(root);
		System.out.println();
		
		System.out.println("Levelorder Traversal: ");
		levelTraversal(root);
		System.out.println();
		
	}
	
	public Node buildTree(int[] array) {
		
		if(array == null || array.length <= 0) {
			return null;
		}
		
		Node root = new Node(array[0]);
		List<Node> list = new LinkedList<Node>();
		list.add(root);
		Node node = root;
		int index = 1;
		while(index < array.length) {
			
			node = list.remove(0);
			node.left = new Node(array[index++]);
			list.add(node.left);
			
			if(index < array.length) {
				node.right = new Node(array[index++]);
				list.add(node.right);
			}
		}
		
		return root;
	}
	
	public void preTraversal(Node root) {
		
		if(root == null) {
			return;
		}
		
		Deque<Node> queue = new ArrayDeque<Node>();
		queue.offerFirst(root);
		
		while(!queue.isEmpty()) {
			Node node  = queue.pollFirst();
			
			System.out.print(node.value + " ");
			
			if(node.right != null) {
				queue.offerFirst(node.right);
			}
			
			if(node.left != null) {
				queue.offerFirst(node.left);
			}
		}
		
	}
	
	public void inTraversal(Node root) {
		
		if(root == null) {
			return;
		}
		
		Deque<Node> queue = new ArrayDeque<Node>();
		
		Node node = root;
		while(node != null || !queue.isEmpty()) {
			
			if(node != null) {
				queue.offerFirst(node);
				node = node.left;
			} else {
				node = queue.pollFirst();
				System.out.print(node.value + " ");
				node = node.right;
			}
			
		}
	}
	
	public void postTraversal(Node root) {
		
		if(root == null) {
			return;
		}
		
		Deque<Node> queue1 = new ArrayDeque<Node>();
		Deque<Node> queue2 = new ArrayDeque<Node>();
		
		queue1.offerFirst(root);
		
		while(!queue1.isEmpty()) {
			
			Node node = queue1.pollFirst();
			
			if(node.left != null) {
				queue1.offerFirst(node.left);
			}
			
			if(node.right != null) {
				queue1.offerFirst(node.right);
			}
			
			queue2.offerFirst(node);
		}
		
		while(!queue2.isEmpty()) {
			Node node = queue2.pollFirst();
			System.out.print(node.value + " ");
		}
		
	}
	
	public void levelTraversal(Node root) {
		
		if(root == null) {
			return;
		}
		
		Deque<Node> queue = new ArrayDeque<Node>();
		queue.offerLast(root);
		
		while(!queue.isEmpty()) {
			
			Node node = queue.pollFirst();
			
			System.out.print(node.value + " ");
			
			if(node.left != null) {
				queue.offerLast(node.left);
			}
			
			if(node.right != null) {
				queue.offerLast(node.right);
			}
		}
		
	}
	
	class Node {
		
		int value;
		Node left;
		Node right;
		
		public Node(int value) {
			this.value = value;
		}
	}

}
