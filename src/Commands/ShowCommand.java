package Commands;

import Managment.CollectionManager;
import StartData.HumanBeing;

import java.util.Iterator;

public class ShowCommand implements ICommand{

    public void execute(String arg)
    {
        if(CollectionManager.getsize() > 0)
        {
            Iterator<HumanBeing> iter = CollectionManager.GetIenerator();
            HumanBeing cur = null;
            while (iter.hasNext())
            {
                cur = iter.next();
                System.out.println(cur.GetValues());
            }
        }
        else
        {
            System.out.println("Collection is empty");
        }

    }
    public String describe()
    {
        return "prints all collection elements";
    }
}
