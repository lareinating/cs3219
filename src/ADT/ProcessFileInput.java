package ADT;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by lareinating on 21/8/16.
 */
public class ProcessFileInput implements Input {
    private String inputFile;
    private String noiseWordFile;
    private BufferedReader br;
    private Lines lines;
    private Words noiseWords;

    public ProcessFileInput(String inputFile, String noiseWordFile) {
        this.inputFile = inputFile;
        this.noiseWordFile = noiseWordFile;
    }

    @Override
    public void readAndStoreInput() throws IOException {

        br = new BufferedReader(new FileReader(new File(this.inputFile)));
        lines = new InputLines();
        String nextLine = br.readLine();

        while(nextLine != null) {
            lines.setLines(nextLine);
            nextLine = br.readLine();
        }

        br = new BufferedReader(new FileReader(new File(this.noiseWordFile)));
        noiseWords = new NoiseWords();
        String line = br.readLine();

        while(line != null) {
            noiseWords.setWords(line.toLowerCase(), line.toLowerCase());
            line = br.readLine();
        }
    }

    public ArrayList<String> getStoredLines() {
        return lines.getLines();
    }

    public Words getNoiseWords() {
        return noiseWords;
    }
}
