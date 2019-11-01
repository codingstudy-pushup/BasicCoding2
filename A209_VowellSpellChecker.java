package ama003;

import java.util.*;

public class A209_VowellSpellChecker {

	public static void main(String[] args) {
		A209_VowellSpellChecker a = new  A209_VowellSpellChecker();
		
		String[] wordlist = {"yellow"};
		String[] query = {"YellOw"};
		String[] val = a.spellchecker_1(wordlist, query);
		for(String str : val)
			System.out.println(str);
		
	}
	
	public String[] spellchecker_1(String[] wordlist, String[] queries) {
        Set<String> words = new HashSet<>(Arrays.asList(wordlist));
        HashMap<String, String> cap = new HashMap<>();
        HashMap<String, String> vowel = new HashMap<>();
        for (String w : wordlist) {
            String lower = w.toLowerCase(), devowel = lower.replaceAll("[aeiou]", "#");
            cap.putIfAbsent(lower, w);
            vowel.putIfAbsent(devowel, w);
        }
        for (int i = 0; i < queries.length; ++i) {
            if (words.contains(queries[i])) continue;
            String lower = queries[i].toLowerCase(), devowel = lower.replaceAll("[aeiou]", "#");
            if (cap.containsKey(lower)) {
                queries[i] = cap.get(lower);
            } else if (vowel.containsKey(devowel)) {
                queries[i] = vowel.get(devowel);
            } else {
                queries[i] = "";
            }
        }
        return queries;
    }
	
	
	public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> wordSet = new HashSet<>();
        for(String s:wordlist) wordSet.add(s);
        HashMap<String,String> lowerCaseMap = new HashMap<>();
        for(int i = 0;i< wordlist.length;i++){
            String s = wordlist[i].toLowerCase();
            if(!lowerCaseMap.containsKey(s)){
                lowerCaseMap.put(s,wordlist[i]);
            }
        }
        HashMap<String,String> vowMap = new HashMap<>();
        for(int i = 0;i<wordlist.length;i++){
            if(!vowMap.containsKey(toVow(wordlist[i]))){
                vowMap.put(toVow(wordlist[i]),wordlist[i]);
            }
        }
        String[] ans = new String[queries.length];
        for(int i = 0;i<queries.length;i++){
            if(wordSet.contains(queries[i]))ans[i] = queries[i];
            else if(lowerCaseMap.containsKey(queries[i].toLowerCase())) ans[i] = lowerCaseMap.get(queries[i].toLowerCase());
            else if(vowMap.containsKey(toVow(queries[i]))){
                ans[i] = vowMap.get(toVow(queries[i]));
            }
            else ans[i] = "";
        }
        return ans;
    }
    private String toVow (String s){
        StringBuilder sb = new StringBuilder(s.toLowerCase());
            for(int j = 0;j<sb.length();j++){
                char c = sb.charAt(j);
                if(c == 'a' || c == 'e' ||c == 'i' ||c == 'o' ||c == 'u'){
                    sb.setCharAt(j,'a');
                }
            }
        return sb.toString();
    }
}
