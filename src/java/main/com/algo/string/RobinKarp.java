package com.algo.string;

/**
 * 
 * @author jayantg
 *
 */
public class RobinKarp {

	static int num = 10;
	
	public static void main(String[] args) {
		char[] pattern = "abc".toCharArray();
		char[] text = "dabc".toCharArray();
		System.out.println("Pattern start position in text = " + patternSearch(pattern, text));
	}

	private static int patternSearch(char[] pattern, char[] text) {
		int phash = createHash(0, pattern.length, pattern);
		int hash = createHash(0, pattern.length, text);
		for(int i =1; i<= text.length - pattern.length + 1 ; i++) {
			if(hash == phash && checkEqual(pattern, text, i-1)) {
				return i-1;
			}
			//Rolling hash calculation
			hash = hash - text[i-1]; // Subtract outgoing char
			hash = hash / num;		//  Right shift char
			//Adding new char in hash
			hash = (int) (hash + (text[i + pattern.length -1] * Math.pow(num, pattern.length -1)));
		}
		return -1;
	}

	private static boolean checkEqual(char[] pattern, char[] text, int start) {
		int j = 0;
		for(int i = start; j< pattern.length ; i++,j++) {
			if(text[i] != pattern[j]){
				return false;
			}
		}
		return true;
	}

	private static int createHash(int start, int length, char[] text) {
		int hash = 0;
		for(int i=start; i<length; i++) {
			hash = (int) (hash + text[i] * Math.pow(num, i));
		}
		return hash;
	}
}
