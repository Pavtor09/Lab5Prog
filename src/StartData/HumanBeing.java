package StartData;

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

    public HumanBeing(String name, Coordinates cords, Boolean realHero,boolean toothpick, double impactSpeed, String soundtrackName, WeaponType weaponType, Mood mood,Car car)
    {
        this.name = name;
        this.coordinates = cords;
        this.realHero = realHero;
        this.hasToothpick = toothpick;
        this.impactSpeed = impactSpeed;
        this.soundtrackName = soundtrackName;
        this.weaponType =  weaponType;
        this.mood = mood;
        this.car = car;
    }
    public class Coordinates {
        private long x;
        private double y; //Значение поля должно быть больше -275
    }
    public class Car {
        private String name; //Поле не может быть null
        private boolean cool;
    }
    public enum WeaponType {
        HAMMER,
        RIFLE,
        KNIFE;
    }
    public enum Mood {
        LONGING,
        APATHY,
        CALM;
    }
}