package Commands;

import InputManagment.ISeparatedInput;
import Managment.CollectionManager;
import Managment.CommandReader;
import StartData.HumanBeing;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class PrintFieldAscendingImpactSeed implements ICommand {
    public void execute(String arg, ISeparatedInput inptm, CommandReader caller) throws IOException {
        Comparator<HumanBeing> SeedComp = Comparator.comparingDouble(HumanBeing::GetImpactSeed);
        ArrayList<HumanBeing> CurCollection = new ArrayList<HumanBeing>();
        Iterator<HumanBeing> iter = CollectionManager.GetIenerator();
        while (iter.hasNext()) {
            CurCollection.add(iter.next());
        }
        CurCollection.sort(SeedComp);
        for (HumanBeing humanBeing : CurCollection) {
            System.out.println(humanBeing.GetValues());
        }
        caller.HistoryAdd("print_field_ascending");
    }

    public String describe() {
        return "prints all elements ascending by impact seed";
    }
}
