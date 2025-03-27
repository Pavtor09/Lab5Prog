package Commands;

import InputManagment.ISeparatedInput;
import InputManagment.InputRequest;
import Managment.*;
import StartData.HumanBeing;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Класс добавления элемента, если он максимальный в коллекции
 */
public class AddIfMaxCommand implements ICommand {

    @Override
    public void execute(String arg, ISeparatedInput inptm, CommandReader caller) throws IOException {

        boolean state = true;
        Iterator<HumanBeing> iter = CollectionManager.GetIenerator();
        OutputManagment output = new OutputManagment(inptm);
        InputRequest request = new InputRequest();
        String[] curCheck = arg.split(" ");
        if (curCheck.length == 12) {
            arg = request.CheckRequest(inptm, Arrays.copyOfRange(curCheck, 1, curCheck.length), new String[]{"Str", "Bool", "Bool", "Impact", "Str", "Long", "DoubleCords", "Weapon", "Mood", "Str", "Bool"}, new String[]{"name can't be null", "RealHero: Boolean can be true or false", "HasToothpick: Boolean can be true or false", "ImpactSeed must be double and less than 647", "Soundtrack name can't be null", "Coordinates first: must be Long", "Coordinates second: must be double and above -275", "theres no such weapon\n" + HumanBeing.WeaponType.PrintWeapons(), "there's no such Mood\n" + HumanBeing.Mood.PrintMood(), "Car first: name can't be null", "Car second: bool can only be true or false"}, 11);
        } else {

            arg = request.CheckRequest(inptm, Arrays.copyOfRange(curCheck, 1, curCheck.length), new String[]{"Str", "Bool", "Bool", "Impact", "Str", "Long", "DoubleCords", "Weapon", "Str", "Bool"}, new String[]{"name can't be null", "RealHero: Boolean can be true or false", "HasToothpick: Boolean can be true or false", "ImpactSeed must be double and less than 647", "Soundtrack name can't be null", "Coordinates first: must be Long", "Coordinates second: must be double and above -275", "theres no such weapon\n" + HumanBeing.WeaponType.PrintWeapons(), "Car first: name can't be null", "Car second: bool can only be true or false"}, 10);
        }
        if (arg != null) {
            String[] Values = arg.split(";");
            while (iter.hasNext()) {
                HumanBeing CurH = iter.next();
                if (CurH.GetImpactSeed() >= Double.parseDouble(Values[3])) {
                    state = false;
                    break;
                }
            }
            if (state) {
                ParseToCollection parser = new ParseToCollection();
                parser.ParseAndAdd(arg);
            } else {
                System.out.println(Values[3] + " is too small");
            }
        } else {
            output.Println("add if command finished");
        }


        caller.HistoryAdd("add_if_max");
    }

    public String describe() {
        return "Adds element if its impact seed is the biggest in the collection. Arguments: String name, Boolean realHero, bool hasToothpick, double impact seed, String soundtrackName, Coordinates(first - long, second - double), weapon type, mood, Car(String name, bool true)";
    }
}
