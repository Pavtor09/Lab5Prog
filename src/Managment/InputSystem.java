package Managment;

import java.util.Scanner;
import Commands.CommandManager;
import Commands.ICommand;
import Commands.WrongArgumentException;

public class InputSystem { //Класс отвечающий за ввод команд
    static Scanner sc = new Scanner(System.in);
    static boolean Bflag = false;
    public static void Read(){
     while (true){  //цикл работы программы

        String line = sc.nextLine();
        String[] tokens = line.split(" ");
        ICommand curcommand = CommandManager.CommandMap.get(tokens[0]);
        try{
        curcommand.execute(line);
        }
        catch (Exception e)
        {
            System.out.println("There is no such command as "+tokens[0]);
        }
         if (Bflag){
             break;
         }
     }

    }
    public static void BreakFlag() { //метод выхода из программы

    Bflag = true;
    }
}
