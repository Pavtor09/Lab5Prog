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
        if (FieldSpread(line)) // проверка наличия ошибок во введённых аргументах
        {
            System.out.println("Enter coordinates(first number must be long, second - double)");
            line = sc.nextLine();
            String[] words = line.split(" ");
            if (words.length == 2 && Numcheck(words[0]) && Numcheck(words[1])) {
                cords = new Coordinates(Long.parseLong(words[0]),Double.parseDouble(words[1]));
                System.out.println("Enter weapon type");
                HumanBeing.WeaponType.PrintWeapons();
                line = sc.nextLine();
                try {
                    this.weaponType = HumanBeing.WeaponType.valueOf(line);
                }
                catch (Exception e)
                {
                    System.out.println("There is no such weapon");
                }

                if (weaponType != null)
                {
                    System.out.println("Enter Mood");
                    HumanBeing.Mood.PrintMood();
                    line = sc.nextLine();
                    try {
                        this.mood = HumanBeing.Mood.valueOf(line);
                    }
                    catch (Exception e)
                    {
                        if (line != "")
                        {System.out.println(e.getMessage());}
                    }
                    if (this.mood != null || line == ""){
                        System.out.println("Enter car(String name Boolean cool)");
                        line = sc.nextLine();
                        words = line.split(" ");
                        if (words[1].equals("true") || words[1].equals("false")) {
                            this.car = new Car(words[0],words[1].equals("true"));

                            CollectionManager.Add(this.name,this.cords,this.realHero,this.hasToothPick,this.impactSeed,this.soundtrack,this.weaponType,this.mood,this.car);
                        }
                        else{
                            System.out.println("Boolean can only be true or false");
                        }

                    }
                }

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


    boolean FieldSpread(String line) //Метод разделяет строку по значениям, определяет правильное ли их количество и того ли они типа, записывает данные в промежуточные переменные, и если всё правильно возвращает значение true
    {   String[] tokens = line.split(" ");
        if (tokens.length == 6){



            if(Numcheck(tokens[4])) { // проверка на то, что строка число
                this.impactSeed = Double.parseDouble(tokens[4]);
                if (this.impactSeed <= 646)
                {
                    this.name = tokens[1];
                    if ((tokens[2].equals("true")||tokens[2].equals("false"))&&(tokens[3].equals("true")||tokens[3].equals("false"))) {
                        this.realHero = (tokens[2].equals("true"));
                        this.hasToothPick = (tokens[3].equals("true"));

                        this.soundtrack = tokens[5];
                        return true;
                    }
                    else{
                        System.out.println("Boolean can only be true or false");
                        return false;
                    }
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

    boolean Numcheck(String str)// Метод проверяет, является ли строка числом(а так же числом с плавающей точкой)
    {
        int dotcount = 0;
        for(int i = 0;i < str.length();i++)
        {
            if (!(Character.isDigit(str.charAt(i)) || str.charAt(i) == '.'))
            {
                return false;
            }
            else{
                    if (str.charAt(i) == '.') {
                        dotcount ++;
                        if (dotcount > 1)
                        {
                            return false;
                        }
                    }
                }

            }

        return true;
    }
}
