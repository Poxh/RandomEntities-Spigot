package de.poxh.randomEntities.commands;

import de.poxh.randomEntities.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_entity implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        Player player = (Player) sender;
        String entityName = args[1];

        if(args.length == 2) {
            if(Main.entityMap.containsKey(entityName)) {
                player.sendMessage("§cDas Entity -> " + entityName + " befindet sich bei den Koordinaten");
                player.sendMessage("§c" + Main.entityMap.get(entityName));
                player.sendMessage("§m-----------------------------------------------------");
            } else {
                player.sendMessage("§cDas Entity -> " + entityName + " exitiert nicht.");
            }
        }

        return false;
    }
}
