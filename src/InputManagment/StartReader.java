package InputManagment;

import Managment.CollectionManager;
import Managment.InputChecker;
import StartData.Car;
import StartData.Coordinates;
import StartData.HumanBeing;

import java.io.IOException;
import java.time.ZonedDateTime;

public class StartReader {
    FileInput file = new FileInput(System.getenv("fileName"));

    public StartReader() throws IOException
    {
    }
    public void Load()
    {
        String cur = "";
        while (file.HasNext())
        {
            cur = file.NextLine();
//            System.out.println(cur);
            ParseAdd(cur);

        }
    }
    void ParseAdd(String line)
    {
        String[] Values = line.split(";");

        if (InputChecker.ArgCheck(line, ";", 0)) {
            CollectionManager.Add(Values[0], Values[1].equals("true"), Values[2].equals("true"), Double.parseDouble(Values[3]), Values[4], new Coordinates(Long.parseLong(Values[5].split(" ")[0]), Double.parseDouble(Values[5].split(" ")[1])), HumanBeing.WeaponType.valueOf(Values[6]), Values[7].isEmpty() ? null : HumanBeing.Mood.valueOf(Values[7]), new Car(Values[8].split(" ")[0], Values[8].split(" ")[1].equals("true")), Long.parseLong(Values[9]), ZonedDateTime.parse(Values[10]));
        }

    }

}
