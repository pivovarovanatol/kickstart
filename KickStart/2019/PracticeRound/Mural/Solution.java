package PracticeRound.Mural;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
 
public class Solution {
	// completed both Small and Large data sets
    public static void solve(Scanner input, int caseNum, int[] walls) {
    	int windowSize = (int) Math.ceil((double)walls.length/2);
    	long max = 0;
    	// get sum for first window
    	for (int i=0;i<windowSize;i++) {
    		max += walls[i];
    	}
    	long runningMax = max;
    	for (int i=windowSize;i<walls.length;i++) {
    		runningMax -= walls[i-windowSize];
    		runningMax += walls[i];
    		if (runningMax> max) max = runningMax;
    	}
        System.out.println("Case #" + caseNum + ": " + max);
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        try {
			input = new Scanner(new FileInputStream(new File("C:\\Users\\i855719\\git\\kickstart\\KickStart\\2019\\PracticeRound\\Mural\\input3.txt")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // number of cases
        int T = input.nextInt();
        
        // for every case - execute the solution
        for (int ks = 1; ks <= T; ks++) {
            int n = input.nextInt();
            
            int[] walls = new int[n];
        	char[] digits = input.next().toCharArray();
        	
            for (int i=0;i<digits.length;i++) {
            	walls[i] = digits[i]-'0';
            }
            solve(input, ks, walls);
        }
    }
}
