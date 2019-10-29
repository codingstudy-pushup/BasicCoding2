package ama001;

import java.util.*;

public class A025_WordLadder2 {

	public static void main(String[] args) {
		String beginWord = "hit", endWord = "cog";
		String[] wordList = { "hot", "dot", "dog", "lot", "log", "cog" };
//		List<String> dict = new ArrayList<>(Arrays.asList("leet", "codea"));
		List<String> list = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
		A025_WordLadder2 a = new A025_WordLadder2();
		System.out.println(a.findLadders_1(beginWord, endWord, list));
//		System.out.println(a.findLadders_bfs(beginWord, endWord, list));
//		System.out.println(a.findLadders(beginWord, endWord, list));
//		System.out.println(a.findLadders_bfs(beginWord, endWord, list));
	}
	
	
//	1
	public List<List<String>> findLadders_1(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList();
        Set<String> words = new HashSet(wordList);
        
        Set<String> start = new HashSet();
        start.add(beginWord);
        boolean found = false;
        
        // use hashMap to store all possible route ending at key
        Map<String, List<List<String>>> map = new HashMap();
        List<String> init = new ArrayList();
        init.add(beginWord);
        map.put(beginWord, new ArrayList());
        map.get(beginWord).add(init);
        
        
        while(!words.isEmpty() && !found && !start.isEmpty()){
            // eliminate all previous layer words from dict
        	System.out.println("first words "+words+" start "+start);
            words.removeAll(start);
            System.out.println("remove words "+words);
            
            // use another set to record next layers' words
            Set<String> newStart = new HashSet();
            
            // iterate through all new starts
            for(String s: start){
            	System.out.println("s "+s);
                char[] chs = s.toCharArray();
                List<List<String>> endPath  = map.get(s);
                for(int i=0;i<chs.length;i++){
                    // randomly change a character
                    for(char ch='a';ch<='z';ch++){
                        if(chs[i]==ch) continue;
                        char tmp = chs[i];
                        chs[i] = ch;
                        String word = new String(chs);
                        //check if it is in the dict, if so new start found, extending all routes
                        if(words.contains(word)){
                        	System.out.println(" 00word "+ word);
                            newStart.add(word);
                            for(List<String> path:endPath){
                            	System.out.println(" 11path "+ path);
                                List<String> nextPath = new ArrayList(path);
                                System.out.println(" 22nextPath "+ nextPath);
                                nextPath.add(word);
                            
                                System.out.println(" nextPath "+ nextPath+" word: "+word);
                                map.putIfAbsent(word, new ArrayList());
                                map.get(word).add(nextPath);
                                System.out.println(" mapKey word: "+word+" nextPath "+ nextPath);
                                if(word.equals(endWord)){
                                	 System.out.println("===word: "+word+" endWord "+ endWord);
                                    found = true;
                                    res.add(nextPath);
                                }
                            }
                            System.out.println("##############");

                        }
                        chs[i] = tmp;
                    }
                }
                map.remove(s);
            }
            // clear the previous layers words and update
            start.clear();
            start.addAll(newStart);
            System.out.println("$$$$$$$$$$$$$");
            
        }
        
        return res;
    }
	
	
	public List<List<String>> findLadders(String start, String end, List<String> wordList) {
		HashSet<String> dict = new HashSet<String>(wordList);
		List<List<String>> res = new ArrayList<List<String>>();
		HashMap<String, ArrayList<String>> nodeNeighbors = new HashMap<String, ArrayList<String>>();// Neighbors for
																									// every node
		HashMap<String, Integer> distance = new HashMap<String, Integer>();// Distance of every node from the start node
		ArrayList<String> solution = new ArrayList<String>();

		dict.add(start);
		bfs(start, end, dict, nodeNeighbors, distance);
//		   dfs(start, end, dict, nodeNeighbors, distance, solution, res);   
		return res;
	}

	// BFS: Trace every node's distance from the start node (level by level).
	private void bfs(String start, String end, Set<String> dict, HashMap<String, ArrayList<String>> nodeNeighbors,
			HashMap<String, Integer> distance) {
		for (String str : dict)
			nodeNeighbors.put(str, new ArrayList<String>());

		Queue<String> queue = new LinkedList<String>();
		queue.offer(start);
		distance.put(start, 0);

		while (!queue.isEmpty()) {
			int count = queue.size();
			boolean foundEnd = false;
			for (int i = 0; i < count; i++) {
				String cur = queue.poll();
				int curDistance = distance.get(cur);
				ArrayList<String> neighbors = getNeighbors(cur, dict);

				for (String neighbor : neighbors) {
					nodeNeighbors.get(cur).add(neighbor);
					if (!distance.containsKey(neighbor)) {// Check if visited
						distance.put(neighbor, curDistance + 1);
						if (end.equals(neighbor))// Found the shortest path
							foundEnd = true;
						else
							queue.offer(neighbor);
					}
				}
			}

			if (foundEnd)
				break;
		}
	}

	// Find all next level nodes.
	private ArrayList<String> getNeighbors(String node, Set<String> dict) {
		ArrayList<String> res = new ArrayList<String>();
		char chs[] = node.toCharArray();

		for (char ch = 'a'; ch <= 'z'; ch++) {
			for (int i = 0; i < chs.length; i++) {
				if (chs[i] == ch)
					continue;
				char old_ch = chs[i];
				chs[i] = ch;
				if (dict.contains(String.valueOf(chs))) {
					res.add(String.valueOf(chs));
				}
				chs[i] = old_ch;
			}

		}
		return res;
	}

	
//2
	public List<List<String>> findLadders_bfs(String beginWord, String endWord, List<String> wordList) {
		Set<String> dict = new HashSet<>(wordList);
		List<List<String>> res = new ArrayList<>();
		if (!dict.contains(endWord)) {
			return res;
		}
		Map<String, List<String>> map = getChildren(beginWord, endWord, dict);
		List<String> path = new ArrayList<>();
		path.add(beginWord);
		findLadders(beginWord, endWord, map, res, path);
		return res;

	}

	public void findLadders(String beginWord, String endWord, Map<String, List<String>> map, List<List<String>> res,
			List<String> path) {
		if (beginWord.equals(endWord)) {
			res.add(new ArrayList<>(path));
		}
		if (!map.containsKey(beginWord)) {
			return;
		}
		for (String next : map.get(beginWord)) {
			path.add(next);
			findLadders(next, endWord, map, res, path);
			path.remove(path.size() - 1);
		}
	}

	public Map<String, List<String>> getChildren(String beginWord, String endWord, Set<String> dict) {
		Map<String, List<String>> map = new HashMap<>();
		Set<String> start = new HashSet<>();
		start.add(beginWord);
		Set<String> end = new HashSet<>();
		Set<String> visited = new HashSet<>();
		end.add(endWord);
		boolean found = false;
		boolean isBackward = false;
		while (!start.isEmpty() && !found) {
			if (start.size() > end.size()) {
				Set<String> tem = start;
				start = end;
				end = tem;
				isBackward = !isBackward;
			}
			Set<String> set = new HashSet<>();
			for (String cur : start) {
				visited.add(cur);
				for (String next : getNext(cur, dict)) {
					if (visited.contains(next) || start.contains(next)) {
						continue;
					}
					if (end.contains(next)) {
						found = true;
					}
					set.add(next);
					String parent = isBackward ? next : cur;
					String child = isBackward ? cur : next;
					if (!map.containsKey(parent)) {
						map.put(parent, new ArrayList<>());
					}
					map.get(parent).add(child);

				}
			}
			start = set;
		}
		return map;

	}

	private List<String> getNext(String cur, Set<String> dict) {
		List<String> res = new ArrayList<>();
		char[] chars = cur.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			char old = chars[i];
			for (char c = 'a'; c <= 'z'; c++) {
				if (c == old) {
					continue;
				}
				chars[i] = c;
				String next = new String(chars);
				if (dict.contains(next)) {
					res.add(next);
				}
			}
			chars[i] = old;
		}
		return res;
	}

	

	// DFS: output all paths with the shortest distance.
	private void dfs(String cur, String end, Set<String> dict, HashMap<String, ArrayList<String>> nodeNeighbors,
			HashMap<String, Integer> distance, ArrayList<String> solution, List<List<String>> res) {
		solution.add(cur);
		if (end.equals(cur)) {
			res.add(new ArrayList<String>(solution));
		} else {
			for (String next : nodeNeighbors.get(cur)) {
				if (distance.get(next) == distance.get(cur) + 1) {
					dfs(next, end, dict, nodeNeighbors, distance, solution, res);
				}
			}
		}
		solution.remove(solution.size() - 1);
	}
}
