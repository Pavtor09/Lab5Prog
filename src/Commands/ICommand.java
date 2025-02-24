package Commands;

import java.io.IOException;

public interface ICommand {
    public void execute(String arg) throws IOException;
    public String describe();
}
