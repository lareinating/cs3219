import java.util.ArrayList;

/**
 * Created by lareinating on 15/8/16.
 */

public class Reader {
    private ArrayList<String> inputs;

    public Reader() {
        inputs = new ArrayList<String>();
    }

    public void setInputs(String input) {
        inputs.add(input);
    }

    public ArrayList<String> getInputs() {
        return inputs;
    }
}
