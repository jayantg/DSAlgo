package com.graph;

import java.util.*;

public class Graph {

    private ArrayList<Node> edges;
    private int vertexCount;
    private Map<Character, Integer> vertices;

    public static Graph getGraph(){
        Graph graph = new Graph();
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('F');
        graph.addVertex('G');
        graph.addVertex('H');
        return graph;
    }

    public static void addEdges(Graph graph){
        graph.addEdge('A','B');
        graph.addEdge('B','C');
        graph.addEdge('C','D');
        graph.addEdge('B','H');
        graph.addEdge('C','E');
        graph.addEdge('E','F');
        graph.addEdge('E','G');
    }

    public static void addDirectedEdges(Graph graph){
        graph.addDirectedEdge('A','B');
        graph.addDirectedEdge('B','C');
        graph.addDirectedEdge('C','D');
        graph.addDirectedEdge('B','H');
        graph.addDirectedEdge('C','E');
        graph.addDirectedEdge('E','F');
        graph.addDirectedEdge('E','G');
    }

    public Graph() {
        this.vertexCount = 0;
        this.edges = new ArrayList<>();
        this.vertices = new HashMap<>();
    }

    public Graph(char[] vertices) {
        this.vertexCount = vertices.length;
        this.vertices = new HashMap<>();
        this.edges = new ArrayList<>();
        for (int i = 0; i < vertexCount; i++) {
            edges.add(i, new Node(vertices[i]));
            this.vertices.put(vertices[i], i);
        }
    }

    public void addVertex(char c){
        edges.add(vertexCount, new Node(c));
        vertices.put(c,vertexCount);
        vertexCount = vertexCount + 1;
    }

    public void addEdge(char a, char b){
        insertAtEnd(vertices.get(a), b, 0);
        insertAtEnd(vertices.get(b), a, 0);
    }

    public void addDirectedEdge(char a, char b){
        insertAtEnd(vertices.get(a), b, 0);
    }

    public void addDirectedEdge(char a, char b, int w){
        insertAtEnd(vertices.get(a), b, w);
    }

    private void insertAtEnd(Integer i, char c, int w) {
        Node node = edges.get(i);
        while (node.getNext() != null){
            node = node.getNext();
        }
        node.setNext(new Node(c, w));
    }

    public void DFS() {
        Stack<Character> stack = new Stack<>();
        boolean[] visited = new boolean[vertexCount];
        stack.push(edges.get(0).getData());
        while (!stack.isEmpty()){
            Character current = stack.peek();
            if(visited[vertices.get(current)] == false){
                System.out.print(current + " ");
                visited[vertices.get(current)] = true;
            }
            Character unvisited = getUnvisitedNode(visited, current);
            if (unvisited == null) {
                stack.pop();
            }else {
                stack.push(unvisited);
            }
        }
    }

    public void BFS(){
        Queue<Character> queue = new LinkedList<>();
        boolean[] visited = new boolean[vertexCount];
        queue.offer(edges.get(0).getData());
        System.out.print(edges.get(0).getData() + " ");
        visited[0] = true;

        while (!queue.isEmpty()){
            Character current = queue.poll();
            Character unvisited = getUnvisitedNode(visited, current);
            while (unvisited != null){
                System.out.print(unvisited + " ");
                visited[vertices.get(unvisited)] = true;
                queue.offer(unvisited);
                unvisited = getUnvisitedNode(visited, current);
            }
        }
    }

    private Character getUnvisitedNode(boolean[] visited, Character character) {
        Node node = edges.get(vertices.get(character));
        while (node != null){
            if(visited[vertices.get(node.getData())] == false){
                return node.getData();
            }
            node=node.getNext();
        }
        return null;
    }

    public ArrayList<Node> getEdges() {
        return edges;
    }

    public int getVertexCount() {
        return vertexCount;
    }

    public Map<Character, Integer> getVertices() {
        return vertices;
    }
}
