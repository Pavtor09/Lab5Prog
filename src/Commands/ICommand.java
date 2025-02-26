package Commands;

import InputManagment.IInput;
import Managment.CommandReader;

import java.io.IOException;

public interface ICommand {
    public void execute(String arg, IInput inptm, CommandReader caller) throws IOException;
    public String describe();
}
