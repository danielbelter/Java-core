package org.example.service;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.example.model.Graph;
import org.example.model.Node;

import java.io.File;
import java.io.IOException;

public class ApplicationService {
    public static Graph graph = null;

    void DFSUtil(int idx) {
        Node n = graph.nodeArray.get(idx);
        n.visited = true;
        for (int x : n.vertics) {
            int index = graph.nodeArray.indexOf(graph.nodeArray.stream().filter(a -> a.val == x).findFirst().get());
            if (!graph.nodeArray.get(index).visited) {
                DFSUtil(index);
            }
        }
    }
    
    public void countGraph(Graph graph) {
        ApplicationService.graph = graph;
        int graphs = 0;
        for (int v = 0; v < graph.nodeArray.size(); ++v) {
            if (!graph.nodeArray.get(v).visited) {
                DFSUtil(v);
                graphs++;
            }
        }
        System.out.println(graphs);
    }

    public Graph readFile(String filePath) throws IOException {
        LineIterator it = null;
        Graph graph = new Graph();
        try {
            it = FileUtils.lineIterator(new File(filePath), "UTF-8");
            while (it.hasNext()) {
                String line = it.nextLine();
                String[] r = line.split(" ");
                if (r.length == 2) {
                    graph.addEdge(Integer.parseInt(r[0]), Integer.parseInt(r[1]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            it.close();
        }
        return graph;
    }
}
