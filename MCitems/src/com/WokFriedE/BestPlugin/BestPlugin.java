package com.WokFriedE.BestPlugin;

import com.WokFriedE.BestPlugin.commands.MoreCommands;
import com.WokFriedE.BestPlugin.events.ItemEvents;
import com.WokFriedE.BestPlugin.items.ItemManager;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class BestPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[BasePlugin]: Plugin is enabled!");
        ItemManager.init();//tells the code to run the item manager and init everything
        getServer().getPluginManager().registerEvents(new ItemEvents(), this); //last register events
        getCommand("givewand").setExecutor(new MoreCommands()); //registers the command
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[BasePlugin]: Plugin is disabled!");
    }
}

/*

order
1. create default
2. create item --> init, function for multiple items
3. register onEnable
4. create a way to get it, commands
5. register command
6. have events that occur with item
7. register events
8. changing recipes

 */