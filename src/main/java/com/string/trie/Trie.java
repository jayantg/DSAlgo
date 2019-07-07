package com.string.trie;

/**
 * 
 * @author jayantg
 *
 */
public class Trie {

	private TrieNode root;
	
	Trie(){
		root = new TrieNode();
	}
	
	/**
	 * Non recursive insert
	 * @param word
	 */
	public void insert(String word) {
		TrieNode current = root;
		for(int i=0; i<word.length(); i++) {
			Character c = word.charAt(i);
			if(current.getChildren().get(c) == null) {
				current.getChildren().put(c, new TrieNode());
			}
			current = current.getChildren().get(c);
		}
		current.setLast(true);
	}
	
	/**
	 * Search recursive
	 * @param s
	 * @return
	 */
	public boolean search(String word) {
		TrieNode current = root;
		int i=0;
		for(; i<word.length(); i++) {
			Character c = word.charAt(i);
			if(current.getChildren().get(c) == null) {
				return false;
			}
			current = current.getChildren().get(c);
		}
		return i == word.length() ? current.isLast() : false;
	}
	
	/**
	 * 
	 * @param word
	 */
	public void delete(String word) {
		delete(root, word,0);
	}
	
	/**
	 * 
	 * @param current
	 * @param word
	 * @param index
	 * @return
	 */
	private boolean delete(TrieNode current, String word, int index) {
		Character c = word.charAt(index);
		TrieNode node = current.getChildren().get(c);

		//False condition
		if(node == null) {
			return false;
		}else if(word.length() == index + 1 && !node.isLast()) {
			return false;
		}
		//End condition
		if(word.length() == index + 1) {
			node.setLast(false);
		}else {
			delete(node, word, index + 1);
		}
		//Remove if node isn't last and don't have any children 
		if(node.getChildren().isEmpty() && !node.isLast()) {
			current.getChildren().remove(c);
		}
		return true;
	}
	
	
	/**
	 * Test method
	 * @param args
	 */
	public static void main(String[] args) {
		Trie t = new Trie();
		t.insert("abc");
		t.insert("abcd");

		System.out.println(t.search("ab")); // false 
		System.out.println(t.search("abc")); // true
		System.out.println(t.search("abcd")); // true
		t.delete("abc");
		System.out.println(t.search("ab")); // false
		System.out.println(t.search("abc")); // false
		System.out.println(t.search("abcd")); // true

	}
}
