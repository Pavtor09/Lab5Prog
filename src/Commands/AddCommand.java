package Commands;
import  Managment.*;
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
    HumanBeing.Car car;

    public void execute(String arg)
    {
        System.out.println("Enter parameters: String name, Boolean realHero, boolean HasToothPick, Double ImpactSeed(max 646), String Soundtrack");
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        if (FieldSpread(line))
        { System.out.println("Enter coordinates");
        line = sc.nextLine();
        String[] words = line.split(" ");
        cords = new Coordinates(Long.parseLong(words[0]),Double.parseDouble(words[1]));}

        long id =0;
    }

    @Override
    public String describe() {
        return "Adds new element to HumanBeing LinkedHashSet. Input parameters: String name,Coordinates coordinates(Enter x=... y=...), Boolean realHero, boolean HasToothPick,Double ImpacktSeed(max 646), String Soundtrack, WeaponType weaponType, Mood mood(field can be null, write 0 or null), ";
    }
    boolean FieldSpread(String line)
    {   String[] tokens = line.split(" ");
        if (tokens.length == 5){



            if(Numcheck(tokens[3])) {
                this.name = tokens[0];
                this.realHero = (tokens[1].equals("true"));
                this.hasToothPick = (tokens[2].equals("true"));
                this.impactSeed = Double.parseDouble(tokens[3]);
                this.soundtrack = tokens[4];
                return true;
            }

            else{
                System.out.println("Fourth argument must be double");
                return false;
            }
        }
        else {
            System.out.println("Wrong number of arguments");
            return false;
        }


    }

    boolean Numcheck(String str)
    {
        for(int i = 0;i < str.length();i++)
        {
            if (!Character.isDigit(str.charAt(i)))
            {
                return false;
            }
        }
        return true;
    }
}
