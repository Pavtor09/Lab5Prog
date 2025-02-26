package Commands;

import InputManagment.IInput;
import Managment.CollectionManager;
import Managment.CommandReader;
import Managment.InputChecker;
import StartData.Car;
import StartData.Coordinates;
import StartData.HumanBeing;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class UpdateCommand implements ICommand {
    public void execute(String inptarg, IInput inpt, CommandReader caller)
    {

        if(InputChecker.ArgCheckEvSep(inptarg," ",1))
        {
            String[] Values = inptarg.split(" ");

            if (Values.length == 13)
            {
                Iterator<HumanBeing> iter = CollectionManager.GetIenerator();
                Set<HumanBeing> TempHumanCollection = new LinkedHashSet<>();
                while (iter.hasNext())
                {
                    HumanBeing cur = iter.next();
                    String[] args = cur.GetValues().split(";");

                    if (args[9].equals(Values[12]))
                    {
                        TempHumanCollection.add(new HumanBeing(Values[1], Values[2].equals("true"), Values[3].equals("true"), Double.parseDouble(Values[4]), Values[5], new Coordinates(Long.parseLong(Values[6]), Double.parseDouble(Values[7])), HumanBeing.WeaponType.valueOf(Values[8]), Values[9].isEmpty() ? null : HumanBeing.Mood.valueOf(Values[9]), new Car(Values[10], Values[11].equals("true")), Long.parseLong(Values[12]), cur.GetTime()));
                    }
                    else
                    {
                        TempHumanCollection.add(cur);
                    }

                }
                CollectionManager.CollectionReplace(TempHumanCollection);
                System.out.println("Element has been updated");

            }
            else
            {
                System.out.println("Wrong number of arguments");
            }


        }
        else
        {
            System.out.println("Wrong arguments");
        }
    }
    public String describe()
    {
        return "Allows you to update element in collection(String name,Boolean realHero, boolean hasToothpick, double impactSeed, String soundtrack, Coordinates, WeaponType, Mood, Car)";
    }
}
