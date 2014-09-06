package com.grim.spells;

import org.bukkit.Bukkit;

/**
 * Created by Harrison on 30/08/14.
 */
abstract class Spell {

    private Boolean result = false;


    /* Starts a cooldown of a set duration.
     * @param tick Numeber or ticks to wait.
     * @return true.
     */
    public boolean startCooldown(Long tick){
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(HotkeyMC.plugin, new Runnable() {
            @Override
            public void run() {
                result = true;
            }
        }, tick);
        return result;
    }
}
