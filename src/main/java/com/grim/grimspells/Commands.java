package com.grim.grimspells;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;

/**
 * Created by Harrison on 30/08/14.
 */
public class Commands implements CommandExecutor {
    private InventorySave inventorySave = new InventorySave(GrimSpells.plugin);

    public boolean onCommand(CommandSender sender, Command cmd, String name, String[] args){
        if(cmd.getName().equalsIgnoreCase("spellbook")){
            if(!(sender instanceof Player)) return false;
            Player player = (Player) sender;
            try {
                inventorySave.save(player);
            } catch (IOException e){
                System.out.println("IOException while trying to swap inventories");
            }
            //load spellbook
        } return false;
    }
}
