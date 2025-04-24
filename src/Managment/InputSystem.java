package Managment;

import java.io.IOException;
import java.util.Scanner;

import Commands.CommandManager;
import Commands.ICommand;
import Commands.WrongArgumentException;
/*класс отвечает за ввд команд, осуществляет жизненный цикл программы*/

public class InputSystem {
    static Scanner sc = new Scanner(System.in);
    static boolean Bflag = false;//флаг, отвечающий за выход из программы

    //static ICommand curcommand = null;
    public void Read() throws IOException {
        CommandReader MainReader = new CommandReader();
        String line = null;
        while (true) {

            try {
                line = sc.nextLine();
            } catch (Exception e) {
                line = null;
            }


            if (line != null) {
                MainReader.run(line);

            } else {
//             System.out.println("type exit to stop the program");
//             line = " ";
                Bflag = true;
            }
            if (Bflag) {
                break;
            }
        }

    }

    public static void BreakFlag() { //метод выхода из программы

        Bflag = true;
    }
}
