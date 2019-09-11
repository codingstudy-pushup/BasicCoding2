package ama_on;
import java.util.*;

public class OptimalUtilizationAircraft {

	
	public static void main(String[] args) {
		int[][] a1 = {{1, 2}, {2, 4}, {3, 6}};
		int[][]	b1 = {{1, 2}};
		int	target1 = 7;
		aircraftUtilization(target1, a1, b1);
		for(int[] ele : getOptimalUtilization(a1, b1, target1)) {
			System.out.println(Arrays.toString(ele));
		}
		System.out.println("----------------------------");
		int[][] a2 = {{1, 3}, {2, 5}, {3, 7}, {4, 10}};
		int[][] b2 = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
		int target2 = 10;
		for(int[] ele : getOptimalUtilization(a2, b2, target2)) {
			System.out.println(Arrays.toString(ele));
		}
		System.out.println("----------------------------");
		int[][] a3 =  {{1, 5}, {2, 5}};
		int[][] b3 =  {{1, 5}, {2, 5}};
		int target3 = 10;
		for(int[] ele : getOptimalUtilization(a3, b3, target3)) {
			System.out.println(Arrays.toString(ele));
		}
	}
	

	public static List<List<Integer>> aircraftUtilization(int maxTravelDist, int[][] forwardRouteList, int[][] returnRouteList){
	    List<List<Integer>> res = new ArrayList<>();
	    int len1 = forwardRouteList.length, len2 = returnRouteList.length;
	    if(len1 == 0 || len2 == 0) return res;
	    Arrays.sort(forwardRouteList, (int[] a, int[] b) -> (a[1] - b[1]));
	    Arrays.sort(returnRouteList, (int[] a, int[] b) -> (a[1] - b[1]));
	    int left = 0, right = len2 - 1, maxVal = -1;
	    HashMap<Integer, List<List<Integer>>> map = new HashMap<>();
	    while(left < len1 && right >= 0){
	        int sum = forwardRouteList[left][1] + returnRouteList[right][1];
	        if(sum > maxTravelDist){ --right; continue;}
	        if(sum >= maxVal){
	            int r = right;
	            map.putIfAbsent(sum, new ArrayList<>());
	            // check the duplicates 
	            while(r >= 0 && returnRouteList[r][1] == returnRouteList[right][1]){
	                List<Integer> list = new ArrayList<>();
	                list.add(forwardRouteList[left][0]); list.add(returnRouteList[r][0]);
	                map.get(sum).add(list); --r;
	            }
	            maxVal = sum;
	        }
	        ++left;
	    }
	    return map.get(maxVal);
	}

	private static List<int[]> getOptimalUtilization(int[][] a, int[][] b, int target) {
		Arrays.sort(a, (p1, p2)->p1[1] - p2[1]);
		Arrays.sort(b, (p1, p2)->p1[1] - p2[1]);
		List<int[]> res = new ArrayList<>();
		int l = 0, r = b.length-1;
		int tmpMax = Integer.MIN_VALUE;
		while(l < r) {
			int tmp = a[l][1] + b[r][1];
			if(tmp > target)
				r--;
			else {
				tmpMax = Math.max(tmpMax, tmp);
				l++;
			}
		}
		l = 0; r = a.length-1;
		while(l < r) {
			int tmp = b[l][1] + a[r][1];
			if(tmp > target)
				r--;
			else {
				tmpMax = Math.max(tmpMax, tmp);
				l++;
			}
		}
		l = 0; r = b.length-1;
		while(l <= r) {
			int tmp = a[l][1] + b[r][1];
			if(tmp > target) {
				r--;
				if(r < 0)
					break;
			}
			else {
				if(tmp == tmpMax) {
					res.add(new int[] {a[l][0], b[r][0]});
				}
				tmpMax = Math.max(tmpMax, tmp);
				l++;
				if(l >= a.length)
					break;
			}
		}
		l = 0; r = a.length-1;
		while(l <= r) {
			int tmp = b[l][1] + a[r][1];
			if(tmp > target) {
				r--;
				if(r < 0)
					break;
			}
			else {
				if(tmp == tmpMax) {
					res.add(new int[] {a[r][0], b[l][0]});
				}
				tmpMax = Math.max(tmpMax, tmp);
				l++;
				if(l >= b.length)
					break;
			}
		}
		return res;
	}
	

}
