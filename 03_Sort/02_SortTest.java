package a_new_lec;

import java.util.*;

public class SortTest02 {

	public static void main(String[] args) {

		LargestNumber a = new LargestNumber();
		int[] nums = { 10, 9 ,8};
		System.out.println(a.largestNumber(nums));

	}

	public String largestNumber(int[] num) {
		if (num == null || num.length == 0)
			return "";
		// Convert int array to String array, so we can sort later on
		String[] s_num = new String[num.length];
		for (int i = 0; i < num.length; i++)
			s_num[i] = String.valueOf(num[i]);

		// Comparator to decide which string should come first in concatenation
//		Comparator<String> comp = new Comparator<String>() {
//			@Override
//			public int compare(String str1, String str2) {
//				String s1 = str1 + str2;
//				String s2 = str2 + str1;
//				System.out.println("s1 "+s1+" s2 "+s2);
//				
//				return s2.compareTo(s1);
//			}
			
//			public int compare(String str1, String str2) {
//				String s1 = str1 + str2;
//				String s2 = str2 + str1;
//		        if(s1.compareTo(s2)>0) return -1;
//		        else if(s1.compareTo(s2)<0) return 1;
//		        else if(s1.length()<=s2.length()) return -1;
//		        else return -1;
//			}
//		};
		
		
		
		
		Arrays.sort(s_num, (a, b) -> (b + a).compareTo(a + b));  
//		Arrays.sort(s_num, comp);
		
		
		if (s_num[0].charAt(0) == '0')
			return "0";

		StringBuilder sb = new StringBuilder();
		for (String s : s_num)
			sb.append(s);

		return sb.toString();

	}
}
