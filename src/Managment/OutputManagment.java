package Managment;

import InputManagment.ISeparatedInput;

/*Класс осуществляет вывод. Нужен для того, чтобы убрать вывод для файлов*/
public class OutputManagment {
    ISeparatedInput input;

    public OutputManagment(ISeparatedInput inpt) {
        this.input = inpt;
    }

    public void Println(String outstr) {
        if (input.RequiresOutput()) {
            System.out.println(outstr);
        }
    }
}
