package InputManagment;

import Managment.InputSystem;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
/*Класс побайтово считывает данные с файла и преобразует их в нормальный вид*/
public class Reader {
    public String Read(String path) throws IOException {
        FileInputStream geek = null;
        String output = "";
        InputStreamReader InStrm = null;
        boolean opened = false;
        try {
            geek = new FileInputStream(path);
            InStrm = new InputStreamReader(geek);

            opened = true;
        } catch (FileNotFoundException fnfe) {
            System.out.println("NO Such File Exists");
        }
        if (opened)
        {
            int cur = 0;
            while(cur != -1)
            {
                cur = InStrm.read();
                output += (cur!= -1)&&((char)cur != '\r') ? (char)cur:"";

            }
        }
    return output;
    }
}
