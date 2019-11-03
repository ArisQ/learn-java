package love.lipbcu.learnjava.p033_preferences;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.prefs.Preferences;

public class PreferencesMain {
    public static void main(String[] args) {
        Properties defaultProperties = new Properties();
        defaultProperties.setProperty("width", "300");
        defaultProperties.setProperty("height", "200");
        defaultProperties.setProperty("title", "Default title");
        System.out.println(defaultProperties);
        try (OutputStream out = new FileOutputStream("p033_properties.properties")) {
            defaultProperties.store(out, "Program Properties");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Properties settings = new Properties(defaultProperties);
        System.out.println(settings);
        System.out.println(settings.getProperty("width"));
        System.out.println(settings.getProperty("height"));
        System.out.println(settings.getProperty("title"));
        System.out.println(settings.getProperty("description", "Default description"));
        System.out.println(settings.getProperty("description2"));

        System.out.println(System.getProperty("user.home"));

        // Preferences
        Preferences userRoot = Preferences.userRoot(); // ~/.java/.userPrefs/...
        Preferences systemRoot = Preferences.systemRoot();
        Preferences node = userRoot.node("/love/lipbcu/learnjava/p033_preferences");
        Preferences packageNode = Preferences.userNodeForPackage(PreferencesMain.class);
        System.out.println(userRoot);
        System.out.println(systemRoot);
        System.out.println(node);
        System.out.println(packageNode);
        System.out.println(packageNode.get("title", "Title"));
        // packageNode.put("description", "init description");
        System.out.println(packageNode.get("description", "Title"));
        System.out.println(packageNode.getInt("score", 9));
    }
}
