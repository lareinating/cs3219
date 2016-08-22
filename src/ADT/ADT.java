package ADT;

import java.io.IOException;

/**
 * Created by lareinating on 21/8/16.
 */
public class ADT {
    private String inputFile;
    private String noiseWordFile;

    public ADT(String inputFile, String noiseWordFile) {
        this.inputFile = inputFile;
        this.noiseWordFile = noiseWordFile;
    }

    public void execute() throws IOException {
        Input fileInput = new ProcessFileInput(inputFile, noiseWordFile);
        fileInput.readAndStoreInput();
        CircularShift cs = new InputCircularShift(fileInput.getStoredLines(), fileInput.getNoiseWords());
        AlphabeticShift as = new InputAlphabeticShift(cs.getCircularShiftedLines());
        as.alphaShift();
        Output op = new OutputLines("output.txt", as.getAlphaShiftedLines());
        op.processOutput();
    }
}
