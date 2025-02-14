package Managment;

public class InputChecker {
    public static boolean ArgCheck(String line,String sep, int offset)
    {
        String[] words = line.split(sep);
        int lenth = words.length;
        boolean state = true;
            for (int i = 0;i < words.length; i++)
            {
                System.out.println(words[i]);
                switch (i)
                {
                    case (0):
                    {
                        if (words[i+offset].isEmpty())
                        {
                            state = false;
                            break;
                        }

                    }
                    case(1):
                    {
                        if(!(words[i+offset].equals("true") || words[i+offset].equals("false")))
                        {
                            state = false;
                            break;
                        }
                    }
                    case(2):
                    {
                        
                    }


                }

            }


        return state;
    }

}
