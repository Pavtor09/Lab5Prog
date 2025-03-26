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
    CommandMap.put("show", new ShowCommand());
    CommandMap.put("update", new UpdateCommand());
    CommandMap.put("remove", new RemoveCommand());
    CommandMap.put("clear", new ClearCommand());
    CommandMap.put("save",new SaveCommand());
    CommandMap.put("execute",new ExecuteCommand());
    CommandMap.put("add_if_max",new AddIfMaxCommand());
    CommandMap.put("remove_lower",new RemoveLowerCommand());
    CommandMap.put("history",new HistoryCommand());
    CommandMap.put("min_by_impactseed",new MinByImpactSeedCommand());
    CommandMap.put("print_ascending",new PrintAscendingCommand());
    CommandMap.put("print_field_ascending",new PrintFieldAscendingImpactSeed());
    }
}

