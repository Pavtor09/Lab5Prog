package Managment;

import java.io.IOException;
import java.util.Scanner;
import Commands.CommandManager;
import Commands.ICommand;
import Commands.WrongArgumentException;

public class InputSystem { //Класс отвечающий за ввод команд
    static Scanner sc = new Scanner(System.in);
    static boolean Bflag = false;
    static ICommand curcommand = null;
    public void Read() throws IOException {
        CommandReader MainReader = new CommandReader();
     while (true){  //цикл работы программы

         String line = sc.nextLine();
         MainReader.run(line);
         if (Bflag){
             break;
         }
     }

    }
    public static void BreakFlag() { //метод выхода из программы

    Bflag = true;
    }
}
