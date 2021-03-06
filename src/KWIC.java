/**
 * Created by WhyX on 11/8/16.
 */
import Subroutine.SubroutineWithSharedData;
import ADT.ADT;

import java.io.IOException;
import java.util.*;

public class KWIC {
    private static final String DEFAULT_INPUT_FILE_LOCATION = "input.txt";
    private static final String DEFAULT_NOISE_WORDS_FILE_LOCATION = "noiseWords.txt";
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String inputFile = DEFAULT_INPUT_FILE_LOCATION;
        String noiseWordsFile = DEFAULT_NOISE_WORDS_FILE_LOCATION;
        String option;

        System.out.println("====Welcome to KWIC====");
        System.out.println("Default input file name: input.txt");
        System.out.println("Default noise words file name: noiseWords.txt");

        do {
            System.out.println("Do you want to use the default input and noise words file name? (y/n)");
            option = sc.next();
        } while(!option.equals("y") && !option.equals("n"));

        if(option.equals("n")) {
            System.out.println("Please enter your input file name:");
            inputFile = sc.next();

            System.out.println("Please enter your noise words file name:");
            noiseWordsFile = sc.next();
        }

        System.out.println("Please choose one of the following Architectures(input 1 or 2):");
        System.out.println("1. Subroutine with Shared Data - Cheong Yuan Xiang A0112162Y");
        System.out.println("2. Abstract Data Types - Lareina Ting Jia Pei A0112151A");
        System.out.println("Press any other key to exit.");

        while(true) {
            option = sc.next();

            switch(option) {
                case "1":
                    System.out.println("====Subroutine with Shared Data====");
                    SubroutineWithSharedData subroutine = new SubroutineWithSharedData(inputFile, noiseWordsFile);
                    subroutine.execute();
                    break;
                case "2":
                    System.out.println("====Abstract Data Types====");
                    ADT adt = new ADT(inputFile, noiseWordsFile);
                    adt.execute();
                    break;
                default:
                    System.out.println("Program terminated, thank you!");
                    System.exit(0);
            }
        }
    }
}