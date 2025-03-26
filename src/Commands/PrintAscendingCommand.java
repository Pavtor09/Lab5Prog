package Commands;

import InputManagment.IInput;
import Managment.CollectionManager;
import Managment.CommandReader;
import StartData.HumanBeing;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

public class PrintAscendingCommand implements ICommand{
    public void execute(String arg, IInput inptm, CommandReader caller) throws IOException {
        Comparator<HumanBeing> idComp = Comparator.comparingLong(HumanBeing::GetId);
        ArrayList<HumanBeing> CurCollection = new ArrayList<HumanBeing>();
        Iterator<HumanBeing> iter = CollectionManager.GetIenerator();
        while (iter.hasNext())
        {
            CurCollection.add(iter.next());
        }
        CurCollection.sort(idComp);
        for(int i = 0;i < CurCollection.size();i++)
        {
            System.out.println(CurCollection.get(i).GetValues());
        }
        caller.HistoryAdd("print_ascending");

    }

    public String describe() {
        return "prints all element ascending by id";
    }
}
