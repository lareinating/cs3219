package ADT;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by lareinating on 21/8/16.
 */
public interface Input {
    public void readAndStoreInput() throws IOException;
    public ArrayList<String> getStoredLines();
    public Words getNoiseWords();
}