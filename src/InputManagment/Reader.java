package InputManagment;
import StartData.Car;
import StartData.Coordinates;
import StartData.HumanBeing;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.ZonedDateTime;

public class Reader implements IReader{

    public String Read(String file) throws IOException {

        FileInputStream fis = new FileInputStream(file);

        InputStreamReader inpt = new InputStreamReader(fis);
//        CollectionManager.HumanCollection.clear();

        String line = "";

        int nxt = inpt.read();
        String words = "";
        int sepcount = 0;
        while (nxt != -1) {


        }

        return "";
    }
}
