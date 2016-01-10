/* LinkedCycle.java
 * Detect if linked list has cycle or not.
 */

class Node {
	Node next;
	int id;
	Node(int t) {
		id = t;
		next = null;
	}
}

public class LinkedCycle {
	public boolean hasCycle(Node root) {
		if (root == null || root.next == null)
			return false;

		Node fast = root;
		Node slow = root;

		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			// == checks same instance
			if (fast == slow) {
				return true;	
			}
		}
		return false;
	}

	public static void main(String[] args) {
		LinkedCycle test = new LinkedCycle();

		Node root = new Node(0);
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);

		root.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = null;

		System.out.println(test.hasCycle(root));
	}
}
