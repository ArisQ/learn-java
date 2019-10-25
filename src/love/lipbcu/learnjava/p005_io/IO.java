package love.lipbcu.learnjava.p005_io;

import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Scanner;

public class IO {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = in.nextLine();
        System.out.println("How old are you?");
        int age = in.nextInt();
        System.out.printf("Hello %s. Next year, you will be %d.\n", name, age);

        Console console = System.console();
        if (console != null) {
            String username = console.readLine("User name:");
            char[] password = console.readPassword("Password: ");
        } else {
            System.out.println("Unable to get console.");
        }

        System.out.printf("%d\n", 31);
        System.out.printf("%x\n", 31);
        System.out.printf("%o\n", 31);
        System.out.printf("%f\n", 31.0);
        System.out.printf("%e\n", 31.0);
        System.out.printf("%g\n", 31.0);
        System.out.printf("%a\n", 31.0);
        System.out.printf("%s\n", "Hello");
        System.out.printf("%c\n", 'H');
        System.out.printf("%b\n", true);
        System.out.printf("%h\n", "4269b2");
        System.out.printf("%tc\n", new Date());
        System.out.printf("%Tc\n", new Date());
        System.out.printf("%%\n");
        System.out.printf("%n\n");

        // File IO
        PrintWriter fOut = new PrintWriter("myfile.txt", "UTF-8");
        fOut.printf("%d %x %o %f %e %g %a %s %c %b %h %tc %Tc %% %n",
                31, 31, 31, 31.0, 31.0, 31.0, 31.0, "Hello", 'H', true, "42629b2", new Date(), new Date());
        fOut.println("Hello file.");
        fOut.flush();
        Scanner fIn = new Scanner(Paths.get("myfile.txt"), "UTF-8");
        if (fIn.hasNext())
            System.out.println(fIn.nextLine());
        else
            System.out.println("No line.");

        System.out.println(System.getProperty("user.dir"));
    }
}
