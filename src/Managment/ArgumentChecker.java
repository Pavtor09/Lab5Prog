package Managment;

import InputManagment.IInput;
import InputManagment.InputRequest;
import StartData.HumanBeing;
/*Класс проверяющий ввод на соответствие типам данных. Создаёт запросы на повторный ввод при нахождении ошибки*/
public class ArgumentChecker {
    public String CurArgCheck(String arg, String mod, IInput inpt,String errorMessage,int Invokes)
    {
        InputRequest req =  new InputRequest();

        switch (mod)
        {
            case ("Int"):
                try {
                    Integer.parseInt(arg);
                }
                catch (Exception e)
                {
                    arg = req.Request(inpt,errorMessage,new String[] {mod},new String[]{errorMessage},1," ",Invokes+1);
                }
                break;
            case ("Double"):
                try {
                    Double.parseDouble(arg);
                }
                catch (Exception e)
                {
                    arg = req.Request(inpt,errorMessage,new String[] {mod},new String[]{errorMessage},1," ",Invokes+1);
                }
                break;
            case ("Long"):
                try{
                    Long.parseLong(arg);
                }
                catch (Exception e)
                {

                    arg = req.Request(inpt,errorMessage,new String[] {mod},new String[]{errorMessage},1," ",Invokes+1);
                }
                break;
            case ("Bool"):
                if (!(arg.equals("true") || arg.equals("false")))
                {
                    arg = req.Request(inpt,errorMessage,new String[] {mod},new String[]{errorMessage},1," ",Invokes+1);

                }
                break;
            case ("Weapon"):
                try{
                    HumanBeing.WeaponType.valueOf(arg);
                }
                catch (Exception e)
                {
                    arg = req.Request(inpt,errorMessage,new String[] {mod},new String[]{errorMessage},1," ",Invokes+1);
                }
                break;
            case ("Mood"):
                if (!arg.isEmpty())
                {
                    try
                    {
                    HumanBeing.Mood.valueOf(arg);
                    }
                    catch (Exception e)
                    {
                        arg = req.Request(inpt,errorMessage,new String[] {mod},new String[]{errorMessage},1," ",Invokes+1);
                    }
                }
                break;
            case ("Impact"):
                try {
                    Double.parseDouble(arg);
                }
                catch (Exception e)
                {
                    arg = req.Request(inpt,errorMessage,new String[] {mod},new String[]{errorMessage},1," ",Invokes+1);
                }
                if (arg != null)
                {
                    double temp = Double.parseDouble(arg);
                    if (temp > 646)
                    {
                        arg = req.Request(inpt,errorMessage,new String[] {mod},new String[]{errorMessage},1," ",Invokes+1);
                    }
                }
                break;
            case ("Str"):
                if (arg.isEmpty())
                {
                    arg = req.Request(inpt,errorMessage,new String[] {mod},new String[]{errorMessage},1," ",Invokes+1);

                }
                break;
            case ("DoubleCords"):
                try {
                    Double.parseDouble(arg);
                }
                catch (Exception e)
                {
                    arg = req.Request(inpt,errorMessage,new String[] {mod},new String[]{errorMessage},1," ",Invokes+1);
                }
                if (arg != null)
                {

                    double temp = Double.parseDouble(arg.replaceAll(" ","").replaceAll("\n","").replaceAll("\t",""));
                    if (temp <= -275)
                    {
                        arg = req.Request(inpt,errorMessage,new String[] {mod},new String[]{errorMessage},1," ",Invokes+1);
                    }
                }
                break;
            case ("Id"):
                try{
                    Long.parseLong(arg);
                }
                catch (Exception e)
                {

                    arg = req.Request(inpt,errorMessage,new String[] {mod},new String[]{errorMessage},1," ",Invokes+1);
                }
                if (arg != null)
                {
                    Long temp = Long.parseLong(arg);
                    if (temp <= 0)
                    {
                        arg = req.Request(inpt,errorMessage,new String[] {mod},new String[]{errorMessage},1," ",Invokes+1);
                    }
                }
                break;




        }

        return arg;
    }

}
