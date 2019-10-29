package love.lipbcu.learnjava.p022_log;

import java.io.IOException;
import java.util.Locale;
import java.util.logging.*;

public class LogMain {
    private static final Logger logger = Logger.getLogger("love.lipbcu.learnjava");

    public static void main(String[] args) {
        Logger.getGlobal().info("This is an info log.");

        Handler handler = new ConsoleHandler();
        handler.setLevel(Level.ALL);
        logger.addHandler(handler);

        try {
            FileHandler fileHandler = new FileHandler();
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }

        logger.setLevel(Level.FINE);
        logger.setUseParentHandlers(false);

        logger.info("log by custom logger");
        logger.info("中文");

        Logger localeLogger = Logger.getLogger(
                "love.lipbcu.learnjava",
                "love.lipbcu.learnjava.p022_log.logmessages"
        );
        localeLogger.info("readingFile"); // 中文会乱码，需要处理
    }
}
