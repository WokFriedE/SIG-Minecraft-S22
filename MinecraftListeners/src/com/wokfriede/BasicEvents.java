package com.wokfriede;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class BasicEvents implements Listener {

    //create a method for every event that would occur
    @EventHandler //tell listener to look for it
    public static void onPlayerJoin(PlayerJoinEvent event) { //event is in parameter (name of method is optional and event)
        Player player = event.getPlayer(); //creates a player variable, so we can refer to them
        player.sendMessage(ChatColor.BLUE + "Welcome to the server"); //always occurs when event happens
    }

    @EventHandler
    public static void onPlayerWalk(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        PotionEffectType pot = PotionEffectType.LUCK;


        int x = player.getLocation().getBlockX();
        int y = player.getLocation().getBlockY();
        int z = player.getLocation().getBlockZ();

        Material block  = player.getWorld().getBlockAt(x,y-1,z).getType(); //gets the block the player is at
        // remove 1 from the y position so it gets the one the player is standing on as the current xyz is the block where the feet are

        if (block == Material.STONE) { //if the block is stone
            player.sendMessage(ChatColor.AQUA + "WOW STONE"); //always occurs when event happens
            player.addPotionEffect(new PotionEffect((pot), 20, 2));
            //player.addPotionEffect(new PotionEffect((PotionEffectType.LUCK), 20, 2));
            //target.addPotionEffect(new PotionEffect(potion), duration, level));
        }
    }

    public static void onBlockPlace(BlockPlaceEvent event) {
        Material block = event.getBlock().getType();
        Player player = event.getPlayer();

        if(block == Material.NETHERITE_BLOCK) {
            player.sendMessage(ChatColor.AQUA + "COOLER STONE");
        }

    }


}
