package net.ledestudio.jca.utils;

import org.jetbrains.annotations.NotNull;

import java.util.logging.Level;
import java.util.logging.Logger;

public class JCALogger {

    private static final Logger LOGGER = Logger.getLogger("JCA");

    public static void info(@NotNull String msg) {
        LOGGER.info(msg);
    }

    public static void info(@NotNull String msg, @NotNull Exception e) {
        LOGGER.log(Level.INFO, msg, e);
    }

    public static void warning(@NotNull String msg) {
        LOGGER.warning(msg);
    }

    public static void warning(@NotNull String msg, @NotNull Exception e) {
        LOGGER.log(Level.WARNING, msg, e);
    }

}
