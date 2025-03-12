package Commands;

import InputManagment.IInput;
import Managment.CommandReader;

import java.io.IOException;

public class RemoveLowerCommand implements ICommand {


    public void execute(String arg, IInput inptm, CommandReader caller) throws IOException {
        String[] Args = arg.split(" ");
        if (Args.length != 2)
        {

        }
    }


    public String describe() {
        return "";
    }
}
