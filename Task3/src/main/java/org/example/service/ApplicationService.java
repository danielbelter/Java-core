package org.example.service;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.jgrapht.Graph;
import org.jgrapht.alg.connectivity.ConnectivityInspector;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;

import java.io.File;
import java.io.IOException;

public class ApplicationService {


    public void countGraph(Graph<String, DefaultEdge> graph) {
        ConnectivityInspector<String, DefaultEdge> inspector = new ConnectivityInspector(graph);
        System.out.println(inspector.connectedSets().stream().count());
    }

    public Graph<String, DefaultEdge> readFile(String filePath) throws IOException {
        LineIterator it = null;
        Graph<String, DefaultEdge> graph = new DefaultDirectedGraph<String, DefaultEdge>(DefaultEdge.class);
        try {
            it = FileUtils.lineIterator(new File(filePath), "UTF-8");
            while (it.hasNext()) {
                String line = it.nextLine();
                String[] r = line.split(" ");
                if (r.length == 2) {
                    graph.addVertex(r[0]);
                    graph.addVertex(r[1]);
                    graph.addEdge(r[0], r[1]);
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
