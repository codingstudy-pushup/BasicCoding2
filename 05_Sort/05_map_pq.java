package Sort;
import java.util.*;
import java.util.Map.Entry;

public class TopK {

	public static void main(String[] args) {
//		String[] words= {"i", "study", "inflearn", "i", "study", "coding"};
		int k = 2;
		String[] words= {"a", "b", "c", "a", "b", "c", "a"};
		TopK a = new TopK();
		System.out.println(a.solve(words, k));
		
	}
	public List<String> solve(String[] words, int k) {
	//	1
		List<String> result = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		
		//1.map
		for(String w : words) {
			map.put(w, map.getOrDefault(w, 0)+1); //a3 b2 c2
		}
		
		//2.pq
		Queue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a,b)->
		a.getValue()==b.getValue() ? a.getKey().compareTo(b.getKey()) : 
		b.getValue()-a.getValue());
		
		
		//2.pq comparator
		Comparator<Map.Entry<String, Integer>> comp = new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
				if(a.getValue()==b.getValue())
					return a.getKey().compareTo(b.getKey());
				return b.getValue()-a.getValue();
			}
		};
		Queue<Map.Entry<String, Integer>> pq2 = new PriorityQueue<>(comp);
		
		
		
		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			pq2.offer(entry);
		}
		
		while(k>0) {
			result.add(pq2.poll().getKey());
			k--;
		}
       return result;
    }
}
