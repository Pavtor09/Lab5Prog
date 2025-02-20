package Commands;

import Managment.CollectionManager;
import StartData.HumanBeing;

import java.util.Iterator;

public class ShowCommand implements ICommand{

    public void execute(String arg) {
        Iterator<HumanBeing> iter = CollectionManager.GetIenerator();
        HumanBeing cur = null;
        while (iter.hasNext())
        {
            cur = iter.next();
            System.out.println(cur.GetValues());
        }
    }
    public String describe()
    {
        return "prints all collection elements";
    }
}
