package org.example.model;

import java.util.*;

public class Graph {
    private Map<Integer, List<Integer>> adjVertices;

    public Graph() {
        this.adjVertices = new HashMap<Integer, List<Integer>>();
    }

    public void addVertex(int vertex) {
        adjVertices.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(int src, int dest) {
        adjVertices.get(src).add(dest);
    }


    public Map<Integer, List<Integer>> getAdjVertices() {
        return adjVertices;
    }
}
