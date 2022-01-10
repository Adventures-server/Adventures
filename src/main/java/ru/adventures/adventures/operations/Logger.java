package ru.adventures.adventures.operations;

import ru.adventures.adventures.Adventures;

import java.util.logging.Level;

public class Logger {
    public static void error(String message) {
        Adventures.instance().getLogger().log(Level.SEVERE, message);
    }
    public static void info(String message) {
        Adventures.instance().getLogger().log(Level.INFO, message);
    }
    public static void warning(String message) {
        Adventures.instance().getLogger().log(Level.WARNING, message);
    }
}
