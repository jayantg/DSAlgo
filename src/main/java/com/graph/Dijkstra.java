package com.graph;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Dijkstra {
    public static void main(String[] args) {
        char[] chars = {'A', 'B', 'C', 'D', 'E'};
        Graph graph = new Graph(chars);
        graph.addDirectedEdge('A', 'B', 4);
        graph.addDirectedEdge('A', 'C', 1);
        graph.addDirectedEdge('B', 'E', 4);
        graph.addDirectedEdge('C', 'B', 2);
        graph.addDirectedEdge('C', 'D', 4);
        graph.addDirectedEdge('D', 'E', 4);

        Integer[] distance = new Integer[graph.getVertexCount()];
        Character[] path = new Character[graph.getVertexCount()];
        Map<Integer, DijkstraNode> map = new HashMap<>();
        PriorityQueue<DijkstraNode> queue = new PriorityQueue();
        DijkstraNode source = new DijkstraNode(0,0);
        queue.offer(source);
        map.put(0,source);
        distance[0] = 0;
        while (!queue.isEmpty()){
            DijkstraNode node = queue.poll();
            Node vertex = graph.getEdges().get(node.getIndex());
            Node current = vertex.getNext();
            while (current!=null){
                int c = graph.getVertices().get(current.getData());
                int sourceDistance = distance[node.getIndex()] + current.getWeight();
                if(distance[c] == null){
                    distance[c] = sourceDistance;
                    DijkstraNode dijkstraNode = new DijkstraNode(c, sourceDistance);
                    map.put(c, dijkstraNode);
                    queue.offer(dijkstraNode);
                    path[c] = vertex.getData();
                }else if(distance[c]>sourceDistance){
                    distance[c] = sourceDistance;
                    DijkstraNode dijkstraNode = map.get(c);
                    dijkstraNode.setDistance(sourceDistance);
                    path[c] = vertex.getData();
                }
                current = current.getNext();
            }
        }
        for (int i = 0; i < distance.length; i++) {
            System.out.println("Distance of " + graph.getEdges().get(i).getData() +
                    " from source " + graph.getEdges().get(0).getData() + " is " +  distance[i]);
        }
    }
}

class DijkstraNode implements Comparable<DijkstraNode>{
    private int index;
    private int distance;

    public DijkstraNode(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return index;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public int compareTo(DijkstraNode node) {
        return distance - node.getDistance();
    }
}