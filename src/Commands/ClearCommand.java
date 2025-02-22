package Commands;

import Managment.CollectionManager;
import StartData.HumanBeing;

import java.util.LinkedHashSet;
import java.util.Set;

public class ClearCommand implements ICommand{
    public void execute(String arg)
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
