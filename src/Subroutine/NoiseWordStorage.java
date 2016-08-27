package Subroutine;

import java.util.*;

/**
 * Created by WhyX on 24/8/16.
 */

public class NoiseWordStorage {
    private HashMap<String, String> noiseWords;

    public NoiseWordStorage() {
        this.noiseWords = new HashMap<String, String>();
    }

    public void addNoiseWord(String noiseWord) {
        this.noiseWords.put(noiseWord.toLowerCase(), noiseWord.toLowerCase());
    }

    public boolean checkOccurrence(String lineToCheck) {
        return (this.noiseWords.get(lineToCheck.toLowerCase()) != null);
    }
}
