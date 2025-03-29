package Commands;

import InputManagment.ISeparatedInput;
import Managment.CollectionManager;
import Managment.CommandReader;
import OutputManagment.FormatedArgsOutput;
import StartData.HumanBeing;

import java.io.IOException;
import java.util.*;

/**
 * Вывод команд в порядке возрастания по id
 */
public class PrintAscendingCommand implements ICommand {
    public void execute(String arg, ISeparatedInput inptm, CommandReader caller) throws IOException {
        FormatedArgsOutput out = new FormatedArgsOutput();
        Comparator<HumanBeing> idComp = Comparator.comparingLong(HumanBeing::GetId);
        ArrayList<HumanBeing> CurCollection = new ArrayList<HumanBeing>();
        Iterator<HumanBeing> iter = CollectionManager.GetIenerator();
        while (iter.hasNext()) {
            CurCollection.add(iter.next());
        }
        CurCollection.sort(idComp);
        int elementIndex = 0;
        for (HumanBeing humanBeing : CurCollection) {
            elementIndex += 1;
            out.AllArgOutput(humanBeing.GetValues(),elementIndex);
        }
        caller.HistoryAdd("print_ascending");

    }

    public String describe() {
        return "prints all element ascending by id";
    }
}
