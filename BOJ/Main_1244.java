import java.util.Scanner;

public class Main_1244 {
	public static int[] switches;
	
	public static void change(int index) {
		if(switches[index] == 0) {
			switches[index] = 1;
		}
		else {
			switches[index] = 0;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		switches = new int[length+1];
		
		for(int i=1; i<=length; i++) {
			switches[i] = sc.nextInt();
		}
		int studentNum = sc.nextInt();
		
		for(int i=0; i<studentNum; i++) {
			int s = sc.nextInt();
			int index = sc.nextInt();
			
			if(s == 1) { //남학생
				for(int j=index; j<=length; j+=index) {
					change(j);
				}
			}
			else {         //여학생
				change(index);
				for(int j=1; (index+j)<=length && (index-j)>=1; j++) {
					if(switches[index-j] == switches[index+j]) {
						change(index-j);
						change(index+j);
					}
					else {
						break;
					}
				}
			}
		}
		
		for(int i=1; i<=length; i++) {
			System.out.print(switches[i]);
			if(i%20 == 0)
				System.out.println();
			else
				System.out.print(" ");
		}
		
		sc.close();
	}

}
