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

    public OutputLines(String outputFile) {
        this.outputFile = outputFile;

    }
    @Override
    public void storeToFile(ArrayList<String> lines) throws IOException {
        Path file = Paths.get(outputFile);
        Files.write(file, lines, Charset.forName("UTF-8"));
    }

    @Override
    public void printLines(ArrayList<String> lines) {
        System.out.println("Output:");

        for(int i = 0; i < lines.size(); i++) {
            System.out.println(lines.get(i));
        }
    }
}
