package Commands;

import InputManagment.ISeparatedInput;
import Managment.CollectionManager;
import Managment.CommandReader;
import StartData.HumanBeing;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Класс отвечающий за очистку коллекции
 */
public class ClearCommand implements ICommand {
    public void execute(String arg, ISeparatedInput inpt, CommandReader caller) {
        Set<HumanBeing> ZeroHumanCollection = new LinkedHashSet<>();
        CollectionManager.CollectionReplace(ZeroHumanCollection);
        System.out.println("Collection has been cleared");
        caller.HistoryAdd("clear");
    }

    public String describe() {
        return "removes all elements from collection";
    }

}
