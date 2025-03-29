package Commands;

import InputManagment.ISeparatedInput;
import Managment.CollectionManager;
import Managment.CommandReader;
import Managment.OutputManagment;
import OutputManagment.FormatedArgsOutput;
import StartData.HumanBeing;

import java.util.Iterator;

public class ShowCommand implements ICommand {

    public void execute(String arg, ISeparatedInput inpt, CommandReader caller) {
        int elementIndex = 0;
        String[] args = arg.split(" ");
        int mod = 1;
        if (args.length > 1) {
            if (args[1].equals("-raw")) {
                mod = 0;
            }
        }
        FormatedArgsOutput out = new FormatedArgsOutput();
        OutputManagment rawOutput = new OutputManagment(inpt);
        if (CollectionManager.getsize() > 0) {
            Iterator<HumanBeing> iter = CollectionManager.GetIenerator();
            HumanBeing cur = null;
            while (iter.hasNext()) {
                cur = iter.next();
                elementIndex += 1;
                if (mod == 1) {
                    out.AllArgOutput(cur.GetValues(), elementIndex);
                }
                if (mod == 0)
                {
                    rawOutput.Println(cur.GetValues());
                }

            }
        } else {
            System.out.println("Collection is empty");
        }
        caller.HistoryAdd("show");
    }

    public String describe() {
        return "prints all collection elements";
    }
}
