package OutputManagment;

import StartData.HumanBeing;

import java.io.*;
import java.util.Iterator;

public class Writer implements IOutput{
    public void WriteLine(String line,String path) throws IOException {
        OutputStream outputStream = new FileOutputStream(path);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        outputStreamWriter.write(line);
        outputStreamWriter.close();
    }
//
//    public void WriteLine(String line) throws IOException {
//     String path = System.getenv("fileName");
//     WriteLine(line,path);
//    }

    public void WriteFromIterator(Iterator<HumanBeing> iter,String path) throws IOException {
        OutputStream outputStream = new FileOutputStream(path);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        while (iter.hasNext())
        {
            HumanBeing cur = iter.next();
            outputStreamWriter.write(cur.GetValues()+"\n");
        }
        outputStreamWriter.close();
        System.out.println("Collection has been saved");
    }
    public void WriteFromIterator(Iterator<HumanBeing> iter) throws IOException {
        String defFileName = System.getenv("fileName");
        WriteFromIterator(iter,defFileName);
    }


}
