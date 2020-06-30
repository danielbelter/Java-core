package org.example.service;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.example.model.Node;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ApplicationService {


    public void countGraph(List<Node> dataSet) {
        int graphs = 1;
        for (int i = 0; i <= dataSet.size() - 1; i++) {
            int temp1 = 0;
            int temp2 = 0;
            int firstValue = dataSet.get(i).getFirstValue();
            int secondValue = dataSet.get(i).getSecondValue();

            for (Node n : dataSet) {

                if (n.getFirstValue().equals(firstValue) || n.getFirstValue().equals(secondValue)) {
                    temp1++;
                }
                if (n.getSecondValue().equals(secondValue) || n.getSecondValue().equals(firstValue)) {
                    temp2++;
                }

            }
            if (temp1 == 1 && temp2 == 1) {
                graphs++;
            }
        }
        System.out.println(graphs);
    }

    public List<Node> readFile(String filePath) throws IOException {
        LineIterator it = null;
        List<Node> nodes = new ArrayList<>();
        try {
            it = FileUtils.lineIterator(new File(filePath), "UTF-8");
            while (it.hasNext()) {
                String line = it.nextLine();
                String[] r = line.split(" ");
                if (r.length == 2) {
                    nodes.add(new Node(Integer.parseInt(r[0]), Integer.parseInt(r[1])));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            it.close();
        }
        return nodes;
    }
}
