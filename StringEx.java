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
			if (visited[i])
				return false;
			else
				visited[i] = true;
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

	HashSet<char> visited = new HashSet<char>();
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

	long visitedMask = 0;
	for (int i = 0; i < str.length; ++i) {
		int shift = str[i] - 'A';
		long checker = 0x1 << var;
		if (visitedMask & checker > 0)
			return false;
		else
			visitedMask |= checker;
	} // iterate str
	return true;
}

}
