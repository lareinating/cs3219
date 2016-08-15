import java.util.ArrayList;

/**
 * Created by lareinating on 15/8/16.
 */
public class CircularShift {
    private static ArrayList<String> allInputs;
    private static ArrayList<String> shiftedInputLines;
    private static NoiseWord noiseWord;

    public CircularShift(ArrayList<String> inputs, NoiseWord noiseWord) {
        this.allInputs = inputs;
        this.noiseWord = noiseWord;
        shiftedInputLines = new ArrayList<String>();
    }

    public static ArrayList<String> getShiftedWords() {
        for(int i = 0; i < allInputs.size(); i++) {
            String[] splitLine = allInputs.get(i).split("\\s+");
            for(int j = 0; j < splitLine.length; j++) {

                if(noiseWord.hasNoiseWord(splitLine[j].toLowerCase())) {
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
}
