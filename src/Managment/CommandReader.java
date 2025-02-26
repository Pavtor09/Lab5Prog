package Managment;

import Commands.CommandManager;
import Commands.ICommand;
import InputManagment.ConsoleInput;
import InputManagment.IInput;

import java.io.IOException;

public class CommandReader {
    public IInput inptobj = new ConsoleInput();
    public void run(String line) throws IOException {
        ICommand curcommand = null;
        String[] tokens = line.split(" ");
        System.out.println(tokens[0]);
//        if (tokens.length > 0)
//        {

            curcommand = CommandManager.CommandMap.get(tokens[0]);
            System.out.println(curcommand);
//        }
//        try{

            curcommand.execute(line,inptobj,this);
//        }
//        catch (Exception e)
//        {
//            System.out.println("There is no such command as "+(tokens.length>0?tokens[0]:null));
//        }

    }
}
