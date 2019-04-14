package com.string.suffixtree;

public class Active {
	Active(SuffixNode node){
        activeLength = 0;
        activeNode = node;
        activeEdge = -1;
    }
    
    @Override
    public String toString() {
        
        return "Active [activeNode=" + activeNode + ", activeIndex="
                + activeEdge + ", activeLength=" + activeLength + "]";
    }

    SuffixNode activeNode;
    int activeEdge;
    int activeLength;
}
