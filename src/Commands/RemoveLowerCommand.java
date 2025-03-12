package Commands;

import InputManagment.IInput;
import InputManagment.InputRequest;
import Managment.*;
import StartData.HumanBeing;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveLowerCommand implements ICommand {


    public void execute(String arg, IInput inptm, CommandReader caller) throws IOException {
        String[] Args = arg.split(" ");
        OutputManagment output = new OutputManagment(inptm);
        ArgumentChecker checker = new ArgumentChecker();
        if (Args.length != 2)
        {
            output.Println("Wring number of arguments");
        }
        else {
            String strid = checker.CurArgCheck(Args[1],"Id",inptm,"Id must be Long and above 0",0);

            if (strid != null)
            {
                Set<HumanBeing> TempHumanCollection = new LinkedHashSet<>();
                long id = Long.parseLong(strid);
                Iterator<HumanBeing> iter = CollectionManager.GetIenerator();
                while (iter.hasNext())
                {
                    HumanBeing curHuman = iter.next();
                    if (curHuman.GetId() > id)
                    {
                        TempHumanCollection.add(curHuman);
                    }
                }
                CollectionManager.CollectionReplace(TempHumanCollection);
                output.Println("Finished successfully");
            }
            else {
                output.Println("Remove Lower Command finished");
            }
        }
        caller.HistoryAdd("remove_lower");
    }


    public String describe() {
        return "";
    }
}
