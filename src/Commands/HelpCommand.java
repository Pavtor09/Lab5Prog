package Commands;

public class HelpCommand implements ICommand{


    public void execute(String arg)
    {
        for (String name: CommandManager.CommandMap.keySet()) {
            String value = CommandManager.CommandMap.get(name).describe();
            System.out.println('"'+name+'"' + " " + value);
        }
    }

    public String describe()
    {
        return "Prints all commands";
    }
}
