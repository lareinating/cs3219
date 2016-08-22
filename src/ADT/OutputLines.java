package ADT;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Created by lareinating on 21/8/16.
 */
public class OutputLines implements Output{
    private String outputFile;
    private ArrayList<String> lines;

    public OutputLines(String outputFile, ArrayList<String> lines) {
        this.outputFile = outputFile;
        this.lines = lines;

    }
    @Override
    public void storeToFile() throws IOException {
        Path file = Paths.get(outputFile);
        Files.write(file, lines, Charset.forName("UTF-8"));
    }

    @Override
    public void printLines() {
        System.out.println("Output:");

        for(int i = 0; i < lines.size(); i++) {
            System.out.println(lines.get(i));
        }
    }

    @Override
    public void processOutput() throws IOException {
        storeToFile();
        printLines();
        System.out.println();
        System.out.println("Your output can also be found in " + outputFile + ".");
    }
}
