package Managment;

import InputManagment.IInput;
/*Класс осуществляет вывод. Нужен для того, чтобы убрать вывод для файлов*/
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
