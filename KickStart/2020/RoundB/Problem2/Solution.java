package RoundB.Problem2;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
 
public class Solution {
	
	static int maxSum;
    public static void solve(Scanner input, int caseNum, long[] nums, int n, long d) {
    	long max = d;
    	int maxInd = nums.length-1;
    	boolean spin = true;
    	
    	for (int i = nums.length-1; i>=0;i--) {
    		//if (d % nums[i] == 0) continue;
    		long tmp = max/nums[i]; 
    		tmp *= nums[i];
    		if (tmp < max) max  = tmp; 
    	}
    	
        System.out.println("Case #" + caseNum + ": " + max);
    }

    

    
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        try {
			input = new Scanner(new FileInputStream(new File("C:\\Users\\i855719\\git\\kickstart\\KickStart\\2020\\RoundB\\Problem2\\input.txt")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // number of cases
        int T = input.nextInt();
        
        // for every case - execute the solution
        for (int ks = 1; ks <= T; ks++) {
            int N = Integer.parseInt(input.next());
            long D = Long.parseLong(input.next());
            long[] nums = new long[N];
            for (int i=0;i<N;i++) {
           		nums[i] = Long.parseLong(input.next());
            }
            
            solve(input, ks, nums, N, D);
        }
        
        input.close();
        
    }
}
