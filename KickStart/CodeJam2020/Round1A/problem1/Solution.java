package Round1A.problem1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

// submitted and accepted for all three tests. 
public class Solution {
    public static void solve(Scanner input, int caseNum, int n, String[] words, int maxLen) {
    	String longestPrefix = null;
    	String longestSuffix = null;
    	String middle = "";
    	
    	for (int i=0;i<words.length;i++) {
    		String str = words[i];
    		char[] chars = str.toCharArray();
    		int first = getFirst(chars);
    		int last = getLast(chars);
    		
    		String prefix = str.substring(0, first-1);
    		char[] prefixCh = prefix.toCharArray();
    		String suffix = str.substring(last, str.length());
    		char[] suffixCh = suffix.toCharArray();
    		
    		int end = -1;
    		if (longestPrefix!=null) {
    			end = longestPrefix.length() < prefix.length() ? longestPrefix.length() : prefix.length();
    		} else {
    			longestPrefix = prefix;
    			end = prefix.length();
    		}
    		
    		char[] longestPrefixCh = longestPrefix.toCharArray();
    		for (int ind=0;ind<end;ind++) {
    			if (longestPrefixCh[ind] != prefixCh[ind]) {
    				// Prefixes have different symbols -> no solution.
    				System.out.println("Case #" + caseNum + ": *");
    				return;
    			}
    		}
    		// update the longest prefix
    		if (longestPrefix.length() < prefix.length()) {
    			longestPrefix = prefix;
    			longestPrefixCh = longestPrefix.toCharArray();
    		}
    	
    		if (longestSuffix != null) {
    			end = longestSuffix.length() < suffix.length() ? longestSuffix.length() : suffix.length();
    		} else {
    			longestSuffix = suffix;
    			end = suffix.length();
    		}
    		
    		char[] longestSuffixCh = longestSuffix.toCharArray();
    		for (int ind=0;ind<end;ind++) {
    			if (longestSuffixCh[longestSuffix.length() - ind-1] != suffixCh[suffix.length() - ind-1]) {
    				// Suffixes have different symbols -> no solution.
    				System.out.println("Case #" + caseNum + ": *");
    				return;
    			}
    		}
    		// update the longest suffix
    		if (longestSuffix.length() < suffix.length()) {
    			longestSuffix = suffix;
    			longestSuffixCh = longestSuffix.toCharArray();
    		}
    		middle += getMiddle(str, first, last);
    	}
    	System.out.println("Case #" + caseNum + ": " + longestPrefix + middle + longestSuffix);
    }

    static String getMiddle(String word, int start, int end) {
    	StringBuilder sb = new StringBuilder();
    	for (char ch : word.substring(start, end).toCharArray()) {
    		if (ch != '*') sb.append(ch);
    	}
    	return sb.toString();
    }
    
    
    
    static int getFirst(char[] arr) {
    	for (int i=0;i<arr.length;i++) {
    		if (arr[i]=='*') return i+1;
    	}
    	return -1;
    }

    static int getLast(char[] arr) {
    	for (int i=arr.length-1;i>=0;i--) {
    		if (arr[i]=='*') return i+1;
    	}
    	return -1;
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
         try {
 			input = new Scanner(new FileInputStream(new File("C:\\Users\\i855719\\git\\kickstart\\KickStart\\CodeJam2020\\RoundA\\problem1\\input.txt")));
 		} catch (FileNotFoundException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
        // number of cases
        int T = input.nextInt();
        int maxLen = 0;
        // for every case - execute the solution
        for (int ks = 1; ks <= T; ks++) {
        	int N = input.nextInt();
        	String[] words = new String[N];
        	for (int i=0;i<N;i++) {
        		words[i] = input.next();
        		if (words[i].length() > maxLen) maxLen = words[i].length();
        	}
            solve(input, ks, N, words, maxLen);
        }
        input.close();
    }
}
