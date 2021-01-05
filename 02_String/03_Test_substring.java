
public class Test02 {

	public static void main(String[] args) {
		String str[] = {"fltow","flower"};
		System.out.println(new Test02().solve(str));
	}
	
	public String solve(String[] strs) {
		if(strs.length==0) return "";
		String pre = strs[0];
		for(int i=1; i<strs.length; i++) {
			System.out.println("pre: "+pre);
			System.out.println("strs[i].indexOf(pre): "+strs[i].indexOf(pre));
			while(strs[i].indexOf(pre)!=0) {
				System.out.println(strs[i].indexOf(pre));
				pre = pre.substring(0, pre.length()-1);
				System.out.println("pre "+pre);
			}
		}
		return pre;
	}
}
