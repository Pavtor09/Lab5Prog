package Commands;

import InputManagment.IInput;
import Managment.CollectionManager;
import Managment.CommandReader;
import StartData.HumanBeing;

import java.io.IOException;
import java.util.Iterator;

public class MinByImpactSeedCommand implements ICommand{

    public void execute(String arg, IInput inptm, CommandReader caller) throws IOException {
        Iterator<HumanBeing> iter = CollectionManager.GetIenerator();
        HumanBeing curHuman = iter.next();
        HumanBeing minHuman = curHuman;
        double minImpact = curHuman.GetImpactSeed();
        if (CollectionManager.getsize() > 0)
        {
            while (iter.hasNext())
        {
             curHuman = iter.next();
             if (minImpact > curHuman.GetImpactSeed())
             {
                 minImpact = curHuman.GetImpactSeed();
                 minHuman = curHuman;
             }
        }
        System.out.println(minHuman.GetValues());
        }
        else
        {
        System.out.println("Collection is empty");
        }
        caller.HistoryAdd("min_by_impact_seed");
    }

    public String describe() {
        return "Prints element with the smallest impact seed";
    }
}
