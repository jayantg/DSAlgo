package com.string;

/**
 * 
 * @author jayantg
 * Time complexity = O(n + m)
 * Space complexity = O(m)
 */
public class KMP {

	public static void main(String[] args) {
		char[] pattern =    "ababaca".toCharArray();
		char[] text = "bacbabababacaca".toCharArray();
		System.out.println("Pattern start position in text = " + patternSearch(pattern, text));
	}
	
	private static int patternSearch(char[] pattern, char[] text) {
		int[] table = prefixTable(pattern);
		int i=0,j=0;
		while(i<text.length) {
			if(text[i] == pattern[j]) {
				//last char of pattern
				if(j == pattern.length -1) {
					return i-j;
				}
				j++;
				i++;
			}
			else if(j>0) {
				j = table[j-1];
			}else {
				i++;
			}
		}
		return -1;
	}
	
	/**
	 * | |0|1|2|3|4|5|6
	 * |P|a|b|a|b|a|c|a
	 * |T|0|0|1|2|3|0|1
	 * 
	 * @param pattern
	 * @return
	 */
	private static int[] prefixTable(char[] pattern) {
		int[] prefixTable = new int[pattern.length];
		int j=0, i=1;
		prefixTable[0] = 0;
		while(i<pattern.length) {
			if(pattern[j] == pattern[i]) {
				prefixTable[i] = j+1;
				j++;
				i++;
			}else {
				if(j>0) {
					j= prefixTable[j-1];
				}else {
					prefixTable[i] = 0;
					i++;
				}
			}
		}
		return prefixTable;
	}
}
