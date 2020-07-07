package org.example.model;

import java.util.ArrayList;

public class Node {
    public int val;
    public boolean visited = false;
    public ArrayList<Integer> vertics;

    public Node(int val, ArrayList<Integer> vertics) {
        this.val = val;
        this.vertics = vertics;
    }
}
