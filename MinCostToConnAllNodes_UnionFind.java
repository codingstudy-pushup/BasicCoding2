
import java.util.*;

public class MinCostToConnAllNodes_UnionFind {

	public static void main(String[] args) {
		MinCostToConnAllNodes_UnionFind a = new MinCostToConnAllNodes_UnionFind();
		int tc1 = a.minCostToConnect(6, new int[][] { { 1, 4 }, { 4, 5 }, { 2, 3 } },
				  new int[][] { { 1, 2, 5 }, { 1, 3, 10 }, { 1, 6, 2 }, { 5, 6, 5 } });
		System.out.println("tc1 "+tc1);
	}

	int[] parents;

	public int minCostToConnect(int n, int[][] edges, int[][] newEdges) {
		parents = new int[n + 1];
		int connected = n, minCost = 0;
		for (int i = 0; i <= n; i++) {
			parents[i] = i;
		}
		for (int[] edge : edges) {
			if (this.union(edge[0], edge[1])) {
				connected--;
			}
		}
		Arrays.sort(newEdges, new Comparator<int[]>() {
			@Override
			public int compare(int[] arr1, int[] arr2) {
				return arr1[2] - arr2[2];
			}
		});
		for (int[] newEdge : newEdges) {
			if (this.union(newEdge[0], newEdge[1])) {
				minCost += newEdge[2];
				connected--;
			}
			if (connected == 1) {
				return minCost;
			}
		}
		return connected == 1 ? connected : -1;
	}
//두 부모 노드를 합치는 함수
	private boolean union(int x, int y) {
		int setX = find(x);
		int setY = find(y);
		if (setX != setY) {
			parents[setY] = setX;
			return true;
		}
		return false;
	}
//부모 노드를 찾는 함수
	private int find(int num) {
		if (parents[num] != num) {
			parents[num] = find(parents[num]);
		}
		return parents[num];
	}

}
