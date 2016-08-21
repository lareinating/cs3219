package ADT;

import java.util.ArrayList;

/**
 * Created by lareinating on 21/8/16.
 */
public class InputLines implements Lines {
    private ArrayList<String> inputs;

    public InputLines() {
        inputs = new ArrayList<String>();
    }

    public void setLines(String input) {
        inputs.add(input);
    }

    public ArrayList<String> getLines() {
        return inputs;
    }
}
