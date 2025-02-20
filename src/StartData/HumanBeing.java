package StartData;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Date;

public class HumanBeing {
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Boolean realHero; //Поле не может быть null
    private boolean hasToothpick;
    private double impactSpeed; //Максимальное значение поля: 646
    private String soundtrackName; //Поле не может быть null
    private WeaponType weaponType; //Поле не может быть null
    private Mood mood; //Поле может быть null
    private Car car; //Поле не может быть null

    public HumanBeing(String name, Coordinates cords, Boolean realHero,boolean toothpick, double impactSpeed, String soundtrackName, WeaponType weaponType, Mood mood,Car car,Long id, ZonedDateTime crdate)
    {

        this.id = id;
        this.creationDate = crdate;
        this.name = name;
        this.coordinates = cords;
        this.realHero = realHero;
        this.hasToothpick = toothpick;
        this.impactSpeed = impactSpeed;
        this.soundtrackName = soundtrackName;
        this.weaponType =  weaponType;
        this.mood = mood;
        this.car = car;
        System.out.println("Element has been added");
    }
    public ZonedDateTime GetTime()
    {
        return this.creationDate;
    }

    public String GetValues()
    {
    return id+";"+creationDate+";"+name+";"+realHero+";"+hasToothpick+";"+impactSpeed+";"+soundtrackName+";"+coordinates.GetStringCords()+";"+weaponType+";"+mood+";"+car.GetStringCar();
    }
    public enum WeaponType {
        HAMMER,
        RIFLE,
        KNIFE;
        public static void PrintWeapons(){
            System.out.println(WeaponType.HAMMER.toString());
            System.out.println(WeaponType.RIFLE.toString());
            System.out.println(WeaponType.KNIFE.toString());
        }
    }
    public enum Mood {
        LONGING,
        APATHY,
        CALM;
        public static void PrintMood()
        {
            System.out.println(LONGING.toString());
            System.out.println(APATHY.toString());
            System.out.println(CALM.toString());
        }
    }
}