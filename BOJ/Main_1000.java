import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1000 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] line = br.readLine().split(" ");
		
		System.out.println(Integer.parseInt(line[0])+Integer.parseInt(line[1]));
	}

}
