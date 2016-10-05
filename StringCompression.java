import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringCompression {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String result = "";
		
		int count = 0;
		for(int i = 0; i < str.length(); i++) {
			count++;
			
			if(i+1 == str.length() || str.charAt(i) != str.charAt(i+1)) {
				result += "" + str.charAt(i) + count;
				count = 0;
			}
		}
		
		System.out.println(result);
	}
}
