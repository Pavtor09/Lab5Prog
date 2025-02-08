package Managment;
import Commands.WrongArgumentException;
import StartData.*;
import java.util.LinkedHashSet;
import java.util.Set;
public class CollectionManager {
static Set<HumanBeing> HumanCollection = new LinkedHashSet<>(); // Сет, в котором хранится коллекция
public static void Add(String name, Coordinates coordinates, Boolean realHero, boolean toothpick, double impactSpeed, String soundtrackName, HumanBeing.WeaponType weaponType, HumanBeing.Mood mood, HumanBeing.Car car) throws WrongArgumentException // Метод, который передаёт аргументы с клавиатуры в конструктор и добавляет новый элемент в коллекцию
{

    try
    {
        HumanCollection.add(new HumanBeing(name,coordinates,realHero, toothpick, impactSpeed, soundtrackName, weaponType, mood, car));

    }
    catch (WrongArgumentException e)
    {
        System.out.println(e.getMessage());
    }
}

    static boolean ArgChech(String name, Coordinates coordinates, Boolean realHero, boolean toothpick, double impactSpeed, String soundtrackName, HumanBeing.WeaponType weaponType, HumanBeing.Mood mood, HumanBeing.Car car)
    {
        if (name == null || coordinates == null || realHero == null || impactSpeed >= 646 || soundtrackName == null || weaponType == null || car == null)
        {
            throw new WrongArgumentException("Some arguments are null or out of allowed range");
        }
     return true;
    }
}

