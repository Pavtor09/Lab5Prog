package Managment;

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
//                        System.out.println("case(0) "+words[i+offset]);
                        if (words[i+offset].isEmpty())
                        {   System.out.println("empty string "+words[i+offset]);
                            state = false;
                            break flag;


                        }
                        break;

                    }
                    case(1):
                    {
//                        System.out.println("case(1) "+words[i+offset]);
                        if(!(words[i+offset].equals("true") || words[i+offset].equals("false")))
                        {
                            System.out.println("indx="+(i+offset));
                            System.out.println("Not true or false "+words[i+offset]);
                            state = false;
                            break flag;
                        }
                        break;
                    }
                    case(2):
                    {
                        System.out.println("case(2) "+words[i+offset]);
                        if(!(words[i+offset].equals("true") || words[i+offset].equals("false")))
                        {
//                            System.out.println("Not true or false "+words[i+offset]);
                            state = false;
                            break flag;
                        }
                        break;
                    }
                    case(3):
                    {
//                        System.out.println("case(3) "+words[i+offset]);
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
                        break;

                    }
                    case(4):
                    {
//                        System.out.println("case(4) "+words[i+offset]);
                        if (words[i+offset].isEmpty())
                        {
                            state = false;
                            break flag;
                        }
                        break;
                    }
                    case(5):
                    {

                    }




                }
                System.out.println(words[i+offset]+" "+i);


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
