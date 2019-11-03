package love.lipbcu.learnjava.p032_resource;

import java.io.InputStream;
import java.util.Scanner;

/*
  run in project/src/ directory
  1. Compile
  javac love/lipbcu/learnjava/p032_resource/ResourceMain.java
  2. Packaging
  jar cvfe ResourceMain.jar love.lipbcu.learnjava.p032_resource.ResourceMain love/lipbcu/learnjava/p032_resource/*.(class|txt)
  Or with manifest
  jar cvfm ResourceMain.jar love/lipbcu/learnjava/p032_resource/manifest.mf love/lipbcu/learnjava/p032_resource/*.(class|txt)
  3. Run
  java -jar ResourceMain.jar
*/
public class ResourceMain {
    public static void main(String[] args) {
        InputStream stream = ResourceMain.class.getResourceAsStream("about.txt");
        try (Scanner in = new Scanner(stream, "UTF-8")) {
            while (in.hasNext())
                System.out.println(in.nextLine());
        }
    }
}
