package Commands;

import InputManagment.ISeparatedInput;
import InputManagment.InputRequest;
import Managment.CollectionManager;
import Managment.CommandReader;
import Managment.OutputManagment;
import StartData.Car;
import StartData.Coordinates;
import StartData.HumanBeing;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class UpdateCommand implements ICommand {
    public void execute(String arg, ISeparatedInput inpt, CommandReader caller) {
        OutputManagment output = new OutputManagment(inpt);
        String[] curCheck = arg.split(" ");
        InputRequest request = new InputRequest();
        if (curCheck.length == 13) {
            arg = request.CheckRequest(inpt, Arrays.copyOfRange(curCheck, 1, curCheck.length), new String[]{"Str", "Bool", "Bool", "Impact", "Str", "Long", "DoubleCords", "Weapon", "Mood", "Str", "Bool", "Id"}, new String[]{"name can't be null", "RealHero: Boolean can be true or false", "HasToothpick: Boolean can be true or false", "ImpactSeed must be double and less than 647", "Soundtrack name can't be null", "Coordinates first: must be Long", "Coordinates second: must be double and above -275", "theres no such weapon\n" + HumanBeing.WeaponType.PrintWeapons(), "there's no such Mood\n" + HumanBeing.Mood.PrintMood(), "Car first: name can't be null", "Car second: bool can only be true or false", "Id must be Long and more than 0"}, 12);
        } else {
            arg = request.CheckRequest(inpt, Arrays.copyOfRange(curCheck, 1, curCheck.length), new String[]{"Str", "Bool", "Bool", "Impact", "Str", "Long", "DoubleCords", "Weapon", "Str", "Bool", "Id"}, new String[]{"name can't be null", "RealHero: Boolean can be true or false", "HasToothpick: Boolean can be true or false", "ImpactSeed must be double and less than 647", "Soundtrack name can't be null", "Coordinates first: must be Long", "Coordinates second: must be double and above -275", "theres no such weapon\n" + HumanBeing.WeaponType.PrintWeapons(), "Car first: name can't be null", "Car second: bool can only be true or false", "Id must be Long and more than 0"}, 11);

        }
        if (arg != null) {
            String[] Values = arg.split(";");

            Iterator<HumanBeing> iter = CollectionManager.GetIenerator();
            Set<HumanBeing> TempHumanCollection = new LinkedHashSet<>();
            boolean updated = false;
            while (iter.hasNext()) {
                HumanBeing cur = iter.next();
                String[] args = cur.GetValues().split(";");

                if (args[9].equals(Values[Values.length - 1])) {
                    if (Values.length == 12) {
                        TempHumanCollection.add(new HumanBeing(Values[0], Values[1].equals("true"), Values[2].equals("true"), Double.parseDouble(Values[3]), Values[4], new Coordinates(Long.parseLong(Values[5]), Double.parseDouble(Values[6])), HumanBeing.WeaponType.valueOf(Values[7]), Values[8].isEmpty() ? null : HumanBeing.Mood.valueOf(Values[8]), new Car(Values[9], Values[10].equals("true")), Long.parseLong(Values[11]), cur.GetTime()));
                    } else {
                        TempHumanCollection.add(new HumanBeing(Values[0], Values[1].equals("true"), Values[2].equals("true"), Double.parseDouble(Values[3]), Values[4], new Coordinates(Long.parseLong(Values[5]), Double.parseDouble(Values[6])), HumanBeing.WeaponType.valueOf(Values[7]), null, new Car(Values[8], Values[9].equals("true")), Long.parseLong(Values[10]), cur.GetTime()));

                    }
                    updated = true;
                } else {
                    TempHumanCollection.add(cur);
                }

            }
            CollectionManager.CollectionReplace(TempHumanCollection);
            if (updated) {
                output.Println("Element has been updated");
            } else {
                output.Println("there's no element with such id");
            }


        } else {
            output.Println("Update command finished");
        }
        caller.HistoryAdd("update");
    }

    public String describe() {
        return "Allows you to update element in collection(String name,Boolean realHero, boolean hasToothpick, double impactSeed, String soundtrack, Coordinates, WeaponType, Mood, Car)";
    }
}
