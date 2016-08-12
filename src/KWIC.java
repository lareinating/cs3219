import java.io.BufferedReader;

/**
 * Created by WhyX on 11/8/16.
 */
import java.io.*;
import java.util.*;

public class KWIC {
    private static ArrayList<String> inputLines = new ArrayList<String>();
    private static HashMap<String, String> noiseWords = new HashMap<String, String>();
    private static ArrayList<String> shiftedInputLines = new ArrayList<String>();

    public static void main(String[] args) {
        inputReader();
        circularShift();
        alphabeticalSort();
        output();
    }

    // Interactive Input
    private static void inputReader() {
        System.out.println("Please enter lines(enter z to indicate the end of input):");

        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String line = inputReader.readLine();

            while (!line.equalsIgnoreCase("z")) {
                inputLines.add(line);
                line = inputReader.readLine();
            }
        } catch (IOException error) {
            System.out.println(error.getMessage());
        }

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
    }

    // Circular Shift
    private static void circularShift() {
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
    }

    // Alphabetizer
    private static void alphabeticalSort() {
        Collections.sort(shiftedInputLines);
    }

    // Output
    private static void output() {
        System.out.println();
        System.out.println("Shifted Lines:");

        for(int i = 0; i < shiftedInputLines.size(); i++) {
            System.out.println(shiftedInputLines.get(i));
        }
    }
}