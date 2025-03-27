package Managment;

import StartData.Car;
import StartData.Coordinates;
import StartData.HumanBeing;

/*Класс конвертирует ввод в нужные типы данных и заполняет их в коллекцию*/
public class ParseToCollection {
    public void ParseAndAdd(String args) {
        String[] Values = args.split(";");
        String name = Values[0];
        Boolean realHero = Values[1].equals("true");
        boolean hasToothpick = Values[2].equals("true");
        double impactSeed = Double.parseDouble(Values[3]);
        String soundtrackName = Values[4];
        Coordinates cords = new Coordinates(Long.parseLong(Values[5]), Double.parseDouble(Values[6]));
        HumanBeing.WeaponType weaponType = HumanBeing.WeaponType.valueOf(Values[7]);
        HumanBeing.Mood mood;
        Car car;

        if (Values.length == 11) {
            mood = Values[8].isEmpty() ? null : HumanBeing.Mood.valueOf(Values[8]);
            car = new Car(Values[9], Values[10].equals("true"));
        } else {
            mood = null;
            car = new Car(Values[8], Values[9].equals("true"));
        }
        CollectionManager.Add(name, realHero, hasToothpick, impactSeed, soundtrackName, cords, weaponType, mood, car);
    }
}
