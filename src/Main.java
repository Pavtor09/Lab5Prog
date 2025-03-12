import Commands.*;
import InputManagment.StartReader;
import Managment.InputSystem;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

//        System.out.println(fileName);

        StartReader stR = new StartReader();
        stR.Load();

    CommandManager.Add();
    InputSystem runner = new InputSystem();
    runner.Read();
    }
}