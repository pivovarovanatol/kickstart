package Round1A.problem2;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
 
public class Solution {
    public static void solve(Scanner input, int caseNum, int n) {
    	
    	// generate graph with adjacency list
    	Array

   		System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
    }


    public static List<List<Integer>> generate(int numRows, int n) {
    	List<List<Integer>> result = new ArrayList<>();
    	if (numRows == 0) {
    		return result;
    	}
    
    	int[][] arr = new int[numRows][numRows];
		List<Integer> tmp = new ArrayList<Integer>();   	
    	arr[0][0]=1;
    	tmp.add(arr[0][0]);
		result.add(tmp);
		
    	for (int i=1;i<numRows;i++) {
			List<Integer> tmp1 = new ArrayList<Integer>();
    		for (int j=0;j<i+1;j++) {
    			int top = arr[i-1][j];
    			int left = 0;
    			
    			if (j>0) {
    				left = arr[i-1][j-1];
    			}
    			
    			arr[i][j] = left + top;
    			tmp1.add(arr[i][j]);
    		}
    		result.add(tmp1);
    	}
    	return result;
    }
    
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
         try {
 			input = new Scanner(new FileInputStream(new File("C:\\Users\\i855719\\git\\kickstart\\KickStart\\CodeJam2020\\RoundA\\problem2\\input.txt")));
 		} catch (FileNotFoundException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
        // number of cases
        int T = input.nextInt();
        
        // for every case - execute the solution
        for (int ks = 1; ks <= T; ks++) {
        	int N = input.nextInt();
        	
            solve(input, ks, N);
        }
        input.close();
    }
}
