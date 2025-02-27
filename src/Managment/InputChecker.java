package Managment;

import StartData.HumanBeing;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

public class InputChecker {
    public static boolean ArgCheck(String line,String sep, int offset)
    {
        boolean state = true;
        String output = "";
        line = line.replaceAll(" *;",";");
        line = line.replaceAll("; *",";");
        line = line.replaceAll(" *$","");
//        System.out.println(line);
        String[] words = line.split(sep);
        int lenth = words.length;
        if (lenth < 9)
        {
            output += "Not enough arguments\n";
            state = false;

        }
        else
        {

            flag:
            for (int i = 0; i < lenth-1;i++)
            {
                switch (i)
                {
                    case (0):
                    {

                        if (words[i+offset].isEmpty())
                        {   output += "empty string "+words[i+offset]+"\n";
                            state = false;
//                            break flag;


                        }
                        break;

                    }
                    case 1, 2:
                    {
//
                        if(!(words[i+offset].equals("true") || words[i+offset].equals("false")))
                        {

                            output += "Not true or false "+words[i+offset]+"\n";
                            state = false;
//                            break flag;
                        }
                        break;
                    }

                    case(3):
                    {
//
                        if(!(Numcheck(words[i+offset],true)))
                        {
                            output +="Not num "+words[i+offset]+"\n";
                            state = false;
//                            break flag;
                        }
                        else
                        {
                            if (Double.parseDouble(words[i+offset]) > 646)
                            {
                                output += "Number "+words[i+offset]+" over the max value of 646"+"\n";
                                state = false;
//                                break flag;
                            }
                        }
                        break;

                    }
                    case(4):
                    {
//
                        if (words[i+offset].isEmpty())
                        {
                            output += "Empty string"+"\n";
                            state = false;
//                            break flag;
                        }
                        break;
                    }
                    case(5):
                    {
                        String[] spl = words[i+offset].split(" ");

                        if (spl.length == 2){
                            if(!(Numcheck(spl[0],false) && Numcheck(spl[1],true)))
                            {
                                output += "Coordinates must be numbers. First - long, second - double " + words[i+offset]+"\n";
                                state = false;
//                                break flag;
                            }
                            else {
                                if (Double.parseDouble(spl[1]) <= -275)
                                {
                                    output += "Second coordinate must be over -275"+"\n";
                                    state = false;
//                                    break flag;
                                }
                            }
                        }
                        else
                        {
                            output += "Wrong number of arguments "+words[i+offset]+"\n";
                            state = false;
//                            break flag;
                        }
                        break;
                    }
                    case(6):
                    {

                        HumanBeing.WeaponType Weapon;
                        try
                        {
                            Weapon = HumanBeing.WeaponType.valueOf(words[i+offset]);
                        }
                        catch (Exception e)
                        {
                            output += "There is no such weapon "+words[i+offset]+"\n";
                            Weapon = null;
                            state = false;

//                            break flag;
                        }
                        break;

                    }
                    case(7):
                    {
                            HumanBeing.Mood mood;
                            if (!words[i+offset].isEmpty())
                            {
                                try
                                {
                                    mood = HumanBeing.Mood.valueOf(words[i+offset]);
                                }
                                catch (Exception e)
                                {
                                    output += "There is no such mood "+words[i+offset]+"\n";
                                    mood = null;
                                    state = false;

//                                    break flag;
                                }

                            }
                        break;
                    }
                    case(8):
                    {
                        String[] spl = words[i+offset].split(" ");
                        if (spl.length == 2)
                        {
                            if (!(spl[1].equals("true") || spl[1].equals("false")))
                            {
                                output += "Not true or false " + words[i+offset]+"\n";
                                state = false;
//                                break flag;
                            }
                            if (spl[0].isEmpty())
                            {
                                output += "Name can't be empty\n";
                                state = false;
//                                break flag;
                            }
                        }
                        else{
                            output += "Wrong number of arguments "+words[i+offset]+"\n";
                            state = false;
//                            break flag;
                        }
                        break;
                    }
                    case(9):
                    {
                        try{
                            Long.parseLong(words[i+offset]);
                        }
                        catch (Exception e)
                        {
                            output += "Id must be Long";
                            state = false;
                        }
                        break;
                    }
                    case (10):
                    {
                        try {
                            LocalDateTime.parse(words[i + offset]);
                        }
                        catch (Exception e)
                        {
                            output += "Time is wrong";
                            state = false;
                        }
                        break;
                    }

                }
            }








        }
//        System.out.println(output);


        return state;
    }
    public static boolean ArgCheckEvSep(String arg, String sep, int offset,int numOfArgs)
    {
        String[] CorArgs = arg.split(sep);

        if (CorArgs.length >= 11+offset) {
            CorArgs = Arrays.copyOfRange(CorArgs, offset, CorArgs.length);
            String CorString = CorArgs[0] + ";" + CorArgs[1] + ";" + CorArgs[2] + ";" + CorArgs[3] + ";" + CorArgs[4] + ";" + CorArgs[5] + " " + CorArgs[6] + ";" + CorArgs[7] + ";" + CorArgs[8] + ";" + CorArgs[9] + " " + CorArgs[10] + (CorArgs.length >= 12 ?(";" + CorArgs[11]):"");
//            String CorString = "";
//            for(int i = 0;i < numOfArgs-offset;i++)
//            {
//                CorString += CorArgs[i]+ (i == numOfArgs-1?"":";");
//            }
//            System.out.println(CorString);
            return ArgCheck(CorString, ";", 0);
        }
        else
        {
//            System.out.println("Wrong number of arguments in update");
            return false;
        }
    }

    public static boolean Numcheck(String str,boolean HasDot)// Метод проверяет, является ли строка числом(а так же числом с плавающей точкой)
    {
        int dotcount = 0;
        for(int i = 0;i < str.length();i++)
        {
            if (!(Character.isDigit(str.charAt(i)) || (str.charAt(i) == '.' && HasDot)))
            {
                return false;
            }
            else{
                if (str.charAt(i) == '.') {
                    dotcount ++;
                    if (dotcount > 1)
                    {
                        return false;
                    }
                }
            }

        }

        return true;
    }

}
