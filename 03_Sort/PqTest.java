

import java.util.PriorityQueue;

public class PqTest {

	public static void main(String[] args) {
		PqTest a = new PqTest();
		int[] sticks= {1,8,3,5};
		
		System.out.println(a.connectSticks(sticks));
	}
	public int connectSticks(int[] sticks) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i: sticks) {
			pq.offer(i);
		}
		
		int sum =0;
		while(pq.size()>1) {
			int twoSum = pq.poll()+pq.poll();
			sum += twoSum;
			pq.offer(twoSum);
		}
		return sum;
        
	}
}
