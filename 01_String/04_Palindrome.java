package String;

public class String_palindrom {

	public static void main(String[] args) {
		String_palindrom a = new String_palindrom();
//		String s = "b";		
//		String s = "bb";
//		String s = "bbb";
		String s = "bbbb";
		
//		String s = "abba";
//		String s = "banana";

//		String s = "ba";
//		String s = "ban";
		
		System.out.println(a.solve(s));
	}

	int start, end;
	public String solve(String s) {
		//1. ds
		int len = s.length();
		if(len <2) return s;

		
		//2. for while
		for(int i=0; i<len; i++) {
			System.out.println("i "+i);
//			if(i==3) {
			findSubstring(s,i,i);//odd
			findSubstring(s,i,i+1);//even

//			}
			
		}
		return s.substring(start, end+start);
		
	}
	public void findSubstring(String s,int left, int right) {
	
		while( 0<=left&& right<s.length() && s.charAt(left) == s.charAt(right)) {
			left--;//2,1,0
			right++;//4,5,6
			System.out.println("left "+left+" right "+right);
		}
		//0,6 => 1,5
		if( end< right-left-1) {
			start=left+1;
		    end= right-left-1;
		}
		System.out.println("start "+start+" end "+end);
	}
	
	


}
