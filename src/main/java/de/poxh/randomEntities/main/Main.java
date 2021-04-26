package de.poxh.randomEntities.main;

import de.poxh.randomEntities.listeners.PlayerjoinListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public class Main extends JavaPlugin {

    //Strings
    public String prefix = "§6RandomEntities §7❘ ";

    //Objects
    public static Main instance;

    //maps
    public static Map<String, String> entityMap = new HashMap<String, String>();

    @Override
    public void onEnable() {
        instance = this;
        log("§aThe plugin started successfully.");

        //register all listeners
        new PlayerjoinListener(this);
    }

    public void log(String message) {
        Bukkit.getConsoleSender().sendMessage(prefix + message);
    }
}
