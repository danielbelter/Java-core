package org.example.service;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.example.model.Pair;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ApplicationService {
    public List<Pair> findPairsWithSum(List<Integer> numbers, int expectedSum) {
        List<Integer> sorted = new ArrayList<>(numbers);
        sorted.sort(Comparator.naturalOrder());
        List<Pair> pairs = new ArrayList<>();

        for (int i = 0; i < sorted.size() - 1; i++) {
            for (int j = i + 1; j < sorted.size(); j++) {
                if ((sorted.get(i) + sorted.get(j)) == expectedSum) {
                    pairs.add(new Pair(sorted.get(i), sorted.get(j)));
                }
            }
        }
        return pairs;
    }

    public List<Integer> readFile(String filePath) throws IOException {

        LineIterator it = FileUtils.lineIterator(new File(filePath), "UTF-8");
        List<Integer> numbers = new ArrayList<>();
        while (it.hasNext()) {
            String line = it.nextLine();
            String[] r = line.split(" ");
            for (String value : r) {
                numbers.add(Integer.parseInt(value));
            }
        }
        return numbers;
    }
}
