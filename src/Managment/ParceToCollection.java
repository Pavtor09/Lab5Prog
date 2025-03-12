package Managment;

import StartData.Car;
import StartData.Coordinates;
import StartData.HumanBeing;

public class ParceToCollection {
    public void ParceAndAdd(String args)
    {
        String[] Values = args.split(";");
        String name = Values[0];
        Boolean realHero = Values[1].equals("true");
        boolean hasToothpick = Values[2].equals("true");
        Double impactSeed = Double.parseDouble(Values[3]);
        String soundtrackName = Values[4];
        Coordinates cords =  new Coordinates(Long.parseLong(Values[5]),Double.parseDouble(Values[6]));
        HumanBeing.WeaponType weaponType = HumanBeing.WeaponType.valueOf(Values[7]);
        if (Values.length == 11)
        {
            HumanBeing.Mood mood = Values[8].isEmpty() ? null : HumanBeing.Mood.valueOf(Values[8]);
            Car car = new Car(Values[9],Values[10].equals("true"));
            CollectionManager.Add(name,realHero,hasToothpick,impactSeed,soundtrackName,cords,weaponType,mood,car);
        }
        else {
            HumanBeing.Mood mood = null;
            Car car = new Car(Values[8],Values[9].equals("true"));
            CollectionManager.Add(name,realHero,hasToothpick,impactSeed,soundtrackName,cords,weaponType,mood,car);
        }
    }
}
