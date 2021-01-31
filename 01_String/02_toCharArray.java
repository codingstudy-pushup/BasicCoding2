package String;

public class Test_charAt_02 {

	
public static void main(String[] args) {
		
//		String s = "(a(b(c)d)";
//		String s = "(((a(b(c(e(f)d))";
//	    String  s = "in(f(lea)r)n)";
//		String  s = "a)b(c)d";
		String  s = "a)b(c)d)";

//		String  s = "(()))";
//		String  s = "(()";
//	    String  s = "))((";
		System.out.println(new Test_charAt_02().solve(s));
	}
	public String solve(String s) {
		//1
		StringBuilder sb = new StringBuilder();
		StringBuilder result = new StringBuilder();
		int openBrace=0; // '('
		
		//2 count 
		for(char c: s.toCharArray()) {
			System.out.println("c "+c);
			if(c=='(') {
				openBrace++;
			}else if(c==')') {
				if(openBrace==0) continue;
				openBrace--;
			}
			sb.append(c);//그대로 저장
		}

		System.out.println("1_sb== "+sb);
		//3 제외 할 대상만 빼고 그대로 저장
		for(int i=sb.length()-1; i>=0; i--) {
			System.out.println("sb "+sb.charAt(i));
			if(sb.charAt(i)=='(' && openBrace-- > 0) {
				continue;
			}
			result.append(sb.charAt(i));
		}
		return result.reverse().toString();
		
	}
}
