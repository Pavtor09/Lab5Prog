package Commands;
import Managment.*;
import StartData.HumanBeing;

import java.util.Iterator;

public class InfoCommand implements ICommand{
    public void execute(String arg)
    {
        HumanBeing last = null;
        Iterator<HumanBeing> iter = CollectionManager.HumanCollection.iterator();
//        while (iter.hasNext())
//        {
            last = iter.next();
//        }

        System.out.println("Type of collection: "+CollectionManager.HumanCollection.getClass().toString()+" | Time of initialization "+ (last != null?last.GetTime().toString().replaceAll("\\..*","").replace("T"," "):"-")+" | Collection size: " +CollectionManager.HumanCollection.size());
    }
    public String describe()
    {
        return "";
    }
}
