package InputManagment;

import java.io.IOException;

/*Класс для ввода и хранения данных с файла*/
public class FileSeparatedInput implements ISeparatedInput {
    String path;
    String[] fileLines;
    Reader inpt = null;
    int lineNum = 0;
    private boolean reqOut = false;

    public FileSeparatedInput(String path) throws IOException {
        this.path = path;
        inpt = new Reader();
        fileLines = inpt.Read(path).split("\n");

    }

    public String NextLine() {
        lineNum += 1;
        if (lineNum <= fileLines.length) {
            return fileLines[lineNum - 1];
        } else {
            return "\\end";
        }

    }

    public boolean HasNext() {
        return lineNum < fileLines.length;
    }

    public boolean RequiresOutput() {
        return reqOut;
    }
}
