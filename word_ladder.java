import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;

public class word_ladder {
	public static int shortestnStep(String word, String target, String[] dict) {
		if (word == null || target == null) {
			return -1;
		}	
		if (word.length() != target.length()) {
			return -1;
		}
		if (word.equals(target)) {
			return 0;	
		}
		int depth = 1;
		Set<String> dict_set = new HashSet<String>(Arrays.asList(dict));
		Set<String> visited = new HashSet<String>();
		Queue<String> search_list = new LinkedList<String>();
		search_list.add(word);
		while (search_list.size() > 0) {
			++depth;
			for (int i = 0; i < search_list.size(); ++i) {
				String ladder = search_list.remove();
				if (distance(ladder, target) == 1)
					return depth;
				for (String dict_word : dict) {
					int dist = distance(ladder, dict_word);
					if (dist == 1) {
						if (!visited.contains(dict_word)) {
							search_list.add(dict_word);
							visited.add(dict_word);				
						}
					} 
				}
			}	
		}
		return -1;
	}

	public static int distance(String a, String b) {
		if (a == null || b == null) {
			return -1;
		}
		if (a.length() != b.length()) {
			return -1;
		}
		int dist = 0;
		for (int i = 0; i < a.length(); ++i) {
			if (a.charAt(i) != b.charAt(i))
				++dist;
		}
		return dist;
	}

	public static void main(String[] args) {
		word_ladder test = new word_ladder();
		String[] dict = new String[] {"hot", "dot", "dog", "lot", "log"};
		String word = "hit";
		String target = "cog";
		int dist = shortestnStep(word, target, dict);
		System.out.println(dist);
	}
}	
