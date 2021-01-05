package String;

public class String_palindrom {

	public static void main(String[] args) {
		String_palindrom a = new String_palindrom();
		String s = "bananas";

		System.out.println(a.solve1(s));
//			System.out.println(a.solve(s));
	}
	
	 public String solve (String s) {
	        String max = "";
	        for (int i = 0; i < s.length(); i++) {
	            String s1 = findSubstring(s, i, i ,"odd") ;
	            String s2 = findSubstring(s, i, i + 1,"eve");
	            System.out.println("s1: "+s1+" s2 "+s2 );
	            if (s1.length() > max.length()) max = s1;
	            if (s2.length() > max.length()) max = s2;
	        }
	        return max;
	    }
	    
	    private String findSubstring(String s, int i, int j, String str) {
	    	 System.out.println("=s: "+s+" i "+i+" j "+j+" str "+str );
	        for (; 0 <= i && j < s.length(); i--, j++) {
	            if (s.charAt(i) != s.charAt(j)) break;
	        }
	        String subStr = s.substring(i + 1, j);
	        System.out.println("=subStr "+subStr);
	        return subStr;
	    }
   }
