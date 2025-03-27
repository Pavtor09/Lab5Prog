package Commands;

import InputManagment.ISeparatedInput;
import Managment.CollectionManager;
import Managment.CommandReader;
import StartData.HumanBeing;

import java.util.Iterator;

public class ShowCommand implements ICommand {

    public void execute(String arg, ISeparatedInput inpt, CommandReader caller) {
        if (CollectionManager.getsize() > 0) {
            Iterator<HumanBeing> iter = CollectionManager.GetIenerator();
            HumanBeing cur = null;
            while (iter.hasNext()) {
                cur = iter.next();
                System.out.println(cur.GetValues());
            }
        } else {
            System.out.println("Collection is empty");
        }
        caller.HistoryAdd("show");
    }

    public String describe() {
        return "prints all collection elements";
    }
}
