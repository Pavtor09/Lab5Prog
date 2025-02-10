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
//        System.out.println("Enter parameters: String name, Boolean realHero, boolean HasToothPick, Double ImpactSeed(max 646), String Soundtrack");
        Scanner sc = new Scanner(System.in);
          String line = arg;

        if (FieldSpread(line))
        {
            System.out.println("Enter coordinates(first number must be long, second - double)");
            line = sc.nextLine();
            String[] words = line.split(" ");
            if (words.length == 2 && Numcheck(words[0]) && Numcheck(words[1])) {
                cords = new Coordinates(Long.parseLong(words[0]),Double.parseDouble(words[1]));
                System.out.println("Enter weapon type");
//                System.out.println(HumanBeing.WeaponType.values());
            }
            else{
                System.out.println("Coordinates must be Long and Double");
            }
        }


    }

    @Override
    public String describe() {
        return "Adds new element to HumanBeing LinkedHashSet. Input parameters: String name,Coordinates coordinates(Enter x=... y=...), Boolean realHero, boolean HasToothPick,Double ImpacktSeed(max 646), String Soundtrack, WeaponType weaponType, Mood mood(field can be null, write 0 or null), ";
    }


    boolean FieldSpread(String line)
    {   String[] tokens = line.split(" ");
        if (tokens.length == 5){



            if(Numcheck(tokens[3])) {
                this.impactSeed = Double.parseDouble(tokens[3]);
                if (this.impactSeed <= 646)
                {
                    this.name = tokens[0];
                    this.realHero = (tokens[1].equals("true"));
                    this.hasToothPick = (tokens[2].equals("true"));

                    this.soundtrack = tokens[4];
                    return true;
                }
                else{
                    System.out.println("ImpactSeed must be under 647");
                    return false;
                }

            }
            else{
                System.out.println("Fourth argument must be double");
                return false;
            }
        }
        else {
            System.out.println("Wrong amount of arguments");
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
