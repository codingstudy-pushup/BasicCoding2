package ama004;
import java.util.*;
public class A304_LastStoneWeight {

	public static void main(String[] args) {
		int[] stones = {2,7,4,1,8,1};
		System.out.println(lastStoneWeight(stones));
		System.out.println(lastStoneWeightII2(stones));
	}
	public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        for(int i=0;i<stones.length;i++) {
        	pq.offer(stones[i]);
        }
        while(pq.size()>1) {
            int a=pq.poll(), b=pq.poll();
            if(a!=b) pq.offer(a-b);
        }
        if(pq.size()==0) return 0;
        return pq.peek();
    }
	
	public static int lastStoneWeightII(int[] stones) {
        Set<Integer> set = new HashSet<>();
        set.add(stones[0]);
        set.add(-stones[0]);
        for(int i=1;i<stones.length;i++){
            Set<Integer> set2 = new HashSet<>();
            for(int item : set){
                set2.add(item + stones[i]);
                set2.add(item - stones[i]);
            }
            set = set2;
        }
        int min = Integer.MAX_VALUE;
        for(int item : set) {
        	System.out.println("item "+item+" Math.abs(item): "+Math.abs(item));
        	min = Math.min(Math.abs(item), min);
        }
        return min;
    }
	
	
	public static int lastStoneWeightII2(int[] stones) {
        int S = 0, S2 = 0;
        for (int s : stones) S += s;
        int n = stones.length;
        boolean[][] dp = new boolean[S + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[0][i] = true;
        }
        for (int i = 1; i <= n; i++) {
            for (int s = 1; s <= S / 2; s++) {
                if (dp[s][i - 1] || (s >= stones[i - 1] && dp[s - stones[i - 1]][i - 1])) {
                	System.out.println("dp["+s+"]["+i+"] "+dp[s][i]);
                    dp[s][i] = true;
                    S2 = Math.max(S2, s);
                }
            }
        }
        return S - 2 * S2;
    }
}
