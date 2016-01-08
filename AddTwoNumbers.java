/* AddTwoNumbers.java
 * Numbers are represented as linked lists of single digits
 * Head of linked list is the least significant digit.
 */

class DigitNode {
	private DigitNode next;
	private int val;
	public DigitNode() {
		val = 0;
		next = null;
	}
	public DigitNode(int i) {
		next = null;
		val = i;
		if (i > 9)
			val = i % 10;
		if (i < 0)
			val = 0;
	}
	public DigitNode(int i, DigitNode nx) {
		next = nx;
		val = i;
		if (i > 9)
			val = i % 10;
		if (i < 0)
			val = 0;
	}
	DigitNode(DigitNode c) {
		next = c.next;
		val = c.val;
	}
	public void setNext(DigitNode nx) {
		next = nx;
	}
	public int setVal(int newVal) {
		val = newVal % 10;
		return newVal/10;
	}
	public int getVal() {	
		return val;	
	}
	public DigitNode getNext() {
		return next;
	}
	
	@Override
	public String toString() {
		if (next != null)
			return " " + val + " ->" + next.toString();
		else 
			return " " + val;
	}
}

public class AddTwoNumbers {
	public DigitNode add2(DigitNode lsa, DigitNode lsb) {
		DigitNode a = lsa;
		DigitNode b = lsb;
		DigitNode result = new DigitNode();	
		DigitNode c = result;
		int carry = 0;
		while (a != null && b != null) {
			carry = c.setVal(a.getVal() + b.getVal() + carry);
			a = a.getNext();
			b = b.getNext();
			if (a != null || b != null) {
				c.setNext(new DigitNode());
				c = c.getNext();
			}
		}
		while (b != null) {
			carry = c.setVal(b.getVal() + carry);
			b = b.getNext();
			if (b != null) {
				c.setNext(new DigitNode());
				c = c.getNext();
			}
		}
		while (a != null) {
			carry = c.setVal(a.getVal() + carry);
			a .getNext();
			if (a != null) {
				c.setNext(new DigitNode());
				c = c.getNext();
			}
		}

		while (carry > 0) {
			System.out.print(carry);
			c.setNext(new DigitNode());
			c = c.getNext();
			carry = c.setVal(carry % 10);
		}

		return result;
	}	

	public static void main(String[] args) {
		DigitNode lsa = new DigitNode(8, new DigitNode(9, new DigitNode(9)));
		DigitNode lsb = new DigitNode(9, new DigitNode(9, new DigitNode(9)));

		AddTwoNumbers test = new AddTwoNumbers();
		DigitNode result = test.add2(lsa, lsb);
		
		System.out.println("Input a: " + lsa.toString());
		System.out.println("Input b: " + lsb.toString());
		System.out.println("Output: " + result.toString()); 
	}
}
