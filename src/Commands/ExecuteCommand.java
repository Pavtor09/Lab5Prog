package Commands;

import InputManagment.FileInput;
import InputManagment.IInput;
import InputManagment.Reader;
import Managment.CommandReader;

import java.io.IOException;

public class ExecuteCommand implements ICommand{
    public void execute(String arg, IInput inpt, CommandReader caller) throws IOException {
        String[] tokens = arg.split(" ");
        String path = tokens[1];
        Reader Inpt = new Reader();
        inpt = new FileInput(path);
        CommandReader CR = new CommandReader();
        CR.inptobj = inpt;
        while (inpt.HasNext())
        {
//            System.out.println("____"+inpt.NextLine());
            CR.run(inpt.NextLine());
        }


    }
    public String describe()
    {
        return "executes commands from file";
    }

}
