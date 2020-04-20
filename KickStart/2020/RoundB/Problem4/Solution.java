package RoundB.Problem4;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void solve(Scanner input, int caseNum, int W, int H, int L, int U, int R, int D) {
    	// trying to solve with DFS. Count the number of ways to reach the end with and without hole and calc probability
    	double prob = 0.0;
    	
    	int total = dfs(1, 1, W, H, -1, -1, -1, -1);
    	
    	int success = dfs(1, 1, W, H, L, U, R, D);
    	
    	prob = (double) success / total;
    	
        System.out.println("Case #" + caseNum + ": " + prob);
    }

    static int dfs(int r, int c, int W, int H, int L, int U, int R, int D) {
    	if (c==W && r==H) return 1;
    	if (c>W) return 0;
    	if (r>H) return 0;
    	
    	if (c >= L && c <= R && r >= U && r <= D) return 0;
    	
    	return dfs(r+1, c, W, H, L, U, R, D) + dfs(r, c+1, W, H, L, U, R, D);
    }
    
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        try {
			input = new Scanner(new FileInputStream(new File("C:\\Users\\i855719\\git\\kickstart\\KickStart\\2020\\RoundB\\Problem4\\input.txt")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // number of cases
        int T = input.nextInt();
        
        // for every case - execute the solution
        for (int ks = 1; ks <= T; ks++) {
           	int W = Integer.parseInt(input.next());
           	int H = Integer.parseInt(input.next());
           	int L = Integer.parseInt(input.next());
           	int U = Integer.parseInt(input.next());
           	int R = Integer.parseInt(input.next());
           	int D = Integer.parseInt(input.next());

            solve(input, ks, W, H, L, U, R, D);
        }
        
        input.close();
        
    }
}
