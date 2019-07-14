package com.graph;

import java.util.Stack;

/**
 * 1. Graph can't be cyclic
 * 2. Graph should be directed
 * 3. If graph satisfied above two condition, it is called DAG (Directed acyclic graph)
 * 4. Each node comes before all nodes to which it has outgoing edges.
 */
public class TopologicalSort {

    private Graph graph;
    private boolean[] visited;
    private Stack<Character> stack;

    public TopologicalSort(Graph graph) {
        this.graph = graph;
        this.visited = new boolean[graph.getVertexCount()];
        this.stack = new Stack<>();
    }

    public static void main(String[] args) {
        Graph graph = Graph.getGraph();
        Graph.addDirectedEdges(graph);
        TopologicalSort ts = new TopologicalSort(graph);

        for (int i = 0; i < graph.getVertexCount(); i++) {
            if(ts.visited[i] == true){
                continue;
            }
            ts.sort(i);
        }
        System.out.println("Topological Sort");
        while (!ts.stack.isEmpty()){
            System.out.print(ts.stack.pop() + " ");
        }
    }

    private void sort(int i) {
        visited[i] = true;
        Node v = getUnvisitedNode(i);
        while (v!=null){
            sort(graph.getVertices().get(v.getData()));
            v = getUnvisitedNode(i);
        }
        stack.push(graph.getEdges().get(i).getData());
    }

    private Node getUnvisitedNode(int i) {
        Node node = graph.getEdges().get(i);
        while (node != null){
            if (visited[graph.getVertices().get(node.getData())] == false){
                return node;
            }
            node = node.getNext();
        }
        return null;
    }
}
