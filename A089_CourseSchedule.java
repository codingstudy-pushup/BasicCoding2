package ama001;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class A089_CourseSchedule {

	public static void main(String[] args) {
		int m = 2; 
		int[][] prerequisites = {{1,0}};
		A089_CourseSchedule a = new A089_CourseSchedule();
		System.out.println(a.canFinish(m, prerequisites));
		a.canFinish_1(m, prerequisites);
	}
	/*
	 * 1. indegree=0 것 탐색
	 * 2. 관련 edge제거, indegree 업데이트
	 * 
	 */
	
	public boolean canFinish(int numCourses, int[][] p) {
		int[] indegree = new int[numCourses];
		List<List<Integer>> adjList = new ArrayList<>();
		for(int i=0; i<numCourses; i++) {
			adjList.add(new ArrayList<Integer>());
		}
		for(int[] edge:p) {
			indegree[edge[0]]++;
			adjList.get(edge[1]).add(edge[0]);
		}
		Queue<Integer> q = new LinkedList<>();
		for(int i=0; i<numCourses; i++) {
			if(indegree[i]==0) q.offer(i);
		}
		Set<Integer> visited = new HashSet<>();
		while(!q.isEmpty()) {
			int node = q.poll();
			System.out.println("node "+node);
			visited.add(node);
			for(int dest: adjList.get(node)) {
				if(--indegree[dest]==0) {
					System.out.println("dest "+dest);
					q.offer(dest);
				}
			}
			System.out.println("clear node "+node);
			adjList.get(node).clear();
		}
		return visited.size()==numCourses;
		
		
	}
	
	public boolean canFinish_1(int numCourses, int[][] prerequisites){
	    int[] incomingEdges = new int[numCourses];
	    List<Integer>[] goCourses = new List[numCourses];
	    for(int i=0;i<goCourses.length;i++){
	        goCourses[i] = new LinkedList<Integer>();
	    }
	    for(int[] pair: prerequisites){
	        incomingEdges[pair[0]]++;
	        goCourses[pair[1]].add(pair[0]);
	    }
	    Queue<Integer> queue = new LinkedList<Integer>();
	    for(int i=0;i<incomingEdges.length;i++){
	        if(incomingEdges[i]==0){
	            queue.add(i);
	        }
	    }
	    int edgeCnt = prerequisites.length;
	    while(!queue.isEmpty()){
	        int cur = queue.poll();
	        System.out.println("cur "+cur);
	        for(int goCrs: goCourses[cur]){
	             edgeCnt--;
	             if(--incomingEdges[goCrs]==0)
	                queue.add(goCrs);
	        }
	    }
	    return edgeCnt==0;
	}
	
	

	
	//bfs
	 public static boolean canFinish2(int numCourses, int[][] prerequisites) {
	        ArrayList[] graph = new ArrayList[numCourses];
	        int[] degree = new int[numCourses];
	        Queue queue = new LinkedList();
	        int count=0;
	        
	        for(int i=0;i<numCourses;i++)
	            graph[i] = new ArrayList();
	            
	        for(int i=0; i<prerequisites.length;i++){
	            degree[prerequisites[i][1]]++;
	            graph[prerequisites[i][0]].add(prerequisites[i][1]);
	        }
	        for(int i=0; i<degree.length;i++){
	            if(degree[i] == 0){
	                queue.add(i);
	                count++;
	            }
	        }
	        
	        while(queue.size() != 0){
	            int course = (int)queue.poll();
	            for(int i=0; i<graph[course].size();i++){
	                int pointer = (int)graph[course].get(i);
	                degree[pointer]--;
	                if(degree[pointer] == 0){
	                    queue.add(pointer);
	                    count++;
	                }
	            }
	        }
	        if(count == numCourses)
	            return true;
	        else    
	            return false;
	    }
	 
	 //dfs
	 
	 public boolean canFinish_dfs(int numCourses, int[][] prerequisites) {
         ArrayList[] graph = new ArrayList[numCourses];
         for(int i=0;i<numCourses;i++)
             graph[i] = new ArrayList();
             
         boolean[] visited = new boolean[numCourses];
         for(int i=0; i<prerequisites.length;i++){
             graph[prerequisites[i][1]].add(prerequisites[i][0]);
         }

         for(int i=0; i<numCourses; i++){
             if(!dfs(graph,visited,i))
                 return false;
         }
         return true;
     }

     private boolean dfs(ArrayList[] graph, boolean[] visited, int course){
         if(visited[course])
             return false;
         else
             visited[course] = true;;

         for(int i=0; i<graph[course].size();i++){
             if(!dfs(graph,visited,(int)graph[course].get(i)))
                 return false;
         }
         visited[course] = false;
         return true;
     }
	//1 bfs
	public boolean canFinish_bfs(int numCourses, int[][] prerequisites) {
	    int[][] matrix = new int[numCourses][numCourses]; // i -> j
	    int[] indegree = new int[numCourses];
	    
	    for (int i=0; i<prerequisites.length; i++) {
	        int ready = prerequisites[i][0];
	        int pre = prerequisites[i][1];
	        if (matrix[pre][ready] == 0)
	            indegree[ready]++; //duplicate case
	        matrix[pre][ready] = 1;
	    }
	    
	    int count = 0;
	    Queue<Integer> queue = new LinkedList();
	    for (int i=0; i<indegree.length; i++) {
	        if (indegree[i] == 0) queue.offer(i);
	    }
	    while (!queue.isEmpty()) {
	        int course = queue.poll();
	        count++;
	        for (int i=0; i<numCourses; i++) {
	            if (matrix[course][i] != 0) {
	                if (--indegree[i] == 0)
	                    queue.offer(i);
	            }
	        }
	    }
	    return count == numCourses;
	}
}
