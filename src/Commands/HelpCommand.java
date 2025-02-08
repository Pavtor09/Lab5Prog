package Commands;

public class HelpCommand implements ICommand{


    public void execute(String arg)
    {
        for (String name: CommandManager.CommandMap.keySet()) {
            String key = name.toString();
            String value = CommandManager.CommandMap.get(name).describe();
            System.out.println('"'+key+'"' + " " + value);
        }
    }

    public String describe()
    {
        return "Prints all commands";
    }
}
