package Commands;

import InputManagment.IInput;
import Managment.CollectionManager;
import Managment.CommandReader;
import StartData.HumanBeing;
import OutputManagment.Writer;

import java.io.IOException;
import java.util.Iterator;

public class SaveCommand implements ICommand {
    public void execute(String arg, IInput inpt, CommandReader caller) throws IOException {
        Iterator<HumanBeing> iter = CollectionManager.GetIenerator();
        Writer out = new Writer();
        out.WriteFromIterator(iter,System.getenv("fileName"));
        caller.HistoryAdd("save");
    }
    public String describe()
    {
        return "Writes collection into file";
    }
}
