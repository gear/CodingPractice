/* AddTwoNumbers.java
 * Numbers are represented as linked lists of single digits
 * Head of linked list is the least significant digit.
 */

class DigitNode {
	private DigitNode next;
	private int val;
	public DigitNode(int i) {
		next = null;
		if (i > 9)
			val = i % 10;
		if (i < 0)
			val = 0;
	}
	public void setNext(DigitNode nx) {
		next = nx;
	}
	public void setVal(int newVal) {
		val = newVal;	
	}
	public int getVal() {	
		return val;	
	}
	public DigitNode getNext() {
		return next;
	}
}

public class AddTwoNumbers {
	public DigitNode add2(DigitNode lsa, DigitNode lsb) {
		
	}	
}
