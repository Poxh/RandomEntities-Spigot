package de.poxh.randomEntities.listeners;

import de.poxh.randomEntities.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.PluginManager;

import java.util.Map;

public class PlayerjoinListener implements Listener {

    public PlayerjoinListener(Main main) {
        PluginManager manager = Bukkit.getPluginManager();
        manager.registerEvents(this, main);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        World world = Bukkit.getWorld("world");

        for (Entity entity : world.getEntities()) {
            Main.instance.log("§cEntity: " + entity.getName());

            float entityX = entity.getLocation().getBlockX();
            float entityY = entity.getLocation().getBlockY();
            float entityZ = entity.getLocation().getBlockZ();

            String entityFinalLocation = "§cX: " + entityX + " §cY: " + entityY + " §cZ: " + entityZ;
            Main.entityMap.put(entity.getName(), entityFinalLocation);
        }
    }
}
