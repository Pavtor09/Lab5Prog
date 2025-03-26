package Commands;

import InputManagment.IInput;
import Managment.CommandReader;
import Managment.OutputManagment;

import java.io.IOException;

public class HistoryCommand implements ICommand{
    public void execute(String arg, IInput inptm, CommandReader caller) throws IOException {
        OutputManagment output = new OutputManagment(inptm);
        output.Println(caller.HistoryGet());
    }

    public String describe() {
        return "prints 9 last commands without arguments";
    }
}
