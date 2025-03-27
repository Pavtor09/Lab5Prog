package Commands;

import InputManagment.ISeparatedInput;
import Managment.CommandReader;

import java.io.IOException;
/**Интерфейс, который реализуют все команды
 **/
public interface ICommand {
    public void execute(String arg, ISeparatedInput inptm, CommandReader caller) throws IOException;
    public String describe();
}
