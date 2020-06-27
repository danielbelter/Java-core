package org.example;


import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import org.example.model.Node;
import org.example.service.ApplicationService;

import java.io.IOException;
import java.util.List;

public class App {
    @Parameter(names = {"--file", "-f"})
    String fileName;

    public static void main(String... argv) {
        App main = new App();
        JCommander.newBuilder()
                .addObject(main)
                .build()
                .parse(argv);

        main.run();
    }

    public void run() {
        if (fileName != null) {
            ApplicationService applicationService = new ApplicationService();
            List<Node> data = null;
            try {
                data = applicationService.readFile(fileName);
                applicationService.countGraph(data);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Missing path to file with data: run app using java -jar Task2-1.0.jar -f <path to test data>");
        }
    }
}
