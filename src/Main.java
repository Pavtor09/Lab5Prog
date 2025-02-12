import Commands.*;
import Managment.InputSystem;

public class Main {
    public static void main(String[] args) {
        String fileName = System.getenv("fileName");
//        System.out.println(fileName);
    CommandManager.Add();
    InputSystem.Read();
    }
}