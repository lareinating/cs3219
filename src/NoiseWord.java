import java.util.HashMap;

/**
 * Created by lareinating on 15/8/16.
 */
public class NoiseWord {
    private HashMap<String, String> noiseWord;

    public NoiseWord() {
        noiseWord = new HashMap<String, String>();
    }

    public void setNoiseWords(String key, String value) {
        noiseWord.put(key, value);
    }

    public boolean hasNoiseWord(String word) {
        if (noiseWord.get(word) != null) {
            return true;
        } else {
            return false;
        }
    }
}
