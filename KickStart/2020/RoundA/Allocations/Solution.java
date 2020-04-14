package RoundA.Allocations;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
 
public class Solution {
	// completed both Small and Large data sets
    public static void solve(Scanner input, int caseNum, int[] nums, int n, int b) {
    	int count = 0;
    	Arrays.sort(nums);;
    	
    	for (int i=0;i<n;i++) {
    		if (b >= nums[i]) {
    			b -= nums[i];
    			count++;
    		} else {
    			break;
    		}
    	}
    	
        System.out.println("Case #" + caseNum + ": " + count);
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        try {
			input = new Scanner(new FileInputStream(new File("C:\\Users\\i855719\\git\\kickstart\\KickStart\\2020\\RoundA\\Allocations\\input.txt")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // number of cases
        int T = input.nextInt();
        
        // for every case - execute the solution
        for (int ks = 1; ks <= T; ks++) {
        	String s = input.next();
            String[] str = s.split(" ");
            
            int N = Integer.parseInt(str[0]);
            
        	s = input.next();
            str = s.split(" ");
            
            int B = Integer.parseInt(str[0]);
            
            int[] nums = new int[N];
        	
        	
            for (int i=0;i<N;i++) {
            	String price = input.next();
            	nums[i] = Integer.parseInt(price);
            }
            solve(input, ks, nums, N, B);
        }
        
        input.close();
        
    }
}
