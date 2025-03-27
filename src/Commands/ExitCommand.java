package Commands;

import InputManagment.ISeparatedInput;
import Managment.*;

/**
 * Класс выхода из команды
 */
public class ExitCommand implements ICommand {
    public void execute(String arg, ISeparatedInput inpt, CommandReader caller) {
        InputSystem.BreakFlag();

    }

    public String describe() {
        return "Exits the program";
    }
}
