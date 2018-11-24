package com.greedy.huffmancoding;

public class BSTNode implements Comparable<BSTNode>{
	
	private int frequency;
	private Character data;
	private BSTNode left;
	private BSTNode right;
	
	public BSTNode(){}
	
	public BSTNode(Character data, int frequency) {
		this.frequency = frequency;
		this.data = data;
	}
	
	public int getFrequency() {
		return frequency;
	}
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	public Character getData() {
		return data;
	}
	public void setData(Character data) {
		this.data = data;
	}
	public BSTNode getLeft() {
		return left;
	}
	public void setLeft(BSTNode left) {
		this.left = left;
	}
	public BSTNode getRight() {
		return right;
	}
	public void setRight(BSTNode right) {
		this.right = right;
	}
	
	@Override
	public int compareTo(BSTNode o) {
		return this.frequency - o.frequency;
	}
}
