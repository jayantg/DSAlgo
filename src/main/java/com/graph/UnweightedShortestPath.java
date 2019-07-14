package com.graph;

import java.util.LinkedList;
import java.util.Queue;

public class UnweightedShortestPath {

    public static void main(String[] args) {
        char[] arr = {'a','b','c','d','e','f','g'};
        Graph graph = new Graph(arr);
        graph.addDirectedEdge('a', 'b');
        graph.addDirectedEdge('a', 'd');
        graph.addDirectedEdge('b', 'e');
        graph.addDirectedEdge('b', 'd');
        graph.addDirectedEdge('c', 'a');
        graph.addDirectedEdge('c', 'f');
        graph.addDirectedEdge('d', 'f');
        graph.addDirectedEdge('d', 'g');
        graph.addDirectedEdge('e', 'g');
        graph.addDirectedEdge('g', 'f');

        unweightedShortestPath(graph,0);
    }

    private static void unweightedShortestPath(Graph graph, int source) {
        Integer[] distance =  new Integer[graph.getVertexCount()];
        Character[] path = new Character[graph.getVertexCount()];
        Queue<Integer> queue = new LinkedList<>();

        distance[source] = 0;
        queue.offer(source);

        while (!queue.isEmpty()) {
            Integer v = queue.poll();
            Node node = graph.getEdges().get(v);
            Node current = node.getNext();
            while (current != null){
                Integer c = graph.getVertices().get(current.getData());
                if(distance[c] == null || (distance[c]>distance[v]+1)){
                    distance[c] = distance[v] + 1;
                    path[c] = node.getData();
                    queue.offer(c);
                }
                current = current.getNext();
            }
        }

        for (int i = 0; i < distance.length; i++) {
            System.out.println("Distance of " + graph.getEdges().get(i).getData() +
                    " from source " + graph.getEdges().get(source).getData() + " is " +  distance[i]);
        }
    }
}
