import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_1541 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		ArrayList<Integer> nums = new ArrayList<>();
		ArrayList<Boolean> symbols = new ArrayList<>();
		
		String line = br.readLine();
		
		String[] split = line.split("\\+|-");
		
		for(String num : split) {
			nums.add(Integer.parseInt(num));
		}
		
		int sum = nums.get(0);
		int check = 1;
		
		for(int i=0; i<line.length(); i++) {
			if(line.charAt(i) == '+') {
				sum += nums.get(check);
				check++;
			} else if(line.charAt(i) == '-') {
				break;
			}
		}
		
		int neg = 0;
		for(int i=check; i<nums.size(); i++) {
			neg += nums.get(i);
		}
		
		System.out.println(sum-neg);
	}

}
