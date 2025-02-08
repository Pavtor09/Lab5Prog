package Commands;
import Managment.*;
public class ExitCommand implements  ICommand{
    public void execute(String arg)
    {
        InputSystem.BreakFlag();
    }
    public String describe()
    {
        return "Exits the programm";
    }
}
