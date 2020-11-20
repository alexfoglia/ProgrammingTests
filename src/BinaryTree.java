import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
	private BinaryTree left;
	private BinaryTree right;
	private Integer value;
	
	public BinaryTree(BinaryTree left, BinaryTree right, Integer value) {
		this.left = left;
		this.right = right;
		this.value = value;
	}
	
	public void setLeft(BinaryTree left) {
		this.left = left;
	}
	
	public void setRight(BinaryTree right) {
		this.right = right;
	}
	
	public void setValue(Integer value) {
		this.value = value;
	}
	
	public BinaryTree getLeft() {
		return left;
	}
	
	public BinaryTree getRight() {
		return right;
	}
	
	public Integer getValue() {
		return value;
	}
	
	public void addNode(BinaryTree root, Integer value) {
		while (root != null) {
			Integer currentVal = root.getValue();
			
			if (currentVal == value) {
				BinaryTree newBinaryTree = new BinaryTree(null, null, value);
				root.setLeft(newBinaryTree);
				break;
			}
			
			if (value < currentVal) {
				if (root.getLeft() != null) {
					root = root.getLeft();
				} else {
					BinaryTree newBinaryTree = new BinaryTree(null, null, value);
					root.setLeft(newBinaryTree);
					break;
				}
			} else {
				if (root.getRight() != null) {
					root = root.getRight();
				} else {
					BinaryTree newBinaryTree = new BinaryTree(null, null, value);
					root.setRight(newBinaryTree);
					break;
				}
			}
		}
	}
	
	/*
		Start at the root node
		Loop while current node is non-null
			If the current node's value is equal to the search value
				Return the current node
			If the current node's value is less than the search value
				Make the right node the current node
			If the current node's value is greater than the search value
				Make the left node the current node
		End loop
	 */
	public BinaryTree findBinaryTree(BinaryTree root, Integer value) {
		
		while (root != null) {
			Integer currentVal = root.getValue();
			
			if (currentVal == value) {
				return root;
			}
			
			if (currentVal > value) {
				root = root.getLeft();
			} else {
				root = root.getRight();
			}
		}
		
		return null;
	}
	
	public static boolean treeEquals(BinaryTree a, BinaryTree b) {
	    // check for reference equality and nulls
	    if (a == b) return true; // note this picks up case of two nulls
	    if (a == null) return false;
	    if (b == null) return false;

	    // check for data inequality
	    if (a.value != b.value) {
	        if ((a.value == null) || (b.value == null)) return false;
	        if (!(a.value.equals(b.value))) return false;
	    }

	    // recursively check branches
	    if (!treeEquals(a.left,b.left)) return false;
	    if (!treeEquals(a.right,b.right)) return false;

	    // we've eliminated all possibilities for non-equality, so trees must be equal
	    return true;
	}
	
	/*
	  	- Breadth first is a queue, depth first is a stack.
		- For breadth first, add all children to the queue, then pull the head and do a breadth first 
		  search on it, using the same queue.
		- For depth first, add all children to the stack, then pop and do a depth 
		  first on that node, using the same stack.
	 */
	public static void printTreeBreadthFirst(BinaryTree root) {
		Queue<BinaryTree> queue = new LinkedList<BinaryTree>();
		
		if (root == null) {
			return;
		}
		
		queue.add(root);
		
		System.out.println();
		while (!queue.isEmpty()) {
			BinaryTree node = queue.remove();
	        System.out.print(node.value + " ");
	        if (node.left != null) queue.add(node.left);
	        if (node.right != null) queue.add(node.right);
		}
	}
	
	public static void printTreeDepthFirst(BinaryTree root) {
		Stack<BinaryTree> stack = new Stack<BinaryTree>();
		
		if (root == null) {
			return;
		}
		
		stack.add(root);
		
		System.out.println();
		while (!stack.isEmpty()) {
			BinaryTree node = stack.pop();
	        System.out.print(node.value + " ");
	        if (node.right != null) stack.add(node.right);
	        if (node.left != null) stack.add(node.left);
		}
	}
	
	public static void printTreeBreadthFirstSnakeMode(BinaryTree root) {
		Queue<BinaryTree> queue = new LinkedList<BinaryTree>();
		Stack<BinaryTree> stack = new Stack<BinaryTree>();
		int counter = 0;
		int exponent = 0;
		
		if (root == null) {
			return;
		}
		
		queue.add(root);
		
		System.out.println();
		while (!queue.isEmpty()) {
			BinaryTree node = queue.remove();
	        System.out.print(node.value + " ");
	        
	        if ((exponent % 2) == 0) {
	        	if (node.right != null) stack.add(node.right);
	        	if (node.left != null) stack.add(node.left);
	        } else {
	        	if (node.left != null) stack.add(node.left);
	        	if (node.right != null) stack.add(node.right);
	        }
	        
	        counter++;
			if (counter == (int)Math.pow(2, exponent)) {
				counter = 0;
				exponent++;
				
				while (!stack.isEmpty()) {
					queue.add(stack.pop());
				}
			}
		}
	}
	
	public void printNode(BinaryTree node) {
		// Print current node value
		if (node != null && node.getValue() != null) {
			System.out.println("Current value: " + node.getValue());
		}
		
		// Print left node value
		if (node.getLeft()!= null && node.getLeft().getValue() != null) {
			System.out.println("Left Value: " + node.getLeft().getValue());
		}
		
		// Print right node value
		if (node.getRight()!= null && node.getRight().getValue() != null) {
			System.out.println("Right Value: " + node.getRight().getValue());
		}
	}

	public void printInOrder(BinaryTree node) {
		if (node != null) {
			printInOrder(node.getLeft());
			System.out.println(node.getValue());
			printInOrder(node.getRight());
		}
	}

	public void printPreOrder(BinaryTree node) {
		if (node != null) {
            System.out.println(node.getValue());
			printInOrder(node.getLeft());
			printInOrder(node.getRight());
		}
	}

	public void printPostOrder(BinaryTree node) {
		if (node != null) {
			printInOrder(node.getLeft());
			printInOrder(node.getRight());
            System.out.println(node.getValue());
		}
	}
}
