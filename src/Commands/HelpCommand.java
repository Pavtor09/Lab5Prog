package Commands;

import InputManagment.ISeparatedInput;
import Managment.CommandReader;

/**
 * Класс вывода всех команд и их аргументов
 */
public class HelpCommand implements ICommand {


    public void execute(String arg, ISeparatedInput inpt, CommandReader caller) {
        for (String name : CommandManager.CommandMap.keySet()) {
            String value = CommandManager.CommandMap.get(name).describe();
            System.out.println('"' + name + '"' + " " + value + "\n");

        }
        caller.HistoryAdd("help");
    }

    public String describe() {
        return "Prints all commands";
    }
}
