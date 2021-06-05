package String;

public class String_palindrom {

	public static void main(String[] args) {
		String_palindrom a = new String_palindrom();
//		String s = "b";		
//		String s = "bb";
		String s = "bbb";
//		String s = "bbbb";
		
//		String s = "abba";
//		String s = "banana";

//		String s = "ba";
//		String s = "ban";
		
		System.out.println(a.solve(s));
	}

	int start, end;

	public String solve(String s) {
		int len = s.length();
		if (len < 2) return s;
		
		for(int i=0; i<len-1; i++) {
			System.out.println("i: "+i);
			findSubstring(s,i,i);//odd
			findSubstring(s,i,i+1);//even
		}
		return s.substring(start , start+end);

	}
	public void findSubstring(String s, int left, int right) {
		
		System.out.println("l: "+left+" r: "+right);
		while(0 <= left && right<s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
			
		}
		if(end< right-left-1) {
			end =right-left-1;//6
			start = left+1;//0
		}
		
	}


}
