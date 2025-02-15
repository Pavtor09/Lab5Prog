package Managment;

public class InputChecker {
    public static boolean ArgCheck(String line,String sep, int offset)
    {
        String[] words = line.split(sep);
        int lenth = words.length;
        boolean state = true;
            flag:
            for (int i = 0; i < 5;i++)
            {
                System.out.println(words[i+offset]+" "+i);
                switch (i)
                {
                    case (0):
                    {
                        System.out.println("REEEEEEEEEE");
                        if (words[i+offset].isEmpty())
                        {   System.out.println("empty string "+words[i+offset]);
                            state = false;
                            break flag;

                        }

                    }
                    case(1):
                    {
                        if(!(words[i+offset].equals("true") || words[i+offset].equals("false")))
                        {
                            System.out.println("indx="+(i+offset));
                            System.out.println("Not true or false "+words[i+offset]);
                            state = false;
                            break flag;
                        }
                    }
                    case(2):
                    {
                        if(!(words[i+offset].equals("true") || words[i+offset].equals("false")))
                        {
                            System.out.println("Not true or false "+words[i+offset]);
                            state = false;
                            break flag;
                        }
                    }
                    case(3):
                    {
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
                                state = false;
                                break flag;
                            }
                        }

                    }
                    case(4):
                    {
                        if (words[i+offset].isEmpty())
                        {
                            state = false;
                            break flag;
                        }
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
