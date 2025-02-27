package Commands;
import InputManagment.IInput;
import  Managment.*;
import StartData.Car;
import StartData.Coordinates;
import StartData.HumanBeing;

import java.util.Scanner;
import java.util.concurrent.TimeoutException;

public class AddCommand implements ICommand{
    String name;
    Boolean realHero;
    boolean hasToothPick;
    double impactSeed;
    String soundtrack;
    Coordinates cords;
    HumanBeing.WeaponType weaponType;
    HumanBeing.Mood mood;
    Car car;
    IInput inpt = null;
    public void execute(String arg,IInput inpt,CommandReader caller)
    {
        this.inpt = inpt;
//        System.out.println("Enter parameters: String name, Boolean realHero, boolean HasToothPick, Double ImpactSeed(max 646), String Soundtrack");
//        Scanner sc = new Scanner(System.in);
//        System.out.println(arg);

        String line = arg.replaceAll("\r","");
        Println("Enter coordinates(First number must be long, second - double)");
        line = inpt.NextLine();


        arg = arg.replaceAll(" ",";");
        arg = arg.replaceAll("\r","");
        arg += ";"+line.replaceAll("\r","");
//        System.out.println(arg);

        Println("Enter weapon type");
        Println(HumanBeing.WeaponType.PrintWeapons());
        line = inpt.NextLine();
        arg += ";"+line.replaceAll("\r","");
//        System.out.println(arg);


        Println("Enter Mood");
        Println(HumanBeing.Mood.PrintMood());
        line = inpt.NextLine();
        arg += ";"+line.replaceAll("\r","");
//        System.out.println(arg);


        Println("Enter car(String name Boolean cool)");
        line = inpt.NextLine();
        arg+= ";"+line.replaceAll("\r","");
//        System.out.println(arg);



        if (InputChecker.ArgCheck(arg,";",1))
        {
            arg = arg.replaceAll("; ",";").replaceAll(" ;","").replaceAll(" *$","");
            Convert(arg);
            CollectionManager.Add(name,realHero,hasToothPick,impactSeed,soundtrack,cords,weaponType,mood,car);
        }
        caller.HistoryAdd("add");
    }

    @Override
    public String describe() {
        return "Adds new element to HumanBeing LinkedHashSet. Input parameters: String name,Coordinates coordinates(Enter x=... y=...), Boolean realHero, boolean HasToothPick,Double ImpacktSeed(max 646), String Soundtrack, WeaponType weaponType, Mood mood(field can be null, write 0 or null), ";
    }
    private void Convert(String arg)
    {
        String[] Arguments = arg.split(";");

        this.name = Arguments[1];
        this.realHero = Arguments[2].equals("true");
        this.hasToothPick = Arguments[3].equals("true");
        this.impactSeed = Double.parseDouble(Arguments[4]);
        this.soundtrack = Arguments[5];
        String[] cur = Arguments[6].split(" ");
        this.cords = new Coordinates(Long.parseLong(cur[0]),Double.parseDouble(cur[1]));
        this.weaponType = HumanBeing.WeaponType.valueOf(Arguments[7]);
        if (!Arguments[8].isEmpty())
        {
            this.mood = HumanBeing.Mood.valueOf(Arguments[8]);
        }
        cur = Arguments[9].split(" ");
        this.car = new Car(cur[0],cur[1].equals("true"));

    }
    private void Println(String outstr)
    {
        if (inpt.RequiresOutput())
        {
            System.out.println(outstr);
        }
    }
}
