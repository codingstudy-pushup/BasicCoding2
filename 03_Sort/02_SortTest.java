package Sort;

import java.util.*;

//1
class Interval {
	int start;
	int end;

	Interval(int s, int e) {
		this.start = s;
		this.end = e;
	}
}

public class SortTest02_Com {

	public static void main(String[] args) {

//		int[][] nums = {{1,3},{2,6},{8,10},{15,18}};
		Interval in1 = new Interval(1, 3);
		Interval in3 = new Interval(2, 6);
		Interval in2 = new Interval(8, 10);
		Interval in4 = new Interval(15, 18);

		List<Interval> intervals = new ArrayList<>();
		intervals.add(in1);
		intervals.add(in2);
		intervals.add(in3);
		intervals.add(in4);
		SortTest02_Com a = new SortTest02_Com();
		a.print(intervals);
		List<Interval> list = a.merge(intervals);
		System.out.println("===after====");
		a.print(list);
	}
	
	

	public List<Interval> merge(List<Interval> intervals) {
		if (intervals.isEmpty())
			return intervals;
		
		//1.sorting
		Collections.sort(intervals, comp2);
//		Collections.sort(intervals, (a,b)-> a.start-b.start);

		List<Interval> result = new ArrayList<>();
		Interval before = intervals.get(0);
		for(int i=1; i<intervals.size(); i++) {
			Interval curr = intervals.get(i);
			if(before.end  >= curr.start) {
				before.end = Math.max(curr.end, before.end);  
			}else {
				result.add(before);
				before = curr;
			}
		}
		if(!result.contains(before)) {
			result.add(before);
		}
		return intervals;
	}
	
	Comparator comp = new Comparator<Interval>() {
		@Override
		public int compare(Interval a, Interval b) {
			// TODO Auto-generated method stub
			return a.start-b.start;
		}
	};
	
	Comparator comp2 = new Comparator<Interval>() {
		@Override
		public int compare(Interval a, Interval b) {
			// TODO Auto-generated method stub
			if(a.start < b.start) {
				return -1;
			}else if(a.start > b.start) {
				return 1;
			}else {
				return 0;
			}
		}
	};
    
	
	


	void print(List<Interval> list) {
		for (int i = 0; i < list.size(); i++) {
			Interval in = list.get(i);
			System.out.println(in.start + " " + in.end);
		}
	}

}

