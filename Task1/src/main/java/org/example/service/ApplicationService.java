package org.example.service;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class ApplicationService {

    public void parseData(List<Integer> data) {
        Set<Integer> uniqueValues = new TreeSet<>(data);
        uniqueValues.forEach(value -> System.out.print(value + " "));
        System.out.println("");
        System.out.println("count: " + data.size());
        System.out.println("distinct: " + uniqueValues.size());
        System.out.println("min: " + Collections.min(data));
        System.out.println("max: " + Collections.max(data));
    }

    public List<Integer> readFile(String filePath) throws IOException {

        LineIterator it = null;
        List<Integer> numbers = new ArrayList<>();
        try {
            it = FileUtils.lineIterator(new File(filePath), "UTF-8");
            while (it.hasNext()) {
                String line = it.nextLine();
                String[] r = line.split(" ");
                for (String value : r) {
                    numbers.add(Integer.parseInt(value));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            it.close();
        }
        return numbers;
    }
}
