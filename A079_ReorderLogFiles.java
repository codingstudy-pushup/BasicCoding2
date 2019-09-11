package ama_online;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class A079_ReorderLogFiles {

	public static void main(String[] args) {
		String[] input = { "a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo" };

		A079_ReorderLogFiles a = new A079_ReorderLogFiles();
		String[] result = a.reorderLogFiles2(input);
		for(String s : result)
			System.out.println("s: "+s);
	}
	
	public String[] reorderLogFiles2(String[] logs) {

		Comparator<String> myComp = new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				System.out.println("s1: "+s1+" s2: "+s2);
				int s1si = s1.indexOf(' ');
				System.out.println("s1si: "+s1si);
				int s2si = s2.indexOf(' ');
				System.out.println("s2si: "+s2si);
				char s1fc = s1.charAt(s1si + 1);
				System.out.println("s1fc: "+s1fc);
				char s2fc = s2.charAt(s2si + 1);
				System.out.println("s2fc: "+s2fc);

				if (s1fc <= '9') {
					if (s2fc <= '9')
						return 0;
					else
						return 1;
				}
				if (s2fc <= '9')
					return -1;

				int preCompute = s1.substring(s1si + 1).compareTo(s2.substring(s2si + 1));
				if (preCompute == 0)
					return s1.substring(0, s1si).compareTo(s2.substring(0, s2si));
				return preCompute;
			}
		};

		Arrays.sort(logs, myComp);
		return logs;
	}
	
	 public String[] reorderLogFiles_comp(String[] logs) {
	       Comparator<String> myComp = new Comparator<String>() {
	         @Override
	         public int compare(String s1, String s2) {
	           String[] split1 = s1.split(" ", 2);
	           String[] split2 = s2.split(" ", 2);
	           boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
	           boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
	           if(!isDigit1 && !isDigit2) {             
	             int comp = split1[1].compareTo(split2[1]);
	             if(comp != 0)
	              return comp;
	              return split1[0].compareTo(split2[0]);
	           }
	             return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
	         }
	       };
	       Arrays.sort(logs, myComp);
	       return logs;
	    }



	public String[] reorderLogFiles(String[] logs) {
		String[] res = new String[logs.length];
		if (logs.length == 0)
			return res;
		Queue<String> q = new LinkedList<>();

		PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {

			public int compare(String s1, String s2) {
				String subs1 = s1.substring(s1.indexOf("") + 1);
				String subs2 = s2.substring(s2.indexOf("") + 1);
				return subs1.compareTo(subs2);
			}
		});

		for (String log : logs) {
			System.out.println("log: " + log);
			System.out.println(
					log.charAt(log.indexOf(" ") + 1) + " " + Character.isDigit(log.charAt(log.indexOf(" ") + 1)));
			if (Character.isDigit(log.charAt(log.indexOf(" ") + 1))) {
				q.add(log);
			} else
				pq.add(log);
		}

		int i = 0;
		while (!pq.isEmpty()) {
			res[i] = pq.poll();
			i++;
		}

		while (!q.isEmpty()) {
			res[i] = q.poll();
			i++;
		}

		return res;
	}
}
