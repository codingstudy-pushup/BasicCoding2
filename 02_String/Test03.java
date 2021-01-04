package aa;

public class Test03 {
	public static void main(String[] args) {
		String s = "PAYPALISHIRING";
		int numRows = 3;
		
		System.out.println(new Test03().convert(s, numRows));

	}

	public String convert(String s, int numRows) {
		if (numRows <= 1)
			return s;
		StringBuilder[] sbs = new StringBuilder[numRows];
		for (int i = 0; i < sbs.length; i++)
			sbs[i] = new StringBuilder();
		int idx = 0;
		int direction = -1;
		char[] chars = s.toCharArray();
		for (char c : chars) {
			sbs[idx].append(c);
			if (idx == 0 || idx == numRows - 1)
				direction = 0 - direction;
			idx += direction;
		}
		StringBuilder res = new StringBuilder();
		for (StringBuilder sb : sbs)
			res.append(sb);
		return res.toString();
	}

}
