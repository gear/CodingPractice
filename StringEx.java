import java.util.HashSet;
import java.util.HashMap;

public class StringEx {

    /* Ex1.1: Implement an algorithm to determine if a string is all unique
     * using extra data strucuture. Assumption: Only ASCII.
     * Signature: boolean isAllUniqueASCII(char[] str);
     */
    public boolean isAllUniqueASCII(char[] str) {
		if (str == null)
			return false;
		if (str.length < 2)
			return true;

		boolean[] visited = new boolean[256];
		for (int i = 0; i < 256; ++i) {
			visited[i] = false;
		}
		for (int i = 0; i < str.length; ++i) {
			if (visited[str[i]])
				return false;
			else
				visited[str[i]] = true;
		}
		return true;
    }

    /* Ex1.2: Implement an algorithm to determine if a string is all unique
     * using extra data structure. Asumption: Any character.
     * Signature: boolean isAllUnique(char[] str);
     */
    public boolean isAllUnique(char[] str) {
    	if (str == null)
    			return false;
    		if (str.length < 2)
    			return true;

    	HashSet<Character> visited = new HashSet<Character>();
    	for (int i = 0; i < str.length; ++i) {
    		if (visited.contains(str[i]))
    			return false;
    		else
    			visited.add(str[i]);
    	}
    	return true;
    }

    /* Ex1.3: Implement an algorithm ot determine if a string is all unique
     * without using extra data structure. Assumption: Only from A to Z.
     * Signature: boolean isAllUniqueAZ(char[] str);
     */
    public boolean isAllUniqueAZ(char[] str) {
    	if (str == null)
    			return false;
    		if (str.length < 2)
    			return true;

    	long visitedMask = 0L;
    	for (int i = 0; i < str.length; ++i) {
    		int shift = str[i] - 'A';
    		long checker = 0x1L << shift;
    		if ((visitedMask & checker) > 0)
    			return false;
    		else
    			visitedMask |= checker;
    	} // iterate str
    	return true;
    }

    /* Ex2: Write code to reverse C string */

    /* Ex3: Design algorithm to remove duplicate without additional buffer
     * one or two variables are ok, extra O(n) space is not. Return the new
     * length of the modified string.
     * Signature: int removeDuplicate(char[] str);
     */
    public int removeDuplicate(char[] str) {

      if (str == null)
        return 0;
      if (str.length < 2)
        return 1;

      int len = str.length;
      int tail = len - 1;
      for (int i = 0; i < tail; ++i) {
        for (int j = i+1; j <= tail; ++j) {
          if (str[i] == str[j]) {
            while(tail >= j && str[j] == str[i]) {
              str[j] = str[tail--];
            }
          } 
        }
      }
      return tail+1;
    } // This solution is correct, but it doesn't preserve the order of str.

    public int removeDuplicates(char[] str) {


    }


    public static void main(String[] args) {
      StringEx test = new StringEx();
    	char[] str = new String("abcabcabc").toCharArray();
    	System.out.println(test.isAllUniqueASCII(str));
    	System.out.println(test.isAllUnique(str));
      System.out.println(test.removeDuplicate(str));
      System.out.println(str);
    }
}
