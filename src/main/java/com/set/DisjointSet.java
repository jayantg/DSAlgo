package com.set;

import java.util.HashMap;
import java.util.Map;

public class DisjointSet {

    private Map<Integer, Node> map;

    public DisjointSet() {
        this.map = new HashMap<>();
    }

    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet();

        ds.makeSet(1);
        ds.makeSet(2);
        ds.makeSet(3);
        ds.makeSet(4);
        ds.makeSet(5);
        ds.makeSet(6);
        ds.makeSet(7);

        ds.union(1,2);
        ds.union(2,3);
        ds.union(4,5);
        ds.union(6,7);
        ds.union(5,6);
        ds.union(3,7);

        System.out.println(ds.findSet(1).getData());
        System.out.println(ds.findSet(2).getData());
        System.out.println(ds.findSet(3).getData());
        System.out.println(ds.findSet(4).getData());
        System.out.println(ds.findSet(5).getData());
        System.out.println(ds.findSet(6).getData());
        System.out.println(ds.findSet(7).getData());
    }

    private Node findSet(int data) {
        Node node = map.get(data);
        return findSet(node);
    }

    private Node findSet(Node node) {
        Node parent = node.getParent();
        if(parent == node){
            return parent;
        }
        //Optimization by setting each node to same parent
        //It is called path compression
        node.setParent(findSet(node.getParent()));
        return node.getParent();
    }

    private void union(int a, int b) {

        Node nodeA = findSet(a);
        Node nodeB = findSet(b);

        Node parentA = findSet(nodeA);
        Node parentB = findSet(nodeB);

        if(parentA.getData() == parentB.getData()){
            return;
        }

        if(parentA.getRank() > parentB.getRank()){
            parentB.setParent(parentA);
        }else if(parentA.getRank() < parentB.getRank()){
            parentA.setParent(parentB);
        }else {
            // If rank are same, choose any one as parent and increase it's rank by 1
            int rank = parentA.getRank() + 1;
            parentB.setParent(parentA);
            parentA.setRank(rank);
        }
    }

    private void makeSet(int data) {
        Node node = new Node(data);
        node.setParent(node);
        node.setRank(0);
        map.put(data, node);
    }
}
