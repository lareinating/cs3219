package ADT;

import java.util.HashMap;

/**
 * Created by lareinating on 21/8/16.
 */
public class NoiseWords implements Words {
    private HashMap<String, String> noiseWords;

    public NoiseWords() {
        noiseWords = new HashMap<String, String>();
    }

    public void setWords(String key, String value) {
        noiseWords.put(key, value);
    }

    public boolean hasWord(String word) {
        if (noiseWords.get(word) != null) {
            return true;
        } else {
            return false;
        }
    }
}
