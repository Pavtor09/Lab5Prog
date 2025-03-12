package Commands;
import InputManagment.IInput;
import InputManagment.InputRequest;
import  Managment.*;
import StartData.Car;
import StartData.Coordinates;
import StartData.HumanBeing;

import java.util.Arrays;
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
        OutputManagment output = new OutputManagment(inpt);
        InputRequest request = new InputRequest();
        ArgumentChecker checker = new ArgumentChecker();
        this.inpt = inpt;
        String[] curCheck = arg.split(" ");
        String resStr = "";

        resStr +=  request.CheckRequest(inpt, Arrays.copyOfRange(curCheck,1,curCheck.length),new String[]{"Str","Bool","Bool","Impact","Str"},new String[]{"name can't be null","RealHero: Boolean can be true or false","HasToothpick: Boolean can be true or false","ImpactSeed must be double and less than 647","Soundtrack name can't be null"},5);

        String line = "";
        resStr += ";"+request.Request(inpt,"Enter coordinates(First number must be long, second - double)",new String[]{"Long","DoubleCords"}, new String[]{"First coordinate must be long","Second coordinate must be double and more than -275"},2," ",0);

        resStr += ";"+request.Request(inpt,"Enter weaponType\n"+HumanBeing.WeaponType.PrintWeapons(),new String[]{"Weapon"},new String[]{"Type of weapon is worng\n"+HumanBeing.WeaponType.PrintWeapons()},1," ",0);

        resStr += ";"+request.Request(inpt,"Enter Mood\n"+HumanBeing.Mood.PrintMood(),new String[]{"Mood"},new String[]{"There's no such mood"},1," ",0);

        resStr += ";"+request.Request(inpt,"Enter Car first - string, second - bool",new String[] {"Str","Bool"},new String[]{"Car name:String can't be empty","Cool: Bool can be true or false"},2," ",0);

        System.out.println(resStr);
        ParceToCollection parser = new ParceToCollection();
        parser.ParceAndAdd(resStr);

        caller.HistoryAdd("add");
    }

    @Override
    public String describe() {
        return "Adds new element to HumanBeing LinkedHashSet. Input parameters: String name,Coordinates coordinates(Enter x=... y=...), Boolean realHero, boolean HasToothPick,Double ImpacktSeed(max 646), String Soundtrack, WeaponType weaponType, Mood mood(field can be null, write 0 or null), ";
    }

}
