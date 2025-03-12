package InputManagment;

import java.util.Scanner;

public class ConsoleInput implements IInput{
    Scanner sc = null;
    private boolean reqOut = true;
    public ConsoleInput()
    {
        sc = new Scanner(System.in);
    }
    public String NextLine()
    {
        return sc.nextLine().replaceAll("\n","").replaceAll("\t","");
    }
    public boolean HasNext()
    {
     return sc.hasNext();
    }
    public boolean RequiresOutput()
    {
        return reqOut;
    }

}
