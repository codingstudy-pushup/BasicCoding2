package ama_onsi;

import java.util.*;


class Interval{
	int start;
	int end;
	public Interval(int s, int e) {
		this.start = s;
		this.end = e;
	}
}

public class EmployeeFreeTime {

	public static void main(String[] args) {
//		schedule = {{{1,2},{5,6}},{{1,3}},{{4,10}}};
		Interval in1 = new Interval(1,2);
		Interval in2 = new Interval(5,6);
		Interval in3 = new Interval(1,3);
		Interval in4 = new Interval(4,10);
		List<Interval> list1 = new ArrayList<>();
		List<Interval> list2 = new ArrayList<>();
		List<Interval> list3 = new ArrayList<>();
		List<Interval> list4 = new ArrayList<>();
		list1.add(in1); list2.add(in2);list3.add(in3);list4.add(in4);
		List<List<Interval>> avails = new ArrayList<>();
		avails.add(list1);
		avails.add(list2);
		avails.add(list3);
		avails.add(list4);
		List<Interval> val = employeeFreeTime(avails);
		print(val);
	}
	public static void print(List<Interval> val) {
		for(Interval in : val)
			System.out.println(in.start+" "+in.end);
	}
	 public static List<Interval> employeeFreeTime(List<List<Interval>> avails) {

	        List<Interval> result = new ArrayList<>();

	        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> a.start - b.start);
	        avails.forEach(e -> pq.addAll(e));

	        Interval temp = pq.poll();
	        while(!pq.isEmpty()) {
	            if(temp.end < pq.peek().start) { // no intersect
	                result.add(new Interval(temp.end, pq.peek().start));
	                temp = pq.poll(); // becomes the next temp interval
	            }else { // intersect or sub merged
	                temp = temp.end < pq.peek().end ? pq.peek() : temp;
	                pq.poll();
	            }
	        }
	        return result;
	    }
}
