import java.io.BufferedReader;

/**
 * Created by WhyX on 11/8/16.
 */
import java.io.*;
import java.util.*;

public class KWIC {
    private static ArrayList<String> shiftedInputLines = new ArrayList<String>();
    private static Reader readerStore = new Reader();
    private static NoiseWord noiseWord = new NoiseWord();

    private static CircularShift circularShift;
    private static Alphabetizer alphabetizer;

    public static void main(String[] args) {
        System.out.println("Please enter lines(enter z to indicate the end of input):");

        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String line = inputReader.readLine();

            while (!line.equalsIgnoreCase("z")) {
                readerStore.setInputs(line);
                line = inputReader.readLine();
            }
        } catch (IOException error) {
            System.out.println(error.getMessage());
        }

        System.out.println("Please enter noise words to be ignored(enter z to indicate the end of input):");

        try {
            String line = inputReader.readLine();

            while (!line.equalsIgnoreCase("z")) {
                noiseWord.setNoiseWords(line.toLowerCase(), line.toLowerCase());
                line = inputReader.readLine();
            }
        } catch (IOException error) {
            System.out.println(error.getMessage());
        }

        circularShift = new CircularShift(readerStore.getInputs(), noiseWord);
        shiftedInputLines = circularShift.getShiftedWords();

        alphabetizer = new Alphabetizer(shiftedInputLines);
        shiftedInputLines = alphabetizer.sortInputs();

        System.out.println();
        System.out.println("Shifted Lines:");

        for(int i = 0; i < shiftedInputLines.size(); i++) {
            System.out.println(shiftedInputLines.get(i));
        }
    }
}