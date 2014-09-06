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
public class Spellbook{
    private File path;

    public Spellbook(GrimSpells plugin){
        this.path = plugin.getDataFolder();
    }

    /*Saves the players spellbook into a yml file.
     *@param player Player whose spellbook to save.
     */
    public void save(Player player) throws IOException {
        YamlConfiguration c = new YamlConfiguration();
        c.set("inventory.armor", player.getInventory().getArmorContents());
        c.set("inventory.content", player.getInventory().getContents());
        c.save(new File(path, player.getName()+"Spellbook"+".yml"));
    }

    /*Loads the players saved spellbook from the save format.
     *@param player Player whose spellbook to load from file.
     */
    @SuppressWarnings("unchecked")
    public void load(Player player) throws IOException {
        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(path, player.getName()+"Spellbook"+".yml"));
        ItemStack[] content = ((List<ItemStack>) c.get("inventory.armor")).toArray(new ItemStack[0]);
        player.getInventory().setArmorContents(content);
        content = ((List<ItemStack>) c.get("inventory.content")).toArray(new ItemStack[0]);
        player.getInventory().setContents(content);
    }

    @SuppressWarnings("unchecked")
    public void loadDefault(Player player) throws IOException {
        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(path, "DefaultSpellbook"+".yml"));
        ItemStack[] content = ((List<ItemStack>) c.get("inventory.armor")).toArray(new ItemStack[0]);
        player.getInventory().setArmorContents(content);
        content = ((List<ItemStack>) c.get("inventory.content")).toArray(new ItemStack[0]);
        player.getInventory().setContents(content);
    }
}
