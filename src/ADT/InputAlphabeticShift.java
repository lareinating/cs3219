package ADT;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by lareinating on 21/8/16.
 */
public class InputAlphabeticShift implements AlphabeticShift {
    private static ArrayList<String> processedInputs;

    public InputAlphabeticShift(ArrayList<String> processedInputs) {
        this.processedInputs = processedInputs;
    }

    public void alphaShift() {
        Collections.sort(processedInputs);
    }

    public ArrayList<String> getAlphaShiftedLines() {
        return processedInputs;
    }
}
