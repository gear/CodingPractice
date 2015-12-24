/*  
    Programming Creek Interview practice
    String - Question 2: Evaluate values in Reverse Polish order
    Java
*/

class MStack {
	MNode head;
	int stack_size;
	public void push(MNode newNode) {
		if (head == null) {
			head = newNode;
		} else {
			newNode.setPrev(head);
			head = newNode;
		}
		++stack_size;
	}
	public MNode pop() {
		if (stack_size <= 0) 
			return null;
		else {
			MNode ret = head;
			head = ret.getPrev();
			--stack_size;
			return ret;
		}
	}
	public MStack() {
		stack_size = 0;
		head = null;
	}
	public int size() {
		return stack_size;
	}
}

class MNode {
	MNode prev;
	String key;
	public MNode() {
		prev = null;
		key = "";
	}
	public MNode(String str) {
		prev = null;
		key = new String(str);
	}
	public MNode getPrev() {
		return prev;
	}
	public String getKey() {
		return this.key;
	}
	public void setPrev(MNode nod) {
		prev = nod;
	}
}

public class rev_polish {
	public float eval(String[] arr) {
		int op;
		MStack m_stack = new MStack();
		String ops = "+-*/";
		for(String str : arr) {
			if (str.matches("[+-/*]")) {
				op = ops.indexOf(str);
				if (m_stack.size() < 2) {
					return Float.parseFloat(m_stack.pop().getKey());
				} else {
					float a = Float.parseFloat(m_stack.pop().getKey());
					float b = Float.parseFloat(m_stack.pop().getKey());
					m_stack.push(new MNode(String.valueOf(cal(a,b,op))));
				}
			} else {
				m_stack.push(new MNode(str));
			}
		}
		return Float.parseFloat(m_stack.pop().getKey());
	}
	public float cal(float a, float b, int op) {
		switch(op) {
		case 0:
			return a + b;
		case 1:
			return a - b;
		case 2: 
			return a * b;
		case 3:
			return a / b;
		default:
			return b;
		}
	}	
	public static void main(String[] args) {
		rev_polish test = new rev_polish();
		System.out.println(test.eval(new String[]{"12", "1", "2", "+", "*"}));	
	}
}		
				
