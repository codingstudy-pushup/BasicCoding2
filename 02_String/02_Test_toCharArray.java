package String;

public class Test_charAt_02 {

	
public static void main(String[] args) {
		
//		String s = "(a(b(c)d)";
//	    String  s = "in(f(lea)r)n)";
		String  s = "a)b(c)d";
		System.out.println(new Test_charAt_02().solve(s));
	}
	public String solve(String s) {
		StringBuilder sb = new StringBuilder();
		int count =0;
		
		for(char c :s.toCharArray()) {
			System.out.println("c: "+c);
			if(c=='(') {
				count++;
			}else if(c==')') {
				if(count==0) continue;
				count--;
			}
			sb.append(c);
		}
		
		StringBuilder result = new StringBuilder();
		for(int i =sb.length()-1; i >=0; i-- ) {
			if(sb.charAt(i) =='(' && count-->0 ) continue;
			result.append(sb.charAt(i));
			System.out.println("result "+result);

		}
		 return result.reverse().toString();
		
		
	}
}
