package Commands;
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

    public void execute(String arg)
    {
//        System.out.println("Enter parameters: String name, Boolean realHero, boolean HasToothPick, Double ImpactSeed(max 646), String Soundtrack");
        Scanner sc = new Scanner(System.in);
          String line = arg;
            System.out.println("Enter coordinates(First number must be long, second - double)");
            line = sc.nextLine();
            arg = arg.replaceAll(" ",";");
            arg += ";"+line;

            System.out.println("Enter weapon type");
            HumanBeing.WeaponType.PrintWeapons();
            line = sc.nextLine();
            arg += ";"+line;

            System.out.println("Enter Mood");
            HumanBeing.Mood.PrintMood();
            line = sc.nextLine();
            arg += ";"+line;

            System.out.println("Enter car(String name Boolean cool)");
            line = sc.nextLine();
            arg+= ";"+line;


        if (InputChecker.ArgCheck(arg,";",1))
        {

            Convert(arg);
            CollectionManager.Add(name,realHero,hasToothPick,impactSeed,soundtrack,cords,weaponType,mood,car);
        }
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
}
