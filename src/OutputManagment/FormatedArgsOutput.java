package OutputManagment;

public class FormatedArgsOutput {
    public void AllArgOutput(String toOut,int element)
    {
        if (element != 0)
        {
        System.out.println("\n####################################### element"+element);
        }
        String[] elementArgs = toOut.split(";");
        System.out.println("name = "+elementArgs[0]);
        System.out.println("realHero = "+elementArgs[1]);
        System.out.println("hasToothpick = "+elementArgs[2]);
        System.out.println("impactSeed = "+elementArgs[3]);
        System.out.println("soundtrack name = "+elementArgs[4]);
        System.out.println("coordinates = "+elementArgs[5]);
        System.out.println("weapon = "+elementArgs[6]);
        System.out.println("mood = "+elementArgs[7]);
        System.out.println("car = "+elementArgs[8]);
        System.out.println("id = "+elementArgs[9]);
        String formatedTime = elementArgs[10].replaceAll("[.].*","").replaceAll("-",".").replaceAll("T"," ");
        System.out.println("time = "+formatedTime);

    }

    public void AllArgOutput(String toOut)
    {
       AllArgOutput(toOut,0);
    }
}
