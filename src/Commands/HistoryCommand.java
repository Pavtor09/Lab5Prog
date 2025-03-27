package Commands;

import InputManagment.ISeparatedInput;
import Managment.CommandReader;
import Managment.OutputManagment;

import java.io.IOException;

/**
 * Класс вывода последних 9 команд без аргументов
 */
public class HistoryCommand implements ICommand {
    public void execute(String arg, ISeparatedInput inptm, CommandReader caller) throws IOException {
        OutputManagment output = new OutputManagment(inptm);
        output.Println(caller.HistoryGet());
    }

    public String describe() {
        return "prints 9 last commands without arguments";
    }
}
