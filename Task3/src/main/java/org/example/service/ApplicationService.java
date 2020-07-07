package org.example.service;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.example.model.Graph;

import java.io.File;
import java.io.IOException;

public class ApplicationService {
    public static int graphs = 0;
    static boolean[] isVisited = null;

    public static void dfs(Graph g, int v) {
        isVisited[v] = true;
        if (g.getAdjVertices().get(v) != null) {
            for (int dest : g.getAdjVertices().get(v)) {
                if (!isVisited[dest])
                    dfs(g, dest);
            }
        }
    }

    public void countGraph(Graph graph) {
        isVisited = new boolean[1000];
        for (int i = 0; i <= graph.getAdjVertices().keySet().size(); i++) {
            isVisited[i] = false;
        }
        for (int vertex : graph.getAdjVertices().keySet()) {
            if (graph.getAdjVertices().get(vertex) != null) {
                if (!isVisited[vertex]) {
                    dfs(graph, vertex);
                    graphs++;
                }
            }
        }
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
                    graph.addVertex(Integer.parseInt(r[0]));
                    graph.addVertex(Integer.parseInt(r[1]));
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
