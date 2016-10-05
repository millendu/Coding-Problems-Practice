import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringPermutation {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		while(!(str = br.readLine()).equals("quit")) {
			String[] strs = str.split(" ");
			boolean result = isPermute(strs[0] , strs[1]);
			if(result == true) {
				System.out.println("True");
			}
			else {
				System.out.println("False");
			}
		}
	}
	
	public static boolean isPermute(String s, String t) {
		//System.out.println(s.length() + " " + t.length());
		if(s.length() != t.length()) {
			return false;
		}
		char[] charS = s.toCharArray();
		char[] charT = t.toCharArray();
		java.util.Arrays.sort(charS);
		java.util.Arrays.sort(charT);
		
		return (new String(charS)).equals(new String(charT));
	}

}
