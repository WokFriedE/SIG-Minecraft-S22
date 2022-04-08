package com.WokFriedE.BestPlugin.events;

import com.WokFriedE.BestPlugin.items.ItemManager;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class ItemEvents implements Listener { // implement listener
    //add effects
    @EventHandler
    public static void onRightClick(PlayerInteractEvent event){ //register event
        if(event.getAction()== Action.RIGHT_CLICK_BLOCK){ //checks specific events
            if(event.getItem() != null){ //accessing item, no point if empty
                if (event.getItem().getItemMeta().equals(ItemManager.funnystick.getItemMeta())){ //checks custom item
                    Player player = event.getPlayer(); //gets player

                    //do stuff
                    player.getWorld().spawnEntity(player.getLocation(), EntityType.BLAZE);
                    player.getWorld().createExplosion(player.getLocation(), 2);
                    player.sendMessage("§4haha v funny");
                }
            }
        }
    }
}
