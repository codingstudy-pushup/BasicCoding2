package Map;

import java.util.*;

public class MapTest01 {

	public static void main(String[] args) {

		String s = "inflearn in love";
		System.out.println(firstUniqueChar(s));

	}

	public static int firstUniqueChar(String s) {
		if (s == null || s.length() == 0)
			return -1;
		//1.
		Map<Character, Integer> map = new HashMap();
		
		//2
		for (char ch : s.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
		
//		for (char ch : s.toCharArray()) {
//			if(!map.containsKey(ch)) {
//				map.put(ch,1 );
//			}else {
//				map.put(ch, map.get(ch)+1);
//			}
//		}
		

		//3
		for (int i = 0; i < s.length(); i++) {
			if (map.get(s.charAt(i)) == 1) {
				return i;
			}
		}
		return -1;
	}
}
