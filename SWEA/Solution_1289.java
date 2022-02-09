import java.util.Scanner;

public class Solution_1289 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int count=0;
			int index = -1;
			char check = '0';
			char[] nums = sc.next().toCharArray();
			
			for(int i=0; i<nums.length; i++) {
				if(nums[i] == '1') {
					index = i;
					break;
				}
			}
			
			if(index == -1) {
				count = 0;
			}
			else {
				for(int i=index; i<nums.length; i++) {
					if(check != nums[i]) {
						check = nums[i];
						count++;
					}
				}
			}
			
			System.out.println("#"+test_case+" "+count);
		}
	}

}