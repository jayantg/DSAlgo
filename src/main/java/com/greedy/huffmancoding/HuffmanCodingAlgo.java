package com.greedy.huffmancoding;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class HuffmanCodingAlgo {

	private BSTNode root;
	
	/**
	 * @param input
	 */
	public void createTree(String input) {
		//Create frequency map of each character from input
		Map<Character, Integer> map = getFrequencyMap(input);
		//Put each character from input into heap
		Queue<BSTNode> pq = initializeHeap(map);
		BSTNode temp = null;
		for(int i=1;i<map.size();i++) {
			temp = new BSTNode();
			//Take two minimum node to build a new node
			temp.setLeft(pq.poll());
			temp.setRight(pq.poll());
			//Set frequency of new node as sum of children
			temp.setFrequency(temp.getLeft().getFrequency() + temp.getRight().getFrequency());
			pq.add(temp);
		}
		//Last node will be root
		root = temp;
	}
	
	/**
	 * Create frequency map of each character from input
	 * @param input
	 * @return
	 */
	private Map<Character, Integer> getFrequencyMap(String input) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i=0;i<input.length();i++) {
			int count = map.getOrDefault(input.charAt(i), 0) + 1;
			map.put(input.charAt(i), count);
		}
		return map;
	}
	
	/**
	 * Put each character from input into heap
	 * @param map
	 * @return
	 */
	private Queue<BSTNode> initializeHeap(Map<Character, Integer> map) {
		Queue<BSTNode> pq = new PriorityQueue<>();
		map.forEach((data, frequency) -> pq.add(new BSTNode(data, frequency)));
		return pq;
	}

	/**
	 * 
	 * @param c
	 * @return Huffman code of the character. f is character don't exist
	 */
	public String getCode(char c) {
		return getCode(c,root);
	}

	/**
	 * Recursive function to calculate code 
	 * @param c
	 * @param current
	 * @return
	 */
	private String getCode(char c, BSTNode current) {
		if(current != null) {
			if(current.getData() != null && current.getData() == c) {
				return "";
			}
			String temp = getCode(c, current.getLeft());
			if(temp != "f") {
				return "0" + temp; // Add 0 for left traversal
			}
			
			temp = getCode(c, current.getRight());
			if(temp != "f") {
				return "1" + temp; // Add 1 for right traversal
			}		
		}
		return "f";
	}
	
	/**
	 *  a	->	011
	 *	b	->	10
	 *	c	->	11
	 *  d	->	00
	 *	e	->	010
	 * @param args
	 */
	public static void main(String[] args) {
		String input = "aaabbbbbccccccddddee";
		HuffmanCodingAlgo algo = new HuffmanCodingAlgo();
		algo.createTree(input);
		System.out.println("a\t->\t" + algo.getCode('a'));
		System.out.println("b\t->\t" + algo.getCode('b'));
		System.out.println("c\t->\t" + algo.getCode('c'));
		System.out.println("d\t->\t" + algo.getCode('d'));
		System.out.println("e\t->\t" + algo.getCode('e'));
		System.out.println("g\t->\t" + algo.getCode('g'));


	}
}
