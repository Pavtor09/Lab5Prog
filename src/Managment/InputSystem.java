package Managment;

import java.util.Scanner;
import Commands.CommandManager;
import Commands.ICommand;
public class InputSystem { //Класс отвечающий за ввод команд
    static Scanner sc = new Scanner(System.in);
    static boolean Bflag = false;
    public static void Read(){
     while (sc.hasNext()){  //цикл работы программы

        String line = sc.next();
        String[] tokens = line.split(" ");
        ICommand curcommand = CommandManager.CommandMap.get(tokens[0]);
        curcommand.execute(line);
         if (Bflag){
             break;
         }
     }

    }
    public static void BreakFlag() { //метод выхода из программы

    Bflag = true;
    }
}
