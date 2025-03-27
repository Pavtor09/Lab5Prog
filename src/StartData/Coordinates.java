package StartData;

public class Coordinates {
    private long x;
    private double y; //Значение поля должно быть больше -275

    public Coordinates(long x, double y) {
        this.x = x;
        this.y = y;
    }

    public Number[] GetCords() {
        Number[] vals = {x, y};
        return vals;
    }

    public String GetStringCords() {
        return x + " " + y;
    }

}