package Subroutine;

import java.util.*;

/**
 * Created by WhyX on 24/8/16.
 */
public class ShiftedLineStorage {
    private ArrayList<String> shiftedLines;

    public ShiftedLineStorage() {
        this.shiftedLines = new ArrayList<String>();
    }

    public void addShiftedLine(String shiftedLine) {
        this.shiftedLines.add(shiftedLine);
    }

    public int getSize() {
        return this.shiftedLines.size();
    }

    public String getShiftedLine(int index) {
        return this.shiftedLines.get(index);
    }

    public ArrayList<String> getAllShiftedLines() {
        return this.shiftedLines;
    }
}
