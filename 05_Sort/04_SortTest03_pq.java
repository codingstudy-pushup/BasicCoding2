package Sort;

import java.util.*;

public class SortTest03_pq {

	public static void main(String[] args) {
		SortTest04_pq a = new SortTest04_pq();
		int[] sticks = { 1, 8, 2, 5 };

		System.out.println(a.pqSticks(sticks));
	}

	public int pqSticks(int[] sticks) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i : sticks) {
			pq.offer(i);
		}

		int sum = 0;
		while (pq.size() > 1) {
			int twoSum = pq.poll() + pq.poll();
			sum += twoSum;
			pq.offer(twoSum);
		}
		return sum;

	}
}
