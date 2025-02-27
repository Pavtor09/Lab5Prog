package Managment;

import Commands.CommandManager;
import Commands.ICommand;
import InputManagment.ConsoleInput;
import InputManagment.IInput;

import java.io.IOException;
import java.util.ArrayList;

public class CommandReader {
    public ArrayList<String> recursion = new ArrayList<String>();
    public IInput inptobj = new ConsoleInput();
    public void run(String line) throws IOException {
        ICommand curcommand = null;
        String[] tokens = line.split(" ");


        if (tokens.length > 0)
        {

            curcommand = CommandManager.CommandMap.get(tokens[0]);

        }
        try{

            curcommand.execute(line,inptobj,this);
        }
        catch (Exception e)
        {
            System.out.println("There is no such command as "+(tokens.length>0?tokens[0]:null));
        }

    }
}
