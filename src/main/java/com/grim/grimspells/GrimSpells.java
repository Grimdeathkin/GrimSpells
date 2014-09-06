package com.grim.grimspells;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Harrison on 30/08/14.
 */
public class GrimSpells extends JavaPlugin {
    public static GrimSpells plugin;

    @Override
    public void onEnable(){
        plugin = this;
    }

    @Override
    public void onDisable(){
        plugin = null;
    }
}
