package Managment;

import Commands.CommandManager;
import Commands.ICommand;
import InputManagment.ConsoleSeparatedInput;
import InputManagment.ISeparatedInput;
import InputManagment.Pack;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/*Класс отвечает за считывание команд. Нужен для разделения ввода с консоли и файла*/
public class CommandReader {
    public ArrayList<String> recursion = new ArrayList<String>();
    public ISeparatedInput inptobj = new ConsoleSeparatedInput();
    public ArrayList<String> history = new ArrayList<String>();

    public void run(String line) throws IOException {
        ICommand curcommand = null;
        String[] tokens = line.split(" ");


        if (tokens.length > 0) {

            curcommand = CommandManager.CommandMap.get(tokens[0]);
            Pack commandPack = new Pack(curcommand,line);
            ByteArrayOutputStream bos_command = new ByteArrayOutputStream();
            try (ObjectOutputStream oos = new ObjectOutputStream(bos_command)) {
                oos.writeObject(commandPack);
            }
            byte[] bytes = bos_command.toByteArray();
        }
        try {

            curcommand.execute(line, inptobj, this);
        } catch (Exception e) {
            System.out.println("There is no such command as " + ((tokens.length > 0) && (!tokens[0].trim().isEmpty()) ? tokens[0] : null));
        }

    }

    public void HistoryAdd(String in) {
        history.add(in);
        if (history.size() > 9) {
            history.remove(0);
        }
    }

    public String HistoryGet() {
        return history.toString();
    }
}
