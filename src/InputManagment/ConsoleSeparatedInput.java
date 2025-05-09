package InputManagment;

import java.util.Scanner;

/*Класс для ввода с консоли. По сути повторяет scanner. Нужен для того, чтобы стандартизировать ввод*/
public class ConsoleSeparatedInput implements ISeparatedInput {
    Scanner sc = null;
    private boolean reqOut = true;

    public ConsoleSeparatedInput() {
        sc = new Scanner(System.in);
    }

    public String NextLine() {
        try {
            return sc.nextLine().replaceAll("\n", "").replaceAll("\t", "");
        } catch (Exception e) {
            return null;
        }
    }

    public boolean HasNext() {
        return sc.hasNext();
    }

    public boolean RequiresOutput() {
        return reqOut;
    }

}
