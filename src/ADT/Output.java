package ADT;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by lareinating on 21/8/16.
 */
public interface Output {
    public void storeToFile(ArrayList<String> lines) throws IOException;
    public void printLines(ArrayList<String> lines);
}
