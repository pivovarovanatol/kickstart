package Round1B.problem2;
// https://codingcompetitions.withgoogle.com/codejam/round/000000000019fef2/00000000002d5b63
// cd C:\Users\i855719\git\kickstart\KickStart\CodeJam2020\Round1B\problem2\
// java -cp ./../../../bin Round1B.problem2.Solution
//py interactive_runner.py python local_testing_tool.py 0 -- java -cp ./../../../bin Round1B.problem2.Solution
//py interactive_runner.py python local_testing_tool.py 1 -- java -cp ./../../../bin Round1B.problem2.Solution
//py interactive_runner.py python local_testing_tool.py 2 -- java -cp ./../../../bin Round1B.problem2.Solution

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

// Solved with binary search. Passed all 3 test cases. Didn't manage to finish within the contest time.
public class Solution {
	static int count = 0;
	static int maxX = 1000000000;
	static int maxY = 1000000000;
	static int minX = -1000000000;
	static int minY = -1000000000;
	static HashMap<String, Boolean> map;
	public static void solve(Scanner input, int caseNum, int minR, int maxR) {
		boolean found = false;    	
		count = 0;
		map =  new HashMap<String, Boolean>();
		// check first half-point
		int x = maxX/2-1;
		int y = 1;
		found = checkPoint(input, x, y);
		
		if (!found) {
			// check second point
			x = minX/2+1;
			y = -1;
			found = checkPoint(input, x, y);
			if (!found) {
				// check third point
				x = 1;
				y = minY/2+1;
				found = checkPoint(input, x, y);
				if (!found) {
					// check fourth point
					x = -1;
					y = maxY/2-1;
					found = checkPoint(input, x, y);
				}
			}
		}

		System.err.println("================================================");
		System.err.println("Found point in the circle at: " + x + " " + y);

		// find the boundaries on X
		int rightX = bsXR(input, x, maxX, y);
		if (rightX>maxX) {
			System.err.println("================================================");
			System.err.println("Couldn't find the right X! Found: " + rightX + "! EXITING!");
			return;
		}
		System.err.println("================================================");
		System.err.println("Found right X at: " + rightX);
		//System.err.println("================================================");
		
		int leftX = bsXL(input, minX, x, y);
		//System.err.println("================================================");
		System.err.println("Found left X at: " + leftX);
		//System.err.println("================================================");
		
		int middleX = (rightX + leftX)/2; 
		
		
		// find the boundaries on Y
		int topY = bsYU(input, y, maxY, x);
		//System.err.println("================================================");
		System.err.println("Found top Y at: " + topY);
		//System.err.println("================================================");
		
		int downY = bsYD(input, minY, y, x);		
		//System.err.println("================================================");
		System.err.println("Found down Y at: " + downY);
		//System.err.println("================================================");
		int middleY = (topY + downY)/2; 
		
		System.err.println("Boundaries are: " + rightX + " " + leftX + " " + topY + " " + downY);
		System.err.println("Coordinates of the CENTER most likely are: " + middleX + " " + middleY);
		System.err.println("================================================");

		System.out.println(middleX + " " + middleY);
		String answ = input.next();
		System.err.println("The answer is: " + answ);
		
		if (answ.equals("CENTER")) {
			System.err.println("Exiting from test case ");
			System.err.println("================================================");
			return;
		}
		
		System.err.println("Spinning for answer: ");
		int[] coordX = {0,1,1,1,0,-1,-1,-1};
		int[] coordY = {1,1,0,-1,-1,-1,0,1};


		for (int k=1;k<=10;k++) {
			for(int i=0;i<coordX.length;i++) {
				System.err.println("Checking: " + (middleX+coordX[i]*k) + " - " + (middleY+coordY[i]*k));
				System.out.println((middleX+coordX[i]*k) + " " + (middleY+coordY[i]*k));
				answ = input.next();
				//System.err.println("================================================");
				System.err.println("The answer is: " + answ);
				System.err.println("================================================");
				if (answ.equals("CENTER")) {
					System.err.println("Exiting from test case ");
					System.err.println("================================================");
					return;
				}
			}
		}
		System.err.println("Couldn't find the center - exiting...");
		System.err.println("================================================");
		return;
    }
	
	// End is always out of boundaries. 
	static int bsXR(Scanner input, int start, int end, int y) {
		boolean s = checkPoint(input, start, y);
		if (s && (start==minX || start==maxX)) return start;
		boolean e = false;
		int mid = (start+end)/2;
		if (s && (start==mid)) return start;
		boolean m = checkPoint(input, mid, y);
//		System.err.println("Checking RIGHT X range: " + start + " - " + end + " on " + y);
//		System.err.println("Point X start at: " + start + " is in circle? " + s + " count = " + count);
//		System.err.println("Point X mid at: " + mid + " is in circle? " + m + " count = " + count);
		if (m && (Math.abs(end-mid)==0)) return mid;
		if (s && m) return bsXR(input, mid, end, y);
		if (s && !m) return bsXR(input, start, mid-1, y);
		return Integer.MAX_VALUE;
	}

	
	// Start is always out of boundaries. 
	static int bsXL(Scanner input, int start, int end, int y) {
		boolean e = checkPoint(input, end, y);
		if (e && (end==minX || end==maxX)) return end;
		boolean s = false;
		int mid = (start+end)/2;
		if (e && (end==mid)) return end;
		boolean m = checkPoint(input, mid, y);
//		System.err.println("Checking LEFT X range: " + start + " - " + end + " on " + y);
//		System.err.println("Point X start at: " + start + " is in circle? " + s + " count = " + count);
//		System.err.println("Point X mid at: " + mid + " is in circle? " + m + " count = " + count);
		if (m && (Math.abs(end-mid)==0)) return mid;
		if (e && m) return bsXL(input, start, mid, y);
		if (e && !m) return bsXL(input, mid+1, end, y);
		return Integer.MAX_VALUE;
	}
	
	// End is always out of boundaries. 
	static int bsYU(Scanner input, int start, int end, int x) {
		boolean s = checkPoint(input, x, start);
		if (s && (start==minX || start==maxX)) return start;
		boolean e = false;
		int mid = (start+end)/2;
		if (s && (start==mid)) return start;
		boolean m = checkPoint(input, x, mid);
//		System.err.println("Checking UPPER Y range: " + start + " - " + end + " on " + x);
//		System.err.println("Point Y start at: " + start + " is in circle? " + s + " count = " + count);
//		System.err.println("Point Y mid at: " + mid + " is in circle? " + m + " count = " + count);
		if (m && (Math.abs(end-mid)==0)) return mid;
		if (s && m) return bsYU(input, mid, end, x);
		if (s && !m) return bsYU(input, start, mid-1, x);
		return Integer.MAX_VALUE;
	}

	
	// Start is always out of boundaries. 
	static int bsYD(Scanner input, int start, int end, int x) {
		boolean e = checkPoint(input, x, end);
		if (e && (end==minX || end==maxX)) return end;
		boolean s = false;
		int mid = (start+end)/2;
		if (e && (end==mid)) return end;
		boolean m = checkPoint(input, x, mid);
//		System.err.println("Checking DOWN Y range: " + start + " - " + end + " on " + x);
//		System.err.println("Point Y start at: " + start + " is in circle? " + s + " count = " + count);
//		System.err.println("Point Y mid at: " + mid + " is in circle? " + m + " count = " + count);
//		System.err.println();
		if (m && (Math.abs(end-mid)==0)) return mid;
		if (e && m) return bsYD(input, start, mid, x);
		if (e && !m) return bsYD(input, mid+1, end, x);
		return Integer.MAX_VALUE;
	}

	
	// check if X point are in the circle. Use HashMap for memmoizationto reduce the number of queries  
	static boolean checkPoint(Scanner input, int x, int y) {
		if (map.containsKey(x+"|"+y)) return map.get(x+"|"+y);
		
		String answ = ask(input, x, y);
		if (answ.equals("HIT")) {
			map.put(x+"|"+y, true);
			return true;
		}
		else {			
			map.put(x+"|"+y, false);
			return false;
		}
	}

	private static String ask(Scanner input, int x, int Y) {
		count++;
		System.out.println(x + " " + Y);
		String answ = input.next();
		return answ;
	}
	
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.err.println("Welcome to the Solution! Please provide an initial input");
//         try {
// 			input = new Scanner(new FileInputStream(new File("C:\\Users\\i855719\\git\\kickstart\\KickStart\\CodeJam2020\\Round1B\\problem2\\input.txt")));
// 		} catch (FileNotFoundException e) {
// 			// TODO Auto-generated catch block
// 			e.printStackTrace();
// 		}
        // number of cases
        int T = input.nextInt();
        int minR  = input.nextInt();
        int maxR  = input.nextInt();
        
        // for every case - execute the solution
        for (int ks = 1; ks <= T; ks++) {
            solve(input, ks, minR, maxR);
        }
        input.close();
    }
}
