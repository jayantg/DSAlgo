package com.graph;

public class GraphTraversal {
    public static void main(String[] args) {
        char[] arr = {'A','B','C','D','E','F','G','H'};
        Graph graph1 = new Graph(arr);
        Graph.addEdges(graph1);
        System.out.println("DFS of char graph.");
        graph1.DFS();
        System.out.println("\nBFS of char graph");
        graph1.BFS();
        Graph graph2 = Graph.getGraph();
        Graph.addEdges(graph2);
        System.out.println("\nDFS of default graph");
        graph2.DFS();
        System.out.println("\nBFS of default graph");
        graph2.BFS();

        Graph graph3 = Graph.getGraph();
        Graph.addDirectedEdges(graph3);
        System.out.println("\nDFS of directed graph");
        graph3.DFS();
        System.out.println("\nBFS of directed graph");
        graph3.BFS();
    }
}
