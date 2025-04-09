package Commands;

import InputManagment.ISeparatedInput;
import InputManagment.InputRequest;
import Managment.CollectionManager;
import Managment.CommandReader;
import Managment.OutputManagment;
import StartData.Car;
import StartData.Coordinates;
import StartData.HumanBeing;

import java.util.*;

public class UpdateCommand implements ICommand {
    public void execute(String arg, ISeparatedInput inpt, CommandReader caller) {


        HashMap<String, String> ValueMap = new HashMap<>();
        OutputManagment output = new OutputManagment(inpt);
        String[] curCheck = arg.split(" ");
        InputRequest request = new InputRequest();
        String[] args = arg.split(" ");
        ArrayList<String> argValues = new ArrayList<>();
        ArrayList<String> keyValues = new ArrayList<>();
        String curValue = "";
        String[] order = {"-name", "-realHero", "-hasToothpick", "-impactSeed", "-soundtrackName", "-coordinates", "-weapon", "-mood", "-car", "-id", "-time"};

        if (args.length >= 3) {
            String id = request.CheckRequest(inpt, new String[]{args[1]}, new String[]{"Long"}, new String[]{"Id must be long"}, 1);
            if (id != null) {

                Iterator<HumanBeing> iter = CollectionManager.GetIenerator();
                Set<HumanBeing> TempHumanCollection = new LinkedHashSet<>();
                boolean found = false;
                HumanBeing changeHuman = null;
                while (iter.hasNext()) {
                    changeHuman = iter.next();
                    if ((changeHuman.GetId() == Long.parseLong(id))) {
                        String Vals = changeHuman.GetValues();
                        String[] ValsToSave = Vals.split(";");
                        ValueMap.put("-name", ValsToSave[0]);
                        ValueMap.put("-realHero", ValsToSave[1]);
                        ValueMap.put("-hasToothpick", ValsToSave[2]);
                        ValueMap.put("-impactSeed", ValsToSave[3]);
                        ValueMap.put("-soundtrackName", ValsToSave[4]);
                        ValueMap.put("-coordinates", ValsToSave[5]);
                        ValueMap.put("-weapon", ValsToSave[6]);
                        ValueMap.put("-mood", ValsToSave[7]);
                        ValueMap.put("-car", ValsToSave[8]);
                        ValueMap.put("-id", ValsToSave[9]);
                        ValueMap.put("-time", ValsToSave[10]);
                        found = true;
                        break;
                    }
                    TempHumanCollection.add(changeHuman);
                }
                if (found) {


                    int writeArgIndex = -1;
                    for (String cur : Arrays.copyOfRange(args, 2, args.length)) {
                        if (cur.matches("-.*")) {
                            if (writeArgIndex >= 0) {
                                argValues.add(curValue.trim());
                                curValue = "";
                            }
                            writeArgIndex += 1;
                            keyValues.add(cur);

                        } else {
                            if (writeArgIndex >= 0) {
                                curValue += cur + " ";
                            }
                        }
                    }
                    argValues.add(curValue.trim());
                    boolean breakflag = false;
                    for (int i = 0; i < keyValues.size(); i++) {
                        argValues.set(i, request.CheckRequest(inpt, new String[]{argValues.get(i)}, new String[]{keyValues.get(i)}, new String[]{"error at flag " + keyValues.get(i) + ",enter the correct value or enter 'null' to exit"}, 1));
                        if (argValues.get(i) == null && keyValues.get(i).equals("-mood")) {
                            breakflag = true;
                            break;
                        }
                        ValueMap.replace(keyValues.get(i), argValues.get(i));
                    }
                    StringBuilder res = new StringBuilder();
                    if (!breakflag) {

                        for (int i = 0; i < order.length; i++) {
                            res.append(ValueMap.get(order[i])).append((i != order.length - 1) ? ";" : "");
                        }
                        String[] Values = res.toString().replaceAll(" ", ";").split(";");
                        System.out.println(res);
                        TempHumanCollection.add(new HumanBeing(Values[0], Values[1].equals("true"), Values[2].equals("true"), Double.parseDouble(Values[3]), Values[4], new Coordinates(Long.parseLong(Values[5]), Double.parseDouble(Values[6])), HumanBeing.WeaponType.valueOf(Values[7]), (Values[8].isEmpty() || Values[8].equals("null")) ? null : HumanBeing.Mood.valueOf(Values[8]), new Car(Values[9], Values[10].equals("true")), Long.parseLong(Values[11]), changeHuman.GetTime()));
                        while (iter.hasNext()) {
                            changeHuman = iter.next();
                            TempHumanCollection.add(changeHuman);
                        }

                        CollectionManager.CollectionReplace(TempHumanCollection);


                    }
                } else {
                    output.Println("There's no element with such id");
                }
            } else {
                output.Println("Update command finished");
            }
        } else {
            output.Println("Not enough arguments");
        }
//        if (curCheck.length == 13) {
//            arg = request.CheckRequest(inpt, Arrays.copyOfRange(curCheck, 1, curCheck.length), new String[]{"Str", "Bool", "Bool", "Impact", "Str", "Long", "DoubleCords", "Weapon", "Mood", "Str", "Bool", "Id"}, new String[]{"name can't be null", "RealHero: Boolean can be true or false", "HasToothpick: Boolean can be true or false", "ImpactSeed must be double and less than 647", "Soundtrack name can't be null", "Coordinates first: must be Long", "Coordinates second: must be double and above -275", "theres no such weapon\n" + HumanBeing.WeaponType.PrintWeapons(), "there's no such Mood\n" + HumanBeing.Mood.PrintMood(), "Car first: name can't be null", "Car second: bool can only be true or false", "Id must be Long and more than 0"}, 12);
//        } else {
//            arg = request.CheckRequest(inpt, Arrays.copyOfRange(curCheck, 1, curCheck.length), new String[]{"Str", "Bool", "Bool", "Impact", "Str", "Long", "DoubleCords", "Weapon", "Str", "Bool", "Id"}, new String[]{"name can't be null", "RealHero: Boolean can be true or false", "HasToothpick: Boolean can be true or false", "ImpactSeed must be double and less than 647", "Soundtrack name can't be null", "Coordinates first: must be Long", "Coordinates second: must be double and above -275", "theres no such weapon\n" + HumanBeing.WeaponType.PrintWeapons(), "Car first: name can't be null", "Car second: bool can only be true or false", "Id must be Long and more than 0"}, 11);
//
//        }
//        if (arg != null) {
//            String[] Values = arg.split(";");
//
//            Iterator<HumanBeing> iter = CollectionManager.GetIenerator();
//            Set<HumanBeing> TempHumanCollection = new LinkedHashSet<>();
//            boolean updated = false;
//            while (iter.hasNext()) {
//                HumanBeing cur = iter.next();
//                String[] args = cur.GetValues().split(";");
//
//                if (args[9].equals(Values[Values.length - 1])) {
//                    if (Values.length == 12) {
//                        TempHumanCollection.add(new HumanBeing(Values[0], Values[1].equals("true"), Values[2].equals("true"), Double.parseDouble(Values[3]), Values[4], new Coordinates(Long.parseLong(Values[5]), Double.parseDouble(Values[6])), HumanBeing.WeaponType.valueOf(Values[7]), Values[8].isEmpty() ? null : HumanBeing.Mood.valueOf(Values[8]), new Car(Values[9], Values[10].equals("true")), Long.parseLong(Values[11]), cur.GetTime()));
//                    } else {
//                        TempHumanCollection.add(new HumanBeing(Values[0], Values[1].equals("true"), Values[2].equals("true"), Double.parseDouble(Values[3]), Values[4], new Coordinates(Long.parseLong(Values[5]), Double.parseDouble(Values[6])), HumanBeing.WeaponType.valueOf(Values[7]), null, new Car(Values[8], Values[9].equals("true")), Long.parseLong(Values[10]), cur.GetTime()));
//
//                    }
//                    updated = true;
//                } else {
//                    TempHumanCollection.add(cur);
//                }
//
//            }
//            CollectionManager.CollectionReplace(TempHumanCollection);
//            if (updated) {
//                output.Println("Element has been updated");
//            } else {
//                output.Println("there's no element with such id");
//            }
//
//
//        } else {
//            output.Println("Update command finished");
//        }
        caller.HistoryAdd("update");
    }

    public String describe() {
        return "Allows you to update element in collection(String name,Boolean realHero, boolean hasToothpick, double impactSeed, String soundtrack, Coordinates, WeaponType, Mood, Car)";
    }
}
