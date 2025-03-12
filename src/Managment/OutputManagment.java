package Managment;

import InputManagment.IInput;

public class OutputManagment {
    IInput input;
    public OutputManagment(IInput inpt)
    {
    this.input = inpt;
    }
    public void Println(String outstr)
    {
        if (input.RequiresOutput())
        {
            System.out.println(outstr);
        }
    }
}
