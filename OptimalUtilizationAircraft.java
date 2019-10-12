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
	
	
	
	package ama_online;
import java.util.*;

public class A02_OptimalAircraftUtilization_list {
	
	    public static void closestSum(List<List<Integer>> listA, List<List<Integer>> listB, int target) {
	        List<List<Integer>> result = new ArrayList<List<Integer>>();
	        int diff = Integer.MAX_VALUE;
	        
	        for (List<Integer> lista : listA) {
	            int first = lista.get(1);
	            for (List<Integer> listb : listB) {
	                //System.out.println(result);
	                int second = listb.get(1);
	                if ((first+second) <=target ) {
	                    if (target - (first+second) <  diff) {
	                        result.clear();
	                        result.add(new ArrayList<Integer>(Arrays.asList(lista.get(0), listb.get(0))));
	                        diff = target - (first+second);
	                    } else if (target - (first+second) ==  diff) {
	                        result.add(new ArrayList<Integer>(Arrays.asList(lista.get(0), listb.get(0))));
	                    }                                     
	                }
	            }          
	        }
	        System.out.println("Output: " + result);
	    }
	    public static void main(String[] args) {

	        List<List<Integer>> listA = new ArrayList<List<Integer>>();
	        List<List<Integer>> listB = new ArrayList<List<Integer>>();
	        listA.add(new ArrayList<Integer>(Arrays.asList(1, 2000)));
	        listA.add(new ArrayList<Integer>(Arrays.asList(2, 4000)));
	        listA.add(new ArrayList<Integer>(Arrays.asList(3, 6000)));
	       // listA.add(new ArrayList<Integer>(Arrays.asList(4, 10)));
	        listB.add(new ArrayList<Integer>(Arrays.asList(1, 2000)));
	        System.out.println("a = " + listA);
	        System.out.println("b = " + listB);
	        int target = 7000;
	        System.out.println("target = " + target);
	        closestSum(listA, listB, target);
	        
	        
	        
//	        List<List<Integer>> listA = new ArrayList<List<Integer>>();
//	        List<List<Integer>> listB = new ArrayList<List<Integer>>();
//	        listA.add(new ArrayList<Integer>(Arrays.asList(1, 8)));
//	        listA.add(new ArrayList<Integer>(Arrays.asList(2, 15)));
//	        listA.add(new ArrayList<Integer>(Arrays.asList(3, 9)));
//	       // listA.add(new ArrayList<Integer>(Arrays.asList(4, 10)));
//	        listB.add(new ArrayList<Integer>(Arrays.asList(1, 8)));
//	        listB.add(new ArrayList<Integer>(Arrays.asList(2, 11)));
//	        listB.add(new ArrayList<Integer>(Arrays.asList(3, 12)));
//	       // listB.add(new ArrayList<Integer>(Arrays.asList(4, 5)));
//	        System.out.println("a = " + listA);
//	        System.out.println("b = " + listB);
//	        int target = 20;
//	        System.out.println("target = " + target);
//	        closestSum(listA, listB, target);
	    }
}
	
	package ama_online;

import java.util.*;

public class A02_OptimalAircraftUtilization_ListInIntArray {

	public static void main(String[] args) {
		A02_OptimalAircraftUtilization_ListInIntArray main = new A02_OptimalAircraftUtilization_ListInIntArray();
		List<int[]> a1 = Arrays.asList(new int[] { 1, 8 }, new int[] { 2, 15 }, new int[] { 3, 9 });
		List<int[]> b1 = Arrays.asList(new int[] { 1, 8 }, new int[] { 2, 11 }, new int[] { 3, 12 });
		List<int[]> tc1 = main.optimalUtilize(a1, b1, 20);

		List<int[]> a2 = Arrays.asList(new int[] { 1, 3 }, new int[] { 2, 5 }, new int[] { 3, 7 }, new int[] { 4, 10 });
		List<int[]> b2 = Arrays.asList(new int[] { 1, 2 }, new int[] { 2, 3 }, new int[] { 3, 4 }, new int[] { 4, 5 });
		List<int[]> tc2 = main.optimalUtilize(a2, b2, 10);
		for (int[] arr : tc2) {
			System.out.println(arr[0] + "," + arr[1]);
		}
	}

	public List<int[]> optimalUtilize(List<int[]> a, List<int[]> b, int target) {
		int low = 0, high = b.size() - 1, aLen = a.size(), bLen = b.size();
		Collections.sort(a, new Comparator<int[]>() {
			@Override
			public int compare(int[] arr1, int[] arr2) {
				return arr1[1] - arr2[1];
			}
		});
		Collections.sort(b, new Comparator<int[]>() {
			@Override
			public int compare(int[] arr1, int[] arr2) {
				return arr1[1] - arr2[1];
			}
		});
		int maxSum = Integer.MIN_VALUE;
		List<int[]> result = new ArrayList<>();
		while (low < aLen && high >= 0) {
			int sum = a.get(low)[1] + b.get(high)[1];
			if (sum > target) {
				high--;
			} else {
				if (sum >= maxSum) {
					if (sum > maxSum) {
						maxSum = sum;
						result = new ArrayList<>();
					}
					result.add(new int[] { a.get(low)[0], b.get(high)[0] });
					int index = high - 1, prev = b.get(high)[1];
					while (index > 0 && b.get(index)[1] == prev) {
						result.add(new int[] { a.get(low)[0], b.get(high)[0] });
						index--;
					}
				}
				low++;
			}
		}
		return result;
	}

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
