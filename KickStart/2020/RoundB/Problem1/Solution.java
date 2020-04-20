package RoundB.Problem1;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
 
public class Solution {
	
	static int maxSum;
    public static void solve(Scanner input, int caseNum, int[] nums, int n, int d) {
    	int count = 0;
    	if (nums.length <=1) {
    		System.out.println("Case #" + caseNum + ": 0");
    		return;
    	}
    	for (int i=1;i<nums.length-1;i++) {
    		if (nums[i]>nums[i-1] && nums[i]>nums[i+1]) count++;
    	}
    	
        System.out.println("Case #" + caseNum + ": " + count);
    }

    

    
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        try {
			input = new Scanner(new FileInputStream(new File("C:\\Users\\i855719\\git\\kickstart\\KickStart\\2020\\RoundB\\Problem1\\input.txt")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // number of cases
        int T = input.nextInt();
        
        // for every case - execute the solution
        for (int ks = 1; ks <= T; ks++) {
            int N = Integer.parseInt(input.next());
            int D = Integer.parseInt(input.next());
            int[] nums = new int[N];
            for (int i=0;i<N;i++) {
           		nums[i] = Integer.parseInt(input.next());
            }
            
            solve(input, ks, nums, N, D);
        }
        
        input.close();
        
    }
}
