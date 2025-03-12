package InputManagment;

import Managment.ArgumentChecker;
import Managment.InputChecker;
import Managment.OutputManagment;

import java.util.Objects;

public class InputRequest {
//    public String Request(IInput input)
//    {
//    return "";
//    }
//    public String Request(IInput input, String message)
//    {
//    return "";
//    }
    public String Request(IInput input, String message, String[] mod,String[] errors, int amount, String sep, int Invokes)
    {
        IInput missInput = new ConsoleInput();
        ArgumentChecker checker = new ArgumentChecker();
        OutputManagment output = new OutputManagment(input);
        output.Println(message);

        String line = input.NextLine();
        String[] args = line.split(sep);

        if (line.equals("null") || amount != errors.length)
        {
//            System.out.println("Fatal error in method arguments");

            return null;
        }

        if (Invokes == 6)
        {
            output.Println("bruh, you've messed up more than 5 times, I can't handle it");
            return null;
        }
        if (args.length != amount)
        {
//            output.Println("Wrong amount of request arguments");
            InputRequest req = new InputRequest();

            return req.Request (missInput,"wrong amount of arguments \n"+message,mod,errors,amount,sep,Invokes+1);
        }
        if (mod.length != amount)
        {
            output.Println("Wrong amount of request mods");
            return null;
        }

        String curArg = "";
        String ans = "";
        for (int i = 0; i < amount;i++)
        {
            String cmod = mod[i];

            curArg =  checker.CurArgCheck(args[i],cmod,missInput,errors[i],Invokes);

            if (curArg == null)
            {
//                System.out.println("Fatal error in arguments");
                return null;
            }
            ans += curArg+";";
        }
        return ans.substring(0,ans.length()-1);

    }
    public String CheckRequest(IInput input, String[] args,String[] mod, String[] errors, int amount)
    {

        IInput missInput = new ConsoleInput();
        ArgumentChecker checker = new ArgumentChecker();
        OutputManagment output = new OutputManagment(input);




        if (amount != errors.length)
        {
//            System.out.println("Fatal error in method arguments");

            return null;
        }

        if (args.length != amount)
        {
//            output.Println("Wrong amount of request arguments");
            InputRequest req = new InputRequest();
            return req.Request (missInput,"wrong amount of arguments \n",mod,errors,amount," ",1);
        }
        if (mod.length != amount)
        {
            output.Println("Wrong amount of request mods");
            return null;
        }

        String curArg = "";
        String ans = "";
        for (int i = 0; i < amount;i++)
        {
            String cmod = mod[i];

            curArg =  checker.CurArgCheck(args[i],cmod,missInput,errors[i],1);

            if (curArg == null)
            {
//                System.out.println("Fatal error in arguments");
                return null;
            }
            ans += curArg+";";
        }
        return ans.substring(0,ans.length()-1);
    }
}
