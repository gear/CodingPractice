import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class word_ladder_2 {

	class word_node {
		public word_node prev;
		public String s;
		public int depth;
		
		public word_node(String content, int dep) {
			prev = null;
			s = new String(content);
			depth = dep;
		}

		public word_node(String content, word_node previous, int dep) {
			s = new String(content);
			depth = dep;
			prev = previous;
		}	
	}

	public int distance(String a, String b) {
		if (a == null || b == null) 
			return -1;
		if (a.length() != b.length()) 
			return -1;
		if (a.length() <= 0) 
			return -1;
		int dist = 0;
		for (int i = 0; i < a.length(); ++i) {
			if (a.charAt(i) != b.charAt(i))
				++dist;
		}
		return dist;
	}
	
	public ArrayList<String[]> findShortest(String word, String target, String[] dict) {

		ArrayList<String[]> path_list = new ArrayList<String[]>();
		if (word == null || target == null || dict == null)
			return path_list; 
		if (word.length() != target.length())
			return path_list;
		if (word.length() <= 0)
			return path_list;
		if (dict.length <= 0)
			return path_list;
		
		int depth = 1;
		LinkedList<word_node> queue = new LinkedList<word_node>();
		HashSet<String> visited = new HashSet<String>();
		word_node root = new word_node(word, depth);
		word_node end = new word_node(target, depth);
		queue.add(root);
		boolean found_shortest = false;
		while(!queue.isEmpty()) {
			int curr_queue_size = queue.size();
			for (int i = 0; i < curr_queue_size; ++i) { 
				word_node ladder = queue.remove();
				if (distance(ladder.s, target) == 1) {
					String[] word_path = new String[ladder.depth+1];
					end.prev = ladder;
					end.depth = ladder.depth + 1;
					word_node temp = end;
					for (int j = word_path.length-1; j >= 0; --j) {
						word_path[j] = new String(temp.s); 
						temp = temp.prev;
					}
					path_list.add(word_path);
					found_shortest = true;
				} else {
					if (!found_shortest) {
						for (String w : dict) {
							if (distance(ladder.s, w) == 1) {
								if (!visited.contains(w)) {
									word_node w_node = new word_node(w, ladder, ladder.depth+1);
									visited.add(w);
									queue.add(w_node);
								}	
							}
						}
					}
				}
			}
		}	
		return path_list;
	}

	public static void main(String[] args) {
		word_ladder_2 test = new word_ladder_2();
		String[] dict = new String[] {"hot", "dot", "dog", "lot", "log"};
		ArrayList<String[]> path_list = test.findShortest("hit", "cog", dict);
		for (String[] sa : path_list) {
			for (String s : sa) 
				System.out.println(s);
		}
	}
}
