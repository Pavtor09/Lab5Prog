import Commands.*;
import Managment.InputSystem;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

//        System.out.println(fileName);
    CommandManager.Add();
    InputSystem runner = new InputSystem();
    runner.Read();
    }
}