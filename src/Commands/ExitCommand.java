package Commands;
import InputManagment.IInput;
import Managment.*;
public class ExitCommand implements  ICommand{
    public void execute(String arg, IInput inpt,CommandReader caller)
    {
        InputSystem.BreakFlag();
    }
    public String describe()
    {
        return "Exits the programm";
    }
}
