package InputManagment;

import Managment.ArgumentChecker;
import Managment.OutputManagment;

/**
 * Касс создания запросов на ввод и проверку
 */
public class InputRequest {
    /* метод обращается к классу ввода, откуда он берёт значения, затем, он обращается к классу проверки, в котором, если возникла ошибка, создаётся ещё один запрос, в котором просится заново ввести неправильные данные*/
    public String Request(ISeparatedInput input, String message, String[] mod, String[] errors, int amount, String sep, int Invokes) {
        ISeparatedInput missInput = new ConsoleSeparatedInput();
        ArgumentChecker checker = new ArgumentChecker();
        OutputManagment output = new OutputManagment(input);
        output.Println(message);

        String line = input.NextLine();
        String[] args;
        try {
            args = line.split(sep);
        } catch (Exception e) {
            return null;
        }

        if (line.equals("null") || amount != errors.length) {
//            System.out.println("Fatal error in method arguments");

            return null;
        }

        if (Invokes == 6) {
            output.Println("bruh, you've messed up more than 5 times, I can't handle it");
            return null;
        }
        if (args.length != amount) {
//            output.Println("Wrong amount of request arguments");
            InputRequest req = new InputRequest();
            output.Println("wrong amount of arguments");
            return req.Request(missInput,message, mod, errors, amount, sep, Invokes + 1);
        }
        if (mod.length != amount) {
            output.Println("Wrong amount of request mods");
            return null;
        }

        String curArg = "";
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < amount; i++) {
            String cmod = mod[i];

            curArg = checker.CurArgCheck(args[i], cmod, missInput, errors[i], Invokes);

            if (curArg == null) {
//                System.out.println("Fatal error in arguments");
                return null;
            }
            ans.append(curArg).append(";");
        }
        return ans.substring(0, ans.length() - 1);

    }

    //Передаёт уже имеющиеся данные на проверку, в остальном идентичен методу CheckRequest. Удобен для ввода в одну строку
    public String CheckRequest(ISeparatedInput input, String[] args, String[] mod, String[] errors, int amount) {

        ISeparatedInput missInput = new ConsoleSeparatedInput();
        ArgumentChecker checker = new ArgumentChecker();
        OutputManagment output = new OutputManagment(input);


        if (amount != errors.length) {
//            System.out.println("Fatal error in method arguments");

            return null;
        }

        if (args.length != amount) {
//            output.Println("Wrong amount of request arguments");
            InputRequest req = new InputRequest();
            return req.Request(missInput, "wrong amount of arguments \n", mod, errors, amount, " ", 1);
        }
        if (mod.length != amount) {
            output.Println("Wrong amount of request mods");
            return null;
        }

        String curArg = "";
        String ans = "";
        for (int i = 0; i < amount; i++) {
            String cmod = mod[i];

            curArg = checker.CurArgCheck(args[i], cmod, missInput, errors[i], 1);

            if (curArg == null) {
//                System.out.println("Fatal error in arguments");
                return null;
            }
            ans += curArg + ";";
        }
        return ans.substring(0, ans.length() - 1);
    }
}
