package InputManagment;

import Commands.ICommand;

import java.io.Serializable;

public class Pack implements Serializable {
    public Pack(ICommand command, String args)
    {
        this.args = args;
        this.command = command;
    }
    ICommand command;
    String args;
}
