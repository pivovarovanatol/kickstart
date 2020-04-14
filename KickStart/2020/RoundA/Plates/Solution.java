package RoundA.Plates;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
 
public class Solution {
	
	static int maxSum;
    public static void solve(Scanner input, int caseNum, int[][] plates, int n, int k, int p) {
    	int sum = 0;
    	maxSum = 0;
    	
    	sum = dp(plates, 0, n, k, sum, p);
    	
        System.out.println("Case #" + caseNum + ": " + maxSum);
    }

    
    public static int dp(int[][] plates, int row, int height, int width,  int sum, int count) {
    	int col =0;
    	if (row >= height) return -1;
    	if (count < 0) return -1;
    	
    	int t = dp(plates, row+1, height, width, sum, count);
    	
    	int tmp = sum;
    	while (col < width && count > 0) {
    		tmp += plates[row][col];
    		count--;
    		t = dp(plates, row+1, height, width, sum, count);
    		
    		if (t > 0) {
    			sum = Math.max(sum, tmp + t);
    		} else {
    			sum = Math.max(sum, tmp);
    		}
    		col++;
    	}
    	
    	
    	if (count==0) {
    		maxSum = Math.max(sum, maxSum);
    	}
    	return count == 0 ? sum : -1;
    }
    
    
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        try {
			input = new Scanner(new FileInputStream(new File("C:\\Users\\i855719\\git\\kickstart\\KickStart\\2020\\RoundA\\Plates\\input.txt")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // number of cases
        int T = input.nextInt();
        
        // for every case - execute the solution
        for (int ks = 1; ks <= T; ks++) {
            int N = Integer.parseInt(input.next());
            int K = Integer.parseInt(input.next());
            int P = Integer.parseInt(input.next());

            int[][] plates = new int[N][K];
        	
        	
            for (int i=0;i<N;i++) {
            	for (int j=0;j<K;j++) {
            		plates[i][j] = Integer.parseInt(input.next());
            	}
            }
            
            solve(input, ks, plates, N, K, P);
        }
        
        input.close();
        
    }
}
