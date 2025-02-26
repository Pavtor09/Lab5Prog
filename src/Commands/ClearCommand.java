package Commands;

import InputManagment.IInput;
import Managment.CollectionManager;
import Managment.CommandReader;
import StartData.HumanBeing;

import java.util.LinkedHashSet;
import java.util.Set;

public class ClearCommand implements ICommand{
    public void execute(String arg, IInput inpt, CommandReader caller)
    {
        Set<HumanBeing> ZeroHumanCollection = new LinkedHashSet<>();
        CollectionManager.CollectionReplace(ZeroHumanCollection);
        System.out.println("Collection has been cleared");
    }
    public String describe()
    {
        return "removes all elements from collection";
    }

}
