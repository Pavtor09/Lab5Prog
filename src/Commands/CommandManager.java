package Commands;

import java.util.HashMap;
import java.util.Map;

public class CommandManager {

public static HashMap<String, ICommand> CommandMap = new HashMap<>();
public static void Add(){
    CommandMap.put("help",new HelpCommand());
    CommandMap.put("exit",new ExitCommand());
    CommandMap.put("add",new AddCommand());
    CommandMap.put("info",new InfoCommand());


    }
}

