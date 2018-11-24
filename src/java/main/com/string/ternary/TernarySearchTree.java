package com.string.ternary;

/**
 * 
 * @author jayantg
 *
 */
public class TernarySearchTree {

	private TernaryNode root;
	
	/**
	 * 
	 * @param word
	 */
	public void insert(String word) {
		if(!word.isEmpty()) {
			root = insert(word, root, 0);
		}
	}
	
	private TernaryNode insert(String word, TernaryNode current, int index) {
		if(current == null) {
			current = new TernaryNode();
			current.setChar(word.charAt(index));
		}
		
		char c = word.charAt(index);
		
		if(current.getChar() == c) {
			//End condition
			if(index == word.length() -1) {
				current.setLast(true);
				return current;
			}
			current.setEqual(insert(word, current.getEqual(), index + 1));
		}else if(current.getEqual().getChar() > c) {
			current.setLeft((insert(word, current.getLeft(), index)));
		}else {
			current.setRight((insert(word, current.getRight(), index)));
		}
		
		return current;
	}
	
	/**
	 * 
	 * @param word
	 * @return
	 */
	public boolean search(String word) {
		return search(word,root,0);
	}

	private boolean search(String word, TernaryNode current, int index) {
		
		// Error condition
		if(word.isEmpty() || current == null || index >= word.length()) {
			return false;
		}
		
		char c = word.charAt(index);
		if(c == current.getChar()) {
			//End condition
			if(index == word.length() -1 ) {
				return current.isLast();
			}
			return search(word, current.getEqual(), index+1);
		}else if(c > current.getChar()) {
			return search(word, current.getRight(), index);
		}else {
			return search(word, current.getLeft(), index);
		}
	}
	
	/**
	 * Test method
	 * @param args
	 */
	public static void main(String[] args) {
		TernarySearchTree tt = new TernarySearchTree();
		tt.insert("abd");
		tt.insert("ab");
		tt.insert("ad");
		System.out.println(tt.search("abc"));   //false
		System.out.println(tt.search("ab"));	//true
		System.out.println(tt.search("abd"));	//true
		System.out.println(tt.search("ad"));	//true
	}
}
