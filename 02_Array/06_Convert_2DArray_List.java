package Array;
import java.util.*;

public class Convert_2DArray_List {

	 public static void main(String[] args) throws Exception
	    {
	        int[][] A = {{1,2,3}, 
	        		     {4,5,6}, 
	        		     {7,8,9}};
	        
	        List<List<Integer>> list = convert(A);
	        System.out.println(list);
	        int[][] arr2 = convert2(list);
	        for(int i=0; i<arr2.length; i++) {
	        	for(int j=0; j<arr2[i].length; j++) {
	        		System.out.print(" a["+i+"]["+j+"] "+arr2[i][j]);
	        	}
	        	System.out.println("");
	        }
	        
	    }
	 public static int[][] convert2(List<List<Integer>> list) {
		 
		 int[][] arr = new int[list.size()][]; 
		 
		 for(int i=0; i<arr.length; i++) {
			 arr[i]= new int[list.get(i).size()];
		 }
		 
		 for(int i=0; i<list.size(); i++) {
			 for(int j=0; j<list.get(i).size(); j++) {
				 arr[i][j] = list.get(i).get(j); 
			 }
		 }
		 return arr;
		 
	 }
	 
	 public static List<List<Integer>> convert(int[][] a) {
		 List<List<Integer>> result = new ArrayList<>();
		 
		 for(int i=0; i<a.length; i++) {
			 List<Integer> list = new ArrayList<>();
			 for(int j=0; j<a[i].length; j++) {
				 System.out.print(" a["+i+"]["+j+"] "+a[i][j]);
				 list.add(a[i][j]);
			 }
			 System.out.println("");
			 result.add(list);
		 }
		 return result;
	 }  

}
