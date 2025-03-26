package Commands;

import InputManagment.IInput;
import Managment.CollectionManager;
import Managment.CommandReader;
import Managment.InputChecker;
import StartData.HumanBeing;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveCommand implements ICommand{

    public void execute(String arg, IInput inpt, CommandReader caller)
    {
        Set<HumanBeing> TempHumanCollection = new LinkedHashSet<>();
        String[] words = arg.split(" ");
        long delId = 0;
        boolean found = false;

        if (words.length == 2 && InputChecker.Numcheck(words[1],false))
        {
            delId = Long.parseLong(words[1]);

            Iterator<HumanBeing> iter = CollectionManager.GetIenerator();
            while (iter.hasNext())
            {
                HumanBeing cur = iter.next();

                if (cur.GetId() != delId)
                {
                    System.out.println(cur.GetId());
                    TempHumanCollection.add(cur);
                }
                else
                {
                    found = true;

                }
            }
            CollectionManager.CollectionReplace(TempHumanCollection);
            if (found)
            {

                System.out.println("Element has been removed");
            }
            else
            {
                System.out.println(delId);
                System.out.println("There's no element with this id");
            }

        }
        else
        {
            System.out.println("Wrong arguments");
        }

        caller.HistoryAdd("remove");
    }
    public String describe()
    {
        return "Removes element by its id, specify the id in the same line as remove";
    }
}
