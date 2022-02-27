import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1008 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] line = br.readLine().split(" ");
		
		System.out.println(Double.parseDouble(line[0])/Double.parseDouble(line[1]));
	}

}
