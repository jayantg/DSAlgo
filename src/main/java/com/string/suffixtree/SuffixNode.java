package com.string.suffixtree;

public class SuffixNode {
	private SuffixNode(){
    }
    
    private static final int TOTAL = 256;
    SuffixNode[] child = new SuffixNode[TOTAL];
    
    int start;
    End end;
    int index;
    
    SuffixNode suffixLink;
    
    public static SuffixNode createNode(int start, End end){
        SuffixNode node = new SuffixNode();
        node.start = start;
        node.end = end;
        return node;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        int i=0;
        for(SuffixNode node : child){
            if(node != null){
                buffer.append((char)i + " ");
            }
            i++;
        }
        return "SuffixNode [start=" + start + "]" + " " + buffer.toString();
    }
}
