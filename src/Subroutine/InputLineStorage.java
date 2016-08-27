package Subroutine;

import java.util.*;

/**
 * Created by WhyX on 24/8/16.
 */

public class InputLineStorage {
    private ArrayList<String> inputLines;

    public InputLineStorage() {
        this.inputLines = new ArrayList<String>();
    }

    public void addLine(String line) {
        this.inputLines.add(line);
    }

    public int getSize() {
        return this.inputLines.size();
    }

    public String getLine(int index) {
        return this.inputLines.get(index);
    }
}
