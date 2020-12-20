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

//			int[][] nums = {{1,3},{2,6},{8,10},{15,18}};
		Interval in1 = new Interval(1, 3);
		Interval in2 = new Interval(2, 6);
		Interval in3 = new Interval(8, 10);
		Interval in4 = new Interval(15, 18);

		List<Interval> intervals = new ArrayList<>();
		intervals.add(in1);
		intervals.add(in2);
		intervals.add(in3);
		intervals.add(in4);
		SortTest02_Com a = new SortTest02_Com();
		List<Interval> list = a.merge(intervals);
		a.print(list);
	}

	public List<Interval> merge(List<Interval> intervals) {
		if (intervals.isEmpty())
			return intervals;

		Collections.sort(intervals, comp2);
//			Collections.sort(intervals,(a,b) -> a.start-b.start);

		List<Interval> ans = new LinkedList<Interval>();
		Interval hold = intervals.get(0);
		for (int i = 1; i < intervals.size(); i++) {
			Interval current = intervals.get(i);
			if (hold.end >= current.start) {
				System.out.println("hold.end: " + hold.end);
				hold.end = Math.max(current.end, hold.end);
			} else {
				System.out.println("22hold.end: " + hold.end);
				ans.add(hold);
				hold = current;
			}
		}

		if (!ans.contains(hold)) {
			System.out.println("333hold.end: " + hold.end);
			ans.add(hold);
		}

		return ans;
	}

	// 1
	Comparator comp = new Comparator<Interval>() {
		public int compare(Interval a, Interval b) {
			// TODO Auto-generated method stub
			return a.start - b.start;
		}
	};
	// 2
//		 리턴값이 int 양수: 현재 인스턴스가 비교대상인 인스턴스보다 크다 
//	            음수:현재 인스턴스가비교대상인 인스턴스보다 작다
//	               0 :값이 동일
	//
//		public int compare(Interval o1, Interval o2) {
//			if (o1.start > o2.start) {
//				return 1;
//			} else if (o1.start < o2.start) {
//				return -1;
//			} else {
//				return 0;
//			}
//		}

	Comparator<Interval> comp2 = new Comparator<Interval>() {
		@Override

		public int compare(Interval o1, Interval o2) {
			if (o1.start > o2.start) {
				return 1;
			} else if (o1.start < o2.start) {
				return -1;
			} else {
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
