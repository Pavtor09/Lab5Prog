package Commands;

import Managment.CollectionManager;
import StartData.HumanBeing;
import OutputManagment.Writer;

import java.io.IOException;
import java.util.Iterator;

public class SaveCommand implements ICommand {
    public void execute(String arg) throws IOException {
        Iterator<HumanBeing> iter = CollectionManager.GetIenerator();
        Writer out = new Writer();
        out.WriteFromIterator(iter,"C:\\Users\\PC\\Desktop\\Java.csv");
    }
    public String describe()
    {
        return "Writes collection into file";
    }
}
