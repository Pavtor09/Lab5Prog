package Managment;

import StartData.HumanBeing;

public class InputChecker {
    public static boolean ArgCheck(String line,String sep, int offset)
    {

        String[] words = line.split(sep);
        int lenth = words.length;
        boolean state = true;
            flag:
            for (int i = 0; i < 11;i++)
            {
                switch (i)
                {
                    case (0):
                    {

                        if (words[i+offset].isEmpty())
                        {   System.out.println("empty string "+words[i+offset]);
                            state = false;
                            break flag;


                        }
                        break;

                    }
                    case 1, 2:
                    {
//
                        if(!(words[i+offset].equals("true") || words[i+offset].equals("false")))
                        {

                            System.out.println("Not true or false "+words[i+offset]);
                            state = false;
                            break flag;
                        }
                        break;
                    }

                    case(3):
                    {
//
                        if(!(Numcheck(words[i+offset])))
                        {
                            System.out.println("Not num");
                           state = false;
                           break flag;
                        }
                        else
                        {
                            if (Double.parseDouble(words[i+offset]) > 646)
                            {
                                System.out.println("Number "+words[i+offset]+" over the max value of 646");
                                state = false;
                                break flag;
                            }
                        }
                        break;

                    }
                    case(4):
                    {
//
                        if (words[i+offset].isEmpty())
                        {
                            System.out.println("Empty string");
                            state = false;
                            break flag;
                        }
                        break;
                    }
                    case(5):
                    {
                        String[] spl = words[i+offset].split(" ");

                        if (spl.length == 2){
                            if(!(Numcheck(spl[0]) && Numcheck(spl[1])))
                            {
                                System.out.println("Coordinates must be numbers");
                                state = false;
                                break flag;
                            }
                        }
                        else
                        {
                            System.out.println("Wrong number of arguments "+words[i+offset]);
                            state = false;
                            break flag;
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
                            System.out.println("There is no such weapon "+words[i+offset]);
                            Weapon = null;
                            state = false;

                            break flag;
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
                                    System.out.println("There is no such mood "+words[i+offset]);
                                    mood = null;
                                    state = false;

                                    break flag;
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
                                System.out.println("Not true or false " + words[i+offset]);
                                state = false;
                                break flag;
                            }
                            if (spl[0].isEmpty())
                            {
                                System.out.println("Name can't be empty");
                                state = false;
                                break flag;
                            }
                        }
                        else{
                            System.out.println("Wrong number of arguments "+words[i+offset]);
                            state = false;
                            break flag;
                        }
                        break;
                    }

                }








            }


        return state;
    }
    static boolean Numcheck(String str)// Метод проверяет, является ли строка числом(а так же числом с плавающей точкой)
    {
        int dotcount = 0;
        for(int i = 0;i < str.length();i++)
        {
            if (!(Character.isDigit(str.charAt(i)) || str.charAt(i) == '.'))
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
