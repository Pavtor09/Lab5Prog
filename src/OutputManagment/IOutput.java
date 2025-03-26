package OutputManagment;

import StartData.HumanBeing;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public interface IOutput {
//    public void WriteLine(String arg,String path) throws IOException;
    public void WriteFromIterator(Iterator<HumanBeing> iter) throws IOException;
}
