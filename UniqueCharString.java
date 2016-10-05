import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UniqueCharString {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = "";
		while(!(str = br.readLine()).equals("quit")) {
			boolean result = isUnique(str);
			if(result == true) {
				System.out.println("True");
			}
			else {
				System.out.println("False");
			}
		}
	}
	
	public static boolean isUnique(String str) {
		for(int i = 0; i < str.length(); i++) {
			for(int j = i + 1; j < str.length(); j++) {
				if(str.charAt(i) == str.charAt(j)) {
					return false;
				}
			}
		}
		return true;
	}

}
