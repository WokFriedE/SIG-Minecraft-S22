package com.wokfriede;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class ListenersBasics extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new BasicEvents(), this); //need to register the event
        // pulls from the event class (the one we named) and asks for which plugin (this) referring to this one

        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[" + this.getName() + "] has been loaded"); //have this last to see if everything works
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[" + this.getName() + "] has been unloaded");
    }
}
