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
    private ArrayList<String> inputLines;
    private HashMap<String, String> noiseWords;
    private ArrayList<String> shiftedInputLines;

    public SubroutineWithSharedData(String inputFile, String noiseWordsFile) {
        this.inputFile = inputFile;
        this.noiseWordsFile = noiseWordsFile;
        this.inputLines = new ArrayList<String>();
        this.noiseWords = new HashMap<String, String>();
        this.shiftedInputLines = new ArrayList<String>();
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

            while(line != null) {
                inputLines.add(line);
                line = br.readLine();
            }
        } catch(IOException e) {
            e.printStackTrace();
        }

        try {
            br = new BufferedReader(new FileReader(new File(this.noiseWordsFile)));

            String line = br.readLine();

            while(line != null) {
                noiseWords.put(line, line);
                line = br.readLine();
            }
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch(IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    // Circular Shift
    private void circularShift() {
        for(int i = 0; i < this.inputLines.size(); i++) {
            String[] splitLine = this.inputLines.get(i).split("\\s+");

            for(int j = 0; j < splitLine.length; j++) {
                if(this.noiseWords.get(splitLine[j].toLowerCase()) != null) {
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

                this.shiftedInputLines.add(shiftedLine);
            }
        }
    }

    // Alphabetizer
    private void alphabetizer() {
        Collections.sort(this.shiftedInputLines);
    }

    // Output
    private void output() {
        System.out.println("Output:");

        for(int i = 0; i < this.shiftedInputLines.size(); i++) {
            System.out.println(this.shiftedInputLines.get(i));
        }
    }
}

