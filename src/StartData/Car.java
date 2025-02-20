package StartData;

public class Car {
    private String name; //Поле не может быть null
    private boolean cool;
    public Car(String name, boolean cool)
    {
        this.name = name;
        this.cool = cool;
    }
    public String GetStringCar()
    {
        return name+" "+cool;
    }

}