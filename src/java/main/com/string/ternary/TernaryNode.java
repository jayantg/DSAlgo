package com.string.ternary;

/**
 * 
 * @author jayantg
 *
 */
public class TernaryNode {

	private char c;
	private boolean isLast;
	private TernaryNode equal;
	private TernaryNode left;
	private TernaryNode right;

	public char getChar() {
		return c;
	}

	public void setChar(char c) {
		this.c = c;
	}

	public TernaryNode getEqual() {
		return equal;
	}

	public void setEqual(TernaryNode equal) {
		this.equal = equal;
	}

	public TernaryNode getLeft() {
		return left;
	}

	public void setLeft(TernaryNode left) {
		this.left = left;
	}

	public TernaryNode getRight() {
		return right;
	}

	public void setRight(TernaryNode right) {
		this.right = right;
	}

	public boolean isLast() {
		return isLast;
	}

	public void setLast(boolean isLast) {
		this.isLast = isLast;
	}
	
}
