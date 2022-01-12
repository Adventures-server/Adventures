package ru.adventures.adventures;

import org.bukkit.plugin.java.JavaPlugin;
import ru.adventures.adventures.configurations.Configurations;
import ru.adventures.adventures.connection.Connection;
import ru.adventures.adventures.connection.DataManager;
import ru.adventures.adventures.operations.SettingsConfiguration;

public final class Adventures extends JavaPlugin {

    public static Adventures instance;

    public static Adventures instance() {
        return instance;
    }

    public static DataManager connection;

    @Override
    public void onEnable() {
        instance = this;
        Configurations.setup();
        String mode = SettingsConfiguration.string("Mode");
        if (mode.equals("production") || mode.equals("development")) {
            connection = new Connection();
        }
    }

    @Override
    public void onDisable() {
    }
}
