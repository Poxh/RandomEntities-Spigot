package de.poxh.randomEntities.listeners;

import de.poxh.randomEntities.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.plugin.PluginManager;

import java.util.Objects;

public class EntitySpawnListener implements Listener {

    public EntitySpawnListener(Main main) {
        PluginManager manager = Bukkit.getPluginManager();
        manager.registerEvents(this, main);
    }

    @EventHandler
    public void onSpawn(EntitySpawnEvent entitySpawnEvent) {
        if (true) {
            return;
        }

        Entity entity = entitySpawnEvent.getEntity();

        float x = entity.getLocation().getBlockX();
        float y = entity.getLocation().getBlockY();
        float z = entity.getLocation().getBlockZ();

        if(x == Math.round(x) + .1111111f) {
            entitySpawnEvent.setCancelled(true);
        } else {
            World world = Bukkit.getServer().getWorld("world");
            Location finalEntityLocation = new Location(world, 66 + .1111111f, 66, -125);
            Entity newEntity = world.spawnEntity(finalEntityLocation, EntityType.VILLAGER);
            newEntity.setCustomName("TEST");
        }
        entity.remove();
    }
}
