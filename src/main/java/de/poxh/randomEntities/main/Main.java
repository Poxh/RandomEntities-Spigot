package de.poxh.randomEntities.main;

import de.poxh.randomEntities.commands.Command_entity;
import de.poxh.randomEntities.listeners.EntitySpawnListener;
import de.poxh.randomEntities.listeners.PlayerjoinListener;
import org.apache.commons.lang.RandomStringUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
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

        log(Bukkit.getServer().getWorld("world") == null);

        //register all listeners
        new PlayerjoinListener(this);
        new EntitySpawnListener(this);

        //register all commands
        getCommand("entity").setExecutor(new Command_entity());
    }

    public void log(Object message) {
        Bukkit.getConsoleSender().sendMessage(prefix + message);
    }
}
