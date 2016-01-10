/* ReorderList.java
 * Reorder a given list: 0 -> (n-1) -> 1 -> (n-2) ... 
 * Pick one from each end to form a list.
 * Must do in place O(1) space.
 */

class Node {
	Node next;
	int id;
	Node(int i) {
		id = i;
	}
}
	
public class ReorderList {

	/* Classic way to reverse linked list */
	public Node reverse(Node root) throws NullPointerException {
		if (root == null)
			throw new NullPointerException("Root is null");
		if (root.next == null)
			return root;

		Node prev = null;
		Node curr = root;
		Node next = root.next;
		
		while(curr != null) {
			curr.next = prev;
			prev = curr;
			curr = next;
			if (next != null) 
				next = curr.next;
		}
		
		return prev;
	}

	/* O(n^2) solution */
	public Node reorder(Node root) throws NullPointerException {
		if (root == null)
			throw new NullPointerException("Root is null");
		if (root.next == null)
			return root;
		
		Node curr = root;
		while (curr.next != null) {
			curr.next = reverse(curr.next);
			curr = curr.next;
		}
		
		return root;
	}

	/* O(n) solution:
	 * 1. Find the middle point of the linked list.
	 * 2. Reverse the second list.
	 * 3. Merge two list together.
	 */
	public Node reorder_fast(Node root) throws NullPointerException {
		if (root == null)
			throw new NullPointerException("Root is null");
		if (root.next == null)
			return root;

		Node end = root;
		Node mid = root;
		Node premid = null; // To set the last element of first list points to null

		// Get to the middle and end of the list
		while(mid != null && end.next != null && end.next.next != null) {
			premid = mid;
			mid = mid.next;
			end = end.next.next;	
		}
	
		// Adjust to get even lists when the length is even
		if (end.next != null) {
			premid = mid;
			mid = mid.next;
		}

		if (premid.next != null)
			premid.next = null;

		// Reverse the second list
		mid = reverse(mid);

		// Merge two list
		Node i = root;
		Node j = mid;
		Node tmp;

		// j != null is condition for list that
		// has length difference at most 1.
		while (j != null) {
			tmp = i.next;
			i.next = j;
			i = j;
			j = tmp;
		}

		return root;
	}


	public static void main (String[] args) {
		Node root = new Node(1);
		root.next = new Node(2);
		root.next.next = new Node(3);
		root.next.next.next = new Node(4);
		root.next.next.next.next = new Node(5);

		System.out.println("Input: ");
		Node curr = root;
		while(curr != null) {
			System.out.print(curr.id + " ");
			curr = curr.next;
		}
		System.out.print("\n");

		ReorderList test = new ReorderList();
		curr = test.reorder_fast(root);
		System.out.println("Output: ");
		while(curr != null) {
			System.out.print(curr.id + " ");
			curr = curr.next;
		}
		System.out.print("\n");
	}
}
