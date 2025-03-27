package Commands;

import InputManagment.ISeparatedInput;
import Managment.*;
import StartData.HumanBeing;

import java.util.Iterator;

/**
 * Класс вывода информации о коллекции: класс, время создания, количество элементов
 */
public class InfoCommand implements ICommand {
    public void execute(String arg, ISeparatedInput inpt, CommandReader caller) {
        HumanBeing last = null;
        if (CollectionManager.getsize() > 0) {
            Iterator<HumanBeing> iter = CollectionManager.GetIenerator();
            last = iter.next();
            System.out.println("Type of collection: " + CollectionManager.getclass().toString() + " | Time of initialization " + (last != null ? last.GetTime().toString().replaceAll("\\..*", "").replace("T", " ") : "-") + " | Collection size: " + CollectionManager.getsize());
        } else {
            System.out.println("Collection is empty");
        }
        caller.HistoryAdd("info");
    }

    public String describe() {
        return "Writes information about collection";
    }
}
