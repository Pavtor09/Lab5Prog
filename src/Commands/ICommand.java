package Commands;

public interface ICommand {
    public void execute(String arg);
    public String describe();
}
