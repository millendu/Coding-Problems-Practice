import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class oneAway {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String[] strs = str.split(" ");
		boolean result = true;
		if(strs[0].length() == strs[1].length()) {
			result = check(strs[0], strs[1]);
		}
		else if(strs[0].length() + 1 == strs[1].length()) {
			result = check(strs[0], strs[1]);
		}
		else if(strs[0].length() - 1 == strs[1].length()) {
			result = check(strs[1], strs[0]);
		}
		
		if(result) {
			System.out.println("True");
		}
		else {
			System.out.println("False");
		}
	}
	
	public static boolean check(String s, String t) {
		boolean diff = false;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) != t.charAt(i)) {
				if(diff) {
					return false;
				}
				diff = true;
			}
		}
		return true;
	}

}
