package Commands;

import InputManagment.IInput;
import Managment.CommandReader;

public class HelpCommand implements ICommand{


    public void execute(String arg, IInput inpt, CommandReader caller)
    {
        for (String name: CommandManager.CommandMap.keySet()) {
            String value = CommandManager.CommandMap.get(name).describe();
            System.out.println('"'+name+'"' + " " + value);
        }
        caller.HistoryAdd("help");
    }

    public String describe()
    {
        return "Prints all commands";
    }
}
