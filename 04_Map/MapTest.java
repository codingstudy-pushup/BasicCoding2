package Map;

import java.util.*;

public class MapTest {

	
	public static void main(String[] args) {
		
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "A");
		map.put(2, "B");
		map.put(3, "C");
		
		//1
		for(Integer key : map.keySet()) {
			System.out.println("key: "+key+" values "+map.get(key));
		}
		System.out.println();
		//2 entrySet
		for(Map.Entry<Integer, String> elem : map.entrySet()) {
			System.out.println("key: "+elem.getKey()+" value "+elem.getValue());
		}
		//3
		Iterator<Integer> keys = map.keySet().iterator();
			while(keys.hasNext()) {
				Integer key = keys.next();
				System.out.println("key "+key);
			}
		
		
	}
}
