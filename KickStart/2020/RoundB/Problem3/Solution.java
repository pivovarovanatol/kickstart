package RoundB.Problem3;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

// didn't pass test 2 due to WA. Need to follow up.
public class Solution {
	static int mod = 1000000000;	
	static int maxSum;
    public static void solve(Scanner input, int caseNum, String s) {

    	System.err.println(s);
    	int w = 1;
    	int h = 1;
    	Stack<Integer> steps = new Stack<>();
    	char[] str = s.toCharArray();
    	int mult = 1;
    	for (char ch : str) {
    		if (ch >= '0' && ch <= '9') {
    			steps.push((ch - '0'));
    			mult *= (ch - '0');
    		} else if (ch ==')') {
    			mult/=steps.pop();
    		} else if (ch == 'E') {
    			w = add(w, mult);
    		} else if (ch == 'W') {
    			w = sub(w, mult);
    		} else if (ch == 'N') {
    			h = sub(h, mult);
    		} else if (ch == 'S') {
    			h = add(h, mult);
    		} 
    	}
    	
        System.out.println("Case #" + caseNum + ": " + w + " " + h);
    }

    static int add(int x, int y) {
    	long z = x + y;
    	return (int) (z % mod);
    }

    static int sub(int x, int y) {
    	long z = x - y;
    	if (z > 0) return (int) (z % mod);
    	else {
    		
    		return (int)(mod + (z % mod));
    	}
    }

    
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        try {
			input = new Scanner(new FileInputStream(new File("C:\\Users\\i855719\\git\\kickstart\\KickStart\\2020\\RoundB\\Problem3\\input.txt")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // number of cases
        int T = input.nextInt();
        
        // for every case - execute the solution
        for (int ks = 1; ks <= T; ks++) {
            String s = input.next();
            solve(input, ks, s);
        }
        
        input.close();
        
    }
}
