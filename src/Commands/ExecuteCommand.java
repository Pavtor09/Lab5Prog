package Commands;

import InputManagment.FileSeparatedInput;
import InputManagment.ISeparatedInput;
import Managment.CommandReader;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Класс выполнения скрипта из файла
 */
public class ExecuteCommand implements ICommand {
    public void execute(String arg, ISeparatedInput inpt, CommandReader caller) throws IOException {
        String[] tokens = arg.split(" ");

        String path = tokens[1];
        if (!caller.recursion.contains(path)) {
            inpt = new FileSeparatedInput(path);
            CommandReader CR = new CommandReader();
            CR.inptobj = inpt;
            CR.recursion = (ArrayList<String>) caller.recursion.clone();
            CR.recursion.add(path);


            while (inpt.HasNext()) {

                CR.run(inpt.NextLine());
            }
        } else {
            System.out.println("Recursion break");
        }
        caller.HistoryAdd("execute");

    }

    public String describe() {
        return "executes commands from file, specify the path to the file in the same line as execute";
    }

}
