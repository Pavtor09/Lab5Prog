package Commands;

import InputManagment.FileInput;
import InputManagment.IInput;
import InputManagment.Reader;
import Managment.CommandReader;

import java.io.IOException;
import java.util.ArrayList;

public class ExecuteCommand implements ICommand{
    public void execute(String arg, IInput inpt, CommandReader caller) throws IOException {
        String[] tokens = arg.split(" ");

        String path = tokens[1];
        if (!caller.recursion.contains(path))
        {
            Reader Inpt = new Reader();
            inpt = new FileInput(path);
            CommandReader CR = new CommandReader();
            CR.inptobj = inpt;
            CR.recursion = (ArrayList<String>) caller.recursion.clone();
            CR.recursion.add(path);



            while (inpt.HasNext())
            {
    //            System.out.println("____"+inpt.NextLine());
                CR.run(inpt.NextLine());
            }
        }
        else
        {
            System.out.println("Recursion break");
        }
        caller.HistoryAdd("execute");

    }
    public String describe()
    {
        return "executes commands from file";
    }

}
