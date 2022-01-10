package ru.adventures.adventures.configurations;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import ru.adventures.adventures.Adventures;
import ru.adventures.adventures.operations.Logger;

import java.io.File;
import java.io.IOException;
import java.util.Random;


public class Settings {
    static File file;
    static FileConfiguration settings;

    public static void setup() {
        file = new File(Adventures.instance().getDataFolder(), "settings.yml");
        settings = YamlConfiguration.loadConfiguration(file);
        if (!file.exists()) {
            try {
                Random random = new Random();
                int id = random.nextInt(999 - 100 + 1) + 100;
                settings.set("Server","gateway");
                settings.set("Mode","development");
                settings.set("api-id", id);
                settings.set("Connection.address","address");
                settings.set("Connection.port","3306");
                settings.set("Connection.database","database");
                settings.set("Connection.username","username");
                settings.set("Connection.password","password");
                settings.set("Connection.ssl","false");
                settings.set("Connection.minimumIdle",2);
                settings.set("Connection.maximumPoolSize",10);
                settings.set("Connection.connectionTimeout",1500);
                settings.save(file);
            } catch (IOException e) {
                Logger.error(e.getMessage());
            }

        }
    }

    public static FileConfiguration get() {
        return settings;
    }

    public static void save() {
        try {
            settings.save(file);
        } catch (IOException e) {
            Logger.error(e.getMessage());
        }
    }

    public static void reload(){
        settings = YamlConfiguration.loadConfiguration(file);
    }

}
