package com.grim.grimspells;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Harrison on 30/08/14.
 */
public class InventorySave {

    public File path;

    public InventorySave(GrimSpells plugin){
        this.path = plugin.getDataFolder();

    }

    /*Saves the players inventory into a yml file.
     *@param player Player whose inventory to save.
     */
    public void save(Player player) throws IOException {
        YamlConfiguration c = new YamlConfiguration();
        c.set("inventory.armor", player.getInventory().getArmorContents());
        c.set("inventory.content", player.getInventory().getContents());
        c.save(new File(path, player.getName()+".yml"));
    }

    /*Loads the players inventory from the save format.
     * @param player Player whose inventory to load from file.
     */
    @SuppressWarnings("unchecked")
    public void restore(Player player) throws IOException {
        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(path, player.getName()+".yml"));
        ItemStack[] content = ((List<ItemStack>) c.get("inventory.armor")).toArray(new ItemStack[0]);
        player.getInventory().setArmorContents(content);
        content = ((List<ItemStack>) c.get("inventory.content")).toArray(new ItemStack[0]);
        player.getInventory().setContents(content);
    }


}
