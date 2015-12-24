/*  
    Programming Creek Interview practice
    String - Question 3: String isomophism
    Java
*/

public class str_isomorphic {
	public boolean isIsomorphic (String a, String b) {
		if (a.length() != b.length())
			return false;
		for (int i = 0; i < a.length(); ++i) {
			char ac = a.charAt(i);
			char bc = b.charAt(i);	
			for (int j = 0; j < a.length(); ++j) {
				if (ac == a.charAt(j) && bc != b.charAt(j))
					return false;
				if (bc == b.charAt(j) && ac != a.charAt(j))
					return false;
			}
		}
		return true;
	}	
	
	public static void main(String[] args) {
		str_isomorphic test = new str_isomorphic();
		System.out.println(test.isIsomorphic("a", "a"));
	}
}
	
