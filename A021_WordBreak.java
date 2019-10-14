package ama001;


import java.util.*;


public class A021_WordBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		A021_WordBreak aa = new A021_WordBreak();
//		ArrayList<String> dict = new ArrayList<>(Arrays.asList("cats", "dog", "sand", "and", "cat"));
//		System.out.println(aa.wordBreak("catsandog", dict));
		
		List<String> dict = new ArrayList<>(Arrays.asList("leet", "code"));
		System.out.println(aa.wordBreak_BFS("leetcodea", dict));
		System.out.println(aa.wordBreak_bfs("leetcodea", dict));
	}
	
	
	private boolean wordBreak_bfs(String s, List<String> wordDict) {
		Set<String> set = new HashSet<>(wordDict);
		Queue<Integer> queue = new LinkedList<>();
		int[] visited = new int[s.length()];
		queue.offer(0);
		
		while(!queue.isEmpty()) {
			int start = queue.poll();
			if(visited[start] ==0) {
				for(int end = start+1; end<=s.length(); end++) {
					System.out.println("start "+start+" end "+end+" "+(s.substring(start, end)));
					if(set.contains(s.substring(start, end))) {
						System.out.println("==========start "+start+" end "+end+" "+(s.substring(start, end)));
						queue.offer(end);
						if(end==s.length()) {
							return true;
						}
					}
				}
				visited[start]=1;
			}
		}
		return false;
	}
	
	
	public boolean wordBreak_BFS(String s, List<String> wordDict) {
        Set<String> wordDictSet=new HashSet(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[s.length()];
        queue.add(0);
        while (!queue.isEmpty()) {
            int start = queue.remove();
            if (visited[start] == 0) {
                for (int end = start + 1; end <= s.length(); end++) {
                    if (wordDictSet.contains(s.substring(start, end))) {
                        queue.add(end);
                        if (end == s.length()) {
                            return true;
                        }
                    }
                }
                visited[start] = 1;
            }
        }
        return false;
    }
	
	
    public boolean wordBreak_dp(String s, List<String> wordDict) {
        Set<String> wordDictSet=new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
        	System.out.println("start i: "+i);
            for (int j = 0; j < i; j++) {
            	System.out.println("j: "+j+" i: "+i+" "+(s.substring(j, i))+"  dp["+j+"]: "+dp[j]);
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    System.out.println("dp[i]: "+i+" "+dp[i]);
                    break;
                }
              	
            }
            System.out.println();
        }
        System.out.println("dp[s.length()]: "+dp[s.length()]+" "+s.length());
        return dp[s.length()];
    }
	
	public static boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0) {
            return true;
        }

        int len = s.length();
        Map<String, Boolean> mem = new HashMap<>();
        return wordBreak(s, mem, dict);
    }

    private static boolean wordBreak(String s, Map<String, Boolean> mem, Set<String> dict) {
        // If the dict contains the word s, return true directly
        if (dict.contains(s)) {
            return true;
        }
        // if the str state has been calculated, return the result directly
        if (mem.containsKey(s)) {
            return mem.get(s);
        }

        for (int i = 1; i < s.length(); i++) {
            // the left part (substring)
            String subStr = s.substring(0, i);
            System.out.println("subStr: "+subStr);
            if (dict.contains(s.substring(i)) && wordBreak(subStr, mem, dict)) {
                // if the word dictionary contains the right substring (word)
                // and the left subStr can be break into a space-separated sequence of one or more dictionary words
                
            	mem.put(s, true);
                return true;
            }
        }

        mem.put(s, false);
        return false;
    }
	

    
    
	public boolean wordBreak2(String s, List<String> wordDict) {
        if(s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0){
            return false;
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        Set<String> set = new HashSet<>();
        for(String word : wordDict){
            set.add(word);
        }
        for(int i = 1; i <= s.length(); i++){
            String curr = s.substring(0, i);
            if(set.contains(curr)){
                dp[i] = true;
            }else{
                for(int j = i - 1; j >= 0; j--){
                    if(dp[j] && set.contains(s.substring(j, i))){
                        dp[i] = true;
                    }
                }
            }
        }
        return dp[s.length()];
    }
	
	
	public boolean wordBreak(String s, Set<String> dict) {
		  if (s == null || s.length() == 0) return false;
		  
		  int n = s.length();
		  
		  // dp[i] represents whether s[0...i] can be formed by dict
		  boolean[] dp = new boolean[n];
		  
		  for (int i = 0; i < n; i++) {
		    for (int j = 0; j <= i; j++) {
		      String sub = s.substring(j, i + 1);
		      
		      if (dict.contains(sub) && (j == 0 || dp[j - 1])) {
		        dp[i] = true;
		        break;
		      }
		    }
		  }
		  
		  return dp[n - 1];
		}
}
