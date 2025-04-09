import Commands.*;
import InputManagment.StartReader;
import Managment.InputSystem;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        StartReader stR = new StartReader();
        stR.Load();
        CommandManager.LoadCommands();
        InputSystem runner = new InputSystem();
        runner.Read();
    }
}