package com.graph;

import com.set.DisjointSet;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Kruskal {
    public static void main(String[] args) {
        char[] chars = {'A','B','C','D','E','F','G'};
        Graph graph = new Graph(chars);
        graph.addDirectedEdge('A','C', 7);
        graph.addDirectedEdge('A','D', 5);
        graph.addDirectedEdge('B','C', 8);
        graph.addDirectedEdge('B','E', 5);
        graph.addDirectedEdge('C','D', 9);
        graph.addDirectedEdge('C','E', 7);
        graph.addDirectedEdge('D','E', 15);
        graph.addDirectedEdge('D','F', 6);
        graph.addDirectedEdge('E','F', 8);
        graph.addDirectedEdge('E','G', 9);
        graph.addDirectedEdge('G','F', 11);

        PriorityQueue<Edge> queue = new PriorityQueue<>();

        for (int i = 0; i < graph.getVertexCount(); i++) {
            Node node = graph.getEdges().get(i);
            Node current = node.getNext();
            while (current != null){
                queue.add(new Edge(current.getWeight(), node.getData(), current.getData()));
                current = current.getNext();
            }
        }
        DisjointSet<Character> disjointSet = new DisjointSet<>();
        for (int i = 0; i < graph.getVertexCount(); i++) {
            disjointSet.makeSet(graph.getEdges().get(i).getData());
        }

        int resultWeight = 0;
        List<Edge> result = new ArrayList<>();
        while (!queue.isEmpty()){
            Edge edge = queue.poll();
            if(disjointSet.findSet(edge.getSource()) != disjointSet.findSet(edge.getDestination())){
                disjointSet.union(edge.getSource(),edge.getDestination());
                resultWeight = resultWeight + edge.getWeight();
                result.add(edge);
            }
        }

        System.out.println(resultWeight);
        result.forEach(System.out::println);
    }
}


class Edge implements Comparable<Edge>{

    private int weight;
    private char source;
    private char destination;

    public Edge(int weight, char source, char destination) {
        this.weight = weight;
        this.source = source;
        this.destination = destination;
    }

    public int getWeight() {
        return weight;
    }

    public char getSource() {
        return source;
    }

    public char getDestination() {
        return destination;
    }

    @Override
    public int compareTo(Edge edge) {
        return weight - edge.getWeight();
    }

    @Override
    public String toString() {
        return "Edge{" +
                "weight=" + weight +
                ", source=" + source +
                ", destination=" + destination +
                '}';
    }
}