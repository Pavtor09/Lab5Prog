package InputManagment;

import Managment.CollectionManager;
import Managment.InputChecker;
import StartData.Car;
import StartData.Coordinates;
import StartData.HumanBeing;

import java.io.IOException;
import java.time.ZonedDateTime;
/*класс отвечающий за загрузку коллекции из файла*/
public class StartReader {

    FileInput file = null;

//    public StartReader() throws IOException
//    {
//    }
    public void Load() throws IOException {
        try
        {
        file = new FileInput(System.getenv("fileName"));
        }
        catch (Exception e)
        {
            System.out.println("No environment file, can't load data into collection");
        }
        if (file != null)
        {
            String cur = "";
            int  errorLine = 0;
            while (file.HasNext())
            {
                cur = file.NextLine();
                ParseAdd(cur,errorLine);
                errorLine += 1;

            }
        }

    }
    /*метод проверяет считанную строку и добавляет её в коллекцию, если у неё правильный формат*/
    private void ParseAdd(String line,int errorLine)
    {
        String[] Values = line.split(";");

        if (InputChecker.ArgCheck(line, ";", 0)) {
            CollectionManager.Add(Values[0], Values[1].equals("true"), Values[2].equals("true"), Double.parseDouble(Values[3]), Values[4], new Coordinates(Long.parseLong(Values[5].split(" ")[0]), Double.parseDouble(Values[5].split(" ")[1])), HumanBeing.WeaponType.valueOf(Values[6]), Values[7].isEmpty() ? null : HumanBeing.Mood.valueOf(Values[7]), new Car(Values[8].split(" ")[0], Values[8].split(" ")[1].equals("true")), Long.parseLong(Values[9]), ZonedDateTime.parse(Values[10]));
        }
        else {
            System.out.println("File has unreadable data no the line "+errorLine);
        }

    }

}
