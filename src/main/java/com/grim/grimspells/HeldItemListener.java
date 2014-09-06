package com.grim.grimspells;


import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;


/**
 * Created by Harrison on 30/08/14.
 */
public class HeldItemListener implements Listener {

    @EventHandler
    public void onHeldItemSwitch(PlayerItemHeldEvent event){
        Player player = event.getPlayer();
        Material material = player.getItemInHand().getType();

        switch (material){
            //TODO create spells
        }
    }
}
