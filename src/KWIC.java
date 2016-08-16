import java.io.BufferedReader;

/**
 * Created by WhyX on 11/8/16.
 */
import java.io.*;
import java.util.*;

public class KWIC {
    private static BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        ArrayList<String> lines = readLines();
        HashMap<String, String> noiseWords = readNoiseWords();
        ArrayList<String> shiftedLines = circularShift(lines, noiseWords);
        ArrayList<String> alphabetizedLines = alphabeticalSort(shiftedLines);

        output(alphabetizedLines);
    }

    // Read lines
    private static ArrayList<String> readLines() {
        ArrayList<String> inputLines = new ArrayList<String>();

        System.out.println("Please enter lines(enter z to indicate the end of input):");

        try {
            String line = inputReader.readLine();

            while (!line.equalsIgnoreCase("z")) {
                inputLines.add(line);
                line = inputReader.readLine();
            }
        } catch (IOException error) {
            System.out.println(error.getMessage());
        }

        return inputLines;
    }

    // Read noise words
    private static HashMap<String, String> readNoiseWords() {
        HashMap<String, String> noiseWords = new HashMap<String, String>();

        System.out.println("Please enter noise words to be ignored(enter z to indicate the end of input):");

        try {
            String line = inputReader.readLine();

            while (!line.equalsIgnoreCase("z")) {
                noiseWords.put(line.toLowerCase(), line.toLowerCase());
                line = inputReader.readLine();
            }
        } catch (IOException error) {
            System.out.println(error.getMessage());
        }

        return noiseWords;
    }

    // Circular Shift
    private static ArrayList<String> circularShift(ArrayList<String> inputLines, HashMap<String, String> noiseWords) {
        ArrayList<String> shiftedInputLines = new ArrayList<String>();

        for(int i = 0; i < inputLines.size(); i++) {
            String[] splitLine = inputLines.get(i).split("\\s+");

            for(int j = 0; j < splitLine.length; j++) {

                if(noiseWords.get(splitLine[j].toLowerCase()) != null) {
                    continue;
                }

                int currIndex = j;
                String shiftedLine = splitLine[j].concat(" ");

                do {
                    currIndex++;

                    if(currIndex == splitLine.length) {
                        currIndex %= splitLine.length;
                    }

                    if(currIndex == j) {
                        break;
                    }

                    shiftedLine = shiftedLine.concat(splitLine[currIndex]);
                    shiftedLine = shiftedLine.concat(" ");
                } while (currIndex != j);

                shiftedInputLines.add(shiftedLine);
            }
        }

        return shiftedInputLines;
    }

    // Alphabetizer
    private static ArrayList<String> alphabeticalSort(ArrayList<String> shiftedInputLines) {
        ArrayList<String> alphabetizedLines = shiftedInputLines;

        Collections.sort(alphabetizedLines);

        return alphabetizedLines;
    }

    // Output
    private static void output(ArrayList<String> alphabetizedLines) {
        System.out.println();
        System.out.println("Shifted Lines:");

        for(int i = 0; i < alphabetizedLines.size(); i++) {
            System.out.println(alphabetizedLines.get(i));
        }
    }
}