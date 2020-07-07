package org.example.model;

import java.util.*;

public class Graph {
    public ArrayList<Node> nodeArray = new ArrayList<Node>();

    public void addEdge(int src, int dest) {
        Optional<Node> srcNode = nodeArray.stream().filter(x -> x.val == src).findFirst();
        srcNode.ifPresent(node -> node.vertics.add(dest));
        if (!srcNode.isPresent()) {
            nodeArray.add(new Node(src, new ArrayList<>(Arrays.asList(dest))));
        }
        Optional<Node> destNode = nodeArray.stream().filter(x -> x.val == dest).findFirst();
        destNode.ifPresent(node -> node.vertics.add(src));
        if (!destNode.isPresent()) {
            nodeArray.add(new Node(dest, new ArrayList<>(Arrays.asList(src))));
        }
    }
}
