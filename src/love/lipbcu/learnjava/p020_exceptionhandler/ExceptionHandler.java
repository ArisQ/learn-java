package love.lipbcu.learnjava.p020_exceptionhandler;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class ExceptionHandler {
    public static void main(String[] args) {
        try {
            try {
                throw new FileNotFoundException();
            } catch (FileNotFoundException e) {
                System.out.println("Catching...");
                e.printStackTrace();
                Throwable se = new CustomException("custom error");
                se.initCause(e);
                throw se;
            } finally {
                System.out.println("Inside finally");
            }
        } catch (Throwable e) {
            System.out.println("Catching custom exception...");
            e.printStackTrace();
            System.out.println(Arrays.toString(e.getStackTrace()));
        }

        try (Scanner in = new Scanner(new FileInputStream("/usr/share/dict/words"), "UTF-8")) {
            while (in.hasNext())
                System.out.println(in.next().toUpperCase());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
