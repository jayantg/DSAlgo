package com.graph;

import java.util.LinkedList;
import java.util.Queue;

public class BellmanFord {
    public static void main(String[] args) {
        char[] chars = {'A', 'B', 'C', 'D', 'E'};
        Graph graph = new Graph(chars);
        graph.addDirectedEdge('A', 'B', 4);
        graph.addDirectedEdge('A', 'C', 1);
        graph.addDirectedEdge('B', 'E', 4);
        graph.addDirectedEdge('C', 'B', 2);
        graph.addDirectedEdge('C', 'D', 4);
        graph.addDirectedEdge('D', 'E', 4);
        bellmanFord(graph, 0);
    }

    private static void bellmanFord(Graph graph, int source) {
        Integer[] distance = new Integer[graph.getVertexCount()];
        Character[] path = new Character[graph.getVertexCount()];
        distance[source] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()){
            Integer v = queue.poll();
            Node node = graph.getEdges().get(v);
            Node current = node.getNext();
            while (current != null){
                int c = graph.getVertices().get(current.getData());
                if(distance[c] == null || (distance[c] > (distance[v] + current.getWeight()))){
                    distance[c] = distance[v] + current.getWeight();
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
