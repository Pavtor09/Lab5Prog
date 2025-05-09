package Managment;

import Commands.WrongArgumentException;
import StartData.*;

import javax.swing.text.html.HTMLDocument;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class CollectionManager {
    private static Set<HumanBeing> HumanCollection = new LinkedHashSet<>(); // Сет, в котором хранится коллекция

    public static void Add(String name, Boolean realHero, boolean toothpick, double impactSpeed, String soundtrackName, Coordinates coordinates, HumanBeing.WeaponType weaponType, HumanBeing.Mood mood, Car car) throws WrongArgumentException // Метод, который передаёт аргументы с клавиатуры в конструктор и добавляет новый элемент в коллекцию
    {
        ZonedDateTime creationDate;
        LocalDate time = LocalDate.now();
        String strtime = time.toString();
        strtime = strtime.replaceAll("-", "");
        strtime = strtime.replaceAll(":", "");
        strtime = strtime.replaceAll("\\.", "");
        strtime = strtime.replaceAll("T", "");
        strtime = strtime.substring(3, strtime.length() - 1);
        strtime += LocalTime.now().toString().replaceAll(":", "").replaceAll("\\..*", "");

        strtime += realHero ? 1 : 0;
        strtime += toothpick ? 1 : 0;
        creationDate = ZonedDateTime.now();
        HumanCollection.add(new HumanBeing(name, realHero, toothpick, impactSpeed, soundtrackName, coordinates, weaponType, mood, car, Long.parseLong(strtime), creationDate));
        System.out.println("Element has been added");

    }

    public static void Add(String name, Boolean realHero, boolean toothpick, double impactSpeed, String soundtrackName, Coordinates coordinates, HumanBeing.WeaponType weaponType, HumanBeing.Mood mood, Car car, Long id, ZonedDateTime time) throws WrongArgumentException {
        HumanCollection.add(new HumanBeing(name, realHero, toothpick, impactSpeed, soundtrackName, coordinates, weaponType, mood, car, id, time));
    }

    public static Iterator<HumanBeing> GetIenerator() {
        return HumanCollection.iterator();
    }

    public static Class getclass() {
        return HumanCollection.getClass();
    }

    public static int getsize() {
        return HumanCollection.size();
    }

    public static void CollectionReplace(Set<HumanBeing> TempHumanCollection) {
        HumanCollection.clear();
        HumanCollection = TempHumanCollection;
    }


}

