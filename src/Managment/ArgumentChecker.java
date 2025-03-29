package Managment;

import InputManagment.ISeparatedInput;
import InputManagment.InputRequest;
import StartData.HumanBeing;

/*Класс проверяющий ввод на соответствие типам данных. Создаёт запросы на повторный ввод при нахождении ошибки*/
public class ArgumentChecker {
    public String CurArgCheck(String arg, String mod, ISeparatedInput inpt, String errorMessage, int Invokes) {
        InputRequest req = new InputRequest();

        switch (mod) {
            case ("Int"):
                try {
                    Integer.parseInt(arg);
                } catch (Exception e) {
                    arg = req.Request(inpt, errorMessage, new String[]{mod}, new String[]{errorMessage}, 1, " ", Invokes + 1);
                }
                break;
            case ("Double"):
                try {
                    Double.parseDouble(arg);
                } catch (Exception e) {
                    arg = req.Request(inpt, errorMessage, new String[]{mod}, new String[]{errorMessage}, 1, " ", Invokes + 1);
                }
                break;
            case ("Long"):
                try {
                    Long.parseLong(arg);
                } catch (Exception e) {

                    arg = req.Request(inpt, errorMessage, new String[]{mod}, new String[]{errorMessage}, 1, " ", Invokes + 1);
                }
                break;
            case ("Bool"),("-realHero"),("-hasToothpick"):
                if (!(arg.equals("true") || arg.equals("false"))) {
                    arg = req.Request(inpt, errorMessage, new String[]{mod}, new String[]{errorMessage}, 1, " ", Invokes + 1);

                }
                break;
            case ("Weapon"),("-weapon"):
                try {
                    HumanBeing.WeaponType.valueOf(arg);
                } catch (Exception e) {
                    System.out.println(HumanBeing.WeaponType.PrintWeapons());
                    arg = req.Request(inpt, errorMessage, new String[]{mod}, new String[]{errorMessage}, 1, " ", Invokes + 1);
                }
                break;
            case ("Mood"),("-mood"):
                if (!arg.isEmpty()) {
                    try {
                        HumanBeing.Mood.valueOf(arg);
                    } catch (Exception e) {
                        arg = req.Request(inpt, errorMessage, new String[]{mod}, new String[]{errorMessage}, 1, " ", Invokes + 1);
                    }
                }
                break;
            case ("Impact"),("-impactSeed"):
                try {
                    Double.parseDouble(arg);
                } catch (Exception e) {
                    arg = req.Request(inpt, errorMessage, new String[]{mod}, new String[]{errorMessage}, 1, " ", Invokes + 1);
                }
                if (arg != null) {
                    double temp = Double.parseDouble(arg);
                    if (temp > 646) {
                        arg = req.Request(inpt, errorMessage, new String[]{mod}, new String[]{errorMessage}, 1, " ", Invokes + 1);
                    }
                }
                break;
            case ("Str"),("-name"),("-soundtrackName"):
                if (arg.isEmpty()) {
                    arg = req.Request(inpt, errorMessage, new String[]{mod}, new String[]{errorMessage}, 1, " ", Invokes + 1);

                }
                break;
            case ("DoubleCords"):
                try {
                    Double.parseDouble(arg);
                } catch (Exception e) {
                    arg = req.Request(inpt, errorMessage, new String[]{mod}, new String[]{errorMessage}, 1, " ", Invokes + 1);
                }
                if (arg != null) {

                    double temp = Double.parseDouble(arg.replaceAll(" ", "").replaceAll("\n", "").replaceAll("\t", ""));
                    if (temp <= -275) {
                        arg = req.Request(inpt, errorMessage, new String[]{mod}, new String[]{errorMessage}, 1, " ", Invokes + 1);
                    }
                }
                break;
            case ("Id"):
                try {
                    Long.parseLong(arg);
                } catch (Exception e) {

                    arg = req.Request(inpt, errorMessage, new String[]{mod}, new String[]{errorMessage}, 1, " ", Invokes + 1);
                }
                if (arg != null) {
                    long temp = Long.parseLong(arg);
                    if (temp <= 0) {
                        arg = req.Request(inpt, errorMessage, new String[]{mod}, new String[]{errorMessage}, 1, " ", Invokes + 1);
                    }
                }
                break;
            case ("coordinates"):
                String[] cords = arg.split(" ");
                try {
                    Long.parseLong(cords[0]);
                } catch (Exception e) {

                    cords[0] = req.Request(inpt, errorMessage, new String[]{mod}, new String[]{errorMessage}, 1, " ", Invokes + 1);
                }


                try {
                    Double.parseDouble(cords[1]);
                } catch (Exception e) {
                    cords[1] = req.Request(inpt, errorMessage, new String[]{mod}, new String[]{errorMessage}, 1, " ", Invokes + 1);
                }
                if (cords[1] != null) {

                    double temp = Double.parseDouble(cords[1].replaceAll(" ", "").replaceAll("\n", "").replaceAll("\t", ""));
                    if (temp <= -275) {
                        cords[1] = req.Request(inpt, errorMessage, new String[]{mod}, new String[]{errorMessage}, 1, " ", Invokes + 1);
                    }
                }
                arg = cords[0]+" "+cords[1];
                break;



        }

        return arg;
    }

}
