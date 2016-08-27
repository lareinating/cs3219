package Subroutine;

import java.io.*;
import java.util.*;

/**
 * Created by WhyX on 18/8/16.
 */
public class SubroutineWithSharedData {
    private BufferedReader br;
    private String inputFile;
    private String noiseWordsFile;

    // Shared Storage
    private InputLineStorage inputLineStorage;
    private NoiseWordStorage noiseWordStorage;
    private ShiftedLineStorage shiftedLineStorage;

    // Constructor
    public SubroutineWithSharedData(String inputFile, String noiseWordsFile) {
        this.inputFile = inputFile;
        this.noiseWordsFile = noiseWordsFile;
        this.inputLineStorage = new InputLineStorage();
        this.noiseWordStorage = new NoiseWordStorage();
        this.shiftedLineStorage = new ShiftedLineStorage();
    }

    public void execute() {
        this.input();
        this.circularShift();
        this.alphabetizer();
        this.output();
    }

    // Input
    private void input() {
        try {
            br = new BufferedReader(new FileReader(new File(this.inputFile)));

            String line = br.readLine();

            while (line != null) {
                inputLineStorage.addLine(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error reading input lines, please make sure the file does exist and the file name is correct.");
        }

        try {
            br = new BufferedReader(new FileReader(new File(this.noiseWordsFile)));

            String line = br.readLine();

            while (line != null) {
                noiseWordStorage.addNoiseWord(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error reading noise words, please make sure the file does exist and the file name is correct.");
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    // Circular Shift
    private void circularShift() {
        for (int i = 0; i < this.inputLineStorage.getSize(); i++) {
            String[] splitLine = this.inputLineStorage.getLine(i).split("\\s+");

            for (int j = 0; j < splitLine.length; j++) {
                if(this.noiseWordStorage.checkOccurrence(splitLine[j])) {
                    continue;
                }

                int currIndex = j;
                String shiftedLine = splitLine[j].concat(" ");

                do {
                    currIndex++;

                    if (currIndex == splitLine.length) {
                        currIndex %= splitLine.length;
                    }

                    if (currIndex == j) {
                        break;
                    }

                    shiftedLine = shiftedLine.concat(splitLine[currIndex]);
                    shiftedLine = shiftedLine.concat(" ");
                } while (currIndex != j);

                this.shiftedLineStorage.addShiftedLine(shiftedLine);
            }
        }
    }

    // Alphabetizer
    private void alphabetizer() {
        Collections.sort(this.shiftedLineStorage.getAllShiftedLines());
    }

    // Output
    private void output() {
        writeToFile();
        printToConsole();
    }

    private void writeToFile() {
        BufferedWriter writer = null;

        try {
            File outputFile = new File("output.txt");
            writer = new BufferedWriter(new FileWriter(outputFile));
            for (int i = 0; i < this.shiftedLineStorage.getSize(); i++) {
                writer.write(this.shiftedLineStorage.getShiftedLine(i) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error writing to output file");
        } finally {
            if(writer != null) {
                try {
                    writer.close();
                } catch (IOException ec) {
                    ec.printStackTrace();
                }
            }
        }
    }

    private void printToConsole() {
        System.out.println("Output:");
        for (int i = 0; i < this.shiftedLineStorage.getSize(); i++) {
            System.out.println(this.shiftedLineStorage.getShiftedLine(i));
        }

        System.out.println();
        System.out.println("Your output can also be found in output.txt");
    }
}

