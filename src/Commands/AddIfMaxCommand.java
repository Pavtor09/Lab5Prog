package Commands;

import InputManagment.IInput;
import Managment.CollectionManager;
import Managment.CommandReader;
import Managment.InputChecker;
import StartData.Car;
import StartData.Coordinates;
import StartData.HumanBeing;

import javax.print.DocFlavor;
import java.io.IOException;
import java.util.Iterator;

public class AddIfMaxCommand implements ICommand{

    @Override
    public void execute(String arg, IInput inptm, CommandReader caller) throws IOException {
        String[] Values = arg.split(" ");
        boolean state = true;
        Iterator<HumanBeing> iter = CollectionManager.GetIenerator();
//        System.out.println(arg);
        if (InputChecker.ArgCheckEvSep(arg," ",1,12))
        {
            while(iter.hasNext())
            {
                HumanBeing CurH = iter.next();
                if (CurH.GetImpactSeed() >= Double.parseDouble(Values[4]))
                {
                    state = false;
                }
            }
            if (state)
            {
                CollectionManager.Add(Values[1], Values[2].equals("true"), Values[3].equals("true"), Double.parseDouble(Values[4]), Values[5], new Coordinates(Long.parseLong(Values[6]), Double.parseDouble(Values[7])), HumanBeing.WeaponType.valueOf(Values[8]), Values[9].isEmpty() ? null : HumanBeing.Mood.valueOf(Values[9]), new Car(Values[10], Values[11].equals("true")));
            }
            else{
                System.out.println(Values[4]+" is too small");
            }
        }
        else {
            System.out.println("WRONG");
        }
        caller.HistoryAdd("add_if_max");
    }

    public String describe()
    {
        return "Adds element if its impact seed is biggest in the collection";
    }
}
