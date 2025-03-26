package Commands;

import InputManagment.IInput;
import Managment.CollectionManager;
import Managment.CommandReader;
import StartData.HumanBeing;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class PrintFieldAscendingImpactSeed implements ICommand{
    public void execute(String arg, IInput inptm, CommandReader caller) throws IOException {
        Comparator<HumanBeing> SeedComp = Comparator.comparingDouble(HumanBeing::GetImpactSeed);
        ArrayList<HumanBeing> CurCollection = new ArrayList<HumanBeing>();
        Iterator<HumanBeing> iter = CollectionManager.GetIenerator();
        while (iter.hasNext())
        {
            CurCollection.add(iter.next());
        }
        CurCollection.sort(SeedComp);
        for(int i = 0;i < CurCollection.size();i++)
        {
            System.out.println(CurCollection.get(i).GetValues());
        }
        caller.HistoryAdd("print_field_ascending");
    }

    public String describe() {
        return "prints all elements ascending by impact seed";
    }
}
