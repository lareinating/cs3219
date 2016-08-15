import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by lareinating on 15/8/16.
 */
public class Alphabetizer {
    private static ArrayList<String> processedInputs;

    public Alphabetizer(ArrayList<String> processedInputs) {
        this.processedInputs = processedInputs;
    }

    public static ArrayList<String> sortInputs() {
        Collections.sort(processedInputs);
        return processedInputs;
    }
}
