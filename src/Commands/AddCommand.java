package Commands;
import  Managment.*;

import java.util.Scanner;
import java.util.concurrent.TimeoutException;

public class AddCommand implements ICommand{
    String name;
    Boolean realHero;
    boolean hasToothPick;
    double impactSeed;
    String soundtrack;
    public void execute(String arg)
    {
        System.out.println("Enter parameters: String name, Boolean realHero, boolean HasToothPick, Double ImpactSeed(max 646), String Soundtrack");
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        FieldSpread(line);
        System.out.println("Enter coordinates");

        long id =0;
    }

    @Override
    public String describe() {
        return "Adds new element to HumanBeing LinkedHashSet. Input parameters: String name,Coordinates coordinates(Enter x=... y=...), Boolean realHero, boolean HasToothPick,Double ImpacktSeed(max 646), String Soundtrack, WeaponType weaponType, Mood mood(field can be null, write 0 or null), ";
    }
    void FieldSpread(String line)
    {

        String[] tokens = line.split(" ");
        this.name = tokens[0];
        this.realHero = (tokens[1] == "true");
        this.hasToothPick = (tokens[2]=="true");
        this.impactSeed = Double.parseDouble(tokens[3]);
        this.soundtrack = tokens[4];
//        try{ CollectionManager.Add();}
//        catch();


    }
}
