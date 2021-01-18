package Sort;
import java.util.*;
import java.util.Map.Entry;

public class TopK {

	public static void main(String[] args) {
//		String[] words= {"i", "study", "inflearn", "i", "study", "coding"};
		int k = 2;
		String[] words= {"a", "b", "c", "a", "b", "c"};
		TopK a = new TopK();
		System.out.println(a.solve(words, k));
		
	}
	public List<String> solve(String[] words, int k) {
		
	    List<String> result = new ArrayList<>();
		HashMap<String, Integer> map = new HashMap<>();

        for (String w: words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
         
        }
       //1. PriorityQueue 람다식
       PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (a,b) -> a.getValue()==b.getValue() ? a.getKey().compareTo(b.getKey()) : a.getValue()-b.getValue()
       );
       
       
       //2 
       Comparator<Map.Entry<String, Integer>> comp = new Comparator<Map.Entry<String, Integer>>() {
           @Override
           public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
               if(a.getValue()==b.getValue())
                   return (a.getKey().compareTo(b.getKey()));
               return b.getValue().compareTo(a.getValue());
           }
       };
       PriorityQueue<Map.Entry<String, Integer>> pq2 = new PriorityQueue<>(comp);


      
       
       for(Map.Entry<String, Integer> entry: map.entrySet())
           pq.offer(entry);
       
       
       while(k>0){
           result.add(pq.poll().getKey());
           k --;
       }
       return result;
    }
}
