package ru.adventures.adventures.operations;

import ru.adventures.adventures.configurations.Settings;

import java.util.Objects;

public class Configuration {
    public static String string(String path) {
        return Objects.requireNonNullElse(Settings.get().getString(path), "none");
    }
    public static Integer integer(String path) {
        return Objects.requireNonNullElse(Settings.get().getInt(path), 0);
    }
}
