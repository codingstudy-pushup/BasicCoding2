package zTest01;

public class ImpleStr {

	
	
	public static void main(String[] args) {
		
		String haystack = "inflearn", needle = "fl";
		ImpleStr a = new ImpleStr();
		System.out.println(a.strStr(haystack, needle));
		
	}
	public int strStr(String haystack, String needle) {

        if (needle.length() == 0)
            return 0;
        if (haystack.length() == 0)
            return -1;
        
        
        for (int i = 0; i < haystack.length(); i++) {
            // no enough places for needle after i
            if (i + needle.length() > haystack.length()) break;
            
            for (int j = 0; j < needle.length(); j++) {
            	System.out.println("i "+i+" j "+j);
                if (haystack.charAt(i+j) != needle.charAt(j))
                    break;
                if (j == needle.length()-1)
                    return i;
            }
        }
        
        return -1;
    }
}
