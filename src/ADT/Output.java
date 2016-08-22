package ADT;

import java.io.IOException;

/**
 * Created by lareinating on 21/8/16.
 */
public interface Output {
    public void storeToFile() throws IOException;
    public void printLines();
    public void processOutput() throws IOException;
}
